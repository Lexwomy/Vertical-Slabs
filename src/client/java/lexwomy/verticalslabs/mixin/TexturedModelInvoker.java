package lexwomy.verticalslabs.mixin;

import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TexturedModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(TexturedModel.class)
public interface TexturedModelInvoker {
  @Invoker("<init>")
  static TexturedModel invokeTexturedModelConstructor(
      TextureMapping textureMapping, ModelTemplate modelTemplate) {
    throw new AssertionError("Implemented by Mixin");
  }
}
