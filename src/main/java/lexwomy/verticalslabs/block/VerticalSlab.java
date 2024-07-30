package lexwomy.verticalslabs.block;

import lexwomy.verticalslabs.VerticalSlabs;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.block.AbstractBlock.Settings;

import static net.minecraft.block.Blocks.*;

public class VerticalSlab {
    public static Block register(Block block, String name, boolean shouldRegisterItem) {
        Identifier id = Identifier.of(VerticalSlabs.MOD_ID, name);

        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }

        return Registry.register(Registries.BLOCK, id, block);
    }

    public static final RegistryKey<ItemGroup> VERTICAL_SLAB_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(VerticalSlabs.MOD_ID, "item_group"));
    public static final ItemGroup VERTICAL_SLAB_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(VerticalSlab.VERTICAL_STONE_SLAB))
            .displayName(Text.translatable("itemGroup.vertical_slabs"))
            .build();
    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, VERTICAL_SLAB_GROUP_KEY, VERTICAL_SLAB_GROUP);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register((itemGroup) -> {
            itemGroup.add(VERTICAL_STONE_SLAB);
            itemGroup.add(VERTICAL_COBBLESTONE_SLAB);
            itemGroup.add(VERTICAL_MOSSY_COBBLESTONE_SLAB);
            itemGroup.add(VERTICAL_SMOOTH_STONE_SLAB);
            itemGroup.add(VERTICAL_STONE_BRICK_SLAB);
            itemGroup.add(VERTICAL_MOSSY_STONE_BRICK_SLAB);
            itemGroup.add(VERTICAL_GRANITE_SLAB);
            itemGroup.add(VERTICAL_POLISHED_GRANITE_SLAB);
            itemGroup.add(VERTICAL_DIORITE_SLAB);
            itemGroup.add(VERTICAL_POLISHED_DIORITE_SLAB);
            itemGroup.add(VERTICAL_ANDESITE_SLAB);
            itemGroup.add(VERTICAL_POLISHED_ANDESITE_SLAB);
            itemGroup.add(VERTICAL_COBBLED_DEEPSLATE_SLAB);
            itemGroup.add(VERTICAL_POLISHED_DEEPSLATE_SLAB);
            itemGroup.add(VERTICAL_DEEPSLATE_BRICK_SLAB);
            itemGroup.add(VERTICAL_DEEPSLATE_TILE_SLAB);
            itemGroup.add(VERTICAL_TUFF_SLAB);
            itemGroup.add(VERTICAL_POLISHED_TUFF_SLAB);
            itemGroup.add(VERTICAL_TUFF_BRICK_SLAB);
        });
        ItemGroupEvents.modifyEntriesEvent(VERTICAL_SLAB_GROUP_KEY).register((itemGroup) -> {
            itemGroup.add(VERTICAL_STONE_SLAB);
            itemGroup.add(VERTICAL_COBBLESTONE_SLAB);
            itemGroup.add(VERTICAL_MOSSY_COBBLESTONE_SLAB);
            itemGroup.add(VERTICAL_SMOOTH_STONE_SLAB);
            itemGroup.add(VERTICAL_STONE_BRICK_SLAB);
            itemGroup.add(VERTICAL_MOSSY_STONE_BRICK_SLAB);
            itemGroup.add(VERTICAL_GRANITE_SLAB);
            itemGroup.add(VERTICAL_POLISHED_GRANITE_SLAB);
            itemGroup.add(VERTICAL_DIORITE_SLAB);
            itemGroup.add(VERTICAL_POLISHED_DIORITE_SLAB);
            itemGroup.add(VERTICAL_ANDESITE_SLAB);
            itemGroup.add(VERTICAL_POLISHED_ANDESITE_SLAB);
            itemGroup.add(VERTICAL_COBBLED_DEEPSLATE_SLAB);
            itemGroup.add(VERTICAL_POLISHED_DEEPSLATE_SLAB);
            itemGroup.add(VERTICAL_DEEPSLATE_BRICK_SLAB);
            itemGroup.add(VERTICAL_DEEPSLATE_TILE_SLAB);
            itemGroup.add(VERTICAL_TUFF_SLAB);
            itemGroup.add(VERTICAL_POLISHED_TUFF_SLAB);
            itemGroup.add(VERTICAL_TUFF_BRICK_SLAB);
        });
    }

    public static final Block VERTICAL_STONE_SLAB = register(
            new VerticalSlabBlock(Settings.copy(STONE).strength(2.0F, 6.0F)),
            "vertical_stone_slab",
            true
    );

    public static final Block VERTICAL_SMOOTH_STONE_SLAB = register(
            new VerticalSlabBlock(Settings.copy(SMOOTH_STONE)),
            "vertical_smooth_stone_slab",
            true
    );

    public static final Block VERTICAL_COBBLESTONE_SLAB = register(
            new VerticalSlabBlock(Settings.copy(COBBLESTONE)),
            "vertical_cobblestone_slab",
            true
    );

    public static final Block VERTICAL_MOSSY_COBBLESTONE_SLAB = register(
            new VerticalSlabBlock(Settings.copy(MOSSY_COBBLESTONE).strength(2.0F, 6.0F)),
            "vertical_mossy_cobblestone_slab",
            true
    );

    public static final Block VERTICAL_STONE_BRICK_SLAB = register(
            new VerticalSlabBlock(Settings.copy(STONE_BRICKS).strength(2.0F, 6.0F)),
            "vertical_stone_brick_slab",
            true
    );

    public static final Block VERTICAL_MOSSY_STONE_BRICK_SLAB = register(
            new VerticalSlabBlock(Settings.copy(MOSSY_STONE_BRICKS).strength(2.0F, 6.0F)),
            "vertical_mossy_stone_brick_slab",
            true
    );

    public static final Block VERTICAL_GRANITE_SLAB = register(
            new VerticalSlabBlock(Settings.copy(GRANITE)),
            "vertical_granite_slab",
            true
    );

    public static final Block VERTICAL_POLISHED_GRANITE_SLAB = register(
            new VerticalSlabBlock(Settings.copy(POLISHED_GRANITE)),
            "vertical_polished_granite_slab",
            true
    );

    public static final Block VERTICAL_DIORITE_SLAB = register(
            new VerticalSlabBlock(Settings.copy(DIORITE)),
            "vertical_diorite_slab",
            true
    );

    public static final Block VERTICAL_POLISHED_DIORITE_SLAB = register(
            new VerticalSlabBlock(Settings.copy(POLISHED_DIORITE)),
            "vertical_polished_diorite_slab",
            true
    );

    public static final Block VERTICAL_ANDESITE_SLAB = register(
            new VerticalSlabBlock(Settings.copy(ANDESITE)),
            "vertical_andesite_slab",
            true
    );

    public static final Block VERTICAL_POLISHED_ANDESITE_SLAB = register(
            new VerticalSlabBlock(Settings.copy(POLISHED_ANDESITE)),
            "vertical_polished_andesite_slab",
            true
    );

    public static final Block VERTICAL_COBBLED_DEEPSLATE_SLAB = register(
            new VerticalSlabBlock(Settings.copy(COBBLED_DEEPSLATE)),
                "vertical_cobbled_deepslate_slab",
                true
    );

    public static final Block VERTICAL_POLISHED_DEEPSLATE_SLAB = register(
            new VerticalSlabBlock(Settings.copy(POLISHED_DEEPSLATE)),
            "vertical_polished_deepslate_slab",
            true
    );

    public static final Block VERTICAL_DEEPSLATE_BRICK_SLAB = register(
            new VerticalSlabBlock(Settings.copy(DEEPSLATE_BRICKS)),
            "vertical_deepslate_brick_slab",
            true
    );

    public static final Block VERTICAL_DEEPSLATE_TILE_SLAB = register(
            new VerticalSlabBlock(Settings.copy(DEEPSLATE_TILES)),
            "vertical_deepslate_tile_slab",
            true
    );

    public static final Block VERTICAL_TUFF_SLAB = register(
            new VerticalSlabBlock(Settings.copy(TUFF)),
            "vertical_tuff_slab",
            true
    );

    public static final Block VERTICAL_POLISHED_TUFF_SLAB = register(
            new VerticalSlabBlock(Settings.copy(POLISHED_TUFF)),
            "vertical_polished_tuff_slab",
            true
    );

    public static final Block VERTICAL_TUFF_BRICK_SLAB = register(
            new VerticalSlabBlock(Settings.copy(TUFF_BRICKS)),
            "vertical_tuff_brick_slab",
            true
    );
}
