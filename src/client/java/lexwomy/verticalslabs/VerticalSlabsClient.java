package lexwomy.verticalslabs;

import net.fabricmc.api.ClientModInitializer;

public class VerticalSlabsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        VerticalSlabs.LOGGER.info("Client initialized!");
    }
}
