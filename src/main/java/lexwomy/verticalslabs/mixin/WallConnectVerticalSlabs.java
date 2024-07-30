package lexwomy.verticalslabs.mixin;

import lexwomy.verticalslabs.block.VerticalSlabBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.WallBlock;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WallBlock.class)
public abstract class WallConnectVerticalSlabs extends Block {


    @Inject(method = "shouldConnectTo", at = @At("HEAD"), cancellable = true)
    private void onCheckConnect(BlockState state, boolean faceFullSquare, Direction side, CallbackInfoReturnable<Boolean> cir) {
        Block block = state.getBlock();
        if (block instanceof VerticalSlabBlock && ((VerticalSlabBlock) block).canWallConnect(state, side)) {
            cir.setReturnValue(true);
        }
    }
}
