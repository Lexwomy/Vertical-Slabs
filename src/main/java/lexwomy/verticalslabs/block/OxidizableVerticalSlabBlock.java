package lexwomy.verticalslabs.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.ChangeOverTimeBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class OxidizableVerticalSlabBlock extends VerticalSlabBlock implements WeatheringCopper {
  public static final MapCodec<OxidizableVerticalSlabBlock> CODEC =
      RecordCodecBuilder.mapCodec(
          (instance) ->
              instance
                  .group(
                      WeatherState.CODEC
                          .fieldOf("weathering_state")
                          .forGetter(ChangeOverTimeBlock::getAge),
                      propertiesCodec())
                  .apply(instance, OxidizableVerticalSlabBlock::new));

  private final WeatheringCopper.WeatherState oxidationLevel;

  public OxidizableVerticalSlabBlock(
      WeatheringCopper.WeatherState oxidationLevel, BlockBehaviour.Properties settings) {
    super(settings);
    this.oxidationLevel = oxidationLevel;
  }

  public MapCodec<OxidizableVerticalSlabBlock> codec() {
    return CODEC;
  }

  protected void randomTick(
      BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
    this.changeOverTime(state, world, pos, random);
  }

  protected boolean isRandomlyTicking(BlockState state) {
    return WeatheringCopper.getNext(state.getBlock()).isPresent();
  }

  public WeatheringCopper.WeatherState getAge() {
    return this.oxidationLevel;
  }
}
