package lexwomy.verticalslabs.mixin;

import com.google.common.collect.ImmutableBiMap;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import lexwomy.verticalslabs.block.VerticalSlab;
import net.minecraft.block.Block;
import net.minecraft.block.Degradable;
import net.minecraft.block.Oxidizable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Oxidizable.class)
public abstract interface VerticalOxidizableInterface extends Degradable<Oxidizable.OxidationLevel>  {
	@ModifyExpressionValue(method = "method_34740",
			at = @At(value="INVOKE",
					target="Lcom/google/common/collect/ImmutableBiMap$Builder;put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableBiMap$Builder;",
					shift = At.Shift.AFTER, ordinal = 26))
	private static ImmutableBiMap.Builder<Block, Block> addVerticalCopperSlabsToMap(ImmutableBiMap.Builder<Block, Block> original) {
		return original.put(VerticalSlab.VERTICAL_CUT_COPPER_SLAB, VerticalSlab.VERTICAL_EXPOSED_CUT_COPPER_SLAB)
				.put(VerticalSlab.VERTICAL_EXPOSED_CUT_COPPER_SLAB, VerticalSlab.VERTICAL_WEATHERED_CUT_COPPER_SLAB)
				.put(VerticalSlab.VERTICAL_WEATHERED_CUT_COPPER_SLAB, VerticalSlab.VERTICAL_OXIDIZED_CUT_COPPER_SLAB);
	}
}