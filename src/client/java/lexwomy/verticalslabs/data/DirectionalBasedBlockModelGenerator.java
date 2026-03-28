package lexwomy.verticalslabs.data;

import static net.minecraft.client.data.models.BlockModelGenerators.plainVariant;

import java.util.EnumMap;
import java.util.function.UnaryOperator;
import lexwomy.verticalslabs.block.VerticalSlabBlock;
import lexwomy.verticalslabs.block.VerticalSlabType;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public record DirectionalBasedBlockModelGenerator(
    @NotNull VerticalSlabTexturedModelProvider northFacingModelProvider,
    @NotNull VerticalSlabTexturedModelProvider eastFacingModelProvider,
    @NotNull VerticalSlabTexturedModelProvider southFacingModelProvider,
    @NotNull VerticalSlabTexturedModelProvider westFacingModelProvider,
    @NotNull String textureSourceSuffix,
    @NotNull
        EnumMap<VerticalSlabType, EnumMap<Direction, UnaryOperator<MultiVariant>>> blockStateMap)
    implements VerticalSlabBlockModelGenerator {
  @Override
  public void generateBlockModels(
      Block slab, Block textureSource, BlockModelGenerators blockModelGenerators) {
    MultiVariant northFacingModel =
        plainVariant(
            this.northFacingModelProvider.create(
                slab, textureSource, blockModelGenerators.modelOutput));
    MultiVariant southFacingModel =
        plainVariant(
            this.southFacingModelProvider.create(
                slab, textureSource, blockModelGenerators.modelOutput));
    MultiVariant westFacingModel =
        plainVariant(
            this.westFacingModelProvider.create(
                slab, textureSource, blockModelGenerators.modelOutput));
    MultiVariant eastFacingModel =
        plainVariant(
            this.eastFacingModelProvider.create(
                slab, textureSource, blockModelGenerators.modelOutput));
    MultiVariant doubleSlabModel =
        plainVariant(ModelLocationUtils.getModelLocation(textureSource, this.textureSourceSuffix));

    blockModelGenerators.blockStateOutput.accept(
        MultiVariantGenerator.dispatch(slab)
            .with(
                PropertyDispatch.initial(VerticalSlabBlock.TYPE, VerticalSlabBlock.FACING)
                    .generate(
                        (slabType, direction) -> {
                          MultiVariant model;
                          if (slabType == VerticalSlabType.BOTTOM) {
                            switch (direction) {
                              case NORTH -> model = northFacingModel;
                              case SOUTH -> model = southFacingModel;
                              case EAST -> model = eastFacingModel;
                              case WEST -> model = westFacingModel;
                              case null, default ->
                                  throw new IllegalStateException(
                                      "No blockstate defined for direction" + direction);
                            }
                          } else if (slabType == VerticalSlabType.TOP) {
                            switch (direction) {
                              case NORTH -> model = southFacingModel;
                              case SOUTH -> model = northFacingModel;
                              case EAST -> model = westFacingModel;
                              case WEST -> model = eastFacingModel;
                              case null, default ->
                                  throw new IllegalStateException(
                                      "No blockstate defined for direction" + direction);
                            }
                          } else {
                            model = doubleSlabModel;
                          }
                          return this.blockStateMap.get(slabType).get(direction).apply(model);
                        })));
    blockModelGenerators.registerSimpleItemModel(
        slab, ModelLocationUtils.getModelLocation(slab, "_north_facing"));
  }
}
