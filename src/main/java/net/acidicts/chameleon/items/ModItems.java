package net.acidicts.chameleon.items;

import net.acidicts.chameleon.ChameleonMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item CHAMELEON = registerItem("chameleon", new Item(new Item.Settings()));
    public static final Item CHAMELEON_EGG = registerItem("chameleon_egg", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        ChameleonMod.LOGGER.info("Registering " + name + " !");
        return Registry.register(Registries.ITEM, Identifier.of(ChameleonMod.MOD_ID, name), item);
    }

    public static void registerItems() {
        ChameleonMod.LOGGER.info("Registering Items for " + ChameleonMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> entries.add(CHAMELEON));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> entries.add(CHAMELEON_EGG));
    }
}
