package lexwomy.verticalslabs;

import com.mojang.datafixers.util.Pair;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;
import lexwomy.verticalslabs.block.VerticalSlab;
import lexwomy.verticalslabs.block.VerticalSlabBlock;
import lexwomy.verticalslabs.block.VerticalSlabType;
import lexwomy.verticalslabs.data.*;
import lexwomy.verticalslabs.references.VerticalSlabBlockItemIds;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.advancements.predicates.StatePropertiesPredicate;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.tags.TagAppender;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.WeatheringCopperCollection;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.jetbrains.annotations.Nullable;

public class VerticalSlabsDataGenerator implements DataGeneratorEntrypoint {
  private static final List<VerticalSlabDetails> VERTICAL_SLAB_DETAILS =
      List.of(
          VerticalSlabDetails.createFromCutCopperCollection(
              "Exposed Vertical Cut Copper Slab", WeatheringCopper.WeatherState.EXPOSED, false),
          VerticalSlabDetails.createFromCutCopperCollection(
              "Oxidized Vertical Cut Copper Slab", WeatheringCopper.WeatherState.OXIDIZED, false),
          new VerticalSlabDetails(
              "Vertical Acacia Slab",
              VerticalSlabBlockItemIds.VERTICAL_ACACIA_SLAB,
              VerticalSlab.VERTICAL_ACACIA_SLAB,
              Blocks.ACACIA_PLANKS,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.ACACIA_PLANKS)),
          new VerticalSlabDetails(
              "Vertical Andesite Slab",
              VerticalSlabBlockItemIds.VERTICAL_ANDESITE_SLAB,
              VerticalSlab.VERTICAL_ANDESITE_SLAB,
              Blocks.ANDESITE,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.ANDESITE),
              List.of(Blocks.ANDESITE)),
          new VerticalSlabDetails(
              "Vertical Bamboo Mosaic Slab",
              VerticalSlabBlockItemIds.VERTICAL_BAMBOO_MOSAIC_SLAB,
              VerticalSlab.VERTICAL_BAMBOO_MOSAIC_SLAB,
              Blocks.BAMBOO_MOSAIC,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.BAMBOO_MOSAIC)),
          new VerticalSlabDetails(
              "Vertical Bamboo Slab",
              VerticalSlabBlockItemIds.VERTICAL_BAMBOO_SLAB,
              VerticalSlab.VERTICAL_BAMBOO_SLAB,
              Blocks.BAMBOO_PLANKS,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.BAMBOO_PLANKS)),
          new VerticalSlabDetails(
              "Vertical Birch Slab",
              VerticalSlabBlockItemIds.VERTICAL_BIRCH_SLAB,
              VerticalSlab.VERTICAL_BIRCH_SLAB,
              Blocks.BIRCH_PLANKS,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.BIRCH_PLANKS)),
          new VerticalSlabDetails(
              "Vertical Blackstone Slab",
              VerticalSlabBlockItemIds.VERTICAL_BLACKSTONE_SLAB,
              VerticalSlab.VERTICAL_BLACKSTONE_SLAB,
              Blocks.BLACKSTONE,
              new BottomTopBasedBlockModelGenerator(
                  VerticalSlabTexturedModels.VERTICAL_BOTTOM_SLAB_COLUMN,
                  VerticalSlabTexturedModels.VERTICAL_TOP_SLAB_COLUMN,
                  VerticalSlabBlockStateMaps.simpleUVLockedBlockStateMap),
              List.of(Blocks.BLACKSTONE),
              List.of(Blocks.BLACKSTONE)),
          new VerticalSlabDetails(
              "Vertical Brick Slab",
              VerticalSlabBlockItemIds.VERTICAL_BRICK_SLAB,
              VerticalSlab.VERTICAL_BRICK_SLAB,
              Blocks.BRICKS,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.BRICKS),
              List.of(Blocks.BRICKS)),
          new VerticalSlabDetails(
              "Vertical Cherry Slab",
              VerticalSlabBlockItemIds.VERTICAL_CHERRY_SLAB,
              VerticalSlab.VERTICAL_CHERRY_SLAB,
              Blocks.CHERRY_PLANKS,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.CHERRY_PLANKS)),
          new VerticalSlabDetails(
              "Vertical Cobbled Deepslate Slab",
              VerticalSlabBlockItemIds.VERTICAL_COBBLED_DEEPSLATE_SLAB,
              VerticalSlab.VERTICAL_COBBLED_DEEPSLATE_SLAB,
              Blocks.COBBLED_DEEPSLATE,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.COBBLED_DEEPSLATE),
              List.of(Blocks.COBBLED_DEEPSLATE)),
          new VerticalSlabDetails(
              "Vertical Cobblestone Slab",
              VerticalSlabBlockItemIds.VERTICAL_COBBLESTONE_SLAB,
              VerticalSlab.VERTICAL_COBBLESTONE_SLAB,
              Blocks.COBBLESTONE,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.COBBLESTONE),
              List.of(Blocks.COBBLESTONE)),
          new VerticalSlabDetails(
              "Vertical Crimson Slab",
              VerticalSlabBlockItemIds.VERTICAL_CRIMSON_SLAB,
              VerticalSlab.VERTICAL_CRIMSON_SLAB,
              Blocks.CRIMSON_PLANKS,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.CRIMSON_PLANKS)),
          VerticalSlabDetails.createFromCutCopperCollection(
              "Vertical Cut Copper Slab", WeatheringCopper.WeatherState.UNAFFECTED, false),
          new VerticalSlabDetails(
              "Vertical Cut Red Sandstone Slab",
              VerticalSlabBlockItemIds.VERTICAL_CUT_RED_SANDSTONE_SLAB,
              VerticalSlab.VERTICAL_CUT_RED_SANDSTONE_SLAB,
              Blocks.CUT_RED_SANDSTONE,
              new BottomTopBasedBlockModelGenerator(
                  VerticalSlabTexturedModels.VERTICAL_BOTTOM_SLAB_DIRECTIONAL_COLUMN.updateTexture(
                      mapping ->
                          VerticalSlabTexturedModels.editDirectionalColumnVerticalSlab(
                              mapping,
                              TextureMapping.getBlockTexture(Blocks.RED_SANDSTONE, "_top"),
                              null)),
                  VerticalSlabTexturedModels.VERTICAL_TOP_SLAB_DIRECTIONAL_COLUMN.updateTexture(
                      mapping ->
                          VerticalSlabTexturedModels.editDirectionalColumnVerticalSlab(
                              mapping,
                              TextureMapping.getBlockTexture(Blocks.RED_SANDSTONE, "_top"),
                              null)),
                  VerticalSlabTexturedModels.VERTICAL_DOUBLE_SLAB_DIRECTIONAL_COLUMN.updateTexture(
                      mapping ->
                          VerticalSlabTexturedModels.editDirectionalColumnVerticalSlab(
                              mapping,
                              TextureMapping.getBlockTexture(Blocks.RED_SANDSTONE, "_top"),
                              null)),
                  VerticalSlabBlockStateMaps.directionalBlockStateMap),
              List.of(Blocks.CUT_RED_SANDSTONE),
              List.of(Blocks.RED_SANDSTONE, Blocks.CUT_RED_SANDSTONE)),
          new VerticalSlabDetails(
              "Vertical Cut Sandstone Slab",
              VerticalSlabBlockItemIds.VERTICAL_CUT_SANDSTONE_SLAB,
              VerticalSlab.VERTICAL_CUT_SANDSTONE_SLAB,
              Blocks.CUT_SANDSTONE,
              new BottomTopBasedBlockModelGenerator(
                  VerticalSlabTexturedModels.VERTICAL_BOTTOM_SLAB_DIRECTIONAL_COLUMN.updateTexture(
                      mapping ->
                          VerticalSlabTexturedModels.editDirectionalColumnVerticalSlab(
                              mapping,
                              TextureMapping.getBlockTexture(Blocks.SANDSTONE, "_top"),
                              null)),
                  VerticalSlabTexturedModels.VERTICAL_TOP_SLAB_DIRECTIONAL_COLUMN.updateTexture(
                      mapping ->
                          VerticalSlabTexturedModels.editDirectionalColumnVerticalSlab(
                              mapping,
                              TextureMapping.getBlockTexture(Blocks.SANDSTONE, "_top"),
                              null)),
                  VerticalSlabTexturedModels.VERTICAL_DOUBLE_SLAB_DIRECTIONAL_COLUMN.updateTexture(
                      mapping ->
                          VerticalSlabTexturedModels.editDirectionalColumnVerticalSlab(
                              mapping,
                              TextureMapping.getBlockTexture(Blocks.SANDSTONE, "_top"),
                              null)),
                  VerticalSlabBlockStateMaps.directionalBlockStateMap),
              List.of(Blocks.CUT_SANDSTONE),
              List.of(Blocks.SANDSTONE, Blocks.CUT_SANDSTONE)),
          new VerticalSlabDetails(
              "Vertical Dark Oak Slab",
              VerticalSlabBlockItemIds.VERTICAL_DARK_OAK_SLAB,
              VerticalSlab.VERTICAL_DARK_OAK_SLAB,
              Blocks.DARK_OAK_PLANKS,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.DARK_OAK_PLANKS)),
          new VerticalSlabDetails(
              "Vertical Dark Prismarine Slab",
              VerticalSlabBlockItemIds.VERTICAL_DARK_PRISMARINE_SLAB,
              VerticalSlab.VERTICAL_DARK_PRISMARINE_SLAB,
              Blocks.DARK_PRISMARINE,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.DARK_PRISMARINE),
              List.of(Blocks.DARK_PRISMARINE)),
          new VerticalSlabDetails(
              "Vertical Deepslate Brick Slab",
              VerticalSlabBlockItemIds.VERTICAL_DEEPSLATE_BRICK_SLAB,
              VerticalSlab.VERTICAL_DEEPSLATE_BRICK_SLAB,
              Blocks.DEEPSLATE_BRICKS,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.DEEPSLATE_BRICKS),
              List.of(
                  Blocks.COBBLED_DEEPSLATE, Blocks.DEEPSLATE_BRICKS, Blocks.POLISHED_DEEPSLATE)),
          new VerticalSlabDetails(
              "Vertical Deepslate Tile Slab",
              VerticalSlabBlockItemIds.VERTICAL_DEEPSLATE_TILE_SLAB,
              VerticalSlab.VERTICAL_DEEPSLATE_TILE_SLAB,
              Blocks.DEEPSLATE_TILES,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.DEEPSLATE_TILES),
              List.of(
                  Blocks.COBBLED_DEEPSLATE,
                  Blocks.DEEPSLATE_BRICKS,
                  Blocks.DEEPSLATE_TILES,
                  Blocks.POLISHED_DEEPSLATE)),
          new VerticalSlabDetails(
              "Vertical Diorite Slab",
              VerticalSlabBlockItemIds.VERTICAL_DIORITE_SLAB,
              VerticalSlab.VERTICAL_DIORITE_SLAB,
              Blocks.DIORITE,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.DIORITE),
              List.of(Blocks.DIORITE)),
          new VerticalSlabDetails(
              "Vertical End Stone Brick Slab",
              VerticalSlabBlockItemIds.VERTICAL_END_STONE_BRICK_SLAB,
              VerticalSlab.VERTICAL_END_STONE_BRICK_SLAB,
              Blocks.END_STONE_BRICKS,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.END_STONE_BRICKS),
              List.of(Blocks.END_STONE_BRICKS)),
          new VerticalSlabDetails(
              "Vertical Granite Slab",
              VerticalSlabBlockItemIds.VERTICAL_GRANITE_SLAB,
              VerticalSlab.VERTICAL_GRANITE_SLAB,
              Blocks.GRANITE,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.GRANITE),
              List.of(Blocks.GRANITE)),
          new VerticalSlabDetails(
              "Vertical Jungle Slab",
              VerticalSlabBlockItemIds.VERTICAL_JUNGLE_SLAB,
              VerticalSlab.VERTICAL_JUNGLE_SLAB,
              Blocks.JUNGLE_PLANKS,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.JUNGLE_PLANKS)),
          new VerticalSlabDetails(
              "Vertical Mangrove Slab",
              VerticalSlabBlockItemIds.VERTICAL_MANGROVE_SLAB,
              VerticalSlab.VERTICAL_MANGROVE_SLAB,
              Blocks.MANGROVE_PLANKS,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.MANGROVE_PLANKS)),
          new VerticalSlabDetails(
              "Vertical Mossy Cobblestone Slab",
              VerticalSlabBlockItemIds.VERTICAL_MOSSY_COBBLESTONE_SLAB,
              VerticalSlab.VERTICAL_MOSSY_COBBLESTONE_SLAB,
              Blocks.MOSSY_COBBLESTONE,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.MOSSY_COBBLESTONE),
              List.of(Blocks.MOSSY_COBBLESTONE)),
          new VerticalSlabDetails(
              "Vertical Mossy Stone Brick Slab",
              VerticalSlabBlockItemIds.VERTICAL_MOSSY_STONE_BRICK_SLAB,
              VerticalSlab.VERTICAL_MOSSY_STONE_BRICK_SLAB,
              Blocks.MOSSY_STONE_BRICKS,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.MOSSY_STONE_BRICKS),
              List.of(Blocks.MOSSY_STONE_BRICKS)),
          new VerticalSlabDetails(
              "Vertical Mud Brick Slab",
              VerticalSlabBlockItemIds.VERTICAL_MUD_BRICK_SLAB,
              VerticalSlab.VERTICAL_MUD_BRICK_SLAB,
              Blocks.MUD_BRICKS,
              new DirectionalBasedBlockModelGenerator(
                  VerticalSlabTexturedModels.VERTICAL_NORTH_FACING_SLAB_NORTH_WEST_MIRRORED,
                  VerticalSlabTexturedModels.VERTICAL_EAST_FACING_SLAB_NORTH_WEST_MIRRORED,
                  VerticalSlabTexturedModels.VERTICAL_SOUTH_FACING_SLAB_NORTH_WEST_MIRRORED,
                  VerticalSlabTexturedModels.VERTICAL_WEST_FACING_SLAB_NORTH_WEST_MIRRORED,
                  "_north_west_mirrored",
                  VerticalSlabBlockStateMaps.northWestMirroredBlockStateMap),
              List.of(Blocks.MUD_BRICKS),
              List.of(Blocks.MUD_BRICKS)),
          new VerticalSlabDetails(
              "Vertical Nether Brick Slab",
              VerticalSlabBlockItemIds.VERTICAL_NETHER_BRICK_SLAB,
              VerticalSlab.VERTICAL_NETHER_BRICK_SLAB,
              Blocks.NETHER_BRICKS,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.NETHER_BRICKS),
              List.of(Blocks.NETHER_BRICKS)),
          new VerticalSlabDetails(
              "Vertical Oak Slab",
              VerticalSlabBlockItemIds.VERTICAL_OAK_SLAB,
              VerticalSlab.VERTICAL_OAK_SLAB,
              Blocks.OAK_PLANKS,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.OAK_PLANKS)),
          new VerticalSlabDetails(
              "Vertical Pale Oak Slab",
              VerticalSlabBlockItemIds.VERTICAL_PALE_OAK_SLAB,
              VerticalSlab.VERTICAL_PALE_OAK_SLAB,
              Blocks.PALE_OAK_PLANKS,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.PALE_OAK_PLANKS)),
          new VerticalSlabDetails(
              "Vertical Polished Andesite Slab",
              VerticalSlabBlockItemIds.VERTICAL_POLISHED_ANDESITE_SLAB,
              VerticalSlab.VERTICAL_POLISHED_ANDESITE_SLAB,
              Blocks.POLISHED_ANDESITE,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.POLISHED_ANDESITE),
              List.of(Blocks.ANDESITE, Blocks.POLISHED_ANDESITE)),
          new VerticalSlabDetails(
              "Vertical Polished Blackstone Brick Slab",
              VerticalSlabBlockItemIds.VERTICAL_POLISHED_BLACKSTONE_BRICK_SLAB,
              VerticalSlab.VERTICAL_POLISHED_BLACKSTONE_BRICK_SLAB,
              Blocks.POLISHED_BLACKSTONE_BRICKS,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.POLISHED_BLACKSTONE_BRICKS),
              List.of(
                  Blocks.BLACKSTONE,
                  Blocks.POLISHED_BLACKSTONE_BRICKS,
                  Blocks.POLISHED_BLACKSTONE)),
          new VerticalSlabDetails(
              "Vertical Polished Blackstone Slab",
              VerticalSlabBlockItemIds.VERTICAL_POLISHED_BLACKSTONE_SLAB,
              VerticalSlab.VERTICAL_POLISHED_BLACKSTONE_SLAB,
              Blocks.POLISHED_BLACKSTONE,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.POLISHED_BLACKSTONE),
              List.of(Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE)),
          new VerticalSlabDetails(
              "Vertical Polished Deepslate Slab",
              VerticalSlabBlockItemIds.VERTICAL_POLISHED_DEEPSLATE_SLAB,
              VerticalSlab.VERTICAL_POLISHED_DEEPSLATE_SLAB,
              Blocks.POLISHED_DEEPSLATE,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.POLISHED_DEEPSLATE),
              List.of(Blocks.COBBLED_DEEPSLATE, Blocks.POLISHED_DEEPSLATE)),
          new VerticalSlabDetails(
              "Vertical Polished Diorite Slab",
              VerticalSlabBlockItemIds.VERTICAL_POLISHED_DIORITE_SLAB,
              VerticalSlab.VERTICAL_POLISHED_DIORITE_SLAB,
              Blocks.POLISHED_DIORITE,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.POLISHED_DIORITE),
              List.of(Blocks.DIORITE, Blocks.POLISHED_DIORITE)),
          new VerticalSlabDetails(
              "Vertical Polished Granite Slab",
              VerticalSlabBlockItemIds.VERTICAL_POLISHED_GRANITE_SLAB,
              VerticalSlab.VERTICAL_POLISHED_GRANITE_SLAB,
              Blocks.POLISHED_GRANITE,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.POLISHED_GRANITE),
              List.of(Blocks.GRANITE, Blocks.POLISHED_GRANITE)),
          new VerticalSlabDetails(
              "Vertical Polished Tuff Slab",
              VerticalSlabBlockItemIds.VERTICAL_POLISHED_TUFF_SLAB,
              VerticalSlab.VERTICAL_POLISHED_TUFF_SLAB,
              Blocks.POLISHED_TUFF,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.POLISHED_TUFF),
              List.of(Blocks.TUFF, Blocks.POLISHED_TUFF)),
          new VerticalSlabDetails(
              "Vertical Prismarine Slab",
              VerticalSlabBlockItemIds.VERTICAL_PRISMARINE_SLAB,
              VerticalSlab.VERTICAL_PRISMARINE_SLAB,
              Blocks.PRISMARINE,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.PRISMARINE),
              List.of(Blocks.PRISMARINE)),
          new VerticalSlabDetails(
              "Vertical Prismarine Brick Slab",
              VerticalSlabBlockItemIds.VERTICAL_PRISMARINE_BRICK_SLAB,
              VerticalSlab.VERTICAL_PRISMARINE_BRICK_SLAB,
              Blocks.PRISMARINE_BRICKS,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.PRISMARINE_BRICKS),
              List.of(Blocks.PRISMARINE_BRICKS)),
          new VerticalSlabDetails(
              "Vertical Purpur Slab",
              VerticalSlabBlockItemIds.VERTICAL_PURPUR_SLAB,
              VerticalSlab.VERTICAL_PURPUR_SLAB,
              Blocks.PURPUR_BLOCK,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.PURPUR_BLOCK, Blocks.PURPUR_PILLAR),
              List.of(Blocks.PURPUR_BLOCK)),
          new VerticalSlabDetails(
              "Vertical Quartz Slab",
              VerticalSlabBlockItemIds.VERTICAL_QUARTZ_SLAB,
              VerticalSlab.VERTICAL_QUARTZ_SLAB,
              Blocks.QUARTZ_BLOCK,
              new BottomTopBasedBlockModelGenerator(
                  VerticalSlabTexturedModels.VERTICAL_BOTTOM_SLAB_TOP_BOTTOM_SIDE,
                  VerticalSlabTexturedModels.VERTICAL_TOP_SLAB_TOP_BOTTOM_SIDE,
                  VerticalSlabBlockStateMaps.simpleUVLockedBlockStateMap),
              List.of(Blocks.QUARTZ_BLOCK, Blocks.QUARTZ_PILLAR, Blocks.CHISELED_QUARTZ_BLOCK),
              List.of(Blocks.QUARTZ_BLOCK)),
          new VerticalSlabDetails(
              "Vertical Red Nether Brick Slab",
              VerticalSlabBlockItemIds.VERTICAL_RED_NETHER_BRICK_SLAB,
              VerticalSlab.VERTICAL_RED_NETHER_BRICK_SLAB,
              Blocks.RED_NETHER_BRICKS,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.RED_NETHER_BRICKS),
              List.of(Blocks.RED_NETHER_BRICKS)),
          new VerticalSlabDetails(
              "Vertical Red Sandstone Slab",
              VerticalSlabBlockItemIds.VERTICAL_RED_SANDSTONE_SLAB,
              VerticalSlab.VERTICAL_RED_SANDSTONE_SLAB,
              Blocks.RED_SANDSTONE,
              new BottomTopBasedBlockModelGenerator(
                  VerticalSlabTexturedModels.VERTICAL_BOTTOM_SLAB_DIRECTIONAL_BOTTOM_TOP,
                  VerticalSlabTexturedModels.VERTICAL_TOP_SLAB_DIRECTIONAL_BOTTOM_TOP,
                  VerticalSlabTexturedModels.VERTICAL_DOUBLE_SLAB_DIRECTIONAL_BOTTOM_TOP,
                  VerticalSlabBlockStateMaps.directionalBlockStateMap),
              List.of(Blocks.RED_SANDSTONE, Blocks.CHISELED_RED_SANDSTONE),
              List.of(Blocks.RED_SANDSTONE)),
          new VerticalSlabDetails(
              "Vertical Resin Brick Slab",
              VerticalSlabBlockItemIds.VERTICAL_RESIN_BRICK_SLAB,
              VerticalSlab.VERTICAL_RESIN_BRICK_SLAB,
              Blocks.RESIN_BRICKS,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.RESIN_BRICKS),
              List.of(Blocks.RESIN_BRICKS)),
          new VerticalSlabDetails(
              "Vertical Sandstone Slab",
              VerticalSlabBlockItemIds.VERTICAL_SANDSTONE_SLAB,
              VerticalSlab.VERTICAL_SANDSTONE_SLAB,
              Blocks.SANDSTONE,
              new BottomTopBasedBlockModelGenerator(
                  VerticalSlabTexturedModels.VERTICAL_BOTTOM_SLAB_DIRECTIONAL_BOTTOM_TOP,
                  VerticalSlabTexturedModels.VERTICAL_TOP_SLAB_DIRECTIONAL_BOTTOM_TOP,
                  VerticalSlabTexturedModels.VERTICAL_DOUBLE_SLAB_DIRECTIONAL_BOTTOM_TOP,
                  VerticalSlabBlockStateMaps.directionalBlockStateMap),
              List.of(Blocks.SANDSTONE, Blocks.CHISELED_SANDSTONE),
              List.of(Blocks.SANDSTONE)),
          new VerticalSlabDetails(
              "Vertical Smooth Quartz Slab",
              VerticalSlabBlockItemIds.VERTICAL_SMOOTH_QUARTZ_SLAB,
              VerticalSlab.VERTICAL_SMOOTH_QUARTZ_SLAB,
              Blocks.QUARTZ_BLOCK,
              new BottomTopBasedBlockModelGenerator(
                  VerticalSlabTexturedModels.VERTICAL_BOTTOM_SLAB.updateTexture(
                      mapping ->
                          VerticalSlabTexturedModels.editSimpleVerticalSlab(
                              mapping,
                              TextureMapping.getBlockTexture(Blocks.QUARTZ_BLOCK, "_top"))),
                  VerticalSlabTexturedModels.VERTICAL_TOP_SLAB.updateTexture(
                      mapping ->
                          VerticalSlabTexturedModels.editSimpleVerticalSlab(
                              mapping,
                              TextureMapping.getBlockTexture(Blocks.QUARTZ_BLOCK, "_top"))),
                  VerticalSlabBlockStateMaps.simpleUVLockedBlockStateMap),
              List.of(Blocks.SMOOTH_QUARTZ),
              List.of(Blocks.SMOOTH_QUARTZ)),
          new VerticalSlabDetails(
              "Vertical Smooth Red Sandstone Slab",
              VerticalSlabBlockItemIds.VERTICAL_SMOOTH_RED_SANDSTONE_SLAB,
              VerticalSlab.VERTICAL_SMOOTH_RED_SANDSTONE_SLAB,
              Blocks.SMOOTH_RED_SANDSTONE,
              new BottomTopBasedBlockModelGenerator(
                  VerticalSlabTexturedModels.VERTICAL_BOTTOM_SLAB.updateTexture(
                      mapping ->
                          VerticalSlabTexturedModels.editSimpleVerticalSlab(
                              mapping,
                              TextureMapping.getBlockTexture(Blocks.RED_SANDSTONE, "_top"))),
                  VerticalSlabTexturedModels.VERTICAL_TOP_SLAB.updateTexture(
                      mapping ->
                          VerticalSlabTexturedModels.editSimpleVerticalSlab(
                              mapping,
                              TextureMapping.getBlockTexture(Blocks.RED_SANDSTONE, "_top"))),
                  VerticalSlabBlockStateMaps.simpleUVLockedBlockStateMap),
              List.of(Blocks.SMOOTH_RED_SANDSTONE),
              List.of(Blocks.SMOOTH_RED_SANDSTONE)),
          new VerticalSlabDetails(
              "Vertical Smooth Sandstone Slab",
              VerticalSlabBlockItemIds.VERTICAL_SMOOTH_SANDSTONE_SLAB,
              VerticalSlab.VERTICAL_SMOOTH_SANDSTONE_SLAB,
              Blocks.SMOOTH_SANDSTONE,
              new BottomTopBasedBlockModelGenerator(
                  VerticalSlabTexturedModels.VERTICAL_BOTTOM_SLAB.updateTexture(
                      mapping ->
                          VerticalSlabTexturedModels.editSimpleVerticalSlab(
                              mapping, TextureMapping.getBlockTexture(Blocks.SANDSTONE, "_top"))),
                  VerticalSlabTexturedModels.VERTICAL_TOP_SLAB.updateTexture(
                      mapping ->
                          VerticalSlabTexturedModels.editSimpleVerticalSlab(
                              mapping, TextureMapping.getBlockTexture(Blocks.SANDSTONE, "_top"))),
                  VerticalSlabBlockStateMaps.simpleUVLockedBlockStateMap),
              List.of(Blocks.SMOOTH_SANDSTONE),
              List.of(Blocks.SMOOTH_SANDSTONE)),
          new VerticalSlabDetails(
              "Vertical Smooth Stone Slab",
              VerticalSlabBlockItemIds.VERTICAL_SMOOTH_STONE_SLAB,
              VerticalSlab.VERTICAL_SMOOTH_STONE_SLAB,
              Blocks.SMOOTH_STONE_SLAB,
              new BottomTopBasedBlockModelGenerator(
                  VerticalSlabTexturedModels.VERTICAL_BOTTOM_SLAB_DIRECTIONAL_COLUMN_SIDE
                      .updateTexture(
                          mapping ->
                              VerticalSlabTexturedModels.editDirectionalColumnVerticalSlab(
                                  mapping,
                                  TextureMapping.getBlockTexture(Blocks.SMOOTH_STONE),
                                  null)),
                  VerticalSlabTexturedModels.VERTICAL_TOP_SLAB_DIRECTIONAL_COLUMN_SIDE
                      .updateTexture(
                          mapping ->
                              VerticalSlabTexturedModels.editDirectionalColumnVerticalSlab(
                                  mapping,
                                  TextureMapping.getBlockTexture(Blocks.SMOOTH_STONE),
                                  null)),
                  VerticalSlabTexturedModels.VERTICAL_DOUBLE_SLAB_DIRECTIONAL_COLUMN_SIDE
                      .updateTexture(
                          mapping ->
                              VerticalSlabTexturedModels.editDirectionalColumnVerticalSlab(
                                  mapping,
                                  TextureMapping.getBlockTexture(Blocks.SMOOTH_STONE),
                                  null)),
                  VerticalSlabBlockStateMaps.directionalBlockStateMap),
              List.of(Blocks.SMOOTH_STONE),
              List.of(Blocks.SMOOTH_STONE)),
          new VerticalSlabDetails(
              "Vertical Spruce Slab",
              VerticalSlabBlockItemIds.VERTICAL_SPRUCE_SLAB,
              VerticalSlab.VERTICAL_SPRUCE_SLAB,
              Blocks.SPRUCE_PLANKS,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.SPRUCE_PLANKS)),
          new VerticalSlabDetails(
              "Vertical Stone Brick Slab",
              VerticalSlabBlockItemIds.VERTICAL_STONE_BRICK_SLAB,
              VerticalSlab.VERTICAL_STONE_BRICK_SLAB,
              Blocks.STONE_BRICKS,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.STONE_BRICKS),
              List.of(Blocks.STONE, Blocks.STONE_BRICKS)),
          new VerticalSlabDetails(
              "Vertical Stone Slab",
              VerticalSlabBlockItemIds.VERTICAL_STONE_SLAB,
              VerticalSlab.VERTICAL_STONE_SLAB,
              Blocks.STONE,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.STONE),
              List.of(Blocks.STONE)),
          new VerticalSlabDetails(
              "Vertical Tuff Brick Slab",
              VerticalSlabBlockItemIds.VERTICAL_TUFF_BRICK_SLAB,
              VerticalSlab.VERTICAL_TUFF_BRICK_SLAB,
              Blocks.TUFF_BRICKS,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.TUFF_BRICKS),
              List.of(Blocks.TUFF, Blocks.POLISHED_TUFF, Blocks.TUFF_BRICKS)),
          new VerticalSlabDetails(
              "Vertical Tuff Slab",
              VerticalSlabBlockItemIds.VERTICAL_TUFF_SLAB,
              VerticalSlab.VERTICAL_TUFF_SLAB,
              Blocks.TUFF,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.TUFF),
              List.of(Blocks.TUFF)),
          new VerticalSlabDetails(
              "Vertical Warped Slab",
              VerticalSlabBlockItemIds.VERTICAL_WARPED_SLAB,
              VerticalSlab.VERTICAL_WARPED_SLAB,
              Blocks.WARPED_PLANKS,
              BottomTopBasedBlockModelGenerator.simpleUVLockedBlockModel(),
              List.of(Blocks.WARPED_PLANKS)),
          VerticalSlabDetails.createFromCutCopperCollection(
              "Waxed Exposed Vertical Cut Copper Slab",
              WeatheringCopper.WeatherState.EXPOSED,
              true),
          VerticalSlabDetails.createFromCutCopperCollection(
              "Waxed Oxidized Vertical Cut Copper Slab",
              WeatheringCopper.WeatherState.OXIDIZED,
              true),
          VerticalSlabDetails.createFromCutCopperCollection(
              "Waxed Vertical Cut Copper Slab", WeatheringCopper.WeatherState.UNAFFECTED, true),
          VerticalSlabDetails.createFromCutCopperCollection(
              "Waxed Weathered Vertical Cut Copper Slab",
              WeatheringCopper.WeatherState.WEATHERED,
              true),
          VerticalSlabDetails.createFromCutCopperCollection(
              "Weathered Vertical Cut Copper Slab",
              WeatheringCopper.WeatherState.WEATHERED,
              false));

  @Override
  public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
    final FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
    pack.addProvider(VerticalSlabsModelProvider::new);
    pack.addProvider(VerticalSlabsLanguageProvider::new);
    pack.addProvider(VerticalSlabsRecipeProvider::new);
    VerticalSlabsTagsProvider.addProvider(pack);
    pack.addProvider(VerticalSlabsBlockLootProvider::new);
  }

  public static class VerticalSlabsModelProvider extends FabricModelProvider {
    private VerticalSlabsModelProvider(FabricPackOutput output) {
      super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
      VERTICAL_SLAB_DETAILS.forEach(
          verticalSlabDetails -> verticalSlabDetails.generateBlockModels(blockModelGenerators));
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {}
  }

  private static class VerticalSlabsLanguageProvider extends FabricLanguageProvider {
    private static final List<Pair<String, String>> TRANSLATION_MAP =
        List.of(
            new Pair<>("itemGroup.vertical_slabs", "Vertical Slabs"),
            new Pair<>(
                "tag.item.vertical_slabs.vertical_flammable_slabs", "Flammable Vertical Slabs"),
            new Pair<>(
                "tag.item.vertical_slabs.vertical_mineable_slabs", "Mineable Vertical Slabs"),
            new Pair<>("tag.item.vertical_slabs.vertical_slabs", "Vertical Slabs"),
            new Pair<>("tag.item.vertical_slabs.vertical_wooden_slabs", "Vertical Wooden Slabs"));

    private VerticalSlabsLanguageProvider(
        FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
      super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(
        HolderLookup.Provider provider, TranslationBuilder translationBuilder) {
      VERTICAL_SLAB_DETAILS.forEach(
          verticalSlabDetails -> verticalSlabDetails.generateTranslation(translationBuilder));
      TRANSLATION_MAP.forEach(
          mapping -> translationBuilder.add(mapping.getFirst(), mapping.getSecond()));
    }
  }

  public static class VerticalSlabsRecipeProvider extends FabricRecipeProvider {
    private static final List<Pair<Block, Block>> CHISELED_FROM_VERTICAL_SLAB_MAPPING =
        List.of(
            new Pair<>(VerticalSlab.VERTICAL_STONE_BRICK_SLAB, Blocks.CHISELED_STONE_BRICKS),
            new Pair<>(VerticalSlab.VERTICAL_COBBLED_DEEPSLATE_SLAB, Blocks.CHISELED_DEEPSLATE),
            new Pair<>(VerticalSlab.VERTICAL_TUFF_SLAB, Blocks.CHISELED_TUFF),
            new Pair<>(VerticalSlab.VERTICAL_TUFF_BRICK_SLAB, Blocks.CHISELED_TUFF_BRICKS),
            new Pair<>(VerticalSlab.VERTICAL_RESIN_BRICK_SLAB, Blocks.CHISELED_RESIN_BRICKS),
            new Pair<>(VerticalSlab.VERTICAL_SANDSTONE_SLAB, Blocks.CHISELED_SANDSTONE),
            new Pair<>(VerticalSlab.VERTICAL_RED_SANDSTONE_SLAB, Blocks.CHISELED_RED_SANDSTONE),
            new Pair<>(VerticalSlab.VERTICAL_NETHER_BRICK_SLAB, Blocks.CHISELED_NETHER_BRICKS),
            new Pair<>(
                VerticalSlab.VERTICAL_POLISHED_BLACKSTONE_SLAB,
                Blocks.CHISELED_POLISHED_BLACKSTONE),
            new Pair<>(VerticalSlab.VERTICAL_QUARTZ_SLAB, Blocks.CHISELED_QUARTZ_BLOCK),
            new Pair<>(VerticalSlab.VERTICAL_PURPUR_SLAB, Blocks.PURPUR_PILLAR),
            new Pair<>(VerticalSlab.VERTICAL_BAMBOO_SLAB, Blocks.BAMBOO_MOSAIC));

    private VerticalSlabsRecipeProvider(
        FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
      super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(
        HolderLookup.Provider provider, RecipeOutput recipeOutput) {
      return new RecipeProvider(provider, recipeOutput) {
        @Override
        public void buildRecipes() {
          // Generate all normal crafting table and stonecutter recipes
          VERTICAL_SLAB_DETAILS.forEach(
              verticalSlabDetails -> verticalSlabDetails.generateRecipes(this, recipeOutput));

          // Generate special recipes - manual hardcode these
          // Apply wax recipe, chiseled blocks from vertical slabs
          VerticalSlab.VERTICAL_CUT_COPPER_SLAB.zipUnwaxedWaxed(
              this::generateWaxedVerticalSlabRecipe);

          // Chiseled block variants
          CHISELED_FROM_VERTICAL_SLAB_MAPPING.forEach(
              chiseledPair ->
                  generateChiseledFromVerticalSlabRecipe(
                      chiseledPair.getFirst(), chiseledPair.getSecond()));
          WeatheringCopperCollection.zipApply(
              VerticalSlab.VERTICAL_CUT_COPPER_SLAB,
              Blocks.CHISELED_COPPER,
              this::generateChiseledFromVerticalSlabRecipe);
        }

        public void generateWaxedVerticalSlabRecipe(ItemLike unwaxedSlab, ItemLike waxedSlab) {
          this.shapeless(RecipeCategory.BUILDING_BLOCKS, waxedSlab)
              .requires(unwaxedSlab)
              .requires(Items.HONEYCOMB)
              .unlockedBy(getHasName(unwaxedSlab), this.has(unwaxedSlab))
              .save(
                  recipeOutput,
                  VerticalSlabs.identifier(getConversionRecipeName(waxedSlab, Items.HONEYCOMB))
                      .toString());
        }

        public void generateChiseledFromVerticalSlabRecipe(ItemLike slab, ItemLike chiseled) {
          this.shaped(RecipeCategory.BUILDING_BLOCKS, chiseled, 1)
              .define('#', slab)
              .pattern("##")
              .unlockedBy(getHasName(slab), this.has(slab))
              .save(
                  recipeOutput,
                  VerticalSlabs.identifier(getConversionRecipeName(chiseled, slab)).toString());
        }
      };
    }

    @Override
    public String getName() {
      return "Vertical Slabs Recipe Provider";
    }
  }

  public static class VerticalSlabsTagsProvider {
    private static final Set<BlockItemId> woodenSlabSet =
        Set.of(
            VerticalSlabBlockItemIds.VERTICAL_OAK_SLAB,
            VerticalSlabBlockItemIds.VERTICAL_BIRCH_SLAB,
            VerticalSlabBlockItemIds.VERTICAL_SPRUCE_SLAB,
            VerticalSlabBlockItemIds.VERTICAL_JUNGLE_SLAB,
            VerticalSlabBlockItemIds.VERTICAL_ACACIA_SLAB,
            VerticalSlabBlockItemIds.VERTICAL_DARK_OAK_SLAB,
            VerticalSlabBlockItemIds.VERTICAL_CHERRY_SLAB,
            VerticalSlabBlockItemIds.VERTICAL_MANGROVE_SLAB,
            VerticalSlabBlockItemIds.VERTICAL_BAMBOO_SLAB,
            VerticalSlabBlockItemIds.VERTICAL_BAMBOO_MOSAIC_SLAB,
            VerticalSlabBlockItemIds.VERTICAL_PALE_OAK_SLAB,
            VerticalSlabBlockItemIds.VERTICAL_CRIMSON_SLAB,
            VerticalSlabBlockItemIds.VERTICAL_WARPED_SLAB);

    private static final List<ResourceKey<Block>> needsStoneTools =
        Stream.concat(
                VerticalSlabBlockItemIds.VERTICAL_CUT_COPPER_SLAB
                    .map(BlockItemId::block)
                    .asList()
                    .stream(),
                Stream.of())
            .toList();

    private static final List<BlockItemId> flammableVerticalSlabs =
        List.of(
            VerticalSlabBlockItemIds.VERTICAL_OAK_SLAB,
            VerticalSlabBlockItemIds.VERTICAL_BIRCH_SLAB,
            VerticalSlabBlockItemIds.VERTICAL_SPRUCE_SLAB,
            VerticalSlabBlockItemIds.VERTICAL_JUNGLE_SLAB,
            VerticalSlabBlockItemIds.VERTICAL_ACACIA_SLAB,
            VerticalSlabBlockItemIds.VERTICAL_DARK_OAK_SLAB,
            VerticalSlabBlockItemIds.VERTICAL_MANGROVE_SLAB,
            VerticalSlabBlockItemIds.VERTICAL_CHERRY_SLAB,
            VerticalSlabBlockItemIds.VERTICAL_BAMBOO_SLAB,
            VerticalSlabBlockItemIds.VERTICAL_BAMBOO_MOSAIC_SLAB);

    private static void addProvider(FabricDataGenerator.Pack pack) {
      VerticalSlabsBlockTagsProvider verticalSlabsBlockTagProvider =
          pack.addProvider(VerticalSlabsBlockTagsProvider::new);
      pack.addProvider(
          (output, registriesFuture) ->
              new VerticalSlabsItemTagsProvider(
                  output, registriesFuture, verticalSlabsBlockTagProvider));
    }

    private static class VerticalSlabsBlockTagsProvider
        extends FabricTagsProvider.BlockTagsProvider {
      private VerticalSlabsBlockTagsProvider(
          FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
      }

      @Override
      protected void addTags(HolderLookup.Provider wrapperLookup) {
        // Add all vertical slabs to vertical slab tag
        TagAppender<Block> verticalSlabBuilder = this.tag(VerticalSlabs.VERTICAL_SLABS.block());
        TagAppender<Block> verticalWoodenSlabBuilder =
            this.tag(VerticalSlabs.VERTICAL_WOODEN_SLABS.block());
        TagAppender<Block> verticalMineableSlabBuilder =
            this.tag(VerticalSlabs.VERTICAL_MINEABLE_SLABS.block());

        verticalWoodenSlabBuilder.addAll(woodenSlabSet.stream().map(BlockItemId::block));
        for (VerticalSlabDetails verticalSlabDetails : VERTICAL_SLAB_DETAILS) {
          verticalSlabBuilder.add(verticalSlabDetails.slabId().block());
          if (!woodenSlabSet.contains(verticalSlabDetails.slabId())) {
            verticalMineableSlabBuilder.add(verticalSlabDetails.slabId().block());
          }
        }

        // Append wooden vertical slabs to vanilla wooden slabs tag
        this.tag(BlockTags.WOODEN_SLABS)
            .addTag(VerticalSlabs.VERTICAL_WOODEN_SLABS.block())
            .setReplace(false);
        // Append stone slabs to mineable with pickaxe
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .addTag(VerticalSlabs.VERTICAL_MINEABLE_SLABS.block())
            .setReplace(false);
        // Append copper slabs to needs stone tool
        this.tag(BlockTags.NEEDS_STONE_TOOL).addAll(needsStoneTools).setReplace(false);
        this.tag(VerticalSlabs.VERTICAL_FLAMMABLE_SLABS.block())
            .addAll(flammableVerticalSlabs.stream().map(BlockItemId::block))
            .setReplace(false);
      }
    }

    private static class VerticalSlabsItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {
      private VerticalSlabsItemTagsProvider(
          FabricPackOutput output,
          CompletableFuture<HolderLookup.Provider> completableFuture,
          @Nullable FabricTagsProvider.BlockTagsProvider blockTagsProvider) {
        super(output, completableFuture, blockTagsProvider);
      }

      @Override
      protected void addTags(HolderLookup.Provider wrapperLookup) {
        // Make vertical wooden slabs item tags, vertical mineable slabs item tags, and all vertical
        // slabs item tags
        // Not using copy to allow multiple mods to add to vertical slab tags independently in any
        // order

        TagAppender<Item> verticalSlabBuilder = this.tag(VerticalSlabs.VERTICAL_SLABS.item());
        TagAppender<Item> verticalWoodenSlabBuilder =
            this.tag(VerticalSlabs.VERTICAL_WOODEN_SLABS.item());
        TagAppender<Item> verticalMineableSlabBuilder =
            this.tag(VerticalSlabs.VERTICAL_MINEABLE_SLABS.item());

        verticalWoodenSlabBuilder.addAll(woodenSlabSet.stream().map(BlockItemId::item));
        for (VerticalSlabDetails verticalSlabDetails : VERTICAL_SLAB_DETAILS) {
          verticalSlabBuilder.add(verticalSlabDetails.slabId().item());
          if (!woodenSlabSet.contains(verticalSlabDetails.slabId())) {
            verticalMineableSlabBuilder.add(verticalSlabDetails.slabId().item());
          }
        }

        // Append wooden vertical slabs to vanilla wooden slabs tag
        this.tag(ItemTags.WOODEN_SLABS)
            .addTag(VerticalSlabs.VERTICAL_WOODEN_SLABS.item())
            .setReplace(false);

        this.tag(ItemTags.NON_FLAMMABLE_WOOD)
            .add(VerticalSlabBlockItemIds.VERTICAL_CRIMSON_SLAB.item())
            .add(VerticalSlabBlockItemIds.VERTICAL_WARPED_SLAB.item())
            .setReplace(false);

        this.tag(VerticalSlabs.VERTICAL_FLAMMABLE_SLABS.item())
            .addAll(flammableVerticalSlabs.stream().map(BlockItemId::item))
            .setReplace(false);
      }
    }
  }

  public static class VerticalSlabsBlockLootProvider extends FabricBlockLootSubProvider {
    private VerticalSlabsBlockLootProvider(
        FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
      super(dataOutput, registryLookup);
    }

    public static LootTable.Builder createVerticalSlabLootTable(
        FabricBlockLootSubProvider self, Block drop) {
      return LootTable.lootTable()
          .withPool(
              LootPool.lootPool()
                  .setRolls(ConstantValue.exactly(1.0F))
                  .add(
                      self.applyExplosionDecay(
                          drop,
                          LootItem.lootTableItem(drop)
                              .apply(
                                  SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))
                                      .when(
                                          LootItemBlockStatePropertyCondition
                                              .hasBlockStateProperties(drop)
                                              .setProperties(
                                                  StatePropertiesPredicate.Builder.properties()
                                                      .hasProperty(
                                                          VerticalSlabBlock.TYPE,
                                                          VerticalSlabType.DOUBLE)))))));
    }

    @Override
    public void generate() {
      for (VerticalSlabDetails verticalSlabDetails : VERTICAL_SLAB_DETAILS) {
        this.add(
            verticalSlabDetails.slab(),
            createVerticalSlabLootTable(this, verticalSlabDetails.slab()));
      }
    }
  }
}
