package lexwomy.verticalslabs.mixin;

import lexwomy.verticalslabs.block.VerticalSlabBlock;
import lexwomy.verticalslabs.block.VerticalSlabType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.WallBlock;
import net.minecraft.block.enums.WallShape;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static lexwomy.verticalslabs.block.VerticalSlabBlock.FACING;
import static lexwomy.verticalslabs.block.VerticalSlabBlock.TYPE;

@Mixin(WallBlock.class)
public abstract class WallConnectVerticalSlabs extends Block {

    @Shadow @Final public static EnumProperty<WallShape> NORTH_SHAPE;

    @Shadow @Final public static EnumProperty<WallShape> SOUTH_SHAPE;

    @Shadow @Final public static EnumProperty<WallShape> EAST_SHAPE;

    @Shadow @Final public static EnumProperty<WallShape> WEST_SHAPE;

    @Shadow @Final public static BooleanProperty WATERLOGGED;

    @Shadow @Final public static BooleanProperty UP;

    public WallConnectVerticalSlabs(Settings settings) {
        super(settings);
    }

    @Inject(method = "shouldConnectTo", at = @At("HEAD"), cancellable = true)
    private void onCheckConnect(BlockState state, boolean faceFullSquare, Direction side, CallbackInfoReturnable<Boolean> cir) {
        Block block = state.getBlock();
        if (block instanceof VerticalSlabBlock && ((VerticalSlabBlock) block).canWallConnect(state, side)) {
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "getStateWith(Lnet/minecraft/world/WorldView;Lnet/minecraft/block/BlockState;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;ZZZZ)Lnet/minecraft/block/BlockState;",
            at = @At(value = "TAIL"), cancellable = true)
    private void interjectWithVerticalSlabCheck(WorldView world, BlockState state, BlockPos pos, BlockState aboveState,
                                                boolean north, boolean east, boolean south, boolean west, CallbackInfoReturnable<BlockState> cir) {
        //If above state is a vertical slab and the wall below is connected to at least one side, perform check to see which walls
        //should be raised to tall
        if (aboveState.getBlock() instanceof VerticalSlabBlock && aboveState.get(TYPE) == VerticalSlabType.HALF
                && (north || east || south || west)) {
            BlockState result = cir.getReturnValue();

            boolean ns = false;
            boolean ew = false;
            Direction face = aboveState.get(FACING);
            if (face == Direction.NORTH || face == Direction.SOUTH) {
                ns = true;
            } else {
                ew = true;
            }

            WallBlock wall = ((WallBlock) (Object) this);

            BlockState thisState = wall.getStateWithProperties(state)
                    .with(NORTH_SHAPE, ((ew || face == Direction.SOUTH) && north) ? WallShape.TALL : result.get(NORTH_SHAPE))
                    .with(SOUTH_SHAPE, ((ew || face == Direction.NORTH) && south) ? WallShape.TALL : result.get(SOUTH_SHAPE))
                    .with(EAST_SHAPE, ((ns || face == Direction.WEST) && east) ? WallShape.TALL : result.get(EAST_SHAPE))
                    .with(WEST_SHAPE, ((ns || face == Direction.EAST) && west) ? WallShape.TALL : result.get(WEST_SHAPE));

            boolean full_z = thisState.get(NORTH_SHAPE) == WallShape.TALL && thisState.get(SOUTH_SHAPE) == WallShape.TALL
                            && thisState.get(EAST_SHAPE) == WallShape.NONE && thisState.get(WEST_SHAPE) == WallShape.NONE;
            boolean full_x = thisState.get(NORTH_SHAPE) == WallShape.NONE && thisState.get(SOUTH_SHAPE) == WallShape.NONE
                            && thisState.get(EAST_SHAPE) == WallShape.TALL && thisState.get(WEST_SHAPE) == WallShape.TALL;

            cir.setReturnValue(thisState.with(UP, !(full_z || full_x)).with(WATERLOGGED, result.get(WATERLOGGED)));
        }
    }
}
