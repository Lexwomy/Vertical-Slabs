package lexwomy.verticalslabs.block;

import lexwomy.verticalslabs.VerticalSlabs;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.fabricmc.fabric.impl.content.registry.FlammableBlockRegistryImpl;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;
import net.minecraft.block.Oxidizable;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

import static net.minecraft.block.Blocks.*;

public class VerticalSlab {
    public static Block register(Settings settings, String name, boolean shouldRegisterItem) {
        Identifier id = Identifier.of(VerticalSlabs.MOD_ID, name);
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, id);
        Settings blockSettings = settings.registryKey(key);
        Block block = Registry.register(Registries.BLOCK, key, new VerticalSlabBlock(blockSettings));

        if (shouldRegisterItem) {
            RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, id);
            Item.Settings itemSettings = new Item.Settings().useBlockPrefixedTranslationKey().registryKey(itemKey);
            Registry.register(Registries.ITEM, itemKey, new BlockItem(block, itemSettings));
        }

        return block;
    }

    public static Block registerOxidizable(Oxidizable.OxidationLevel level, Settings settings, String name, boolean shouldRegisterItem) {
        Identifier id = Identifier.of(VerticalSlabs.MOD_ID, name);
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, id);
        Settings blockSettings = settings.registryKey(key);
        Block block = Registry.register(Registries.BLOCK, key, new OxidizableVerticalSlabBlock(level, blockSettings));

        if (shouldRegisterItem) {
            RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, id);
            Item.Settings itemSettings = new Item.Settings().useBlockPrefixedTranslationKey().registryKey(itemKey);
            Registry.register(Registries.ITEM, itemKey, new BlockItem(block, itemSettings));
        }

        return block;
    }

    public static final RegistryKey<ItemGroup> VERTICAL_SLAB_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(VerticalSlabs.MOD_ID, "item_group"));
    public static final ItemGroup VERTICAL_SLAB_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(VerticalSlab.VERTICAL_STONE_SLAB))
            .displayName(Text.translatable("itemGroup.vertical_slabs"))
            .build();
    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, VERTICAL_SLAB_GROUP_KEY, VERTICAL_SLAB_GROUP);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register((itemGroup) -> {
            itemGroup.add(VERTICAL_OAK_SLAB.asItem());
            itemGroup.add(VERTICAL_SPRUCE_SLAB.asItem());
            itemGroup.add(VERTICAL_BIRCH_SLAB.asItem());
            itemGroup.add(VERTICAL_JUNGLE_SLAB.asItem());
            itemGroup.add(VERTICAL_ACACIA_SLAB.asItem());
            itemGroup.add(VERTICAL_DARK_OAK_SLAB.asItem());
            itemGroup.add(VERTICAL_MANGROVE_SLAB.asItem());
            itemGroup.add(VERTICAL_CHERRY_SLAB.asItem());
            itemGroup.add(VERTICAL_PALE_OAK_SLAB.asItem());
            itemGroup.add(VERTICAL_BAMBOO_SLAB.asItem());
            itemGroup.add(VERTICAL_BAMBOO_MOSAIC_SLAB.asItem());
            itemGroup.add(VERTICAL_CRIMSON_SLAB.asItem());
            itemGroup.add(VERTICAL_WARPED_SLAB.asItem());
            itemGroup.add(VERTICAL_STONE_SLAB.asItem());
            itemGroup.add(VERTICAL_COBBLESTONE_SLAB.asItem());
            itemGroup.add(VERTICAL_MOSSY_COBBLESTONE_SLAB.asItem());
            itemGroup.add(VERTICAL_SMOOTH_STONE_SLAB.asItem());
            itemGroup.add(VERTICAL_STONE_BRICK_SLAB.asItem());
            itemGroup.add(VERTICAL_MOSSY_STONE_BRICK_SLAB.asItem());
            itemGroup.add(VERTICAL_GRANITE_SLAB.asItem());
            itemGroup.add(VERTICAL_POLISHED_GRANITE_SLAB.asItem());
            itemGroup.add(VERTICAL_DIORITE_SLAB.asItem());
            itemGroup.add(VERTICAL_POLISHED_DIORITE_SLAB.asItem());
            itemGroup.add(VERTICAL_ANDESITE_SLAB.asItem());
            itemGroup.add(VERTICAL_POLISHED_ANDESITE_SLAB.asItem());
            itemGroup.add(VERTICAL_COBBLED_DEEPSLATE_SLAB.asItem());
            itemGroup.add(VERTICAL_POLISHED_DEEPSLATE_SLAB.asItem());
            itemGroup.add(VERTICAL_DEEPSLATE_BRICK_SLAB.asItem());
            itemGroup.add(VERTICAL_DEEPSLATE_TILE_SLAB.asItem());
            itemGroup.add(VERTICAL_TUFF_SLAB.asItem());
            itemGroup.add(VERTICAL_POLISHED_TUFF_SLAB.asItem());
            itemGroup.add(VERTICAL_TUFF_BRICK_SLAB.asItem());
            itemGroup.add(VERTICAL_BRICK_SLAB.asItem());
            itemGroup.add(VERTICAL_MUD_BRICK_SLAB.asItem());
            itemGroup.add(VERTICAL_RESIN_BRICK_SLAB.asItem());
            itemGroup.add(VERTICAL_SANDSTONE_SLAB.asItem());
            itemGroup.add(VERTICAL_SMOOTH_SANDSTONE_SLAB.asItem());
            itemGroup.add(VERTICAL_CUT_SANDSTONE_SLAB.asItem());
            itemGroup.add(VERTICAL_RED_SANDSTONE_SLAB.asItem());
            itemGroup.add(VERTICAL_SMOOTH_RED_SANDSTONE_SLAB.asItem());
            itemGroup.add(VERTICAL_CUT_RED_SANDSTONE_SLAB.asItem());
            itemGroup.add(VERTICAL_PRISMARINE_SLAB.asItem());
            itemGroup.add(VERTICAL_PRISMARINE_BRICK_SLAB.asItem());
            itemGroup.add(VERTICAL_DARK_PRISMARINE_SLAB.asItem());
            itemGroup.add(VERTICAL_NETHER_BRICK_SLAB.asItem());
            itemGroup.add(VERTICAL_RED_NETHER_BRICK_SLAB.asItem());
            itemGroup.add(VERTICAL_BLACKSTONE_SLAB.asItem());
            itemGroup.add(VERTICAL_POLISHED_BLACKSTONE_SLAB.asItem());
            itemGroup.add(VERTICAL_POLISHED_BLACKSTONE_BRICK_SLAB.asItem());
            itemGroup.add(VERTICAL_END_STONE_BRICK_SLAB.asItem());
            itemGroup.add(VERTICAL_PURPUR_SLAB.asItem());
            itemGroup.add(VERTICAL_QUARTZ_SLAB.asItem());
            itemGroup.add(VERTICAL_SMOOTH_QUARTZ_SLAB.asItem());
            itemGroup.add(VERTICAL_CUT_COPPER_SLAB.asItem());
            itemGroup.add(EXPOSED_VERTICAL_CUT_COPPER_SLAB.asItem());
            itemGroup.add(WEATHERED_VERTICAL_CUT_COPPER_SLAB.asItem());
            itemGroup.add(OXIDIZED_VERTICAL_CUT_COPPER_SLAB.asItem());
            itemGroup.add(WAXED_VERTICAL_CUT_COPPER_SLAB.asItem());
            itemGroup.add(WAXED_EXPOSED_VERTICAL_CUT_COPPER_SLAB.asItem());
            itemGroup.add(WAXED_WEATHERED_VERTICAL_CUT_COPPER_SLAB.asItem());
            itemGroup.add(WAXED_OXIDIZED_VERTICAL_CUT_COPPER_SLAB.asItem());
        });
        ItemGroupEvents.modifyEntriesEvent(VERTICAL_SLAB_GROUP_KEY).register((itemGroup) -> {
            itemGroup.add(VERTICAL_OAK_SLAB.asItem());
            itemGroup.add(VERTICAL_SPRUCE_SLAB.asItem());
            itemGroup.add(VERTICAL_BIRCH_SLAB.asItem());
            itemGroup.add(VERTICAL_JUNGLE_SLAB.asItem());
            itemGroup.add(VERTICAL_ACACIA_SLAB.asItem());
            itemGroup.add(VERTICAL_DARK_OAK_SLAB.asItem());
            itemGroup.add(VERTICAL_MANGROVE_SLAB.asItem());
            itemGroup.add(VERTICAL_CHERRY_SLAB.asItem());
            itemGroup.add(VERTICAL_PALE_OAK_SLAB.asItem());
            itemGroup.add(VERTICAL_BAMBOO_SLAB.asItem());
            itemGroup.add(VERTICAL_BAMBOO_MOSAIC_SLAB.asItem());
            itemGroup.add(VERTICAL_CRIMSON_SLAB.asItem());
            itemGroup.add(VERTICAL_WARPED_SLAB.asItem());
            itemGroup.add(VERTICAL_STONE_SLAB.asItem());
            itemGroup.add(VERTICAL_COBBLESTONE_SLAB.asItem());
            itemGroup.add(VERTICAL_MOSSY_COBBLESTONE_SLAB.asItem());
            itemGroup.add(VERTICAL_SMOOTH_STONE_SLAB.asItem());
            itemGroup.add(VERTICAL_STONE_BRICK_SLAB.asItem());
            itemGroup.add(VERTICAL_MOSSY_STONE_BRICK_SLAB.asItem());
            itemGroup.add(VERTICAL_GRANITE_SLAB.asItem());
            itemGroup.add(VERTICAL_POLISHED_GRANITE_SLAB.asItem());
            itemGroup.add(VERTICAL_DIORITE_SLAB.asItem());
            itemGroup.add(VERTICAL_POLISHED_DIORITE_SLAB.asItem());
            itemGroup.add(VERTICAL_ANDESITE_SLAB.asItem());
            itemGroup.add(VERTICAL_POLISHED_ANDESITE_SLAB.asItem());
            itemGroup.add(VERTICAL_COBBLED_DEEPSLATE_SLAB.asItem());
            itemGroup.add(VERTICAL_POLISHED_DEEPSLATE_SLAB.asItem());
            itemGroup.add(VERTICAL_DEEPSLATE_BRICK_SLAB.asItem());
            itemGroup.add(VERTICAL_DEEPSLATE_TILE_SLAB.asItem());
            itemGroup.add(VERTICAL_TUFF_SLAB.asItem());
            itemGroup.add(VERTICAL_POLISHED_TUFF_SLAB.asItem());
            itemGroup.add(VERTICAL_TUFF_BRICK_SLAB.asItem());
            itemGroup.add(VERTICAL_BRICK_SLAB.asItem());
            itemGroup.add(VERTICAL_MUD_BRICK_SLAB.asItem());
            itemGroup.add(VERTICAL_RESIN_BRICK_SLAB.asItem());
            itemGroup.add(VERTICAL_SANDSTONE_SLAB.asItem());
            itemGroup.add(VERTICAL_SMOOTH_SANDSTONE_SLAB.asItem());
            itemGroup.add(VERTICAL_CUT_SANDSTONE_SLAB.asItem());
            itemGroup.add(VERTICAL_RED_SANDSTONE_SLAB.asItem());
            itemGroup.add(VERTICAL_SMOOTH_RED_SANDSTONE_SLAB.asItem());
            itemGroup.add(VERTICAL_CUT_RED_SANDSTONE_SLAB.asItem());
            itemGroup.add(VERTICAL_PRISMARINE_SLAB.asItem());
            itemGroup.add(VERTICAL_PRISMARINE_BRICK_SLAB.asItem());
            itemGroup.add(VERTICAL_DARK_PRISMARINE_SLAB.asItem());
            itemGroup.add(VERTICAL_NETHER_BRICK_SLAB.asItem());
            itemGroup.add(VERTICAL_RED_NETHER_BRICK_SLAB.asItem());
            itemGroup.add(VERTICAL_BLACKSTONE_SLAB.asItem());
            itemGroup.add(VERTICAL_POLISHED_BLACKSTONE_SLAB.asItem());
            itemGroup.add(VERTICAL_POLISHED_BLACKSTONE_BRICK_SLAB.asItem());
            itemGroup.add(VERTICAL_END_STONE_BRICK_SLAB.asItem());
            itemGroup.add(VERTICAL_PURPUR_SLAB.asItem());
            itemGroup.add(VERTICAL_QUARTZ_SLAB.asItem());
            itemGroup.add(VERTICAL_SMOOTH_QUARTZ_SLAB.asItem());
            itemGroup.add(VERTICAL_CUT_COPPER_SLAB.asItem());
            itemGroup.add(EXPOSED_VERTICAL_CUT_COPPER_SLAB.asItem());
            itemGroup.add(WEATHERED_VERTICAL_CUT_COPPER_SLAB.asItem());
            itemGroup.add(OXIDIZED_VERTICAL_CUT_COPPER_SLAB.asItem());
            itemGroup.add(WAXED_VERTICAL_CUT_COPPER_SLAB.asItem());
            itemGroup.add(WAXED_EXPOSED_VERTICAL_CUT_COPPER_SLAB.asItem());
            itemGroup.add(WAXED_WEATHERED_VERTICAL_CUT_COPPER_SLAB.asItem());
            itemGroup.add(WAXED_OXIDIZED_VERTICAL_CUT_COPPER_SLAB.asItem());
        });

        OxidizableBlocksRegistry.registerOxidizableBlockPair(VERTICAL_CUT_COPPER_SLAB, EXPOSED_VERTICAL_CUT_COPPER_SLAB);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(EXPOSED_VERTICAL_CUT_COPPER_SLAB, WEATHERED_VERTICAL_CUT_COPPER_SLAB);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(WEATHERED_VERTICAL_CUT_COPPER_SLAB, OXIDIZED_VERTICAL_CUT_COPPER_SLAB);
        OxidizableBlocksRegistry.registerWaxableBlockPair(VERTICAL_CUT_COPPER_SLAB, WAXED_VERTICAL_CUT_COPPER_SLAB);
        OxidizableBlocksRegistry.registerWaxableBlockPair(EXPOSED_VERTICAL_CUT_COPPER_SLAB, WAXED_EXPOSED_VERTICAL_CUT_COPPER_SLAB);
        OxidizableBlocksRegistry.registerWaxableBlockPair(WEATHERED_VERTICAL_CUT_COPPER_SLAB, WAXED_WEATHERED_VERTICAL_CUT_COPPER_SLAB);
        OxidizableBlocksRegistry.registerWaxableBlockPair(OXIDIZED_VERTICAL_CUT_COPPER_SLAB, WAXED_OXIDIZED_VERTICAL_CUT_COPPER_SLAB);

        int verticalSlabBurnTicks = 150; // 0.75 of an item, which takes 200 ticks, as of 1.21.4.

        FuelRegistryEvents.BUILD.register(((builder, context) -> builder.add(VerticalSlabs.VERTICAL_FLAMMABLE_SLABS_ITEMS, verticalSlabBurnTicks)));

        // Try to add vertical wooden slabs to flammables in fire block
        FlammableBlockRegistry.getDefaultInstance().add(VerticalSlabs.VERTICAL_FLAMMABLE_SLABS, 5, 20);
//        RegistryEntryAddedCallback.event(Registries.BLOCK).register(((rawId, id, object) -> {
//            if (object.equals(Blocks.FIRE)) {
//                FireBlock fire = (FireBlock) object;
//                FlammableBlockRegistry.getInstance(fire).add(VerticalSlabs.VERTICAL_FLAMMABLE_SLABS, verticalSlabBurnChance, verticalSlabSpreadChance);
//            }
//        }));
    }

    public static final Block VERTICAL_OAK_SLAB = register(
            Settings.copy(OAK_SLAB),
            "vertical_oak_slab",
            true
    );

    public static final Block VERTICAL_SPRUCE_SLAB = register(
            Settings.copy(SPRUCE_SLAB),
            "vertical_spruce_slab",
            true
    );

    public static final Block VERTICAL_BIRCH_SLAB = register(
            Settings.copy(BIRCH_SLAB),
            "vertical_birch_slab",
            true
    );

    public static final Block VERTICAL_JUNGLE_SLAB = register(
            Settings.copy(JUNGLE_SLAB),
            "vertical_jungle_slab",
            true
    );

    public static final Block VERTICAL_ACACIA_SLAB = register(
            Settings.copy(ACACIA_SLAB),
            "vertical_acacia_slab",
            true
    );

    public static final Block VERTICAL_DARK_OAK_SLAB = register(
            Settings.copy(DARK_OAK_SLAB),
            "vertical_dark_oak_slab",
            true
    );

    public static final Block VERTICAL_MANGROVE_SLAB = register(
            Settings.copy(MANGROVE_SLAB),
            "vertical_mangrove_slab",
            true
    );

    public static final Block VERTICAL_CHERRY_SLAB = register(
            Settings.copy(CHERRY_SLAB),
            "vertical_cherry_slab",
            true
    );

    public static final Block VERTICAL_PALE_OAK_SLAB = register(
            Settings.copy(PALE_OAK_SLAB),
            "vertical_pale_oak_slab",
            true
    );

    public static final Block VERTICAL_BAMBOO_SLAB = register(
            Settings.copy(BAMBOO_SLAB),
            "vertical_bamboo_slab",
            true
    );

    public static final Block VERTICAL_BAMBOO_MOSAIC_SLAB = register(
            Settings.copy(BAMBOO_MOSAIC_SLAB),
            "vertical_bamboo_mosaic_slab",
            true
    );

    public static final Block VERTICAL_CRIMSON_SLAB = register(
            Settings.copy(CRIMSON_SLAB),
            "vertical_crimson_slab",
            true
    );

    public static final Block VERTICAL_WARPED_SLAB = register(
            Settings.copy(WARPED_SLAB),
            "vertical_warped_slab",
            true
    );

    public static final Block VERTICAL_STONE_SLAB = register(
            Settings.copy(STONE_SLAB),
            "vertical_stone_slab",
            true
    );

    public static final Block VERTICAL_SMOOTH_STONE_SLAB = register(
            Settings.copy(SMOOTH_STONE_SLAB),
            "vertical_smooth_stone_slab",
            true
    );

    public static final Block VERTICAL_COBBLESTONE_SLAB = register(
            Settings.copy(COBBLESTONE_SLAB),
            "vertical_cobblestone_slab",
            true
    );

    public static final Block VERTICAL_MOSSY_COBBLESTONE_SLAB = register(
            Settings.copy(MOSSY_COBBLESTONE_SLAB),
            "vertical_mossy_cobblestone_slab",
            true
    );

    public static final Block VERTICAL_STONE_BRICK_SLAB = register(
            Settings.copy(STONE_BRICK_SLAB),
            "vertical_stone_brick_slab",
            true
    );

    public static final Block VERTICAL_MOSSY_STONE_BRICK_SLAB = register(
            Settings.copy(MOSSY_STONE_BRICK_SLAB),
            "vertical_mossy_stone_brick_slab",
            true
    );

    public static final Block VERTICAL_GRANITE_SLAB = register(
            Settings.copy(GRANITE_SLAB),
            "vertical_granite_slab",
            true
    );

    public static final Block VERTICAL_POLISHED_GRANITE_SLAB = register(
            Settings.copy(POLISHED_GRANITE_SLAB),
            "vertical_polished_granite_slab",
            true
    );

    public static final Block VERTICAL_DIORITE_SLAB = register(
            Settings.copy(DIORITE_SLAB),
            "vertical_diorite_slab",
            true
    );

    public static final Block VERTICAL_POLISHED_DIORITE_SLAB = register(
            Settings.copy(POLISHED_DIORITE_SLAB),
            "vertical_polished_diorite_slab",
            true
    );

    public static final Block VERTICAL_ANDESITE_SLAB = register(
            Settings.copy(ANDESITE_SLAB),
            "vertical_andesite_slab",
            true
    );

    public static final Block VERTICAL_POLISHED_ANDESITE_SLAB = register(
            Settings.copy(POLISHED_ANDESITE_SLAB),
            "vertical_polished_andesite_slab",
            true
    );

    public static final Block VERTICAL_COBBLED_DEEPSLATE_SLAB = register(
            Settings.copy(COBBLED_DEEPSLATE_SLAB),
            "vertical_cobbled_deepslate_slab",
            true
    );

    public static final Block VERTICAL_POLISHED_DEEPSLATE_SLAB = register(
            Settings.copy(POLISHED_DEEPSLATE_SLAB),
            "vertical_polished_deepslate_slab",
            true
    );

    public static final Block VERTICAL_DEEPSLATE_BRICK_SLAB = register(
            Settings.copy(DEEPSLATE_BRICK_SLAB),
            "vertical_deepslate_brick_slab",
            true
    );

    public static final Block VERTICAL_DEEPSLATE_TILE_SLAB = register(
            Settings.copy(DEEPSLATE_TILE_SLAB),
            "vertical_deepslate_tile_slab",
            true
    );

    public static final Block VERTICAL_TUFF_SLAB = register(
            Settings.copy(TUFF_SLAB),
            "vertical_tuff_slab",
            true
    );

    public static final Block VERTICAL_POLISHED_TUFF_SLAB = register(
            Settings.copy(POLISHED_TUFF_SLAB),
            "vertical_polished_tuff_slab",
            true
    );

    public static final Block VERTICAL_TUFF_BRICK_SLAB = register(
            Settings.copy(TUFF_BRICK_SLAB),
            "vertical_tuff_brick_slab",
            true
    );

    public static final Block VERTICAL_BRICK_SLAB = register(
            Settings.copy(BRICK_SLAB),
            "vertical_brick_slab",
            true
    );

    public static final Block VERTICAL_MUD_BRICK_SLAB = register(
            Settings.copy(MUD_BRICK_SLAB),
            "vertical_mud_brick_slab",
            true
    );

    public static final Block VERTICAL_RESIN_BRICK_SLAB = register(
            Settings.copy(RESIN_BRICK_SLAB),
            "vertical_resin_brick_slab",
            true
    );

    public static final Block VERTICAL_SANDSTONE_SLAB = register(
            Settings.copy(SANDSTONE_SLAB),
            "vertical_sandstone_slab",
            true
    );

    public static final Block VERTICAL_SMOOTH_SANDSTONE_SLAB = register(
            Settings.copy(SMOOTH_SANDSTONE_SLAB),
            "vertical_smooth_sandstone_slab",
            true
    );

    public static final Block VERTICAL_CUT_SANDSTONE_SLAB = register(
            Settings.copy(CUT_SANDSTONE_SLAB),
            "vertical_cut_sandstone_slab",
            true
    );

    public static final Block VERTICAL_RED_SANDSTONE_SLAB = register(
            Settings.copy(RED_SANDSTONE_SLAB),
            "vertical_red_sandstone_slab",
            true
    );

    public static final Block VERTICAL_SMOOTH_RED_SANDSTONE_SLAB = register(
            Settings.copy(SMOOTH_RED_SANDSTONE_SLAB),
            "vertical_smooth_red_sandstone_slab",
            true
    );

    public static final Block VERTICAL_CUT_RED_SANDSTONE_SLAB = register(
            Settings.copy(CUT_RED_SANDSTONE_SLAB),
            "vertical_cut_red_sandstone_slab",
            true
    );

    public static final Block VERTICAL_PRISMARINE_SLAB = register(
            Settings.copy(PRISMARINE_SLAB),
            "vertical_prismarine_slab",
            true
    );

    public static final Block VERTICAL_PRISMARINE_BRICK_SLAB = register(
            Settings.copy(PRISMARINE_BRICK_SLAB),
            "vertical_prismarine_brick_slab",
            true
    );

    public static final Block VERTICAL_DARK_PRISMARINE_SLAB = register(
            Settings.copy(DARK_PRISMARINE_SLAB),
            "vertical_dark_prismarine_slab",
            true
    );

    public static final Block VERTICAL_NETHER_BRICK_SLAB = register(
            Settings.copy(NETHER_BRICK_SLAB),
            "vertical_nether_brick_slab",
            true
    );

    public static final Block VERTICAL_RED_NETHER_BRICK_SLAB = register(
            Settings.copy(RED_NETHER_BRICK_SLAB),
            "vertical_red_nether_brick_slab",
            true
    );

    public static final Block VERTICAL_BLACKSTONE_SLAB = register(
            Settings.copy(BLACKSTONE_SLAB),
            "vertical_blackstone_slab",
            true
    );

    public static final Block VERTICAL_POLISHED_BLACKSTONE_SLAB = register(
            Settings.copy(POLISHED_BLACKSTONE_SLAB),
            "vertical_polished_blackstone_slab",
            true
    );

    public static final Block VERTICAL_POLISHED_BLACKSTONE_BRICK_SLAB = register(
            Settings.copy(POLISHED_BLACKSTONE_BRICK_SLAB),
            "vertical_polished_blackstone_brick_slab",
            true
    );

    public static final Block VERTICAL_END_STONE_BRICK_SLAB = register(
            Settings.copy(END_STONE_BRICK_SLAB),
            "vertical_end_stone_brick_slab",
            true
    );

    public static final Block VERTICAL_PURPUR_SLAB = register(
            Settings.copy(PURPUR_SLAB),
            "vertical_purpur_slab",
            true
    );

    public static final Block VERTICAL_QUARTZ_SLAB = register(
            Settings.copy(QUARTZ_SLAB),
            "vertical_quartz_slab",
            true
    );

    public static final Block VERTICAL_SMOOTH_QUARTZ_SLAB = register(
            Settings.copy(SMOOTH_QUARTZ_SLAB),
            "vertical_smooth_quartz_slab",
            true
    );

    public static final Block VERTICAL_CUT_COPPER_SLAB = registerOxidizable(
            Oxidizable.OxidationLevel.UNAFFECTED,
            Settings.copy(CUT_COPPER_SLAB),
            "vertical_cut_copper_slab",
            true
    );

    public static final Block EXPOSED_VERTICAL_CUT_COPPER_SLAB = registerOxidizable(
            Oxidizable.OxidationLevel.EXPOSED, Settings.copy(EXPOSED_CUT_COPPER_SLAB),
            "exposed_vertical_cut_copper_slab",
            true
    );

    public static final Block WEATHERED_VERTICAL_CUT_COPPER_SLAB = registerOxidizable(
            Oxidizable.OxidationLevel.WEATHERED, Settings.copy(WEATHERED_CUT_COPPER_SLAB),
            "weathered_vertical_cut_copper_slab",
            true
    );

    public static final Block OXIDIZED_VERTICAL_CUT_COPPER_SLAB = registerOxidizable(
            Oxidizable.OxidationLevel.OXIDIZED, Settings.copy(OXIDIZED_CUT_COPPER_SLAB),
            "oxidized_vertical_cut_copper_slab",
            true
    );

    public static final Block WAXED_VERTICAL_CUT_COPPER_SLAB = registerOxidizable(
            Oxidizable.OxidationLevel.UNAFFECTED, Settings.copy(CUT_COPPER_SLAB),
            "waxed_vertical_cut_copper_slab",
            true
    );

    public static final Block WAXED_EXPOSED_VERTICAL_CUT_COPPER_SLAB = registerOxidizable(
            Oxidizable.OxidationLevel.EXPOSED, Settings.copy(EXPOSED_CUT_COPPER_SLAB),
            "waxed_exposed_vertical_cut_copper_slab",
            true
    );

    public static final Block WAXED_WEATHERED_VERTICAL_CUT_COPPER_SLAB = registerOxidizable(
            Oxidizable.OxidationLevel.WEATHERED, Settings.copy(WEATHERED_CUT_COPPER_SLAB),
            "waxed_weathered_vertical_cut_copper_slab",
            true
    );

    public static final Block WAXED_OXIDIZED_VERTICAL_CUT_COPPER_SLAB = registerOxidizable(
            Oxidizable.OxidationLevel.OXIDIZED, Settings.copy(OXIDIZED_CUT_COPPER_SLAB),
            "waxed_oxidized_vertical_cut_copper_slab",
            true
    );
}
