package lexwomy.verticalslabs.data;

import static net.minecraft.client.data.models.model.TextureMapping.getBlockTexture;

import java.util.function.Function;
import lexwomy.verticalslabs.VerticalSlabs;
import lexwomy.verticalslabs.mixin.TexturedModelInvoker;
import net.minecraft.client.data.models.model.*;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

public class VerticalSlabTexturedModels {
  public static final VerticalSlabTexturedModelProvider VERTICAL_BOTTOM_SLAB =
      createProvider(
          VerticalSlabTexturedModels::simpleVerticalSlab,
          VerticalSlabModelTemplates.VERTICAL_BOTTOM_SLAB);

  public static final VerticalSlabTexturedModelProvider VERTICAL_TOP_SLAB =
      createProvider(
          VerticalSlabTexturedModels::simpleVerticalSlab,
          VerticalSlabModelTemplates.VERTICAL_TOP_SLAB);

  public static final VerticalSlabTexturedModelProvider VERTICAL_BOTTOM_SLAB_TOP_BOTTOM_SIDE =
      createProvider(
          VerticalSlabTexturedModels::bottomTopWithSideVerticalSlab,
          VerticalSlabModelTemplates.VERTICAL_BOTTOM_SLAB);

  public static final VerticalSlabTexturedModelProvider VERTICAL_TOP_SLAB_TOP_BOTTOM_SIDE =
      createProvider(
          VerticalSlabTexturedModels::bottomTopWithSideVerticalSlab,
          VerticalSlabModelTemplates.VERTICAL_TOP_SLAB);

  public static final VerticalSlabTexturedModelProvider VERTICAL_BOTTOM_SLAB_COLUMN =
      createProvider(
          VerticalSlabTexturedModels::columnVerticalSlab,
          VerticalSlabModelTemplates.VERTICAL_BOTTOM_SLAB);

  public static final VerticalSlabTexturedModelProvider VERTICAL_TOP_SLAB_COLUMN =
      createProvider(
          VerticalSlabTexturedModels::columnVerticalSlab,
          VerticalSlabModelTemplates.VERTICAL_TOP_SLAB);

  public static final VerticalSlabTexturedModelProvider
      VERTICAL_NORTH_FACING_SLAB_NORTH_WEST_MIRRORED =
          createProvider(
              VerticalSlabTexturedModels::simpleVerticalSlab,
              VerticalSlabModelTemplates.VERTICAL_NORTH_FACING_SLAB_NORTH_WEST_MIRRORED);

  public static final VerticalSlabTexturedModelProvider
      VERTICAL_SOUTH_FACING_SLAB_NORTH_WEST_MIRRORED =
          createProvider(
              VerticalSlabTexturedModels::simpleVerticalSlab,
              VerticalSlabModelTemplates.VERTICAL_SOUTH_FACING_SLAB_NORTH_WEST_MIRRORED);

  public static final VerticalSlabTexturedModelProvider
      VERTICAL_WEST_FACING_SLAB_NORTH_WEST_MIRRORED =
          createProvider(
              VerticalSlabTexturedModels::simpleVerticalSlab,
              VerticalSlabModelTemplates.VERTICAL_WEST_FACING_SLAB_NORTH_WEST_MIRRORED);

  public static final VerticalSlabTexturedModelProvider
      VERTICAL_EAST_FACING_SLAB_NORTH_WEST_MIRRORED =
          createProvider(
              VerticalSlabTexturedModels::simpleVerticalSlab,
              VerticalSlabModelTemplates.VERTICAL_EAST_FACING_SLAB_NORTH_WEST_MIRRORED);

  public static final VerticalSlabTexturedModelProvider VERTICAL_BOTTOM_SLAB_MIRRORED =
      createProvider(
          VerticalSlabTexturedModels::simpleVerticalSlab,
          VerticalSlabModelTemplates.VERTICAL_BOTTOM_SLAB_MIRRORED);

  public static final VerticalSlabTexturedModelProvider VERTICAL_TOP_SLAB_MIRRORED =
      createProvider(
          VerticalSlabTexturedModels::simpleVerticalSlab,
          VerticalSlabModelTemplates.VERTICAL_TOP_SLAB_MIRRORED);

  public static final VerticalSlabTexturedModelProvider VERTICAL_BOTTOM_SLAB_DIRECTIONAL =
      createProvider(
          VerticalSlabTexturedModels::simpleVerticalSlab,
          VerticalSlabModelTemplates.VERTICAL_BOTTOM_SLAB_DIRECTIONAL);

  public static final VerticalSlabTexturedModelProvider VERTICAL_TOP_SLAB_DIRECTIONAL =
      createProvider(
          VerticalSlabTexturedModels::simpleVerticalSlab,
          VerticalSlabModelTemplates.VERTICAL_TOP_SLAB_DIRECTIONAL);

  public static final VerticalSlabTexturedModelProvider VERTICAL_DOUBLE_SLAB_DIRECTIONAL =
      createProvider(
          VerticalSlabTexturedModels::simpleVerticalSlab, ModelTemplates.CUBE_DIRECTIONAL);

  public static final VerticalSlabTexturedModelProvider VERTICAL_BOTTOM_SLAB_DIRECTIONAL_COLUMN =
      createProvider(
          VerticalSlabTexturedModels::directionalColumnVerticalSlab,
          VerticalSlabModelTemplates.VERTICAL_BOTTOM_SLAB_DIRECTIONAL);

  public static final VerticalSlabTexturedModelProvider VERTICAL_TOP_SLAB_DIRECTIONAL_COLUMN =
      createProvider(
          VerticalSlabTexturedModels::directionalColumnVerticalSlab,
          VerticalSlabModelTemplates.VERTICAL_TOP_SLAB_DIRECTIONAL);

  public static final VerticalSlabTexturedModelProvider VERTICAL_DOUBLE_SLAB_DIRECTIONAL_COLUMN =
      createProvider(
          VerticalSlabTexturedModels::directionalColumnVerticalSlab,
          ModelTemplates.CUBE_DIRECTIONAL);

  public static final VerticalSlabTexturedModelProvider
      VERTICAL_BOTTOM_SLAB_DIRECTIONAL_COLUMN_SIDE =
          createProvider(
              VerticalSlabTexturedModels::directionalColumnWithSideVerticalSlab,
              VerticalSlabModelTemplates.VERTICAL_BOTTOM_SLAB_DIRECTIONAL);

  public static final VerticalSlabTexturedModelProvider VERTICAL_TOP_SLAB_DIRECTIONAL_COLUMN_SIDE =
      createProvider(
          VerticalSlabTexturedModels::directionalColumnWithSideVerticalSlab,
          VerticalSlabModelTemplates.VERTICAL_TOP_SLAB_DIRECTIONAL);

  public static final VerticalSlabTexturedModelProvider
      VERTICAL_DOUBLE_SLAB_DIRECTIONAL_COLUMN_SIDE =
          createProvider(
              VerticalSlabTexturedModels::directionalColumnWithSideVerticalSlab,
              ModelTemplates.CUBE_DIRECTIONAL);

  public static final VerticalSlabTexturedModelProvider
      VERTICAL_BOTTOM_SLAB_DIRECTIONAL_BOTTOM_TOP =
          createProvider(
              VerticalSlabTexturedModels::directionalBottomTopVerticalSlab,
              VerticalSlabModelTemplates.VERTICAL_BOTTOM_SLAB_DIRECTIONAL);

  public static final VerticalSlabTexturedModelProvider VERTICAL_TOP_SLAB_DIRECTIONAL_BOTTOM_TOP =
      createProvider(
          VerticalSlabTexturedModels::directionalBottomTopVerticalSlab,
          VerticalSlabModelTemplates.VERTICAL_TOP_SLAB_DIRECTIONAL);

  public static final VerticalSlabTexturedModelProvider
      VERTICAL_DOUBLE_SLAB_DIRECTIONAL_BOTTOM_TOP =
          createProvider(
              VerticalSlabTexturedModels::directionalBottomTopVerticalSlab,
              ModelTemplates.CUBE_DIRECTIONAL);

  public static TextureMapping simpleVerticalSlab(Block block) {
    Identifier blockTexture = getBlockTexture(block);
    return new TextureMapping()
        .put(TextureSlot.NORTH, blockTexture)
        .put(TextureSlot.SOUTH, blockTexture)
        .put(TextureSlot.EAST, blockTexture)
        .put(TextureSlot.WEST, blockTexture)
        .put(TextureSlot.UP, blockTexture)
        .put(TextureSlot.DOWN, blockTexture)
        .put(TextureSlot.PARTICLE, blockTexture);
  }

  public static void editSimpleVerticalSlab(TextureMapping mapping, Identifier customBlockTexture) {
    mapping
        .put(TextureSlot.NORTH, customBlockTexture)
        .put(TextureSlot.SOUTH, customBlockTexture)
        .put(TextureSlot.EAST, customBlockTexture)
        .put(TextureSlot.WEST, customBlockTexture)
        .put(TextureSlot.UP, customBlockTexture)
        .put(TextureSlot.DOWN, customBlockTexture)
        .put(TextureSlot.PARTICLE, customBlockTexture);
  }

  public static TextureMapping columnWithSideVerticalSlab(Block block) {
    Identifier sideTexture = getBlockTexture(block, "_side");
    Identifier endTexture = getBlockTexture(block, "_top");
    return new TextureMapping()
        .put(TextureSlot.NORTH, sideTexture)
        .put(TextureSlot.SOUTH, sideTexture)
        .put(TextureSlot.EAST, sideTexture)
        .put(TextureSlot.WEST, sideTexture)
        .put(TextureSlot.UP, endTexture)
        .put(TextureSlot.DOWN, endTexture)
        .put(TextureSlot.PARTICLE, sideTexture);
  }

  public static TextureMapping directionalColumnWithSideVerticalSlab(Block block) {
    Identifier sideTexture = getBlockTexture(block, "_side");
    Identifier endTexture = getBlockTexture(block, "_top");
    return new TextureMapping()
        .put(TextureSlot.NORTH, endTexture)
        .put(TextureSlot.SOUTH, endTexture)
        .put(TextureSlot.EAST, sideTexture)
        .put(TextureSlot.WEST, sideTexture)
        .put(TextureSlot.UP, sideTexture)
        .put(TextureSlot.DOWN, sideTexture)
        .put(TextureSlot.PARTICLE, sideTexture);
  }

  public static TextureMapping columnVerticalSlab(Block block) {
    Identifier sideTexture = getBlockTexture(block);
    Identifier endTexture = getBlockTexture(block, "_top");
    return new TextureMapping()
        .put(TextureSlot.NORTH, sideTexture)
        .put(TextureSlot.SOUTH, sideTexture)
        .put(TextureSlot.EAST, sideTexture)
        .put(TextureSlot.WEST, sideTexture)
        .put(TextureSlot.UP, endTexture)
        .put(TextureSlot.DOWN, endTexture)
        .put(TextureSlot.PARTICLE, sideTexture);
  }

  public static TextureMapping directionalColumnVerticalSlab(Block block) {
    Identifier sideTexture = getBlockTexture(block);
    Identifier endTexture = getBlockTexture(block, "_top");
    return new TextureMapping()
        .put(TextureSlot.NORTH, endTexture)
        .put(TextureSlot.SOUTH, endTexture)
        .put(TextureSlot.EAST, sideTexture)
        .put(TextureSlot.WEST, sideTexture)
        .put(TextureSlot.UP, sideTexture)
        .put(TextureSlot.DOWN, sideTexture)
        .put(TextureSlot.PARTICLE, sideTexture);
  }

  public static void editColumnVerticalSlab(
      TextureMapping mapping,
      @Nullable Identifier customEndTexture,
      @Nullable Identifier customSideTexture) {
    if (customEndTexture != null) {
      mapping.put(TextureSlot.UP, customEndTexture).put(TextureSlot.DOWN, customEndTexture);
    }
    if (customSideTexture != null) {
      mapping
          .put(TextureSlot.NORTH, customSideTexture)
          .put(TextureSlot.EAST, customSideTexture)
          .put(TextureSlot.SOUTH, customSideTexture)
          .put(TextureSlot.WEST, customSideTexture)
          .put(TextureSlot.PARTICLE, customSideTexture);
    }
  }

  public static void editDirectionalColumnVerticalSlab(
      TextureMapping mapping,
      @Nullable Identifier customEndTexture,
      @Nullable Identifier customSideTexture) {
    if (customEndTexture != null) {
      mapping.put(TextureSlot.NORTH, customEndTexture).put(TextureSlot.SOUTH, customEndTexture);
    }
    if (customSideTexture != null) {
      mapping
          .put(TextureSlot.UP, customSideTexture)
          .put(TextureSlot.EAST, customSideTexture)
          .put(TextureSlot.DOWN, customSideTexture)
          .put(TextureSlot.WEST, customSideTexture)
          .put(TextureSlot.PARTICLE, customSideTexture);
    }
  }

  public static TextureMapping bottomTopWithSideVerticalSlab(Block block) {
    Identifier sideTexture = getBlockTexture(block, "_side");
    Identifier topTexture = getBlockTexture(block, "_top");
    Identifier bottomTexture = getBlockTexture(block, "_bottom");
    return new TextureMapping()
        .put(TextureSlot.NORTH, sideTexture)
        .put(TextureSlot.SOUTH, sideTexture)
        .put(TextureSlot.EAST, sideTexture)
        .put(TextureSlot.WEST, sideTexture)
        .put(TextureSlot.UP, topTexture)
        .put(TextureSlot.DOWN, bottomTexture)
        .put(TextureSlot.PARTICLE, sideTexture);
  }

  public static TextureMapping directionalBottomTopWithSideVerticalSlab(Block block) {
    Identifier sideTexture = getBlockTexture(block, "_side");
    Identifier topTexture = getBlockTexture(block, "_top");
    Identifier bottomTexture = getBlockTexture(block, "_bottom");
    return new TextureMapping()
        .put(TextureSlot.NORTH, topTexture)
        .put(TextureSlot.SOUTH, bottomTexture)
        .put(TextureSlot.EAST, sideTexture)
        .put(TextureSlot.WEST, sideTexture)
        .put(TextureSlot.UP, sideTexture)
        .put(TextureSlot.DOWN, sideTexture)
        .put(TextureSlot.PARTICLE, sideTexture);
  }

  public static TextureMapping bottomTopVerticalSlab(Block block) {
    Identifier sideTexture = getBlockTexture(block);
    Identifier topTexture = getBlockTexture(block, "_top");
    Identifier bottomTexture = getBlockTexture(block, "_bottom");
    return new TextureMapping()
        .put(TextureSlot.NORTH, sideTexture)
        .put(TextureSlot.SOUTH, sideTexture)
        .put(TextureSlot.EAST, sideTexture)
        .put(TextureSlot.WEST, sideTexture)
        .put(TextureSlot.UP, topTexture)
        .put(TextureSlot.DOWN, bottomTexture)
        .put(TextureSlot.PARTICLE, sideTexture);
  }

  public static TextureMapping directionalBottomTopVerticalSlab(Block block) {
    Identifier sideTexture = getBlockTexture(block);
    Identifier topTexture = getBlockTexture(block, "_top");
    Identifier bottomTexture = getBlockTexture(block, "_bottom");
    return new TextureMapping()
        .put(TextureSlot.NORTH, topTexture)
        .put(TextureSlot.SOUTH, bottomTexture)
        .put(TextureSlot.EAST, sideTexture)
        .put(TextureSlot.WEST, sideTexture)
        .put(TextureSlot.UP, sideTexture)
        .put(TextureSlot.DOWN, sideTexture)
        .put(TextureSlot.PARTICLE, sideTexture);
  }

  public static void editBottomTopWithSideVerticalSlab(
      TextureMapping mapping,
      @Nullable Identifier customBottomTexture,
      @Nullable Identifier customTopTexture,
      @Nullable Identifier customSideTexture) {
    if (customBottomTexture != null) {
      mapping.put(TextureSlot.DOWN, customBottomTexture);
    }
    if (customTopTexture != null) {
      mapping.put(TextureSlot.UP, customTopTexture);
    }
    if (customSideTexture != null) {
      mapping
          .put(TextureSlot.NORTH, customSideTexture)
          .put(TextureSlot.SOUTH, customSideTexture)
          .put(TextureSlot.EAST, customSideTexture)
          .put(TextureSlot.WEST, customSideTexture)
          .put(TextureSlot.PARTICLE, customSideTexture);
    }
  }

  public static void editDirectionalBottomTopWithSideVerticalSlab(
      TextureMapping mapping,
      @Nullable Identifier customBottomTexture,
      @Nullable Identifier customTopTexture,
      @Nullable Identifier customSideTexture) {
    if (customBottomTexture != null) {
      mapping.put(TextureSlot.SOUTH, customBottomTexture);
    }
    if (customTopTexture != null) {
      mapping.put(TextureSlot.NORTH, customTopTexture);
    }
    if (customSideTexture != null) {
      mapping
          .put(TextureSlot.UP, customSideTexture)
          .put(TextureSlot.DOWN, customSideTexture)
          .put(TextureSlot.EAST, customSideTexture)
          .put(TextureSlot.WEST, customSideTexture)
          .put(TextureSlot.PARTICLE, customSideTexture);
    }
  }

  public static VerticalSlabTexturedModelProvider createProvider(
      Function<Block, TextureMapping> function, ModelTemplate modelTemplate) {
    return source ->
        TexturedModelInvoker.invokeTexturedModelConstructor(function.apply(source), modelTemplate);
  }

  public static void initialize() {
    VerticalSlabs.LOGGER.info("Vertical Slab Textured Models initialized!");
  }
}
