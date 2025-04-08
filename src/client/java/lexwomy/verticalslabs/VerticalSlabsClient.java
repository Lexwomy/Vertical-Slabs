package lexwomy.verticalslabs;

import net.fabricmc.api.ClientModInitializer;

public class VerticalSlabsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        VerticalSlabModels.initialize();
        VerticalSlabs.LOGGER.info("Client initialized!");
    }
}
