package net.acidicts.chameleon.datagen;

import net.acidicts.chameleon.item.ModItems;
import net.acidicts.chameleon.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
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
    }
}
