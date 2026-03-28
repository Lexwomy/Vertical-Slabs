package lexwomy.verticalslabs.data;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.data.models.model.ModelInstance;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;

@FunctionalInterface
@Environment(EnvType.CLIENT)
public interface VerticalSlabTexturedModelProvider {
  TexturedModel get(Block source);

  default Identifier create(
      Block slab, Block fullBlock, BiConsumer<Identifier, ModelInstance> biConsumer) {
    return this.get(fullBlock).create(slab, biConsumer);
  }

  default Identifier createWithSuffix(
      Block slab,
      Block fullBlock,
      String string,
      BiConsumer<Identifier, ModelInstance> biConsumer) {
    return this.get(fullBlock).createWithSuffix(slab, string, biConsumer);
  }

  default VerticalSlabTexturedModelProvider updateTexture(Consumer<TextureMapping> consumer) {
    return block -> this.get(block).updateTextures(consumer);
  }
}
