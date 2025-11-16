package net.acidicts.chameleon.item;

import net.acidicts.chameleon.ChameleonMod;
import net.acidicts.chameleon.entity.ModEntities;
import net.acidicts.chameleon.item.items.ChameleonCapturer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item CHAMELEON = registerItem("chameleon", new Item(new Item.Settings()));
    public static final Item CHAMELEON_EGG = registerItem("chameleon_egg", new Item(new Item.Settings()));
    public static final Item STEEL_INGOT = registerItem("steel_ingot", new Item(new Item.Settings()));
    public static final Item STEEL_DUST = registerItem("steel_dust", new Item(new Item.Settings()));
    public static final Item CAPTURE_CHAMELEON = registerItem("capture_chameleon", new ChameleonCapturer(new Item.Settings().maxCount(1)));

    public static final Item CHAMELEON_SPAWN_EGG = registerItem("chameleon_spawn_egg", new SpawnEggItem(ModEntities.CHAMELEON,
            0x4CAF50, 0xFFEB3B, new Item.Settings().maxCount(16)));

    private static Item registerItem(String name, Item item) {
        Item registeredItem = Registry.register(Registries.ITEM, Identifier.of(ChameleonMod.MOD_ID, name), item);

        String translationKey = "item." + ChameleonMod.MOD_ID + "." + name;
        String translatedName = Text.translatable(translationKey).getString();

        if (translatedName.equals(translationKey)) {
            translatedName = formatRegistryName(name);
        }

        ChameleonMod.LOGGER.info("Registering {} !", translatedName);
        return registeredItem;
    }

    public static String formatRegistryName(String name) {
        String[] words = name.split("_");
        StringBuilder formatted = new StringBuilder();
        for (String word : words) {
            if (!formatted.isEmpty()) {
                formatted.append(" ");
            }
            formatted.append(Character.toUpperCase(word.charAt(0)))
                     .append(word.substring(1));
        }
        return formatted.toString();
    }

    public static void registerItems() {
        ChameleonMod.LOGGER.info("Registering Items for " + ChameleonMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> entries.add(CHAMELEON));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> entries.add(CHAMELEON_EGG));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.add(STEEL_INGOT));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.add(STEEL_DUST));
    }
}
