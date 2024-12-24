package lexwomy.verticalslabs;

import com.google.common.collect.BiMap;
import lexwomy.verticalslabs.block.VerticalSlab;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.fabricmc.fabric.api.event.registry.DynamicRegistries;
import net.fabricmc.fabric.api.event.registry.DynamicRegistrySetupCallback;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRequirements;
import net.minecraft.advancement.criterion.ItemCriterion;
import net.minecraft.block.Block;
import net.minecraft.item.HoneycombItem;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.condition.LocationCheckLootCondition;
import net.minecraft.predicate.BlockPredicate;
import net.minecraft.predicate.entity.LocationPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static net.minecraft.data.advancement.vanilla.VanillaHusbandryTabAdvancementGenerator.AXE_ITEMS;

public class VerticalSlabs implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("vertical_slabs");
	public static final String MOD_ID = "vertical_slabs";
	public static final TagKey<Block> VERTICAL_SLABS = TagKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, "vertical_slabs"));
	public static final TagKey<Block> VERTICAL_WOODEN_SLABS = TagKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, "vertical_wooden_slabs"));
	public static final TagKey<Block> VERTICAL_MINEABLE_SLABS = TagKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, "vertical_mineable_slabs"));
	public static Optional<AdvancementCriterion<ItemCriterion.Conditions>> VERTICAL_SLABS_WAX_ON_CRITERION = Optional.empty();
	public static Optional<AdvancementCriterion<ItemCriterion.Conditions>> VERTICAL_SLABS_WAX_OFF_CRITERION = Optional.empty();
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		VerticalSlab.initialize();
		BiMap<Block, Block> unwaxedToWaxed = HoneycombItem.UNWAXED_TO_WAXED_BLOCKS.get();

		VERTICAL_SLABS_WAX_ON_CRITERION = Optional.of(ItemCriterion.Conditions.createItemUsedOnBlock(
				LocationPredicate.Builder.create().block(BlockPredicate.Builder.create().blocks(Registries.BLOCK, unwaxedToWaxed.keySet())),
				ItemPredicate.Builder.create().items(Registries.ITEM, Items.HONEYCOMB)
		));

		VERTICAL_SLABS_WAX_OFF_CRITERION = Optional.of(ItemCriterion.Conditions.createItemUsedOnBlock(
				LocationPredicate.Builder.create().block(BlockPredicate.Builder.create().blocks(Registries.BLOCK, unwaxedToWaxed.values())),
				ItemPredicate.Builder.create().items(Registries.ITEM, AXE_ITEMS)
		));

		LOGGER.info("Hello Fabric world! Debug is {}", LOGGER.isDebugEnabled());
	}
}