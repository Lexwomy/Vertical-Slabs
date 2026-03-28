package lexwomy.verticalslabs.data;

import java.util.Optional;
import lexwomy.verticalslabs.VerticalSlabs;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureSlot;

public class VerticalSlabModelTemplates {
  // Double is minecraft:block/cube
  public static final ModelTemplate VERTICAL_BOTTOM_SLAB =
      new ModelTemplate(
          Optional.of(VerticalSlabs.identifier("block/vertical_bottom_slab")),
          Optional.of("_bottom"),
          TextureSlot.NORTH,
          TextureSlot.EAST,
          TextureSlot.SOUTH,
          TextureSlot.WEST,
          TextureSlot.UP,
          TextureSlot.DOWN,
          TextureSlot.PARTICLE);

  public static final ModelTemplate VERTICAL_TOP_SLAB =
      new ModelTemplate(
          Optional.of(VerticalSlabs.identifier("block/vertical_top_slab")),
          Optional.of("_top"),
          TextureSlot.NORTH,
          TextureSlot.EAST,
          TextureSlot.SOUTH,
          TextureSlot.WEST,
          TextureSlot.UP,
          TextureSlot.DOWN,
          TextureSlot.PARTICLE);

  // Double is minecraft:block/cube_directional
  public static final ModelTemplate VERTICAL_BOTTOM_SLAB_DIRECTIONAL =
      new ModelTemplate(
          Optional.of(VerticalSlabs.identifier("block/vertical_bottom_slab_directional")),
          Optional.of("_bottom"),
          TextureSlot.NORTH,
          TextureSlot.EAST,
          TextureSlot.SOUTH,
          TextureSlot.WEST,
          TextureSlot.UP,
          TextureSlot.DOWN,
          TextureSlot.PARTICLE);

  public static final ModelTemplate VERTICAL_TOP_SLAB_DIRECTIONAL =
      new ModelTemplate(
          Optional.of(VerticalSlabs.identifier("block/vertical_top_slab_directional")),
          Optional.of("_top"),
          TextureSlot.NORTH,
          TextureSlot.EAST,
          TextureSlot.SOUTH,
          TextureSlot.WEST,
          TextureSlot.UP,
          TextureSlot.DOWN,
          TextureSlot.PARTICLE);

  // Double is minecraft:block/cube_mirrored
  public static final ModelTemplate VERTICAL_BOTTOM_SLAB_MIRRORED =
      new ModelTemplate(
          Optional.of(VerticalSlabs.identifier("block/vertical_bottom_slab_mirrored")),
          Optional.of("_bottom"),
          TextureSlot.NORTH,
          TextureSlot.EAST,
          TextureSlot.SOUTH,
          TextureSlot.WEST,
          TextureSlot.UP,
          TextureSlot.DOWN,
          TextureSlot.PARTICLE);

  public static final ModelTemplate VERTICAL_TOP_SLAB_MIRRORED =
      new ModelTemplate(
          Optional.of(VerticalSlabs.identifier("block/vertical_top_slab_mirrored")),
          Optional.of("_top"),
          TextureSlot.NORTH,
          TextureSlot.EAST,
          TextureSlot.SOUTH,
          TextureSlot.WEST,
          TextureSlot.UP,
          TextureSlot.DOWN,
          TextureSlot.PARTICLE);

  // Double is minecraft:block/cube_north_west_mirrored
  public static final ModelTemplate VERTICAL_NORTH_FACING_SLAB_NORTH_WEST_MIRRORED =
      new ModelTemplate(
          Optional.of(
              VerticalSlabs.identifier("block/vertical_north_facing_slab_north_west_mirrored")),
          Optional.of("_north_facing"),
          TextureSlot.NORTH,
          TextureSlot.EAST,
          TextureSlot.SOUTH,
          TextureSlot.WEST,
          TextureSlot.UP,
          TextureSlot.DOWN,
          TextureSlot.PARTICLE);

  public static final ModelTemplate VERTICAL_SOUTH_FACING_SLAB_NORTH_WEST_MIRRORED =
      new ModelTemplate(
          Optional.of(
              VerticalSlabs.identifier("block/vertical_south_facing_slab_north_west_mirrored")),
          Optional.of("_south_facing"),
          TextureSlot.NORTH,
          TextureSlot.EAST,
          TextureSlot.SOUTH,
          TextureSlot.WEST,
          TextureSlot.UP,
          TextureSlot.DOWN,
          TextureSlot.PARTICLE);

  public static final ModelTemplate VERTICAL_WEST_FACING_SLAB_NORTH_WEST_MIRRORED =
      new ModelTemplate(
          Optional.of(
              VerticalSlabs.identifier("block/vertical_west_facing_slab_north_west_mirrored")),
          Optional.of("_west_facing"),
          TextureSlot.NORTH,
          TextureSlot.EAST,
          TextureSlot.SOUTH,
          TextureSlot.WEST,
          TextureSlot.UP,
          TextureSlot.DOWN,
          TextureSlot.PARTICLE);

  public static final ModelTemplate VERTICAL_EAST_FACING_SLAB_NORTH_WEST_MIRRORED =
      new ModelTemplate(
          Optional.of(
              VerticalSlabs.identifier("block/vertical_east_facing_slab_north_west_mirrored")),
          Optional.of("_east_facing"),
          TextureSlot.NORTH,
          TextureSlot.EAST,
          TextureSlot.SOUTH,
          TextureSlot.WEST,
          TextureSlot.UP,
          TextureSlot.DOWN,
          TextureSlot.PARTICLE);

  public static void initialize() {
    VerticalSlabs.LOGGER.info("Vertical Slab Model Templates initialized!");
  }
}
