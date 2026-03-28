package lexwomy.verticalslabs.mixin;

import static lexwomy.verticalslabs.block.VerticalSlabBlock.FACING;
import static lexwomy.verticalslabs.block.VerticalSlabBlock.TYPE;

import lexwomy.verticalslabs.block.VerticalSlabBlock;
import lexwomy.verticalslabs.block.VerticalSlabType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.WallSide;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WallBlock.class)
public abstract class WallConnectVerticalSlabsMixin extends Block {

  @Shadow @Final public static EnumProperty<WallSide> NORTH;

  @Shadow @Final public static EnumProperty<WallSide> SOUTH;

  @Shadow @Final public static EnumProperty<WallSide> EAST;

  @Shadow @Final public static EnumProperty<WallSide> WEST;

  @Shadow @Final public static BooleanProperty UP;

  public WallConnectVerticalSlabsMixin(Properties settings) {
    super(settings);
  }

  @Inject(method = "connectsTo", at = @At("HEAD"), cancellable = true)
  private void onCheckConnect(
      BlockState state,
      boolean faceFullSquare,
      Direction side,
      CallbackInfoReturnable<Boolean> cir) {
    Block block = state.getBlock();
    if (block instanceof VerticalSlabBlock
        && ((VerticalSlabBlock) block).canWallConnect(state, side)) {
      cir.setReturnValue(true);
    }
  }

  @Inject(
      method =
          "updateShape(Lnet/minecraft/world/level/LevelReader;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;ZZZZ)Lnet/minecraft/world/level/block/state/BlockState;",
      at = @At(value = "TAIL"),
      cancellable = true)
  private void interjectWithVerticalSlabCheck(
      LevelReader world,
      BlockState state,
      BlockPos pos,
      BlockState aboveState,
      boolean north,
      boolean east,
      boolean south,
      boolean west,
      CallbackInfoReturnable<BlockState> cir) {
    // If above state is a vertical slab and the wall below is connected to at least one side,
    // perform check to see which walls
    // should be raised to tall
    if (aboveState.getBlock() instanceof VerticalSlabBlock
        && (aboveState.getValue(TYPE) == VerticalSlabType.BOTTOM
            || aboveState.getValue(TYPE) == VerticalSlabType.TOP)
        && (north || east || south || west)) {
      BlockState result = cir.getReturnValue();

      boolean ns = false;
      boolean ew = false;
      Direction face = aboveState.getValue(FACING);
      if (face == Direction.NORTH || face == Direction.SOUTH) {
        ns = true;
      } else {
        ew = true;
      }

      WallSide set_north = result.getValue(NORTH);
      WallSide set_south = result.getValue(SOUTH);
      WallSide set_east = result.getValue(EAST);
      WallSide set_west = result.getValue(WEST);

      int low_count = 4;

      if (north && (ew || face == Direction.SOUTH)) {
        set_north = WallSide.TALL;
        low_count -= 1;
      }
      if (south && (ew || face == Direction.NORTH)) {
        set_south = WallSide.TALL;
        low_count -= 1;
      }
      if (east && (ns || face == Direction.WEST)) {
        set_east = WallSide.TALL;
        low_count -= 1;
      }
      if (west && (ns || face == Direction.EAST)) {
        set_west = WallSide.TALL;
        low_count -= 1;
      }

      boolean straight_wall =
          low_count == 2
              && ((set_north == set_south && set_north == WallSide.TALL)
                  || (set_east == set_west && set_east == WallSide.TALL));

      cir.setReturnValue(
          result
              .setValue(NORTH, set_north)
              .setValue(SOUTH, set_south)
              .setValue(EAST, set_east)
              .setValue(WEST, set_west)
              .setValue(UP, !straight_wall));
    }
  }
}
