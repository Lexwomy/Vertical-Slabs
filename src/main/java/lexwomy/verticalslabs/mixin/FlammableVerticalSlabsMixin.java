package lexwomy.verticalslabs.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import lexwomy.verticalslabs.VerticalSlabs;
import lexwomy.verticalslabs.block.VerticalSlab;
import lexwomy.verticalslabs.block.VerticalSlabBlock;
import lexwomy.verticalslabs.block.VerticalSlabType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.List;

@Mixin(FireBlock.class)
public abstract class FlammableVerticalSlabsMixin {
    @WrapOperation(method = "areBlocksAroundFlammable(Lnet/minecraft/world/BlockView;Lnet/minecraft/util/math/BlockPos;)Z",
    at = @At(value = "INVOKE", target = "Lnet/minecraft/block/FireBlock;isFlammable(Lnet/minecraft/block/BlockState;)Z"))
    private boolean CheckFlammableVerticalSlabs(FireBlock instance, BlockState state, Operation<Boolean> original,
                                                @Local(ordinal = 0) Direction direction) {
        if (state.isIn(VerticalSlabs.VERTICAL_FLAMMABLE_SLABS)) {
            // If block is in vertical flammable slab and is not a double slab, require same axes (solid face only)
            Direction slabFacing = state.get(VerticalSlabBlock.FACING);
            boolean isValidFlammableVerticalSlab = slabFacing.getAxis() == direction.getAxis() ||
                    state.get(VerticalSlabBlock.TYPE) == VerticalSlabType.DOUBLE;

            return original.call(instance, state) && isValidFlammableVerticalSlab;
        }
        return original.call(instance, state);
    }
}
