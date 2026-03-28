package lexwomy.verticalslabs.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import lexwomy.verticalslabs.VerticalSlabs;
import lexwomy.verticalslabs.block.VerticalSlabBlock;
import lexwomy.verticalslabs.block.VerticalSlabType;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FireBlock.class)
public abstract class FlammableVerticalSlabsMixin {
  @WrapOperation(
      method =
          "isValidFireLocation(Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;)Z",
      at =
          @At(
              value = "INVOKE",
              target =
                  "Lnet/minecraft/world/level/block/FireBlock;canBurn(Lnet/minecraft/world/level/block/state/BlockState;)Z"))
  private boolean CheckFlammableVerticalSlabs(
      FireBlock instance,
      BlockState state,
      Operation<Boolean> original,
      @Local(ordinal = 0) Direction direction) {
    if (state.is(VerticalSlabs.VERTICAL_FLAMMABLE_SLABS)) {
      // If block is in vertical flammable slab and is not a double slab, require same axes (solid
      // face only)
      Direction slabFacing = state.getValue(VerticalSlabBlock.FACING);
      boolean isValidFlammableVerticalSlab =
          slabFacing.getAxis() == direction.getAxis()
              || state.getValue(VerticalSlabBlock.TYPE) == VerticalSlabType.DOUBLE;

      return original.call(instance, state) && isValidFlammableVerticalSlab;
    }
    return original.call(instance, state);
  }
}
