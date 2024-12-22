package lexwomy.verticalslabs;

import lexwomy.verticalslabs.block.VerticalSlab;
import lexwomy.verticalslabs.block.VerticalSlabBlock;
import lexwomy.verticalslabs.block.VerticalSlabType;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.data.*;
import net.minecraft.data.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static lexwomy.verticalslabs.VerticalSlabs.MOD_ID;

public class VerticalSlabsDataGenerator implements DataGeneratorEntrypoint {
    // A recipe will be generated for every block in stonecutterInputs if stonecuttable,
    // while a generic crafting recipe will be generated for the input block
    private record VerticalSlabDetails(Block slab, Identifier halfModel, Identifier doubleModel, boolean directional,
                                       List<Block> input, boolean stonecuttable, List<Block> stonecutterInputs) {}
    private static final List<VerticalSlabDetails> VERTICAL_SLAB_DETAILS = List.of(
            new VerticalSlabDetails(VerticalSlab.EXPOSED_VERTICAL_CUT_COPPER_SLAB,
                    Identifier.of(MOD_ID, "block/exposed_vertical_cut_copper_slab"),
                    Identifier.ofVanilla("block/exposed_cut_copper"), false,
                    List.of(Blocks.EXPOSED_CUT_COPPER), true, List.of(Blocks.EXPOSED_COPPER, Blocks.EXPOSED_CUT_COPPER)),
            new VerticalSlabDetails(VerticalSlab.OXIDIZED_VERTICAL_CUT_COPPER_SLAB,
                    Identifier.of(MOD_ID, "block/oxidized_vertical_cut_copper_slab"),
                    Identifier.ofVanilla("block/oxidized_cut_copper"), false,
                    List.of(Blocks.OXIDIZED_CUT_COPPER), true, List.of(Blocks.OXIDIZED_COPPER, Blocks.OXIDIZED_CUT_COPPER)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_ACACIA_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_acacia_slab"),
                    Identifier.ofVanilla("block/acacia_planks"), false,
                    List.of(Blocks.ACACIA_PLANKS), false, null),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_ANDESITE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_andesite_slab"),
                    Identifier.ofVanilla("block/andesite"), false,
                    List.of(Blocks.ANDESITE), true, List.of(Blocks.ANDESITE)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_BAMBOO_MOSAIC_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_bamboo_mosaic_slab"),
                    Identifier.ofVanilla("block/bamboo_mosaic"), false,
                    List.of(Blocks.BAMBOO_MOSAIC), false, null),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_BAMBOO_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_bamboo_slab"),
                    Identifier.ofVanilla("block/bamboo_planks"), false,
                    List.of(Blocks.BAMBOO_PLANKS), false, null),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_BIRCH_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_birch_slab"),
                    Identifier.ofVanilla("block/birch_planks"), false,
                    List.of(Blocks.BIRCH_PLANKS), false, null),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_BLACKSTONE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_blackstone_slab"),
                    Identifier.ofVanilla("block/blackstone"), false,
                    List.of(Blocks.BLACKSTONE), true, List.of(Blocks.BLACKSTONE)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_BRICK_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_brick_slab"),
                    Identifier.ofVanilla("block/bricks"), false,
                    List.of(Blocks.BRICKS), true, List.of(Blocks.BRICKS)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_CHERRY_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_cherry_slab"),
                    Identifier.ofVanilla("block/cherry_planks"), false,
                    List.of(Blocks.CHERRY_PLANKS), false, null),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_COBBLED_DEEPSLATE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_cobbled_deepslate_slab"),
                    Identifier.ofVanilla("block/cobbled_deepslate"), false,
                    List.of(Blocks.COBBLED_DEEPSLATE), true, List.of(Blocks.COBBLED_DEEPSLATE)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_COBBLESTONE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_cobblestone_slab"),
                    Identifier.ofVanilla("block/cobblestone"), false,
                    List.of(Blocks.COBBLESTONE), true, List.of(Blocks.COBBLESTONE)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_CRIMSON_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_crimson_slab"),
                    Identifier.ofVanilla("block/crimson_planks"), false,
                    List.of(Blocks.CRIMSON_PLANKS), false, null),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_CUT_COPPER_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_cut_copper_slab"),
                    Identifier.ofVanilla("block/cut_copper"), false,
                    List.of(Blocks.CUT_COPPER), true, List.of(Blocks.COPPER_BLOCK, Blocks.CUT_COPPER)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_CUT_RED_SANDSTONE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_cut_red_sandstone_slab"),
                    Identifier.of(MOD_ID, "block/vertical_cut_red_sandstone_slab_double"), true,
                    List.of(Blocks.CUT_RED_SANDSTONE), true, List.of(Blocks.RED_SANDSTONE, Blocks.CUT_RED_SANDSTONE)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_CUT_SANDSTONE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_cut_sandstone_slab"),
                    Identifier.of(MOD_ID, "block/vertical_cut_sandstone_slab_double"), true,
                    List.of(Blocks.CUT_SANDSTONE), true, List.of(Blocks.SANDSTONE, Blocks.CUT_SANDSTONE)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_DARK_OAK_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_dark_oak_slab"),
                    Identifier.ofVanilla("block/dark_oak_planks"), false,
                    List.of(Blocks.DARK_OAK_PLANKS), false, null),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_DARK_PRISMARINE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_dark_prismarine_slab"),
                    Identifier.ofVanilla("block/dark_prismarine"), false,
                    List.of(Blocks.DARK_PRISMARINE), true, List.of(Blocks.DARK_PRISMARINE)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_DEEPSLATE_BRICK_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_deepslate_brick_slab"),
                    Identifier.ofVanilla("block/deepslate_bricks"), false,
                    List.of(Blocks.DEEPSLATE_BRICKS), true, List.of(Blocks.COBBLED_DEEPSLATE, Blocks.DEEPSLATE_BRICKS, Blocks.POLISHED_DEEPSLATE)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_DEEPSLATE_TILE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_deepslate_tile_slab"),
                    Identifier.ofVanilla("block/deepslate_tiles"), false,
                    List.of(Blocks.DEEPSLATE_TILES), true,
                    List.of(Blocks.COBBLED_DEEPSLATE, Blocks.DEEPSLATE_BRICKS, Blocks.DEEPSLATE_TILES, Blocks.POLISHED_DEEPSLATE)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_DIORITE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_diorite_slab"),
                    Identifier.ofVanilla("block/diorite"), false,
                    List.of(Blocks.DIORITE), true, List.of(Blocks.DIORITE)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_END_STONE_BRICK_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_end_stone_brick_slab"),
                    Identifier.ofVanilla("block/end_stone_bricks"), false,
                    List.of(Blocks.END_STONE_BRICKS), true, List.of(Blocks.END_STONE_BRICKS)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_GRANITE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_granite_slab"),
                    Identifier.ofVanilla("block/granite"), false,
                    List.of(Blocks.GRANITE), true, List.of(Blocks.GRANITE)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_JUNGLE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_jungle_slab"),
                    Identifier.ofVanilla("block/jungle_planks"), false,
                    List.of(Blocks.JUNGLE_PLANKS), false, null),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_MANGROVE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_mangrove_slab"),
                    Identifier.ofVanilla("block/mangrove_planks"), false,
                    List.of(Blocks.MANGROVE_PLANKS), false, null),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_MOSSY_COBBLESTONE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_mossy_cobblestone_slab"),
                    Identifier.ofVanilla("block/mossy_cobblestone"), false,
                    List.of(Blocks.MOSSY_COBBLESTONE), true, List.of(Blocks.MOSSY_COBBLESTONE)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_MOSSY_STONE_BRICK_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_mossy_stone_brick_slab"),
                    Identifier.ofVanilla("block/mossy_stone_bricks"), false,
                    List.of(Blocks.MOSSY_STONE_BRICKS), true, List.of(Blocks.MOSSY_STONE_BRICKS)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_MUD_BRICK_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_mud_brick_slab"),
                    Identifier.ofVanilla("block/mud_bricks"), false,
                    List.of(Blocks.MUD_BRICKS), true, List.of(Blocks.MUD_BRICKS)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_NETHER_BRICK_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_nether_brick_slab"),
                    Identifier.ofVanilla("block/nether_bricks"), false,
                    List.of(Blocks.NETHER_BRICKS), true, List.of(Blocks.NETHER_BRICKS)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_OAK_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_oak_slab"),
                    Identifier.ofVanilla("block/oak_planks"), false,
                    List.of(Blocks.OAK_PLANKS), false, null),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_PALE_OAK_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_pale_oak_slab"),
                    Identifier.ofVanilla("block/pale_oak_planks"), false,
                    List.of(Blocks.PALE_OAK_PLANKS), false, null),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_POLISHED_ANDESITE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_polished_andesite_slab"),
                    Identifier.ofVanilla("block/polished_andesite"), false,
                    List.of(Blocks.POLISHED_ANDESITE), true, List.of(Blocks.ANDESITE, Blocks.POLISHED_ANDESITE)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_POLISHED_BLACKSTONE_BRICK_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_polished_blackstone_brick_slab"),
                    Identifier.ofVanilla("block/polished_blackstone_bricks"), false,
                    List.of(Blocks.POLISHED_BLACKSTONE_BRICKS), true,
                    List.of(Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.POLISHED_BLACKSTONE)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_POLISHED_BLACKSTONE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_polished_blackstone_slab"),
                    Identifier.ofVanilla("block/polished_blackstone"), false,
                    List.of(Blocks.POLISHED_BLACKSTONE), true, List.of(Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_POLISHED_DEEPSLATE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_polished_deepslate_slab"),
                    Identifier.ofVanilla("block/polished_deepslate"), false,
                    List.of(Blocks.POLISHED_DEEPSLATE), true, List.of(Blocks.COBBLED_DEEPSLATE, Blocks.POLISHED_DEEPSLATE)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_POLISHED_DIORITE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_polished_diorite_slab"),
                    Identifier.ofVanilla("block/polished_diorite"), false,
                    List.of(Blocks.POLISHED_DIORITE), true, List.of(Blocks.DIORITE, Blocks.POLISHED_DIORITE)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_POLISHED_GRANITE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_polished_granite_slab"),
                    Identifier.ofVanilla("block/polished_granite"), false,
                    List.of(Blocks.POLISHED_GRANITE), true, List.of(Blocks.GRANITE, Blocks.POLISHED_GRANITE)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_POLISHED_TUFF_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_polished_tuff_slab"),
                    Identifier.ofVanilla("block/polished_tuff"), false,
                    List.of(Blocks.POLISHED_TUFF), true, List.of(Blocks.TUFF, Blocks.POLISHED_TUFF)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_PRISMARINE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_prismarine_slab"),
                    Identifier.ofVanilla("block/prismarine"), false,
                    List.of(Blocks.PRISMARINE), true, List.of(Blocks.PRISMARINE)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_PRISMARINE_BRICK_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_prismarine_brick_slab"),
                    Identifier.ofVanilla("block/prismarine_bricks"), false,
                    List.of(Blocks.PRISMARINE_BRICKS), true, List.of(Blocks.PRISMARINE_BRICKS)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_PURPUR_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_purpur_slab"),
                    Identifier.ofVanilla("block/purpur_block"), false,
                    List.of(Blocks.PURPUR_BLOCK, Blocks.PURPUR_PILLAR), true, List.of(Blocks.PURPUR_BLOCK)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_QUARTZ_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_quartz_slab"),
                    Identifier.ofVanilla("block/quartz_block"), false,
                    List.of(Blocks.QUARTZ_BLOCK, Blocks.QUARTZ_PILLAR, Blocks.CHISELED_QUARTZ_BLOCK),
                    true, List.of(Blocks.QUARTZ_BLOCK)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_RED_NETHER_BRICK_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_red_nether_brick_slab"),
                    Identifier.ofVanilla("block/red_nether_bricks"), false,
                    List.of(Blocks.RED_NETHER_BRICKS), true, List.of(Blocks.RED_NETHER_BRICKS)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_RED_SANDSTONE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_red_sandstone_slab"),
                    Identifier.ofVanilla("block/red_sandstone"), false,
                    List.of(Blocks.RED_SANDSTONE, Blocks.CHISELED_RED_SANDSTONE), true, List.of(Blocks.RED_SANDSTONE)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_RESIN_BRICK_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_resin_brick_slab"),
                    Identifier.ofVanilla("block/resin_bricks"), false,
                    List.of(Blocks.RESIN_BRICKS), true, List.of(Blocks.RESIN_BRICKS)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_SANDSTONE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_sandstone_slab"),
                    Identifier.ofVanilla("block/sandstone"), false,
                    List.of(Blocks.SANDSTONE, Blocks.CHISELED_SANDSTONE), true, List.of(Blocks.SANDSTONE)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_SMOOTH_QUARTZ_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_smooth_quartz_slab"),
                    Identifier.ofVanilla("block/smooth_quartz"), false,
                    List.of(Blocks.SMOOTH_QUARTZ), true, List.of(Blocks.SMOOTH_QUARTZ)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_SMOOTH_RED_SANDSTONE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_smooth_red_sandstone_slab"),
                    Identifier.ofVanilla("block/smooth_red_sandstone"), false,
                    List.of(Blocks.SMOOTH_RED_SANDSTONE), true, List.of(Blocks.SMOOTH_RED_SANDSTONE)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_SMOOTH_SANDSTONE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_smooth_sandstone_slab"),
                    Identifier.ofVanilla("block/smooth_sandstone"), false,
                    List.of(Blocks.SMOOTH_SANDSTONE), true, List.of(Blocks.SMOOTH_SANDSTONE)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_SMOOTH_STONE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_smooth_stone_slab"),
                    Identifier.of(MOD_ID, "block/vertical_smooth_stone_slab_double"), true,
                    List.of(Blocks.SMOOTH_STONE), true, List.of(Blocks.SMOOTH_STONE)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_SPRUCE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_spruce_slab"),
                    Identifier.ofVanilla("block/spruce_planks"), false,
                    List.of(Blocks.SPRUCE_PLANKS), false, null),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_STONE_BRICK_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_stone_brick_slab"),
                    Identifier.ofVanilla("block/stone_bricks"), false,
                    List.of(Blocks.STONE_BRICKS), true, List.of(Blocks.STONE, Blocks.STONE_BRICKS)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_STONE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_stone_slab"),
                    Identifier.ofVanilla("block/stone"), false,
                    List.of(Blocks.STONE), true, List.of(Blocks.STONE)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_TUFF_BRICK_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_tuff_brick_slab"),
                    Identifier.ofVanilla("block/tuff_bricks"), false,
                    List.of(Blocks.TUFF_BRICKS), true, List.of(Blocks.TUFF, Blocks.POLISHED_TUFF, Blocks.TUFF_BRICKS)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_TUFF_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_tuff_slab"),
                    Identifier.ofVanilla("block/tuff"), false,
                    List.of(Blocks.TUFF), true, List.of(Blocks.TUFF)),
            new VerticalSlabDetails(VerticalSlab.VERTICAL_WARPED_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_warped_slab"),
                    Identifier.ofVanilla("block/warped_planks"), false,
                    List.of(Blocks.WARPED_PLANKS), false, null),
            new VerticalSlabDetails(VerticalSlab.WAXED_EXPOSED_VERTICAL_CUT_COPPER_SLAB,
                    Identifier.of(MOD_ID, "block/waxed_exposed_vertical_cut_copper_slab"),
                    Identifier.ofVanilla("block/exposed_cut_copper"), false,
                    List.of(Blocks.WAXED_EXPOSED_CUT_COPPER), true, List.of(Blocks.WAXED_EXPOSED_COPPER, Blocks.WAXED_EXPOSED_CUT_COPPER)),
            new VerticalSlabDetails(VerticalSlab.WAXED_OXIDIZED_VERTICAL_CUT_COPPER_SLAB,
                    Identifier.of(MOD_ID, "block/waxed_oxidized_vertical_cut_copper_slab"),
                    Identifier.ofVanilla("block/oxidized_cut_copper"), false,
                    List.of(Blocks.WAXED_OXIDIZED_CUT_COPPER), true, List.of(Blocks.WAXED_OXIDIZED_COPPER, Blocks.WAXED_OXIDIZED_CUT_COPPER)),
            new VerticalSlabDetails(VerticalSlab.WAXED_VERTICAL_CUT_COPPER_SLAB,
                    Identifier.of(MOD_ID, "block/waxed_vertical_cut_copper_slab"),
                    Identifier.ofVanilla("block/cut_copper"), false,
                    List.of(Blocks.WAXED_CUT_COPPER), true, List.of(Blocks.WAXED_COPPER_BLOCK, Blocks.WAXED_CUT_COPPER)),
            new VerticalSlabDetails(VerticalSlab.WAXED_WEATHERED_VERTICAL_CUT_COPPER_SLAB,
                    Identifier.of(MOD_ID, "block/waxed_weathered_vertical_cut_copper_slab"),
                    Identifier.ofVanilla("block/weathered_cut_copper"), false,
                    List.of(Blocks.WAXED_WEATHERED_CUT_COPPER), true, List.of(Blocks.WAXED_WEATHERED_COPPER, Blocks.WAXED_WEATHERED_CUT_COPPER)),
            new VerticalSlabDetails(VerticalSlab.WEATHERED_VERTICAL_CUT_COPPER_SLAB,
                    Identifier.of(MOD_ID, "block/weathered_vertical_cut_copper_slab"),
                    Identifier.ofVanilla("block/weathered_cut_copper"), false,
                    List.of(Blocks.WEATHERED_CUT_COPPER), true, List.of(Blocks.WEATHERED_COPPER, Blocks.WEATHERED_CUT_COPPER))
    );
    private static class VerticalSlabsModelProvider extends FabricModelProvider {
        private VerticalSlabsModelProvider(FabricDataOutput output) {
            super(output);
        }

        private BlockStateSupplier createVerticalSlabState(Block slab, Identifier halfModel, Identifier doubleModel, boolean uvlock, boolean directional) {
            return VariantsBlockStateSupplier.create(slab).coordinate(
                    BlockStateVariantMap.create(VerticalSlabBlock.TYPE, VerticalSlabBlock.FACING).register((verticalSlabType, direction) -> {
                        BlockStateVariant setting = BlockStateVariant.create();
                        if (uvlock) {
                            setting.put(VariantSettings.UVLOCK, true);
                        }

                        setting.put(VariantSettings.MODEL, verticalSlabType == VerticalSlabType.DOUBLE ? doubleModel : halfModel);

                        if (verticalSlabType == VerticalSlabType.DOUBLE && !directional) {
                            return setting;
                        }

                        switch (direction) {
                            case SOUTH -> setting.put(VariantSettings.Y, VariantSettings.Rotation.R180);
                            case EAST -> setting.put(VariantSettings.Y, VariantSettings.Rotation.R90);
                            case WEST -> setting.put(VariantSettings.Y, VariantSettings.Rotation.R270);
                        }

                        return setting;
                    })
            );
        }

        @Override
        public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
            for (VerticalSlabDetails verticalSlabMapping : VERTICAL_SLAB_DETAILS) {
                blockStateModelGenerator.blockStateCollector.accept(
                        createVerticalSlabState(verticalSlabMapping.slab, verticalSlabMapping.halfModel,
                                verticalSlabMapping.doubleModel, !verticalSlabMapping.directional, verticalSlabMapping.directional));
            }
        }

        @Override
        public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        }
    }
    private static class VerticalSlabsLanguageProvider extends FabricLanguageProvider {
        private static final List<Pair<String, String>> TRANSLATION_MAP = List.<Pair<String, String>>of(
                new Pair<>("itemGroup.vertical_slabs", "Vertical Slabs"),
                new Pair<>("block.vertical_slabs.vertical_oak_slab", "Vertical Oak Slab"),
                new Pair<>("block.vertical_slabs.vertical_spruce_slab", "Vertical Spruce Slab"),
                new Pair<>("block.vertical_slabs.vertical_birch_slab", "Vertical Birch Slab"),
                new Pair<>("block.vertical_slabs.vertical_jungle_slab", "Vertical Jungle Slab"),
                new Pair<>("block.vertical_slabs.vertical_acacia_slab", "Vertical Acacia Slab"),
                new Pair<>("block.vertical_slabs.vertical_dark_oak_slab", "Vertical Dark Oak Slab"),
                new Pair<>("block.vertical_slabs.vertical_mangrove_slab", "Vertical Mangrove Slab"),
                new Pair<>("block.vertical_slabs.vertical_cherry_slab", "Vertical Cherry Slab"),
                new Pair<>("block.vertical_slabs.vertical_bamboo_slab", "Vertical Bamboo Slab"),
                new Pair<>("block.vertical_slabs.vertical_bamboo_mosaic_slab", "Vertical Bamboo Mosaic Slab"),
                new Pair<>("block.vertical_slabs.vertical_crimson_slab", "Vertical Crimson Slab"),
                new Pair<>("block.vertical_slabs.vertical_warped_slab", "Vertical Stone Slab"),
                new Pair<>("block.vertical_slabs.vertical_pale_oak_slab", "Vertical Pale Oak Slab"),
                new Pair<>("block.vertical_slabs.vertical_stone_slab", "Vertical Stone Slab"),
                new Pair<>("block.vertical_slabs.vertical_smooth_stone_slab", "Vertical Smooth Stone Slab"),
                new Pair<>("block.vertical_slabs.vertical_cobblestone_slab", "Vertical Cobblestone Slab"),
                new Pair<>("block.vertical_slabs.vertical_mossy_cobblestone_slab", "Vertical Mossy Cobblestone Slab"),
                new Pair<>("block.vertical_slabs.vertical_stone_brick_slab", "Vertical Stone Brick Slab"),
                new Pair<>("block.vertical_slabs.vertical_mossy_stone_brick_slab", "Vertical Mossy Stone Brick Slab"),
                new Pair<>("block.vertical_slabs.vertical_granite_slab", "Vertical Granite Slab"),
                new Pair<>("block.vertical_slabs.vertical_polished_granite_slab", "Vertical Polished Granite Slab"),
                new Pair<>("block.vertical_slabs.vertical_diorite_slab", "Vertical Diorite Slab"),
                new Pair<>("block.vertical_slabs.vertical_polished_diorite_slab", "Vertical Polished Diorite Slab"),
                new Pair<>("block.vertical_slabs.vertical_andesite_slab", "Vertical Andesite Slab"),
                new Pair<>("block.vertical_slabs.vertical_polished_andesite_slab", "Vertical Polished Andesite Slab"),
                new Pair<>("block.vertical_slabs.vertical_cobbled_deepslate_slab", "Vertical Cobbled Deepslate Slab"),
                new Pair<>("block.vertical_slabs.vertical_polished_deepslate_slab", "Vertical Polished Deepslate Slab"),
                new Pair<>("block.vertical_slabs.vertical_deepslate_brick_slab", "Vertical Deepslate Brick Slab"),
                new Pair<>("block.vertical_slabs.vertical_deepslate_tile_slab", "Vertical Deepslate Tile Slab"),
                new Pair<>("block.vertical_slabs.vertical_tuff_slab", "Vertical Tuff Slab"),
                new Pair<>("block.vertical_slabs.vertical_polished_tuff_slab", "Vertical Polished Tuff Slab"),
                new Pair<>("block.vertical_slabs.vertical_tuff_brick_slab", "Vertical Tuff Brick Slab"),
                new Pair<>("block.vertical_slabs.vertical_brick_slab", "Vertical Brick Slab"),
                new Pair<>("block.vertical_slabs.vertical_mud_brick_slab", "Vertical Mud Brick Slab"),
                new Pair<>("block.vertical_slabs.vertical_resin_brick_slab", "Vertical Resin Brick Slab"),
                new Pair<>("block.vertical_slabs.vertical_sandstone_slab", "Vertical Sandstone Slab"),
                new Pair<>("block.vertical_slabs.vertical_smooth_sandstone_slab", "Vertical Smooth Sandstone Slab"),
                new Pair<>("block.vertical_slabs.vertical_cut_sandstone_slab", "Vertical Cut Sandstone Slab"),
                new Pair<>("block.vertical_slabs.vertical_red_sandstone_slab", "Vertical Red Sandstone Slab"),
                new Pair<>("block.vertical_slabs.vertical_smooth_red_sandstone_slab", "Vertical Smooth Red Sandstone Slab"),
                new Pair<>("block.vertical_slabs.vertical_cut_red_sandstone_slab", "Vertical Cut Red Sandstone Slab"),
                new Pair<>("block.vertical_slabs.vertical_prismarine_slab", "Vertical Prismarine Slab"),
                new Pair<>("block.vertical_slabs.vertical_prismarine_brick_slab", "Vertical Prismarine Brick Slab"),
                new Pair<>("block.vertical_slabs.vertical_dark_prismarine_slab", "Vertical Dark Prismarine Slab"),
                new Pair<>("block.vertical_slabs.vertical_nether_brick_slab", "Vertical Nether Brick Slab"),
                new Pair<>("block.vertical_slabs.vertical_red_nether_brick_slab", "Vertical Red Nether Brick Slab"),
                new Pair<>("block.vertical_slabs.vertical_blackstone_slab", "Vertical Blackstone Slab"),
                new Pair<>("block.vertical_slabs.vertical_polished_blackstone_slab", "Vertical Polished Blackstone Slab"),
                new Pair<>("block.vertical_slabs.vertical_polished_blackstone_brick_slab", "Vertical Polished Blackstone Brick Slab"),
                new Pair<>("block.vertical_slabs.vertical_end_stone_brick_slab", "Vertical End Stone Brick Slab"),
                new Pair<>("block.vertical_slabs.vertical_purpur_slab", "Vertical Purpur Slab"),
                new Pair<>("block.vertical_slabs.vertical_quartz_slab", "Vertical Quartz Slab"),
                new Pair<>("block.vertical_slabs.vertical_smooth_quartz_slab", "Vertical Smooth Quartz Slab"),
                new Pair<>("block.vertical_slabs.vertical_cut_copper_slab", "Vertical Cut Copper Slab"),
                new Pair<>("block.vertical_slabs.exposed_vertical_cut_copper_slab", "Exposed Vertical Cut Copper Slab"),
                new Pair<>("block.vertical_slabs.weathered_vertical_cut_copper_slab", "Weathered Vertical Cut Copper Slab"),
                new Pair<>("block.vertical_slabs.oxidized_vertical_cut_copper_slab", "Oxidized Vertical Cut Copper Slab"),
                new Pair<>("block.vertical_slabs.waxed_vertical_cut_copper_slab", "Waxed Vertical Cut Copper Slab"),
                new Pair<>("block.vertical_slabs.waxed_exposed_vertical_cut_copper_slab", "Waxed Exposed Vertical Cut Copper Slab"),
                new Pair<>("block.vertical_slabs.waxed_weathered_vertical_cut_copper_slab", "Waxed Weathered Vertical Cut Copper Slab"),
                new Pair<>("block.vertical_slabs.waxed_oxidized_vertical_cut_copper_slab", "Waxed Oxidized Vertical Cut Copper Slab")
        );

        private VerticalSlabsLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
            super(dataOutput, registryLookup);
        }

        @Override
        public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
            for (Pair<String, String> mapping : TRANSLATION_MAP) {
                translationBuilder.add(mapping.getLeft(), mapping.getRight());
            }
        }
    }
    private static class VerticalSlabsRecipeProvider extends FabricRecipeProvider {
        private VerticalSlabsRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, registriesFuture);
        }

        @Override
        protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
            return new RecipeGenerator(registryLookup, exporter) {
                @Override
                public void generate() {
                    // Generate all normal crafting table and stonecutter recipes
                    for (VerticalSlabDetails verticalSlabDetails : VERTICAL_SLAB_DETAILS) {
                        createVerticalSlabRecipe(RecipeCategory.BUILDING_BLOCKS, verticalSlabDetails.slab, verticalSlabDetails.input).offerTo(this.exporter);;

                        if (verticalSlabDetails.stonecuttable) {
                            for (Block stonecutterInput : verticalSlabDetails.stonecutterInputs) {
                                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, verticalSlabDetails.slab, stonecutterInput, 2);
                            }
                        }
                    }

                    // Generate special recipes - manual hardcode these
                    // Apply wax recipe, chiseled blocks from vertical slabs,
                }

                // Creates a generic vertical slab recipe in crafting table
                public CraftingRecipeJsonBuilder createVerticalSlabRecipe(RecipeCategory category, ItemConvertible output, List<Block> input) {
                    return this.createShaped(category, output, 6).input('#', Ingredient.ofItems(input.stream()))
                            .pattern("#").pattern("#").pattern("#")
                            .criterion(hasItem(input.getFirst()), this.conditionsFromItem(input.getFirst()));
                }
            };
        }

        @Override
        public String getName() {
            return "Recipes";
        }
    }
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        final FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(VerticalSlabsModelProvider::new);
        pack.addProvider(VerticalSlabsLanguageProvider::new);
        pack.addProvider(VerticalSlabsRecipeProvider::new);
    }
}
