package net.acidicts.chameleon.block;

import net.acidicts.chameleon.ChameleonMod;
import net.acidicts.chameleon.block.custom.Incubator;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


import static net.acidicts.chameleon.item.ModItems.formatRegistryName;

public class ModBlocks {

    public static final Block INCUBATOR = registerBlock("incubator",
            new Incubator(AbstractBlock.Settings.create().nonOpaque().requiresTool().strength(4f).resistance(12f)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        Block registeredBlock = Registry.register(Registries.BLOCK, Identifier.of(ChameleonMod.MOD_ID, name), block);

        String translationKey = "block." + ChameleonMod.MOD_ID + "." + name;
        String translatedName = net.minecraft.text.Text.translatable(translationKey).getString();

        if (translatedName.equals(translationKey)) {
            translatedName = formatRegistryName(name);
        }

        ChameleonMod.LOGGER.info("Registering {} !", translatedName);
        return registeredBlock;
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(ChameleonMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerBlocks() {
        ChameleonMod.LOGGER.info("Registering Blocks for {}", ChameleonMod.MOD_ID);
    }
}
