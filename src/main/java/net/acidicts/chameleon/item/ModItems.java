package net.acidicts.chameleon.item;

import net.acidicts.chameleon.ChameleonMod;
import net.acidicts.chameleon.entity.ModEntities;
import net.acidicts.chameleon.item.items.ChameleonCapturer;
import net.acidicts.chameleon.item.items.ChameleonScaleArmorItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
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
    public static final Item CHAMELEON_SCALE = registerItem("chameleon_scale", new Item(new Item.Settings()));

    public static final Item CHAMELEON_SPAWN_EGG = registerItem("chameleon_spawn_egg", new SpawnEggItem(ModEntities.CHAMELEON,
            0x4CAF50, 0xFFEB3B, new Item.Settings().maxCount(16)));

    public static final Item COOKED_CHAMELEON = registerItem("cooked_chameleon", new Item(new Item.Settings().food(ModFoodComponents.COOKED_CHAMELEON)));

    public static final Item CHAMELEON_SCALE_HELMET = registerItem("chameleon_scale_helmet",
            new ChameleonScaleArmorItem(ModArmorMaterials.CHAMELEON_SCALE_ARMOUR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(20)).maxCount(1)));
    public static final Item CHAMELEON_SCALE_CHESTPLATE = registerItem("chameleon_scale_chestplate",
            new ChameleonScaleArmorItem(ModArmorMaterials.CHAMELEON_SCALE_ARMOUR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(20)).maxCount(1)));
    public static final Item CHAMELEON_SCALE_LEGGINGS = registerItem("chameleon_scale_leggings",
            new ChameleonScaleArmorItem(ModArmorMaterials.CHAMELEON_SCALE_ARMOUR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(20)).maxCount(1)));
    public static final Item CHAMELEON_SCALE_BOOTS = registerItem("chameleon_scale_boots",
            new ChameleonScaleArmorItem(ModArmorMaterials.CHAMELEON_SCALE_ARMOUR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(20)).maxCount(1)));

    public static final Item CHAMELEON_SCALE_SWORD = registerItem("chameleon_scale_sword",
            new SwordItem(ModToolMaterials.CHAMELEON_SCALE, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.CHAMELEON_SCALE, 3, -2.4f))));
    public static final Item CHAMELEON_SCALE_PICKAXE = registerItem("chameleon_scale_pickaxe",
            new PickaxeItem(ModToolMaterials.CHAMELEON_SCALE, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.CHAMELEON_SCALE, 1, -2.8f))));
    public static final Item CHAMELEON_SCALE_AXE = registerItem("chameleon_scale_axe",
            new AxeItem(ModToolMaterials.CHAMELEON_SCALE, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.CHAMELEON_SCALE, 6, -3.2f))));
    public static final Item CHAMELEON_SCALE_SHOVEL = registerItem("chameleon_scale_shovel",
            new ShovelItem(ModToolMaterials.CHAMELEON_SCALE, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.CHAMELEON_SCALE, 3, -3f))));
    public static final Item CHAMELEON_SCALE_HOE = registerItem("chameleon_scale_hoe",
            new HoeItem(ModToolMaterials.CHAMELEON_SCALE, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.CHAMELEON_SCALE, 3, -3f))));

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
    }
}
