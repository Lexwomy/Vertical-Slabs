package lexwomy.verticalslabs;

import net.minecraft.client.data.Model;
import net.minecraft.client.data.TextureKey;
import net.minecraft.util.Identifier;

import java.util.Optional;

import static lexwomy.verticalslabs.VerticalSlabs.MOD_ID;

public class VerticalSlabModels {
    public static final Model VERTICAL_SLAB =
            new Model(Optional.of(Identifier.of(MOD_ID, "block/vertical_slab")), Optional.empty(),
                    TextureKey.FRONT, TextureKey.SIDE, TextureKey.BACK);
    public static final Model VERTICAL_DIRECTIONAL_SLAB =
            new Model(Optional.of(Identifier.of(MOD_ID, "block/vertical_directional_slab")), Optional.empty(),
                    TextureKey.FRONT, TextureKey.SIDE, TextureKey.BACK);
    public static final Model VERTICAL_DIRECTIONAL_DOUBLE_SLAB =
            new Model(Optional.of(Identifier.of(MOD_ID, "block/vertical_directional_slab_double")), Optional.empty(),
                    TextureKey.FRONT, TextureKey.SIDE, TextureKey.BACK);

    public static void initialize() {
        VerticalSlabs.LOGGER.info("Vertical Slab Models initialized!");
    }
}

