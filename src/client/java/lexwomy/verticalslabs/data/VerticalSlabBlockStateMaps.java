package lexwomy.verticalslabs.data;

import static net.minecraft.client.data.models.BlockModelGenerators.*;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.UnaryOperator;
import lexwomy.verticalslabs.VerticalSlabs;
import lexwomy.verticalslabs.block.VerticalSlabType;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.core.Direction;

public class VerticalSlabBlockStateMaps {
  public static final EnumMap<Direction, UnaryOperator<MultiVariant>>
      halfModelUVLockedBlockStateMap =
          new EnumMap<>(
              Map.of(
                  Direction.NORTH,
                  model -> model.with(UV_LOCK),
                  Direction.EAST,
                  model -> model.with(Y_ROT_90).with(UV_LOCK),
                  Direction.SOUTH,
                  model -> model.with(Y_ROT_180).with(UV_LOCK),
                  Direction.WEST,
                  model -> model.with(Y_ROT_270).with(UV_LOCK)));
  public static final EnumMap<Direction, UnaryOperator<MultiVariant>>
      halfModelNonUVLockedBlockStateMap =
          new EnumMap<>(
              Map.of(
                  Direction.NORTH,
                  model -> model,
                  Direction.EAST,
                  model -> model.with(Y_ROT_90),
                  Direction.SOUTH,
                  model -> model.with(Y_ROT_180),
                  Direction.WEST,
                  model -> model.with(Y_ROT_270)));
  public static final EnumMap<Direction, UnaryOperator<MultiVariant>>
      fullModelUVLockedBlockStateMap =
          new EnumMap<>(
              Map.of(
                  Direction.NORTH,
                  model -> model.with(UV_LOCK),
                  Direction.EAST,
                  model -> model.with(UV_LOCK),
                  Direction.SOUTH,
                  model -> model.with(UV_LOCK),
                  Direction.WEST,
                  model -> model.with(UV_LOCK)));
  public static final EnumMap<Direction, UnaryOperator<MultiVariant>>
      fullModelNonUVLockedBlockStateMap =
          new EnumMap<>(
              Map.of(
                  Direction.NORTH,
                  model -> model,
                  Direction.EAST,
                  model -> model,
                  Direction.SOUTH,
                  model -> model,
                  Direction.WEST,
                  model -> model));
  public static final EnumMap<Direction, UnaryOperator<MultiVariant>>
      fullModelDirectionalBlockStateMap =
          new EnumMap<>(
              Map.of(
                  Direction.NORTH,
                  model -> model,
                  Direction.EAST,
                  model -> model.with(Y_ROT_90),
                  Direction.SOUTH,
                  model -> model.with(Y_ROT_180),
                  Direction.WEST,
                  model -> model.with(Y_ROT_270)));
  public static final EnumMap<VerticalSlabType, EnumMap<Direction, UnaryOperator<MultiVariant>>>
      simpleUVLockedBlockStateMap =
          new EnumMap<>(
              Map.of(
                  VerticalSlabType.BOTTOM,
                  halfModelUVLockedBlockStateMap,
                  VerticalSlabType.TOP,
                  halfModelUVLockedBlockStateMap,
                  VerticalSlabType.DOUBLE,
                  fullModelUVLockedBlockStateMap));
  public static final EnumMap<VerticalSlabType, EnumMap<Direction, UnaryOperator<MultiVariant>>>
      simpleNonUVLockedBlockStateMap =
          new EnumMap<>(
              Map.of(
                  VerticalSlabType.BOTTOM,
                  halfModelNonUVLockedBlockStateMap,
                  VerticalSlabType.TOP,
                  halfModelNonUVLockedBlockStateMap,
                  VerticalSlabType.DOUBLE,
                  fullModelNonUVLockedBlockStateMap));
  public static final EnumMap<VerticalSlabType, EnumMap<Direction, UnaryOperator<MultiVariant>>>
      directionalBlockStateMap =
          new EnumMap<>(
              Map.of(
                  VerticalSlabType.BOTTOM,
                  halfModelNonUVLockedBlockStateMap,
                  VerticalSlabType.TOP,
                  halfModelNonUVLockedBlockStateMap,
                  VerticalSlabType.DOUBLE,
                  fullModelDirectionalBlockStateMap));

  public static final EnumMap<VerticalSlabType, EnumMap<Direction, UnaryOperator<MultiVariant>>>
      northWestMirroredBlockStateMap =
          new EnumMap<>(
              Map.of(
                  VerticalSlabType.BOTTOM,
                  new EnumMap<>(
                      Map.of(
                          Direction.NORTH,
                          model -> model,
                          Direction.EAST,
                          model -> model,
                          Direction.SOUTH,
                          model -> model,
                          Direction.WEST,
                          model -> model)),
                  VerticalSlabType.TOP,
                  new EnumMap<>(
                      Map.of(
                          Direction.NORTH,
                          model -> model,
                          Direction.EAST,
                          model -> model,
                          Direction.SOUTH,
                          model -> model,
                          Direction.WEST,
                          model -> model)),
                  VerticalSlabType.DOUBLE,
                  new EnumMap<>(
                      Map.of(
                          Direction.NORTH,
                          model -> model,
                          Direction.EAST,
                          model -> model,
                          Direction.SOUTH,
                          model -> model,
                          Direction.WEST,
                          model -> model))));

  public static void initialize() {
    VerticalSlabs.LOGGER.info("Vertical Slab Block States initialized!");
  }
}
