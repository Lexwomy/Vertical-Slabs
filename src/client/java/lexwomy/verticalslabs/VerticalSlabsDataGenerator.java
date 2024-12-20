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

import static lexwomy.verticalslabs.VerticalSlabs.MOD_ID;

public class VerticalSlabsDataGenerator implements DataGeneratorEntrypoint {
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
            blockStateModelGenerator.blockStateCollector.accept(
                    createVerticalSlabState(VerticalSlab.VERTICAL_OAK_SLAB,
                            Identifier.of(MOD_ID, "block/vertical_oak_slab"),
                            Identifier.ofVanilla("block/oak_planks"), true, false));
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
