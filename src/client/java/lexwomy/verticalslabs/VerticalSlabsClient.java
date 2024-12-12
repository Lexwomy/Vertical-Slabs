package lexwomy.verticalslabs;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.event.registry.DynamicRegistrySetupCallback;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class VerticalSlabsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        VerticalSlabs.LOGGER.info("Client initialized!");
//        DynamicRegistrySetupCallback.EVENT.register(registryView -> {
//            registryView.registerEntryAdded(RegistryKeys.ADVANCEMENT, (rawId, id, advancement) -> {
////                Optional<Text> possible_name = advancement.name();
////                if (possible_name.isPresent() && possible_name.get().equals(Text.translatable("advancements.husbandry.wax_on.title"))) {
////
////                }
//                VerticalSlabs.LOGGER.info("{}, {}, {}", rawId, id.toString(), advancement.toString());
////                if (id.equals(Identifier.ofVanilla("advancements.husbandry.wax_on.title"))) {
////
////                }
//            });
//        });
    }
}
