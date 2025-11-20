package net.acidicts.chameleon.datagen;

import net.acidicts.chameleon.item.ModItems;
import net.acidicts.chameleon.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.CHAMELEON_MOD)
                .add(ModItems.CHAMELEON)
                .add(ModItems.CHAMELEON_EGG)
                .add(ModItems.STEEL_DUST)
                .add(ModItems.STEEL_INGOT);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.CHAMELEON_SCALE_HELMET)
                .add(ModItems.CHAMELEON_SCALE_CHESTPLATE)
                .add(ModItems.CHAMELEON_SCALE_LEGGINGS)
                .add(ModItems.CHAMELEON_SCALE_BOOTS);

        getOrCreateTagBuilder(ItemTags.ARMOR_ENCHANTABLE)
                .add(ModItems.CHAMELEON_SCALE_HELMET)
                .add(ModItems.CHAMELEON_SCALE_CHESTPLATE)
                .add(ModItems.CHAMELEON_SCALE_LEGGINGS)
                .add(ModItems.CHAMELEON_SCALE_BOOTS);

        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .add(ModItems.CHAMELEON_SCALE_HELMET);

        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR_ENCHANTABLE)
                .add(ModItems.CHAMELEON_SCALE_CHESTPLATE);

        getOrCreateTagBuilder(ItemTags.LEG_ARMOR_ENCHANTABLE)
                .add(ModItems.CHAMELEON_SCALE_LEGGINGS);

        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR_ENCHANTABLE)
                .add(ModItems.CHAMELEON_SCALE_BOOTS);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.CHAMELEON_SCALE_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.CHAMELEON_SCALE_PICKAXE);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.CHAMELEON_SCALE_AXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.CHAMELEON_SCALE_SHOVEL);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.CHAMELEON_SCALE_HOE);

        getOrCreateTagBuilder(ItemTags.WEAPON_ENCHANTABLE)
                .add(ModItems.CHAMELEON_SCALE_SWORD)
                .add(ModItems.CHAMELEON_SCALE_AXE);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.CHAMELEON_SCALE_SWORD);

        getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE)
                .add(ModItems.CHAMELEON_SCALE_SWORD)
                .add(ModItems.CHAMELEON_SCALE_PICKAXE)
                .add(ModItems.CHAMELEON_SCALE_AXE)
                .add(ModItems.CHAMELEON_SCALE_SHOVEL)
                .add(ModItems.CHAMELEON_SCALE_HOE)
                .add(ModItems.CHAMELEON_SCALE_HAMMER);

        getOrCreateTagBuilder(ItemTags.MINING_ENCHANTABLE)
                .add(ModItems.CHAMELEON_SCALE_PICKAXE)
                .add(ModItems.CHAMELEON_SCALE_AXE)
                .add(ModItems.CHAMELEON_SCALE_SHOVEL)
                .add(ModItems.CHAMELEON_SCALE_HOE)
                .add(ModItems.CHAMELEON_SCALE_HAMMER);

        getOrCreateTagBuilder(ItemTags.MINING_LOOT_ENCHANTABLE)
                .add(ModItems.CHAMELEON_SCALE_PICKAXE);
    }
}
