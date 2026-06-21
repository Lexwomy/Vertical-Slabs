package lexwomy.verticalslabs.block;

import static net.minecraft.world.level.block.Blocks.*;

import java.util.function.Function;
import java.util.stream.Stream;
import lexwomy.verticalslabs.VerticalSlabs;
import lexwomy.verticalslabs.references.VerticalSlabBlockItemIds;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelValueEvents;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopperCollection;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class VerticalSlab {
  public static final ResourceKey<CreativeModeTab> VERTICAL_SLAB_GROUP_KEY =
      ResourceKey.create(
          BuiltInRegistries.CREATIVE_MODE_TAB.key(),
          Identifier.fromNamespaceAndPath(VerticalSlabs.MOD_ID, "item_group"));
  public static final Block VERTICAL_OAK_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_OAK_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(OAK_SLAB),
          true);
  public static final Block VERTICAL_SPRUCE_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_SPRUCE_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(SPRUCE_SLAB),
          true);
  public static final Block VERTICAL_BIRCH_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_BIRCH_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(BIRCH_SLAB),
          true);
  public static final Block VERTICAL_JUNGLE_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_JUNGLE_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(JUNGLE_SLAB),
          true);
  public static final Block VERTICAL_ACACIA_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_ACACIA_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(ACACIA_SLAB),
          true);
  public static final Block VERTICAL_DARK_OAK_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_DARK_OAK_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(DARK_OAK_SLAB),
          true);
  public static final Block VERTICAL_MANGROVE_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_MANGROVE_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(MANGROVE_SLAB),
          true);
  public static final Block VERTICAL_CHERRY_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_CHERRY_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(CHERRY_SLAB),
          true);
  public static final Block VERTICAL_PALE_OAK_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_PALE_OAK_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(PALE_OAK_SLAB),
          true);
  public static final Block VERTICAL_BAMBOO_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_BAMBOO_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(BAMBOO_SLAB),
          true);
  public static final Block VERTICAL_BAMBOO_MOSAIC_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_BAMBOO_MOSAIC_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(BAMBOO_MOSAIC_SLAB),
          true);
  public static final Block VERTICAL_CRIMSON_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_CRIMSON_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(CRIMSON_SLAB),
          true);
  public static final Block VERTICAL_WARPED_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_WARPED_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(WARPED_SLAB),
          true);
  public static final Block VERTICAL_STONE_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_STONE_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(STONE_SLAB),
          true);
  public static final Block VERTICAL_SMOOTH_STONE_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_SMOOTH_STONE_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(SMOOTH_STONE_SLAB),
          true);
  public static final Block VERTICAL_COBBLESTONE_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_COBBLESTONE_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(COBBLESTONE_SLAB),
          true);
  public static final Block VERTICAL_MOSSY_COBBLESTONE_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_MOSSY_COBBLESTONE_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(MOSSY_COBBLESTONE_SLAB),
          true);
  public static final Block VERTICAL_STONE_BRICK_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_STONE_BRICK_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(STONE_BRICK_SLAB),
          true);
  public static final Block VERTICAL_MOSSY_STONE_BRICK_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_MOSSY_STONE_BRICK_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(MOSSY_STONE_BRICK_SLAB),
          true);
  public static final Block VERTICAL_GRANITE_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_GRANITE_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(GRANITE_SLAB),
          true);
  public static final Block VERTICAL_POLISHED_GRANITE_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_POLISHED_GRANITE_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(POLISHED_GRANITE_SLAB),
          true);
  public static final Block VERTICAL_DIORITE_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_DIORITE_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(DIORITE_SLAB),
          true);
  public static final Block VERTICAL_POLISHED_DIORITE_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_POLISHED_DIORITE_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(POLISHED_DIORITE_SLAB),
          true);
  public static final Block VERTICAL_ANDESITE_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_ANDESITE_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(ANDESITE_SLAB),
          true);
  public static final Block VERTICAL_POLISHED_ANDESITE_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_POLISHED_ANDESITE_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(POLISHED_ANDESITE_SLAB),
          true);
  public static final Block VERTICAL_COBBLED_DEEPSLATE_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_COBBLED_DEEPSLATE_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(COBBLED_DEEPSLATE_SLAB),
          true);
  public static final Block VERTICAL_POLISHED_DEEPSLATE_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_POLISHED_DEEPSLATE_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(POLISHED_DEEPSLATE_SLAB),
          true);
  public static final Block VERTICAL_DEEPSLATE_BRICK_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_DEEPSLATE_BRICK_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(DEEPSLATE_BRICK_SLAB),
          true);
  public static final Block VERTICAL_DEEPSLATE_TILE_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_DEEPSLATE_TILE_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(DEEPSLATE_TILE_SLAB),
          true);
  public static final Block VERTICAL_TUFF_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_TUFF_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(TUFF_SLAB),
          true);
  public static final Block VERTICAL_POLISHED_TUFF_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_POLISHED_TUFF_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(POLISHED_TUFF_SLAB),
          true);
  public static final Block VERTICAL_TUFF_BRICK_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_TUFF_BRICK_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(TUFF_BRICK_SLAB),
          true);
  public static final Block VERTICAL_BRICK_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_BRICK_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(BRICK_SLAB),
          true);
  public static final Block VERTICAL_MUD_BRICK_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_MUD_BRICK_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(MUD_BRICK_SLAB),
          true);
  public static final Block VERTICAL_RESIN_BRICK_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_RESIN_BRICK_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(RESIN_BRICK_SLAB),
          true);
  public static final Block VERTICAL_SANDSTONE_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_SANDSTONE_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(SANDSTONE_SLAB),
          true);
  public static final Block VERTICAL_SMOOTH_SANDSTONE_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_SMOOTH_SANDSTONE_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(SMOOTH_SANDSTONE_SLAB),
          true);
  public static final Block VERTICAL_CUT_SANDSTONE_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_CUT_SANDSTONE_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(CUT_SANDSTONE_SLAB),
          true);
  public static final Block VERTICAL_RED_SANDSTONE_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_RED_SANDSTONE_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(RED_SANDSTONE_SLAB),
          true);
  public static final Block VERTICAL_SMOOTH_RED_SANDSTONE_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_SMOOTH_RED_SANDSTONE_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(SMOOTH_RED_SANDSTONE_SLAB),
          true);
  public static final Block VERTICAL_CUT_RED_SANDSTONE_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_CUT_RED_SANDSTONE_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(CUT_RED_SANDSTONE_SLAB),
          true);
  public static final Block VERTICAL_PRISMARINE_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_PRISMARINE_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(PRISMARINE_SLAB),
          true);
  public static final Block VERTICAL_PRISMARINE_BRICK_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_PRISMARINE_BRICK_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(PRISMARINE_BRICK_SLAB),
          true);
  public static final Block VERTICAL_DARK_PRISMARINE_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_DARK_PRISMARINE_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(DARK_PRISMARINE_SLAB),
          true);
  public static final Block VERTICAL_NETHER_BRICK_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_NETHER_BRICK_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(NETHER_BRICK_SLAB),
          true);
  public static final Block VERTICAL_RED_NETHER_BRICK_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_RED_NETHER_BRICK_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(RED_NETHER_BRICK_SLAB),
          true);
  public static final Block VERTICAL_BLACKSTONE_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_BLACKSTONE_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(BLACKSTONE_SLAB),
          true);
  public static final Block VERTICAL_POLISHED_BLACKSTONE_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_POLISHED_BLACKSTONE_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(POLISHED_BLACKSTONE_SLAB),
          true);
  public static final Block VERTICAL_POLISHED_BLACKSTONE_BRICK_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_POLISHED_BLACKSTONE_BRICK_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(POLISHED_BLACKSTONE_BRICK_SLAB),
          true);
  public static final Block VERTICAL_END_STONE_BRICK_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_END_STONE_BRICK_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(END_STONE_BRICK_SLAB),
          true);
  public static final Block VERTICAL_PURPUR_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_PURPUR_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(PURPUR_SLAB),
          true);
  public static final Block VERTICAL_QUARTZ_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_QUARTZ_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(QUARTZ_SLAB),
          true);
  public static final Block VERTICAL_SMOOTH_QUARTZ_SLAB =
      register(
          VerticalSlabBlockItemIds.VERTICAL_SMOOTH_QUARTZ_SLAB,
          VerticalSlabBlock::new,
          Properties.ofFullCopy(SMOOTH_QUARTZ_SLAB),
          true);
  public static final WeatheringCopperCollection<Block> VERTICAL_CUT_COPPER_SLAB =
      WeatheringCopperCollection.registerBlocks(
          VerticalSlabBlockItemIds.VERTICAL_CUT_COPPER_SLAB,
          (id, factory, properties) -> register(id, factory, properties, true),
          (weatherState, properties) -> new VerticalSlabBlock(properties),
          OxidizableVerticalSlabBlock::new,
          weatherState -> Properties.ofFullCopy(CUT_COPPER_SLAB.weathering().pick(weatherState)));
  public static final CreativeModeTab VERTICAL_SLAB_GROUP =
      FabricCreativeModeTab.builder()
          .icon(() -> new ItemStack(VerticalSlab.VERTICAL_STONE_SLAB))
          .title(Component.translatable("itemGroup.vertical_slabs"))
          .displayItems(
              (params, output) ->
                  getAllVerticalSlabs().forEach(block -> output.accept(block.asItem())))
          .build();

  public static Stream<Block> getAllVerticalSlabs() {
    return Stream.concat(
        Stream.of(
            VERTICAL_OAK_SLAB,
            VERTICAL_SPRUCE_SLAB,
            VERTICAL_BIRCH_SLAB,
            VERTICAL_JUNGLE_SLAB,
            VERTICAL_ACACIA_SLAB,
            VERTICAL_DARK_OAK_SLAB,
            VERTICAL_MANGROVE_SLAB,
            VERTICAL_CHERRY_SLAB,
            VERTICAL_PALE_OAK_SLAB,
            VERTICAL_BAMBOO_SLAB,
            VERTICAL_BAMBOO_MOSAIC_SLAB,
            VERTICAL_CRIMSON_SLAB,
            VERTICAL_WARPED_SLAB,
            VERTICAL_STONE_SLAB,
            VERTICAL_COBBLESTONE_SLAB,
            VERTICAL_MOSSY_COBBLESTONE_SLAB,
            VERTICAL_SMOOTH_STONE_SLAB,
            VERTICAL_STONE_BRICK_SLAB,
            VERTICAL_MOSSY_STONE_BRICK_SLAB,
            VERTICAL_GRANITE_SLAB,
            VERTICAL_POLISHED_GRANITE_SLAB,
            VERTICAL_DIORITE_SLAB,
            VERTICAL_POLISHED_DIORITE_SLAB,
            VERTICAL_ANDESITE_SLAB,
            VERTICAL_POLISHED_ANDESITE_SLAB,
            VERTICAL_COBBLED_DEEPSLATE_SLAB,
            VERTICAL_POLISHED_DEEPSLATE_SLAB,
            VERTICAL_DEEPSLATE_BRICK_SLAB,
            VERTICAL_DEEPSLATE_TILE_SLAB,
            VERTICAL_TUFF_SLAB,
            VERTICAL_POLISHED_TUFF_SLAB,
            VERTICAL_TUFF_BRICK_SLAB,
            VERTICAL_BRICK_SLAB,
            VERTICAL_MUD_BRICK_SLAB,
            VERTICAL_RESIN_BRICK_SLAB,
            VERTICAL_SANDSTONE_SLAB,
            VERTICAL_SMOOTH_SANDSTONE_SLAB,
            VERTICAL_CUT_SANDSTONE_SLAB,
            VERTICAL_RED_SANDSTONE_SLAB,
            VERTICAL_SMOOTH_RED_SANDSTONE_SLAB,
            VERTICAL_CUT_RED_SANDSTONE_SLAB,
            VERTICAL_PRISMARINE_SLAB,
            VERTICAL_PRISMARINE_BRICK_SLAB,
            VERTICAL_DARK_PRISMARINE_SLAB,
            VERTICAL_NETHER_BRICK_SLAB,
            VERTICAL_RED_NETHER_BRICK_SLAB,
            VERTICAL_BLACKSTONE_SLAB,
            VERTICAL_POLISHED_BLACKSTONE_SLAB,
            VERTICAL_POLISHED_BLACKSTONE_BRICK_SLAB,
            VERTICAL_END_STONE_BRICK_SLAB,
            VERTICAL_PURPUR_SLAB,
            VERTICAL_QUARTZ_SLAB,
            VERTICAL_SMOOTH_QUARTZ_SLAB),
        VERTICAL_CUT_COPPER_SLAB.asList().stream());
  }

  private static Block register(
      BlockItemId name,
      Function<BlockBehaviour.Properties, Block> blockFactory,
      BlockBehaviour.Properties properties,
      boolean shouldRegisterItem) {
    Block block = blockFactory.apply(properties.setId(name.block()));

    if (shouldRegisterItem) {

      BlockItem blockItem =
          new BlockItem(
              block, new Item.Properties().setId(name.item()).useBlockDescriptionPrefix());
      Registry.register(BuiltInRegistries.ITEM, name.item(), blockItem);
    }

    return Registry.register(BuiltInRegistries.BLOCK, name.block(), block);
  }

  public static void initialize() {
    Registry.register(
        BuiltInRegistries.CREATIVE_MODE_TAB, VERTICAL_SLAB_GROUP_KEY, VERTICAL_SLAB_GROUP);

    CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
        .register(
            (itemGroup) ->
                getAllVerticalSlabs().forEach(block -> itemGroup.accept(block.asItem())));
    OxidizableBlocksRegistry.registerWeatheringCopperBlocks(VERTICAL_CUT_COPPER_SLAB);

    int verticalSlabBurnTicks = 150; // 0.75 of an item, which takes 200 ticks, as of 1.21.4.

    FuelValueEvents.BUILD.register(
        ((builder, context) ->
            builder.add(VerticalSlabs.VERTICAL_FLAMMABLE_SLABS.item(), verticalSlabBurnTicks)));

    // Try to add vertical wooden slabs to flammables in fire block
    FlammableBlockRegistry.getDefaultInstance()
        .add(VerticalSlabs.VERTICAL_FLAMMABLE_SLABS.block(), 5, 20);
  }
}
