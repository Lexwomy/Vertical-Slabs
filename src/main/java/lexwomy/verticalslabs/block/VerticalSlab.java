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
        });
        ItemGroupEvents.modifyEntriesEvent(VERTICAL_SLAB_GROUP_KEY).register((itemGroup) -> {
            itemGroup.add(VERTICAL_STONE_SLAB);
        });
    }

    public static final Block VERTICAL_STONE_SLAB = register(
            new VerticalSlabBlock(Settings.create()
                    .mapColor(MapColor.STONE_GRAY).instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool().strength(2.0F, 6.0F).sounds(BlockSoundGroup.STONE)),
            "vertical_stone_slab",
            true
    );


}
