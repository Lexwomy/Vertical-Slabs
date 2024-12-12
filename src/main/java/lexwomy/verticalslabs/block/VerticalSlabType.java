package lexwomy.verticalslabs.block;

import net.minecraft.util.StringIdentifiable;

public enum VerticalSlabType implements StringIdentifiable {
    HALF("half"),
    DOUBLE("double");

    private final String name;

    private VerticalSlabType(final String name) { this.name = name; }

    public String toString() {
        return this.name;
    }

    public String asString() {
        return this.name;
    }
}
