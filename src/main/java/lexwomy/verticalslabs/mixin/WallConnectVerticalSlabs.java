package lexwomy.verticalslabs.mixin;

import lexwomy.verticalslabs.block.VerticalSlabBlock;
import lexwomy.verticalslabs.block.VerticalSlabType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.WallBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static lexwomy.verticalslabs.block.VerticalSlabBlock.TYPE;

@Mixin(WallBlock.class)
public abstract class WallConnectVerticalSlabs extends Block {

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
            at = @At("HEAD"), cancellable = true)
    private void interjectWithVerticalSlabCheck(WorldView world, BlockState state, BlockPos pos, BlockState aboveState,
                                                boolean north, boolean east, boolean south, boolean west, CallbackInfoReturnable<BlockState> cir) {
        //If above state is a vertical slab and the wall below is not already in up state, perform check to see which walls
        //should be raised to tall
        if (aboveState.getBlock() instanceof VerticalSlabBlock && aboveState.get(TYPE) == VerticalSlabType.HALF) {
            BlockState bs = ((VerticalSlabBlock) aboveState.getBlock()).interjectwithVerticalSlabCheck(state, aboveState, north, east, south, west);
            cir.setReturnValue(bs);
        }
    }
}
