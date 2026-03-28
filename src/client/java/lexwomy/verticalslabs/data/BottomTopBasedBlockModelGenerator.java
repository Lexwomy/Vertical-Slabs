package lexwomy.verticalslabs.data;

import static net.minecraft.client.data.models.BlockModelGenerators.UV_LOCK;
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
import org.jetbrains.annotations.Nullable;

public record BottomTopBasedBlockModelGenerator(
    @NotNull VerticalSlabTexturedModelProvider bottomSlabModelProvider,
    @NotNull VerticalSlabTexturedModelProvider topSlabModelProvider,
    @Nullable VerticalSlabTexturedModelProvider doubleSlabModelProvider,
    @NotNull
        EnumMap<VerticalSlabType, EnumMap<Direction, UnaryOperator<MultiVariant>>> blockStateMap)
    implements VerticalSlabBlockModelGenerator {
  private static final UnaryOperator<MultiVariant> defaultMutator = model -> model.with(UV_LOCK);

  public BottomTopBasedBlockModelGenerator(
      @NotNull VerticalSlabTexturedModelProvider bottomSlabModelProvider,
      @NotNull VerticalSlabTexturedModelProvider topSlabModelProvider,
      @NotNull
          EnumMap<VerticalSlabType, EnumMap<Direction, UnaryOperator<MultiVariant>>>
              blockStateMap) {
    this(bottomSlabModelProvider, topSlabModelProvider, null, blockStateMap);
  }

  public static BottomTopBasedBlockModelGenerator simpleUVLockedBlockModel() {
    return new BottomTopBasedBlockModelGenerator(
        VerticalSlabTexturedModels.VERTICAL_BOTTOM_SLAB,
        VerticalSlabTexturedModels.VERTICAL_TOP_SLAB,
        VerticalSlabBlockStateMaps.simpleUVLockedBlockStateMap);
  }

  @Override
  public void generateBlockModels(
      Block slab, Block textureSource, BlockModelGenerators blockModelGenerators) {
    MultiVariant bottomSlabModel =
        plainVariant(
            this.bottomSlabModelProvider.create(
                slab, textureSource, blockModelGenerators.modelOutput));
    MultiVariant topSlabModel =
        plainVariant(
            this.topSlabModelProvider.create(
                slab, textureSource, blockModelGenerators.modelOutput));
    MultiVariant doubleSlabModel;
    if (this.doubleSlabModelProvider == null) {
      doubleSlabModel = plainVariant(ModelLocationUtils.getModelLocation(textureSource));
    } else {
      doubleSlabModel =
          plainVariant(
              this.doubleSlabModelProvider.createWithSuffix(
                  slab, textureSource, "_double", blockModelGenerators.modelOutput));
    }
    blockModelGenerators.blockStateOutput.accept(
        MultiVariantGenerator.dispatch(slab)
            .with(
                PropertyDispatch.initial(VerticalSlabBlock.TYPE, VerticalSlabBlock.FACING)
                    .generate(
                        (slabType, direction) -> {
                          MultiVariant model;
                          switch (slabType) {
                            case BOTTOM -> model = bottomSlabModel;
                            case TOP -> model = topSlabModel;
                            case DOUBLE -> model = doubleSlabModel;
                            case null, default ->
                                throw new IllegalStateException("Unknown slabType " + slabType);
                          }
                          if (blockStateMap().containsKey(slabType)) {
                            return blockStateMap
                                .get(slabType)
                                .getOrDefault(direction, defaultMutator)
                                .apply(model);
                          } else {
                            throw new IllegalStateException("Missing required key: " + slabType);
                          }
                        })));
    blockModelGenerators.registerSimpleItemModel(
        slab, ModelLocationUtils.getModelLocation(slab, "_bottom"));
  }
}
