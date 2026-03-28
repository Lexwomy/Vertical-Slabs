package lexwomy.verticalslabs.data;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.world.level.block.Block;

public interface VerticalSlabBlockModelGenerator {
  void generateBlockModels(
      Block slab, Block textureSource, BlockModelGenerators blockModelGenerators);
}
