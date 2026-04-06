package lexwomy.verticalslabs.block;

import static net.minecraft.world.level.block.Blocks.*;

import lexwomy.verticalslabs.VerticalSlabs;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelValueEvents;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class VerticalSlab {
  public static final ResourceKey<CreativeModeTab> VERTICAL_SLAB_GROUP_KEY =
      ResourceKey.create(
          BuiltInRegistries.CREATIVE_MODE_TAB.key(),
          Identifier.fromNamespaceAndPath(VerticalSlabs.MOD_ID, "item_group"));
  public static final Block VERTICAL_OAK_SLAB =
      register(Properties.ofFullCopy(OAK_SLAB), "vertical_oak_slab", true);
  public static final Block VERTICAL_SPRUCE_SLAB =
      register(Properties.ofFullCopy(SPRUCE_SLAB), "vertical_spruce_slab", true);
  public static final Block VERTICAL_BIRCH_SLAB =
      register(Properties.ofFullCopy(BIRCH_SLAB), "vertical_birch_slab", true);
  public static final Block VERTICAL_JUNGLE_SLAB =
      register(Properties.ofFullCopy(JUNGLE_SLAB), "vertical_jungle_slab", true);
  public static final Block VERTICAL_ACACIA_SLAB =
      register(Properties.ofFullCopy(ACACIA_SLAB), "vertical_acacia_slab", true);
  public static final Block VERTICAL_DARK_OAK_SLAB =
      register(Properties.ofFullCopy(DARK_OAK_SLAB), "vertical_dark_oak_slab", true);
  public static final Block VERTICAL_MANGROVE_SLAB =
      register(Properties.ofFullCopy(MANGROVE_SLAB), "vertical_mangrove_slab", true);
  public static final Block VERTICAL_CHERRY_SLAB =
      register(Properties.ofFullCopy(CHERRY_SLAB), "vertical_cherry_slab", true);
  public static final Block VERTICAL_PALE_OAK_SLAB =
      register(Properties.ofFullCopy(PALE_OAK_SLAB), "vertical_pale_oak_slab", true);
  public static final Block VERTICAL_BAMBOO_SLAB =
      register(Properties.ofFullCopy(BAMBOO_SLAB), "vertical_bamboo_slab", true);
  public static final Block VERTICAL_BAMBOO_MOSAIC_SLAB =
      register(Properties.ofFullCopy(BAMBOO_MOSAIC_SLAB), "vertical_bamboo_mosaic_slab", true);
  public static final Block VERTICAL_CRIMSON_SLAB =
      register(Properties.ofFullCopy(CRIMSON_SLAB), "vertical_crimson_slab", true);
  public static final Block VERTICAL_WARPED_SLAB =
      register(Properties.ofFullCopy(WARPED_SLAB), "vertical_warped_slab", true);
  public static final Block VERTICAL_STONE_SLAB =
      register(Properties.ofFullCopy(STONE_SLAB), "vertical_stone_slab", true);
  public static final Block VERTICAL_SMOOTH_STONE_SLAB =
      register(Properties.ofFullCopy(SMOOTH_STONE_SLAB), "vertical_smooth_stone_slab", true);
  public static final Block VERTICAL_COBBLESTONE_SLAB =
      register(Properties.ofFullCopy(COBBLESTONE_SLAB), "vertical_cobblestone_slab", true);
  public static final Block VERTICAL_MOSSY_COBBLESTONE_SLAB =
      register(
          Properties.ofFullCopy(MOSSY_COBBLESTONE_SLAB), "vertical_mossy_cobblestone_slab", true);
  public static final Block VERTICAL_STONE_BRICK_SLAB =
      register(Properties.ofFullCopy(STONE_BRICK_SLAB), "vertical_stone_brick_slab", true);
  public static final Block VERTICAL_MOSSY_STONE_BRICK_SLAB =
      register(
          Properties.ofFullCopy(MOSSY_STONE_BRICK_SLAB), "vertical_mossy_stone_brick_slab", true);
  public static final Block VERTICAL_GRANITE_SLAB =
      register(Properties.ofFullCopy(GRANITE_SLAB), "vertical_granite_slab", true);
  public static final Block VERTICAL_POLISHED_GRANITE_SLAB =
      register(
          Properties.ofFullCopy(POLISHED_GRANITE_SLAB), "vertical_polished_granite_slab", true);
  public static final Block VERTICAL_DIORITE_SLAB =
      register(Properties.ofFullCopy(DIORITE_SLAB), "vertical_diorite_slab", true);
  public static final Block VERTICAL_POLISHED_DIORITE_SLAB =
      register(
          Properties.ofFullCopy(POLISHED_DIORITE_SLAB), "vertical_polished_diorite_slab", true);
  public static final Block VERTICAL_ANDESITE_SLAB =
      register(Properties.ofFullCopy(ANDESITE_SLAB), "vertical_andesite_slab", true);
  public static final Block VERTICAL_POLISHED_ANDESITE_SLAB =
      register(
          Properties.ofFullCopy(POLISHED_ANDESITE_SLAB), "vertical_polished_andesite_slab", true);
  public static final Block VERTICAL_COBBLED_DEEPSLATE_SLAB =
      register(
          Properties.ofFullCopy(COBBLED_DEEPSLATE_SLAB), "vertical_cobbled_deepslate_slab", true);
  public static final Block VERTICAL_POLISHED_DEEPSLATE_SLAB =
      register(
          Properties.ofFullCopy(POLISHED_DEEPSLATE_SLAB), "vertical_polished_deepslate_slab", true);
  public static final Block VERTICAL_DEEPSLATE_BRICK_SLAB =
      register(Properties.ofFullCopy(DEEPSLATE_BRICK_SLAB), "vertical_deepslate_brick_slab", true);
  public static final Block VERTICAL_DEEPSLATE_TILE_SLAB =
      register(Properties.ofFullCopy(DEEPSLATE_TILE_SLAB), "vertical_deepslate_tile_slab", true);
  public static final Block VERTICAL_TUFF_SLAB =
      register(Properties.ofFullCopy(TUFF_SLAB), "vertical_tuff_slab", true);
  public static final Block VERTICAL_POLISHED_TUFF_SLAB =
      register(Properties.ofFullCopy(POLISHED_TUFF_SLAB), "vertical_polished_tuff_slab", true);
  public static final Block VERTICAL_TUFF_BRICK_SLAB =
      register(Properties.ofFullCopy(TUFF_BRICK_SLAB), "vertical_tuff_brick_slab", true);
  public static final Block VERTICAL_BRICK_SLAB =
      register(Properties.ofFullCopy(BRICK_SLAB), "vertical_brick_slab", true);
  public static final Block VERTICAL_MUD_BRICK_SLAB =
      register(Properties.ofFullCopy(MUD_BRICK_SLAB), "vertical_mud_brick_slab", true);
  public static final Block VERTICAL_RESIN_BRICK_SLAB =
      register(Properties.ofFullCopy(RESIN_BRICK_SLAB), "vertical_resin_brick_slab", true);
  public static final Block VERTICAL_SANDSTONE_SLAB =
      register(Properties.ofFullCopy(SANDSTONE_SLAB), "vertical_sandstone_slab", true);
  public static final Block VERTICAL_SMOOTH_SANDSTONE_SLAB =
      register(
          Properties.ofFullCopy(SMOOTH_SANDSTONE_SLAB), "vertical_smooth_sandstone_slab", true);
  public static final Block VERTICAL_CUT_SANDSTONE_SLAB =
      register(Properties.ofFullCopy(CUT_SANDSTONE_SLAB), "vertical_cut_sandstone_slab", true);
  public static final Block VERTICAL_RED_SANDSTONE_SLAB =
      register(Properties.ofFullCopy(RED_SANDSTONE_SLAB), "vertical_red_sandstone_slab", true);
  public static final Block VERTICAL_SMOOTH_RED_SANDSTONE_SLAB =
      register(
          Properties.ofFullCopy(SMOOTH_RED_SANDSTONE_SLAB),
          "vertical_smooth_red_sandstone_slab",
          true);
  public static final Block VERTICAL_CUT_RED_SANDSTONE_SLAB =
      register(
          Properties.ofFullCopy(CUT_RED_SANDSTONE_SLAB), "vertical_cut_red_sandstone_slab", true);
  public static final Block VERTICAL_PRISMARINE_SLAB =
      register(Properties.ofFullCopy(PRISMARINE_SLAB), "vertical_prismarine_slab", true);
  public static final Block VERTICAL_PRISMARINE_BRICK_SLAB =
      register(
          Properties.ofFullCopy(PRISMARINE_BRICK_SLAB), "vertical_prismarine_brick_slab", true);
  public static final Block VERTICAL_DARK_PRISMARINE_SLAB =
      register(Properties.ofFullCopy(DARK_PRISMARINE_SLAB), "vertical_dark_prismarine_slab", true);
  public static final Block VERTICAL_NETHER_BRICK_SLAB =
      register(Properties.ofFullCopy(NETHER_BRICK_SLAB), "vertical_nether_brick_slab", true);
  public static final Block VERTICAL_RED_NETHER_BRICK_SLAB =
      register(
          Properties.ofFullCopy(RED_NETHER_BRICK_SLAB), "vertical_red_nether_brick_slab", true);
  public static final Block VERTICAL_BLACKSTONE_SLAB =
      register(Properties.ofFullCopy(BLACKSTONE_SLAB), "vertical_blackstone_slab", true);
  public static final Block VERTICAL_POLISHED_BLACKSTONE_SLAB =
      register(
          Properties.ofFullCopy(POLISHED_BLACKSTONE_SLAB),
          "vertical_polished_blackstone_slab",
          true);
  public static final Block VERTICAL_POLISHED_BLACKSTONE_BRICK_SLAB =
      register(
          Properties.ofFullCopy(POLISHED_BLACKSTONE_BRICK_SLAB),
          "vertical_polished_blackstone_brick_slab",
          true);
  public static final Block VERTICAL_END_STONE_BRICK_SLAB =
      register(Properties.ofFullCopy(END_STONE_BRICK_SLAB), "vertical_end_stone_brick_slab", true);
  public static final Block VERTICAL_PURPUR_SLAB =
      register(Properties.ofFullCopy(PURPUR_SLAB), "vertical_purpur_slab", true);
  public static final Block VERTICAL_QUARTZ_SLAB =
      register(Properties.ofFullCopy(QUARTZ_SLAB), "vertical_quartz_slab", true);
  public static final Block VERTICAL_SMOOTH_QUARTZ_SLAB =
      register(Properties.ofFullCopy(SMOOTH_QUARTZ_SLAB), "vertical_smooth_quartz_slab", true);
  public static final Block VERTICAL_CUT_COPPER_SLAB =
      registerOxidizable(
          WeatheringCopper.WeatherState.UNAFFECTED,
          Properties.ofFullCopy(CUT_COPPER_SLAB),
          "vertical_cut_copper_slab",
          true);
  public static final Block EXPOSED_VERTICAL_CUT_COPPER_SLAB =
      registerOxidizable(
          WeatheringCopper.WeatherState.EXPOSED,
          Properties.ofFullCopy(EXPOSED_CUT_COPPER_SLAB),
          "exposed_vertical_cut_copper_slab",
          true);
  public static final Block WEATHERED_VERTICAL_CUT_COPPER_SLAB =
      registerOxidizable(
          WeatheringCopper.WeatherState.WEATHERED,
          Properties.ofFullCopy(WEATHERED_CUT_COPPER_SLAB),
          "weathered_vertical_cut_copper_slab",
          true);
  public static final Block OXIDIZED_VERTICAL_CUT_COPPER_SLAB =
      registerOxidizable(
          WeatheringCopper.WeatherState.OXIDIZED,
          Properties.ofFullCopy(OXIDIZED_CUT_COPPER_SLAB),
          "oxidized_vertical_cut_copper_slab",
          true);
  public static final Block WAXED_VERTICAL_CUT_COPPER_SLAB =
      registerOxidizable(
          WeatheringCopper.WeatherState.UNAFFECTED,
          Properties.ofFullCopy(CUT_COPPER_SLAB),
          "waxed_vertical_cut_copper_slab",
          true);
  public static final Block WAXED_EXPOSED_VERTICAL_CUT_COPPER_SLAB =
      registerOxidizable(
          WeatheringCopper.WeatherState.EXPOSED,
          Properties.ofFullCopy(EXPOSED_CUT_COPPER_SLAB),
          "waxed_exposed_vertical_cut_copper_slab",
          true);
  public static final Block WAXED_WEATHERED_VERTICAL_CUT_COPPER_SLAB =
      registerOxidizable(
          WeatheringCopper.WeatherState.WEATHERED,
          Properties.ofFullCopy(WEATHERED_CUT_COPPER_SLAB),
          "waxed_weathered_vertical_cut_copper_slab",
          true);
  public static final Block WAXED_OXIDIZED_VERTICAL_CUT_COPPER_SLAB =
      registerOxidizable(
          WeatheringCopper.WeatherState.OXIDIZED,
          Properties.ofFullCopy(OXIDIZED_CUT_COPPER_SLAB),
          "waxed_oxidized_vertical_cut_copper_slab",
          true);
  public static final CreativeModeTab VERTICAL_SLAB_GROUP =
      FabricCreativeModeTab.builder()
          .icon(() -> new ItemStack(VerticalSlab.VERTICAL_STONE_SLAB))
          .title(Component.translatable("itemGroup.vertical_slabs"))
          .displayItems(
              (params, output) -> {
                output.accept(VERTICAL_OAK_SLAB.asItem());
                output.accept(VERTICAL_SPRUCE_SLAB.asItem());
                output.accept(VERTICAL_BIRCH_SLAB.asItem());
                output.accept(VERTICAL_JUNGLE_SLAB.asItem());
                output.accept(VERTICAL_ACACIA_SLAB.asItem());
                output.accept(VERTICAL_DARK_OAK_SLAB.asItem());
                output.accept(VERTICAL_MANGROVE_SLAB.asItem());
                output.accept(VERTICAL_CHERRY_SLAB.asItem());
                output.accept(VERTICAL_PALE_OAK_SLAB.asItem());
                output.accept(VERTICAL_BAMBOO_SLAB.asItem());
                output.accept(VERTICAL_BAMBOO_MOSAIC_SLAB.asItem());
                output.accept(VERTICAL_CRIMSON_SLAB.asItem());
                output.accept(VERTICAL_WARPED_SLAB.asItem());
                output.accept(VERTICAL_STONE_SLAB.asItem());
                output.accept(VERTICAL_COBBLESTONE_SLAB.asItem());
                output.accept(VERTICAL_MOSSY_COBBLESTONE_SLAB.asItem());
                output.accept(VERTICAL_SMOOTH_STONE_SLAB.asItem());
                output.accept(VERTICAL_STONE_BRICK_SLAB.asItem());
                output.accept(VERTICAL_MOSSY_STONE_BRICK_SLAB.asItem());
                output.accept(VERTICAL_GRANITE_SLAB.asItem());
                output.accept(VERTICAL_POLISHED_GRANITE_SLAB.asItem());
                output.accept(VERTICAL_DIORITE_SLAB.asItem());
                output.accept(VERTICAL_POLISHED_DIORITE_SLAB.asItem());
                output.accept(VERTICAL_ANDESITE_SLAB.asItem());
                output.accept(VERTICAL_POLISHED_ANDESITE_SLAB.asItem());
                output.accept(VERTICAL_COBBLED_DEEPSLATE_SLAB.asItem());
                output.accept(VERTICAL_POLISHED_DEEPSLATE_SLAB.asItem());
                output.accept(VERTICAL_DEEPSLATE_BRICK_SLAB.asItem());
                output.accept(VERTICAL_DEEPSLATE_TILE_SLAB.asItem());
                output.accept(VERTICAL_TUFF_SLAB.asItem());
                output.accept(VERTICAL_POLISHED_TUFF_SLAB.asItem());
                output.accept(VERTICAL_TUFF_BRICK_SLAB.asItem());
                output.accept(VERTICAL_BRICK_SLAB.asItem());
                output.accept(VERTICAL_MUD_BRICK_SLAB.asItem());
                output.accept(VERTICAL_RESIN_BRICK_SLAB.asItem());
                output.accept(VERTICAL_SANDSTONE_SLAB.asItem());
                output.accept(VERTICAL_SMOOTH_SANDSTONE_SLAB.asItem());
                output.accept(VERTICAL_CUT_SANDSTONE_SLAB.asItem());
                output.accept(VERTICAL_RED_SANDSTONE_SLAB.asItem());
                output.accept(VERTICAL_SMOOTH_RED_SANDSTONE_SLAB.asItem());
                output.accept(VERTICAL_CUT_RED_SANDSTONE_SLAB.asItem());
                output.accept(VERTICAL_PRISMARINE_SLAB.asItem());
                output.accept(VERTICAL_PRISMARINE_BRICK_SLAB.asItem());
                output.accept(VERTICAL_DARK_PRISMARINE_SLAB.asItem());
                output.accept(VERTICAL_NETHER_BRICK_SLAB.asItem());
                output.accept(VERTICAL_RED_NETHER_BRICK_SLAB.asItem());
                output.accept(VERTICAL_BLACKSTONE_SLAB.asItem());
                output.accept(VERTICAL_POLISHED_BLACKSTONE_SLAB.asItem());
                output.accept(VERTICAL_POLISHED_BLACKSTONE_BRICK_SLAB.asItem());
                output.accept(VERTICAL_END_STONE_BRICK_SLAB.asItem());
                output.accept(VERTICAL_PURPUR_SLAB.asItem());
                output.accept(VERTICAL_QUARTZ_SLAB.asItem());
                output.accept(VERTICAL_SMOOTH_QUARTZ_SLAB.asItem());
                output.accept(VERTICAL_CUT_COPPER_SLAB.asItem());
                output.accept(EXPOSED_VERTICAL_CUT_COPPER_SLAB.asItem());
                output.accept(WEATHERED_VERTICAL_CUT_COPPER_SLAB.asItem());
                output.accept(OXIDIZED_VERTICAL_CUT_COPPER_SLAB.asItem());
                output.accept(WAXED_VERTICAL_CUT_COPPER_SLAB.asItem());
                output.accept(WAXED_EXPOSED_VERTICAL_CUT_COPPER_SLAB.asItem());
                output.accept(WAXED_WEATHERED_VERTICAL_CUT_COPPER_SLAB.asItem());
                output.accept(WAXED_OXIDIZED_VERTICAL_CUT_COPPER_SLAB.asItem());
              })
          .build();

  public static Block register(Properties settings, String name, boolean shouldRegisterItem) {
    Identifier id = Identifier.fromNamespaceAndPath(VerticalSlabs.MOD_ID, name);
    ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, id);
    Properties blockSettings = settings.setId(key);
    Block block =
        Registry.register(BuiltInRegistries.BLOCK, key, new VerticalSlabBlock(blockSettings));

    if (shouldRegisterItem) {
      ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, id);
      Item.Properties itemSettings =
          new Item.Properties().useBlockDescriptionPrefix().setId(itemKey);
      Registry.register(BuiltInRegistries.ITEM, itemKey, new BlockItem(block, itemSettings));
    }

    return block;
  }

  public static Block registerOxidizable(
      WeatheringCopper.WeatherState level,
      Properties settings,
      String name,
      boolean shouldRegisterItem) {
    Identifier id = Identifier.fromNamespaceAndPath(VerticalSlabs.MOD_ID, name);
    ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, id);
    Properties blockSettings = settings.setId(key);
    Block block =
        Registry.register(
            BuiltInRegistries.BLOCK, key, new OxidizableVerticalSlabBlock(level, blockSettings));

    if (shouldRegisterItem) {
      ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, id);
      Item.Properties itemSettings =
          new Item.Properties().useBlockDescriptionPrefix().setId(itemKey);
      Registry.register(BuiltInRegistries.ITEM, itemKey, new BlockItem(block, itemSettings));
    }

    return block;
  }

  public static void initialize() {
    Registry.register(
        BuiltInRegistries.CREATIVE_MODE_TAB, VERTICAL_SLAB_GROUP_KEY, VERTICAL_SLAB_GROUP);

    CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
        .register(
            (itemGroup) -> {
              itemGroup.accept(VERTICAL_OAK_SLAB.asItem());
              itemGroup.accept(VERTICAL_SPRUCE_SLAB.asItem());
              itemGroup.accept(VERTICAL_BIRCH_SLAB.asItem());
              itemGroup.accept(VERTICAL_JUNGLE_SLAB.asItem());
              itemGroup.accept(VERTICAL_ACACIA_SLAB.asItem());
              itemGroup.accept(VERTICAL_DARK_OAK_SLAB.asItem());
              itemGroup.accept(VERTICAL_MANGROVE_SLAB.asItem());
              itemGroup.accept(VERTICAL_CHERRY_SLAB.asItem());
              itemGroup.accept(VERTICAL_PALE_OAK_SLAB.asItem());
              itemGroup.accept(VERTICAL_BAMBOO_SLAB.asItem());
              itemGroup.accept(VERTICAL_BAMBOO_MOSAIC_SLAB.asItem());
              itemGroup.accept(VERTICAL_CRIMSON_SLAB.asItem());
              itemGroup.accept(VERTICAL_WARPED_SLAB.asItem());
              itemGroup.accept(VERTICAL_STONE_SLAB.asItem());
              itemGroup.accept(VERTICAL_COBBLESTONE_SLAB.asItem());
              itemGroup.accept(VERTICAL_MOSSY_COBBLESTONE_SLAB.asItem());
              itemGroup.accept(VERTICAL_SMOOTH_STONE_SLAB.asItem());
              itemGroup.accept(VERTICAL_STONE_BRICK_SLAB.asItem());
              itemGroup.accept(VERTICAL_MOSSY_STONE_BRICK_SLAB.asItem());
              itemGroup.accept(VERTICAL_GRANITE_SLAB.asItem());
              itemGroup.accept(VERTICAL_POLISHED_GRANITE_SLAB.asItem());
              itemGroup.accept(VERTICAL_DIORITE_SLAB.asItem());
              itemGroup.accept(VERTICAL_POLISHED_DIORITE_SLAB.asItem());
              itemGroup.accept(VERTICAL_ANDESITE_SLAB.asItem());
              itemGroup.accept(VERTICAL_POLISHED_ANDESITE_SLAB.asItem());
              itemGroup.accept(VERTICAL_COBBLED_DEEPSLATE_SLAB.asItem());
              itemGroup.accept(VERTICAL_POLISHED_DEEPSLATE_SLAB.asItem());
              itemGroup.accept(VERTICAL_DEEPSLATE_BRICK_SLAB.asItem());
              itemGroup.accept(VERTICAL_DEEPSLATE_TILE_SLAB.asItem());
              itemGroup.accept(VERTICAL_TUFF_SLAB.asItem());
              itemGroup.accept(VERTICAL_POLISHED_TUFF_SLAB.asItem());
              itemGroup.accept(VERTICAL_TUFF_BRICK_SLAB.asItem());
              itemGroup.accept(VERTICAL_BRICK_SLAB.asItem());
              itemGroup.accept(VERTICAL_MUD_BRICK_SLAB.asItem());
              itemGroup.accept(VERTICAL_RESIN_BRICK_SLAB.asItem());
              itemGroup.accept(VERTICAL_SANDSTONE_SLAB.asItem());
              itemGroup.accept(VERTICAL_SMOOTH_SANDSTONE_SLAB.asItem());
              itemGroup.accept(VERTICAL_CUT_SANDSTONE_SLAB.asItem());
              itemGroup.accept(VERTICAL_RED_SANDSTONE_SLAB.asItem());
              itemGroup.accept(VERTICAL_SMOOTH_RED_SANDSTONE_SLAB.asItem());
              itemGroup.accept(VERTICAL_CUT_RED_SANDSTONE_SLAB.asItem());
              itemGroup.accept(VERTICAL_PRISMARINE_SLAB.asItem());
              itemGroup.accept(VERTICAL_PRISMARINE_BRICK_SLAB.asItem());
              itemGroup.accept(VERTICAL_DARK_PRISMARINE_SLAB.asItem());
              itemGroup.accept(VERTICAL_NETHER_BRICK_SLAB.asItem());
              itemGroup.accept(VERTICAL_RED_NETHER_BRICK_SLAB.asItem());
              itemGroup.accept(VERTICAL_BLACKSTONE_SLAB.asItem());
              itemGroup.accept(VERTICAL_POLISHED_BLACKSTONE_SLAB.asItem());
              itemGroup.accept(VERTICAL_POLISHED_BLACKSTONE_BRICK_SLAB.asItem());
              itemGroup.accept(VERTICAL_END_STONE_BRICK_SLAB.asItem());
              itemGroup.accept(VERTICAL_PURPUR_SLAB.asItem());
              itemGroup.accept(VERTICAL_QUARTZ_SLAB.asItem());
              itemGroup.accept(VERTICAL_SMOOTH_QUARTZ_SLAB.asItem());
              itemGroup.accept(VERTICAL_CUT_COPPER_SLAB.asItem());
              itemGroup.accept(EXPOSED_VERTICAL_CUT_COPPER_SLAB.asItem());
              itemGroup.accept(WEATHERED_VERTICAL_CUT_COPPER_SLAB.asItem());
              itemGroup.accept(OXIDIZED_VERTICAL_CUT_COPPER_SLAB.asItem());
              itemGroup.accept(WAXED_VERTICAL_CUT_COPPER_SLAB.asItem());
              itemGroup.accept(WAXED_EXPOSED_VERTICAL_CUT_COPPER_SLAB.asItem());
              itemGroup.accept(WAXED_WEATHERED_VERTICAL_CUT_COPPER_SLAB.asItem());
              itemGroup.accept(WAXED_OXIDIZED_VERTICAL_CUT_COPPER_SLAB.asItem());
            });

    OxidizableBlocksRegistry.registerNextStage(
        VERTICAL_CUT_COPPER_SLAB, EXPOSED_VERTICAL_CUT_COPPER_SLAB);
    OxidizableBlocksRegistry.registerNextStage(
        EXPOSED_VERTICAL_CUT_COPPER_SLAB, WEATHERED_VERTICAL_CUT_COPPER_SLAB);
    OxidizableBlocksRegistry.registerNextStage(
        WEATHERED_VERTICAL_CUT_COPPER_SLAB, OXIDIZED_VERTICAL_CUT_COPPER_SLAB);
    OxidizableBlocksRegistry.registerWaxable(
        VERTICAL_CUT_COPPER_SLAB, WAXED_VERTICAL_CUT_COPPER_SLAB);
    OxidizableBlocksRegistry.registerWaxable(
        EXPOSED_VERTICAL_CUT_COPPER_SLAB, WAXED_EXPOSED_VERTICAL_CUT_COPPER_SLAB);
    OxidizableBlocksRegistry.registerWaxable(
        WEATHERED_VERTICAL_CUT_COPPER_SLAB, WAXED_WEATHERED_VERTICAL_CUT_COPPER_SLAB);
    OxidizableBlocksRegistry.registerWaxable(
        OXIDIZED_VERTICAL_CUT_COPPER_SLAB, WAXED_OXIDIZED_VERTICAL_CUT_COPPER_SLAB);

    int verticalSlabBurnTicks = 150; // 0.75 of an item, which takes 200 ticks, as of 1.21.4.

    FuelValueEvents.BUILD.register(
        ((builder, context) ->
            builder.add(VerticalSlabs.VERTICAL_FLAMMABLE_SLABS_ITEMS, verticalSlabBurnTicks)));

    // Try to add vertical wooden slabs to flammables in fire block
    FlammableBlockRegistry.getDefaultInstance().add(VerticalSlabs.VERTICAL_FLAMMABLE_SLABS, 5, 20);
  }
}
