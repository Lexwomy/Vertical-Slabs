package lexwomy.verticalslabs;

import lexwomy.verticalslabs.block.VerticalSlab;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.fabricmc.fabric.api.event.registry.DynamicRegistries;
import net.fabricmc.fabric.api.event.registry.DynamicRegistrySetupCallback;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.advancement.AdvancementRequirements;
import net.minecraft.advancement.criterion.ItemCriterion;
import net.minecraft.block.Block;
import net.minecraft.loot.condition.LocationCheckLootCondition;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class VerticalSlabs implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("vertical_slabs");
	public static final String MOD_ID = "vertical_slabs";
	public static final TagKey<Block> VERTICAL_SLABS = TagKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, "vertical_slabs"));
	public static final TagKey<Block> VERTICAL_WOODEN_SLABS = TagKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, "vertical_wooden_slabs"));
	public static final TagKey<Block> VERTICAL_MINEABLE_SLABS = TagKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, "vertical_mineable_slabs"));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		VerticalSlab.initialize();
		DynamicRegistrySetupCallback.EVENT.register(registryView -> {
			registryView.registerEntryAdded(RegistryKeys.ADVANCEMENT, (rawId, id, advancement) -> {
				LOGGER.info("{}, {}", rawId, id.toString());
				if (advancement.name().isPresent() && advancement.name().get().equals(Text.translatable("advancements.husbandry.wax_on.title"))) {
					LOGGER.info("Found wax on advancement!");

					// Add an extra requirement on to the advancement

				}
			});
		});
		LOGGER.info("Hello Fabric world! Debug is {}", LOGGER.isDebugEnabled());
	}
}