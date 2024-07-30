package lexwomy.verticalslabs.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

//TO-DO: Make rotate/mirror methods, add connectability to walls
public class VerticalSlabBlock extends Block implements Waterloggable {
    public static final MapCodec<VerticalSlabBlock> CODEC = createCodec(VerticalSlabBlock::new);
    public static final EnumProperty<VerticalSlabType> TYPE = EnumProperty.of("type", VerticalSlabType.class);
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    protected static final VoxelShape NORTH_FACING_SHAPE = Block.createCuboidShape(0f, 0f, 8f, 16f, 16f, 16f);
    protected static final VoxelShape SOUTH_FACING_SHAPE = Block.createCuboidShape(0f, 0f, 0f, 16f, 16f, 8f);
    protected static final VoxelShape EAST_FACING_SHAPE = Block.createCuboidShape(0f, 0f, 0f, 8f, 16f, 16f);
    protected static final VoxelShape WEST_FACING_SHAPE = Block.createCuboidShape(8f, 0f, 0f, 16f, 16f, 16f);
    protected static final VoxelShape DOUBLE_SHAPE = VoxelShapes.fullCube();
    public VerticalSlabBlock(AbstractBlock.Settings settings) {
        super(settings);

        setDefaultState(getDefaultState().with(TYPE, VerticalSlabType.HALF).with(FACING, Direction.NORTH).with(WATERLOGGED, false));
    }

    protected MapCodec<? extends VerticalSlabBlock> getCodec() {
        return CODEC;
    }

    @Override
    public boolean canFillWithFluid(@Nullable PlayerEntity player, BlockView world, BlockPos pos, BlockState state, Fluid fluid) {
        return state.get(TYPE) != VerticalSlabType.DOUBLE && Waterloggable.super.canFillWithFluid(player, world, pos, state, fluid);
    }

    @Override
    public boolean tryFillWithFluid(WorldAccess world, BlockPos pos, BlockState state, FluidState fluidState) {
        return state.get(TYPE) != VerticalSlabType.DOUBLE && Waterloggable.super.tryFillWithFluid(world, pos, state, fluidState);
    }

    protected FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    protected BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        if (type == NavigationType.WATER) {
            return state.getFluidState().isIn(FluidTags.WATER);
        }
        return false;
    }

    protected boolean hasSidedTransparency(BlockState blockstate) {
        return blockstate.get(TYPE) != VerticalSlabType.DOUBLE;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        VerticalSlabType type = state.get(TYPE);
        if (type == VerticalSlabType.DOUBLE) {
            return DOUBLE_SHAPE;
        } else {
            switch (state.get(FACING)) {
                case NORTH -> {
                    return NORTH_FACING_SHAPE;
                }
                case SOUTH -> {
                    return SOUTH_FACING_SHAPE;
                }
                case EAST -> {
                    return EAST_FACING_SHAPE;
                }
                default -> {
                    return WEST_FACING_SHAPE;
                }
            }
        }
    }

    protected boolean canReplace(BlockState state, ItemPlacementContext ctx) {
        ItemStack itemStack = ctx.getStack();
        VerticalSlabType type = state.get(TYPE);
        Direction face = state.get(FACING);

        if (type == VerticalSlabType.HALF && itemStack.isOf(this.asItem())) {
            if (ctx.canReplaceExisting()) {
                boolean bl = (face == Direction.NORTH || face == Direction.SOUTH) ?
                        (face == Direction.NORTH ?
                                ctx.getHitPos().z - (double)ctx.getBlockPos().getZ() < 0.5 :
                                ctx.getHitPos().z - (double)ctx.getBlockPos().getZ() > 0.5) :
                        (face == Direction.WEST ?
                                ctx.getHitPos().x - (double)ctx.getBlockPos().getX() < 0.5 :
                                ctx.getHitPos().x - (double)ctx.getBlockPos().getX() > 0.5);
                return ctx.getSide() == face || bl;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING, TYPE, WATERLOGGED});
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction face = ctx.getHorizontalPlayerFacing();
        Vec3d hit_coords = ctx.getHitPos();
        BlockPos block_coords = ctx.getBlockPos();
        BlockState blockstate = ctx.getWorld().getBlockState(block_coords);
        FluidState fluidState = ctx.getWorld().getFluidState(block_coords);

        //If adding a vertical slab onto an existing vertical slab, turn it into a full block
        if (blockstate.isOf(this)) {
            return blockstate.with(TYPE, VerticalSlabType.DOUBLE).with(WATERLOGGED, false);
        }

        return this.getDefaultState().with(TYPE, VerticalSlabType.HALF)
                .with(FACING, (face == Direction.NORTH || face == Direction.SOUTH) ?
                        ((hit_coords.z - (double)block_coords.getZ() < 0.5) ? Direction.SOUTH : Direction.NORTH) :
                        ((hit_coords.x - (double)block_coords.getX() < 0.5) ? Direction.EAST : Direction.WEST))
                .with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
    }

    /*
    * side is the direction of the wall
    * state is the blockstate of the block trying to connect (e.g., this vertical slab rn)
     */
    public boolean canWallConnect(BlockState state, Direction side) {
        return side != state.get(FACING);
    }
}
