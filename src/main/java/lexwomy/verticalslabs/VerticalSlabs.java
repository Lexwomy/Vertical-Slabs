package lexwomy.verticalslabs;

import static net.minecraft.data.advancements.packs.VanillaHusbandryAdvancements.WAX_SCRAPING_TOOLS;

import com.google.common.collect.BiMap;
import lexwomy.verticalslabs.block.VerticalSlab;
import net.fabricmc.api.ModInitializer;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.criterion.BlockPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.ItemUsedOnLocationTrigger;
import net.minecraft.advancements.criterion.LocationPredicate;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.HoneycombItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VerticalSlabs implements ModInitializer {
  // This logger is used to write text to the console and the log file.
  // It is considered best practice to use your mod id as the logger's name.
  // That way, it's clear which mod wrote info, warnings, and errors.
  public static final Logger LOGGER = LoggerFactory.getLogger("vertical_slabs");
  public static final String MOD_ID = "vertical_slabs";
  public static final TagKey<Block> VERTICAL_SLABS =
      TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MOD_ID, "vertical_slabs"));
  public static final TagKey<Block> VERTICAL_WOODEN_SLABS =
      TagKey.create(
          Registries.BLOCK, Identifier.fromNamespaceAndPath(MOD_ID, "vertical_wooden_slabs"));
  public static final TagKey<Block> VERTICAL_MINEABLE_SLABS =
      TagKey.create(
          Registries.BLOCK, Identifier.fromNamespaceAndPath(MOD_ID, "vertical_mineable_slabs"));
  public static final TagKey<Item> VERTICAL_SLABS_ITEMS =
      TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, "vertical_slabs"));
  public static final TagKey<Item> VERTICAL_WOODEN_SLABS_ITEMS =
      TagKey.create(
          Registries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, "vertical_wooden_slabs"));
  public static final TagKey<Item> VERTICAL_FLAMMABLE_SLABS_ITEMS =
      TagKey.create(
          Registries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, "vertical_flammable_slabs"));
  public static final TagKey<Item> VERTICAL_MINEABLE_SLABS_ITEMS =
      TagKey.create(
          Registries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, "vertical_mineable_slabs"));
  public static final TagKey<Block> VERTICAL_FLAMMABLE_SLABS =
      TagKey.create(
          Registries.BLOCK, Identifier.fromNamespaceAndPath(MOD_ID, "vertical_flammable_slabs"));

  @Nullable
  public static Criterion<ItemUsedOnLocationTrigger.TriggerInstance>
      VERTICAL_SLABS_WAX_ON_CRITERION;

  @Nullable
  public static Criterion<ItemUsedOnLocationTrigger.TriggerInstance>
      VERTICAL_SLABS_WAX_OFF_CRITERION;

  public static <T> ResourceKey<@NotNull T> createResourceKey(
      ResourceKey<@NotNull Registry<@NotNull T>> resourceKey, String path) {
    return ResourceKey.create(resourceKey, identifier(path));
  }

  public static Identifier identifier(String path) {
    return Identifier.fromNamespaceAndPath(MOD_ID, path);
  }

  @Override
  public void onInitialize() {
    // This code runs as soon as Minecraft is in a mod-load-ready state.
    // However, some things (like resources) may still be uninitialized.
    // Proceed with mild caution.
    VerticalSlab.initialize();
    BiMap<Block, Block> unwaxedToWaxed = HoneycombItem.WAXABLES.get();

    VERTICAL_SLABS_WAX_ON_CRITERION =
            ItemUsedOnLocationTrigger.TriggerInstance.itemUsedOnBlock(
                LocationPredicate.Builder.location()
                    .setBlock(
                        BlockPredicate.Builder.block()
                            .of(BuiltInRegistries.BLOCK, unwaxedToWaxed.keySet())),
                ItemPredicate.Builder.item().of(BuiltInRegistries.ITEM, Items.HONEYCOMB));

    VERTICAL_SLABS_WAX_OFF_CRITERION =
            ItemUsedOnLocationTrigger.TriggerInstance.itemUsedOnBlock(
                LocationPredicate.Builder.location()
                    .setBlock(
                        BlockPredicate.Builder.block()
                            .of(BuiltInRegistries.BLOCK, unwaxedToWaxed.values())),
                ItemPredicate.Builder.item().of(BuiltInRegistries.ITEM, WAX_SCRAPING_TOOLS));
  }
}
