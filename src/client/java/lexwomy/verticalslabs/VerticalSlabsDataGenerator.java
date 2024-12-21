package lexwomy.verticalslabs;

import lexwomy.verticalslabs.block.VerticalSlab;
import lexwomy.verticalslabs.block.VerticalSlabBlock;
import lexwomy.verticalslabs.block.VerticalSlabType;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.client.data.*;
import net.minecraft.util.Identifier;

import java.util.List;

import static lexwomy.verticalslabs.VerticalSlabs.MOD_ID;

public class VerticalSlabsDataGenerator implements DataGeneratorEntrypoint {
    private static class VerticalSlabsModelProvider extends FabricModelProvider {
        private record VerticalSlabBlockstateDetails(Block slab, Identifier halfModel, Identifier doubleModel, boolean directional) {}

        private static final List<VerticalSlabBlockstateDetails> VERTICAL_SLAB_BLOCKSTATE_DETAILS = List.of(
            new VerticalSlabBlockstateDetails(VerticalSlab.EXPOSED_VERTICAL_CUT_COPPER_SLAB,
                    Identifier.of(MOD_ID, "block/exposed_vertical_cut_copper_slab"),
                    Identifier.ofVanilla("block/exposed_cut_copper"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.OXIDIZED_VERTICAL_CUT_COPPER_SLAB,
                    Identifier.of(MOD_ID, "block/oxidized_vertical_cut_copper_slab"),
                    Identifier.ofVanilla("block/oxidized_cut_copper"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_ACACIA_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_acacia_slab"),
                    Identifier.ofVanilla("block/acacia_planks"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_ANDESITE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_andesite_slab"),
                    Identifier.ofVanilla("block/andesite"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_BAMBOO_MOSAIC_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_bamboo_mosaic_slab"),
                    Identifier.ofVanilla("block/bamboo_mosaic"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_BAMBOO_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_bamboo_slab"),
                    Identifier.ofVanilla("block/bamboo_planks"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_BIRCH_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_birch_slab"),
                    Identifier.ofVanilla("block/birch_planks"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_BLACKSTONE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_blackstone_slab"),
                    Identifier.ofVanilla("block/blackstone"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_BRICK_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_brick_slab"),
                    Identifier.ofVanilla("block/bricks"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_CHERRY_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_cherry_slab"),
                    Identifier.ofVanilla("block/cherry_planks"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_COBBLED_DEEPSLATE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_cobbled_deepslate_slab"),
                    Identifier.ofVanilla("block/cobbled_deepslate"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_COBBLESTONE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_cobblestone_slab"),
                    Identifier.ofVanilla("block/cobblestone"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_CRIMSON_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_crimson_slab"),
                    Identifier.ofVanilla("block/crimson_planks"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_CUT_COPPER_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_cut_copper_slab"),
                    Identifier.ofVanilla("block/cut_copper"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_CUT_RED_SANDSTONE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_cut_red_sandstone_slab"),
                    Identifier.of(MOD_ID, "block/vertical_cut_red_sandstone_slab_double"), true),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_CUT_SANDSTONE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_cut_sandstone_slab"),
                    Identifier.of(MOD_ID, "block/vertical_cut_sandstone_slab_double"), true),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_DARK_OAK_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_dark_oak_slab"),
                    Identifier.ofVanilla("block/dark_oak_planks"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_DARK_PRISMARINE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_dark_prismarine_slab"),
                    Identifier.ofVanilla("block/dark_prismarine"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_DEEPSLATE_BRICK_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_deepslate_brick_slab"),
                    Identifier.ofVanilla("block/deepslate_bricks"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_DEEPSLATE_TILE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_deepslate_tile_slab"),
                    Identifier.ofVanilla("block/deepslate_tiles"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_DIORITE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_diorite_slab"),
                    Identifier.ofVanilla("block/diorite"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_END_STONE_BRICK_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_end_stone_brick_slab"),
                    Identifier.ofVanilla("block/end_stone_bricks"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_GRANITE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_granite_slab"),
                    Identifier.ofVanilla("block/granite"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_JUNGLE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_jungle_slab"),
                    Identifier.ofVanilla("block/jungle_planks"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_MANGROVE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_mangrove_slab"),
                    Identifier.ofVanilla("block/mangrove_planks"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_MOSSY_COBBLESTONE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_mossy_cobblestone_slab"),
                    Identifier.ofVanilla("block/mossy_cobblestone"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_MOSSY_STONE_BRICK_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_mossy_stone_brick_slab"),
                    Identifier.ofVanilla("block/mossy_stone_bricks"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_MUD_BRICK_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_mud_brick_slab"),
                    Identifier.ofVanilla("block/mud_bricks"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_NETHER_BRICK_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_nether_brick_slab"),
                    Identifier.ofVanilla("block/nether_bricks"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_OAK_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_oak_slab"),
                    Identifier.ofVanilla("block/oak_planks"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_PALE_OAK_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_pale_oak_slab"),
                    Identifier.ofVanilla("block/pale_oak_planks"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_POLISHED_ANDESITE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_polished_andesite_slab"),
                    Identifier.ofVanilla("block/polished_andesite"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_POLISHED_BLACKSTONE_BRICK_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_polished_blackstone_brick_slab"),
                    Identifier.ofVanilla("block/polished_blackstone_bricks"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_POLISHED_BLACKSTONE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_polished_blackstone_slab"),
                    Identifier.ofVanilla("block/polished_blackstone"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_POLISHED_DEEPSLATE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_polished_deepslate_slab"),
                    Identifier.ofVanilla("block/polished_deepslate"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_POLISHED_DIORITE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_polished_diorite_slab"),
                    Identifier.ofVanilla("block/polished_diorite"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_POLISHED_GRANITE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_polished_granite_slab"),
                    Identifier.ofVanilla("block/polished_granite"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_POLISHED_TUFF_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_polished_tuff_slab"),
                    Identifier.ofVanilla("block/polished_tuff"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_PRISMARINE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_prismarine_slab"),
                    Identifier.ofVanilla("block/prismarine"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_PRISMARINE_BRICK_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_prismarine_brick_slab"),
                    Identifier.ofVanilla("block/prismarine_bricks"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_PURPUR_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_purpur_slab"),
                    Identifier.ofVanilla("block/purpur_block"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_QUARTZ_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_quartz_slab"),
                    Identifier.ofVanilla("block/quartz_block"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_RED_NETHER_BRICK_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_red_nether_brick_slab"),
                    Identifier.ofVanilla("block/red_nether_bricks"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_RED_SANDSTONE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_red_sandstone_slab"),
                    Identifier.ofVanilla("block/red_sandstone"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_RESIN_BRICK_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_resin_brick_slab"),
                    Identifier.ofVanilla("block/resin_bricks"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_SANDSTONE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_sandstone_slab"),
                    Identifier.ofVanilla("block/sandstone"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_SMOOTH_QUARTZ_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_smooth_quartz_slab"),
                    Identifier.ofVanilla("block/smooth_quartz"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_SMOOTH_RED_SANDSTONE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_smooth_red_sandstone_slab"),
                    Identifier.ofVanilla("block/smooth_red_sandstone"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_SMOOTH_SANDSTONE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_smooth_sandstone_slab"),
                    Identifier.ofVanilla("block/smooth_sandstone"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_SMOOTH_STONE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_smooth_stone_slab"),
                    Identifier.of(MOD_ID, "block/vertical_smooth_stone_slab_double"), true),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_SPRUCE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_spruce_slab"),
                    Identifier.ofVanilla("block/spruce_planks"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_STONE_BRICK_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_stone_brick_slab"),
                    Identifier.ofVanilla("block/stone_bricks"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_STONE_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_stone_slab"),
                    Identifier.ofVanilla("block/stone"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_TUFF_BRICK_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_tuff_brick_slab"),
                    Identifier.ofVanilla("block/tuff_bricks"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_TUFF_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_tuff_slab"),
                    Identifier.ofVanilla("block/tuff_bricks"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.VERTICAL_WARPED_SLAB,
                    Identifier.of(MOD_ID, "block/vertical_warped_slab"),
                    Identifier.ofVanilla("block/warped_planks"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.WAXED_EXPOSED_VERTICAL_CUT_COPPER_SLAB,
                    Identifier.of(MOD_ID, "block/waxed_exposed_vertical_cut_copper_slab"),
                    Identifier.ofVanilla("block/exposed_cut_copper"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.WAXED_OXIDIZED_VERTICAL_CUT_COPPER_SLAB,
                    Identifier.of(MOD_ID, "block/waxed_oxidized_vertical_cut_copper_slab"),
                    Identifier.ofVanilla("block/oxidized_cut_copper"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.WAXED_VERTICAL_CUT_COPPER_SLAB,
                    Identifier.of(MOD_ID, "block/waxed_vertical_cut_copper_slab"),
                    Identifier.ofVanilla("block/cut_copper"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.WAXED_WEATHERED_VERTICAL_CUT_COPPER_SLAB,
                    Identifier.of(MOD_ID, "block/waxed_weathered_vertical_cut_copper_slab"),
                    Identifier.ofVanilla("block/weathered_cut_copper"), false),
            new VerticalSlabBlockstateDetails(VerticalSlab.WEATHERED_VERTICAL_CUT_COPPER_SLAB,
                    Identifier.of(MOD_ID, "block/weathered_vertical_cut_copper_slab"),
                    Identifier.ofVanilla("block/weathered_cut_copper"), false)
        );

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
            for (VerticalSlabBlockstateDetails verticalSlabMapping : VERTICAL_SLAB_BLOCKSTATE_DETAILS) {
                blockStateModelGenerator.blockStateCollector.accept(
                        createVerticalSlabState(verticalSlabMapping.slab, verticalSlabMapping.halfModel,
                                verticalSlabMapping.doubleModel, !verticalSlabMapping.directional, verticalSlabMapping.directional));
            }

        }

        @Override
        public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        }
    }
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        final FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(VerticalSlabsModelProvider::new);
    }
}
