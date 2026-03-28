package lexwomy.verticalslabs.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class VerticalSlabBlock extends Block implements SimpleWaterloggedBlock {
  public static final EnumProperty<VerticalSlabType> TYPE =
      EnumProperty.create("type", VerticalSlabType.class);
  public static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;
  public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
  public static final MapCodec<VerticalSlabBlock> CODEC = simpleCodec(VerticalSlabBlock::new);
  protected static final VoxelShape NORTH_FACING_SHAPE = Block.box(0f, 0f, 8f, 16f, 16f, 16f);
  protected static final VoxelShape SOUTH_FACING_SHAPE = Block.box(0f, 0f, 0f, 16f, 16f, 8f);
  protected static final VoxelShape EAST_FACING_SHAPE = Block.box(0f, 0f, 0f, 8f, 16f, 16f);
  protected static final VoxelShape WEST_FACING_SHAPE = Block.box(8f, 0f, 0f, 16f, 16f, 16f);
  protected static final VoxelShape DOUBLE_SHAPE = Shapes.block();

  public VerticalSlabBlock(BlockBehaviour.Properties settings) {
    super(settings);

    registerDefaultState(
        defaultBlockState()
            .setValue(TYPE, VerticalSlabType.BOTTOM)
            .setValue(FACING, Direction.NORTH)
            .setValue(WATERLOGGED, false));
  }

  protected MapCodec<? extends VerticalSlabBlock> codec() {
    return CODEC;
  }

  @Override
  public BlockState getStateForPlacement(BlockPlaceContext ctx) {
    Direction face = ctx.getHorizontalDirection();
    Vec3 hit_coords = ctx.getClickLocation();
    BlockPos block_coords = ctx.getClickedPos();
    BlockState blockstate = ctx.getLevel().getBlockState(block_coords);
    FluidState fluidState = ctx.getLevel().getFluidState(block_coords);

    // If adding a vertical slab onto an existing vertical slab, turn it into a full block
    if (blockstate.is(this)) {
      return blockstate.setValue(TYPE, VerticalSlabType.DOUBLE).setValue(WATERLOGGED, false);
    }

    VerticalSlabType halfSlabType;
    Direction facing = face.getOpposite();
    if (face.getAxis() == Direction.Axis.Z) {
      halfSlabType =
          face == Direction.NORTH
              ? (hit_coords.z - (double) block_coords.getZ() < 0.5
                  ? VerticalSlabType.BOTTOM
                  : VerticalSlabType.TOP)
              : (hit_coords.z - (double) block_coords.getZ() < 0.5)
                  ? VerticalSlabType.TOP
                  : VerticalSlabType.BOTTOM;
    } else {
      halfSlabType =
          face == Direction.WEST
              ? (hit_coords.x - (double) block_coords.getX() < 0.5
                  ? VerticalSlabType.BOTTOM
                  : VerticalSlabType.TOP)
              : (hit_coords.x - (double) block_coords.getX() < 0.5
                  ? VerticalSlabType.TOP
                  : VerticalSlabType.BOTTOM);
    }
    return this.defaultBlockState()
        .setValue(TYPE, halfSlabType)
        .setValue(FACING, facing)
        .setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
  }

  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
    builder.add(FACING, TYPE, WATERLOGGED);
  }

  @Override
  public boolean canPlaceLiquid(
      @Nullable LivingEntity filler,
      BlockGetter world,
      BlockPos pos,
      BlockState state,
      Fluid fluid) {
    return state.getValue(TYPE) != VerticalSlabType.DOUBLE
        && SimpleWaterloggedBlock.super.canPlaceLiquid(filler, world, pos, state, fluid);
  }

  @Override
  public boolean placeLiquid(
      LevelAccessor world, BlockPos pos, BlockState state, FluidState fluidState) {
    return state.getValue(TYPE) != VerticalSlabType.DOUBLE
        && SimpleWaterloggedBlock.super.placeLiquid(world, pos, state, fluidState);
  }

  protected boolean isPathfindable(BlockState state, PathComputationType type) {
    if (type == PathComputationType.WATER) {
      return state.getFluidState().is(FluidTags.WATER);
    }
    return false;
  }

  protected BlockState updateShape(
      BlockState state,
      LevelReader world,
      ScheduledTickAccess tickView,
      BlockPos pos,
      Direction direction,
      BlockPos neighborPos,
      BlockState neighborState,
      RandomSource random) {
    if (state.getValue(WATERLOGGED)) {
      tickView.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
    }

    return super.updateShape(
        state, world, tickView, pos, direction, neighborPos, neighborState, random);
  }

  protected boolean useShapeForLightOcclusion(BlockState blockstate) {
    return blockstate.getValue(TYPE) != VerticalSlabType.DOUBLE;
  }

  protected FluidState getFluidState(BlockState state) {
    return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
  }

  @Override
  protected BlockState rotate(BlockState state, Rotation rotation) {
    return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
  }

  @Override
  protected BlockState mirror(BlockState state, Mirror mirror) {
    switch (mirror) {
      case LEFT_RIGHT:
        if (state.getValue(FACING).getAxis() == Direction.Axis.Z) {
          return state.setValue(FACING, state.getValue(FACING).getOpposite());
        }
        break;
      case FRONT_BACK:
        if (state.getValue(FACING).getAxis() == Direction.Axis.X) {
          return state.setValue(FACING, state.getValue(FACING).getOpposite());
        }
        break;
    }
    return super.mirror(state, mirror);
  }

  protected boolean canBeReplaced(BlockState state, BlockPlaceContext ctx) {
    ItemStack itemStack = ctx.getItemInHand();
    VerticalSlabType type = state.getValue(TYPE);
    Direction facing = state.getValue(FACING);
    BlockPos clickPos = ctx.getClickedPos();

    if (type == VerticalSlabType.BOTTOM && itemStack.is(this.asItem())) {
      if (ctx.replacingClickedOnBlock()) {
        boolean isInsideBlock =
            (facing.getAxis() == Direction.Axis.Z)
                ? (facing == Direction.NORTH
                    ? ctx.getClickLocation().z - (double) clickPos.getZ() <= 0.5
                    : ctx.getClickLocation().z - (double) clickPos.getZ() >= 0.5)
                : (facing == Direction.WEST
                    ? ctx.getClickLocation().x - (double) clickPos.getX() <= 0.5
                    : ctx.getClickLocation().x - (double) clickPos.getX() >= 0.5);
        return ctx.getClickedFace() == facing && isInsideBlock;
      } else {
        return true;
      }
    } else if (type == VerticalSlabType.TOP && itemStack.is(this.asItem())) {
      if (ctx.replacingClickedOnBlock()) {
        boolean isInsideBlock =
            (facing.getAxis() == Direction.Axis.Z)
                ? (facing == Direction.NORTH
                    ? ctx.getClickLocation().z - (double) clickPos.getZ() >= 0.5
                    : ctx.getClickLocation().z - (double) clickPos.getZ() <= 0.5)
                : (facing == Direction.WEST
                    ? ctx.getClickLocation().x - (double) clickPos.getX() >= 0.5
                    : ctx.getClickLocation().x - (double) clickPos.getX() <= 0.5);
        return ctx.getClickedFace() == facing.getOpposite() && isInsideBlock;
      } else {
        return true;
      }
    } else {
      return false;
    }
  }

  @Override
  public VoxelShape getShape(
      BlockState state, BlockGetter view, BlockPos pos, CollisionContext context) {
    VerticalSlabType type = state.getValue(TYPE);
    if (type == VerticalSlabType.DOUBLE) {
      return DOUBLE_SHAPE;
    } else if (type == VerticalSlabType.BOTTOM) {
      switch (state.getValue(FACING)) {
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
    } else {
      switch (state.getValue(FACING)) {
        case NORTH -> {
          return SOUTH_FACING_SHAPE;
        }
        case SOUTH -> {
          return NORTH_FACING_SHAPE;
        }
        case EAST -> {
          return WEST_FACING_SHAPE;
        }
        default -> {
          return EAST_FACING_SHAPE;
        }
      }
    }
  }

  /*
   * side is the direction of the wall
   * state is the blockstate of the block trying to connect (e.g., this vertical slab rn)
   */
  public boolean canWallConnect(BlockState state, Direction side) {
    return side != state.getValue(FACING);
  }
}
