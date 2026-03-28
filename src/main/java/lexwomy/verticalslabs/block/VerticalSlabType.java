package lexwomy.verticalslabs.block;

import net.minecraft.util.StringRepresentable;
import org.jspecify.annotations.NonNull;

public enum VerticalSlabType implements StringRepresentable {
  BOTTOM("bottom"),
  TOP("top"),
  DOUBLE("double");

  private final String name;

  VerticalSlabType(final String name) {
    this.name = name;
  }

  public String toString() {
    return this.name;
  }

  public @NonNull String getSerializedName() {
    return this.name;
  }
}
