package net.acidicts.chameleon.datagen;

import net.acidicts.chameleon.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> STEEL_INGOT_SMELTABLES = List.of(
                ModItems.STEEL_DUST
        );
        offerSmelting(exporter, STEEL_INGOT_SMELTABLES, RecipeCategory.MISC,
                ModItems.STEEL_INGOT, 0.2f, 300, "steel_ingot_from_smelting");
        offerBlasting(exporter, STEEL_INGOT_SMELTABLES, RecipeCategory.MISC,
                ModItems.STEEL_INGOT, 0.1f, 150, "steel_ingot_from_smelting");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CHAMELEON_EGG)
                .pattern("###")
                .pattern("#E#")
                .pattern("###")
                .input('#', Items.JUNGLE_SAPLING)
                .input('E', Items.EGG)
                .criterion(hasItem(Items.JUNGLE_SAPLING), conditionsFromItem(Items.JUNGLE_SAPLING))
                .offerTo(exporter);

    }
}
