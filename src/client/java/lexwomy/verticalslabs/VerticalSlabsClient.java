package lexwomy.verticalslabs;

import lexwomy.verticalslabs.data.VerticalSlabBlockStateMaps;
import lexwomy.verticalslabs.data.VerticalSlabModelTemplates;
import lexwomy.verticalslabs.data.VerticalSlabTexturedModels;
import net.fabricmc.api.ClientModInitializer;

public class VerticalSlabsClient implements ClientModInitializer {
  @Override
  public void onInitializeClient() {
    VerticalSlabModelTemplates.initialize();
    VerticalSlabTexturedModels.initialize();
    VerticalSlabBlockStateMaps.initialize();
    VerticalSlabs.LOGGER.info("Client initialized!");
  }
}
