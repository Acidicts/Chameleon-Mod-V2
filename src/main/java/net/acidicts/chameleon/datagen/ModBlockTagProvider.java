package net.acidicts.chameleon.datagen;

import net.acidicts.chameleon.block.ModBlocks;
import net.acidicts.chameleon.item.ModItems;
import net.acidicts.chameleon.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.INCUBATOR);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.INCUBATOR);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_CHAMELEON_SCALE_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);
    }
}
