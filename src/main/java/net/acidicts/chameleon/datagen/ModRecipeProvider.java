package net.acidicts.chameleon.datagen;

import net.acidicts.chameleon.ChameleonMod;
import net.acidicts.chameleon.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SmokingRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

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
                ModItems.STEEL_INGOT, 0.1f, 150, "steel_ingot_from_blasting");
        offerSmelting(exporter, List.of(ModItems.CHAMELEON), RecipeCategory.MISC,
                ModItems.COOKED_CHAMELEON, 0.2f, 200, "cooked_chameleon_from_smelting");
        offerFoodCookingRecipe(exporter, "smoker", RecipeSerializer.SMOKING,
                SmokingRecipe::new, 100, ModItems.CHAMELEON, ModItems.COOKED_CHAMELEON, 0.35F);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CHAMELEON_EGG)
                .pattern("###")
                .pattern("#E#")
                .pattern("###")
                .input('#', Items.JUNGLE_SAPLING)
                .input('E', Items.EGG)
                .criterion(hasItem(Items.JUNGLE_SAPLING), conditionsFromItem(Items.JUNGLE_SAPLING))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STEEL_INGOT)
                .pattern("###")
                .pattern("#E#")
                .pattern("###")
                .input('#', Items.CHARCOAL)
                .input('E', Items.IRON_INGOT)
                .criterion(hasItem(Items.JUNGLE_SAPLING), conditionsFromItem(Items.JUNGLE_SAPLING))
                .offerTo(exporter);

        // Special recipe for chameleon capturer filling
        offerSpecialRecipe(exporter, Identifier.of(ChameleonMod.MOD_ID, "chameleon_capturer_filling"));
        generateChameleonArmourToolsRecipes(exporter);

    }

    private void generateChameleonArmourToolsRecipes(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.CHAMELEON_SCALE_SWORD)
                .pattern("###")
                .pattern("#E#")
                .pattern("###")
                .input('#', ModItems.CHAMELEON_SCALE)
                .input('E', Items.IRON_SWORD)
                .criterion(hasItem(ModItems.CHAMELEON_SCALE), conditionsFromItem(ModItems.CHAMELEON_SCALE))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.CHAMELEON_SCALE_PICKAXE)
                .pattern("###")
                .pattern("#E#")
                .pattern("###")
                .input('#', ModItems.CHAMELEON_SCALE)
                .input('E', Items.IRON_PICKAXE)
                .criterion(hasItem(ModItems.CHAMELEON_SCALE), conditionsFromItem(ModItems.CHAMELEON_SCALE))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.CHAMELEON_SCALE_AXE)
                .pattern("###")
                .pattern("#E#")
                .pattern("###")
                .input('#', ModItems.CHAMELEON_SCALE)
                .input('E', Items.IRON_AXE)
                .criterion(hasItem(ModItems.CHAMELEON_SCALE), conditionsFromItem(ModItems.CHAMELEON_SCALE))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.CHAMELEON_SCALE_SHOVEL)
                .pattern("###")
                .pattern("#E#")
                .pattern("###")
                .input('#', ModItems.CHAMELEON_SCALE)
                .input('E', Items.IRON_SHOVEL)
                .criterion(hasItem(ModItems.CHAMELEON_SCALE), conditionsFromItem(ModItems.CHAMELEON_SCALE))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.CHAMELEON_SCALE_HOE)
                .pattern("###")
                .pattern("#E#")
                .pattern("###")
                .input('#', ModItems.CHAMELEON_SCALE)
                .input('E', Items.IRON_HOE)
                .criterion(hasItem(ModItems.CHAMELEON_SCALE), conditionsFromItem(ModItems.CHAMELEON_SCALE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CHAMELEON_SCALE_HELMET)
                .pattern("###")
                .pattern("#E#")
                .pattern("   ")
                .input('#', ModItems.CHAMELEON_SCALE)
                .input('E', Items.IRON_HELMET)
                .criterion(hasItem(ModItems.CHAMELEON_SCALE), conditionsFromItem(ModItems.CHAMELEON_SCALE))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CHAMELEON_SCALE_CHESTPLATE)
                .pattern("#E#")
                .pattern("###")
                .pattern("###")
                .input('#', ModItems.CHAMELEON_SCALE)
                .input('E', Items.IRON_CHESTPLATE)
                .criterion(hasItem(ModItems.CHAMELEON_SCALE), conditionsFromItem(ModItems.CHAMELEON_SCALE))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CHAMELEON_SCALE_LEGGINGS)
                .pattern("###")
                .pattern("#E#")
                .pattern("# #")
                .input('#', ModItems.CHAMELEON_SCALE)
                .input('E', Items.IRON_LEGGINGS)
                .criterion(hasItem(ModItems.CHAMELEON_SCALE), conditionsFromItem(ModItems.CHAMELEON_SCALE))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CHAMELEON_SCALE_BOOTS)
                .pattern("   ")
                .pattern("#E#")
                .pattern("# #")
                .input('#', ModItems.CHAMELEON_SCALE)
                .input('E', Items.IRON_BOOTS)
                .criterion(hasItem(ModItems.CHAMELEON_SCALE), conditionsFromItem(ModItems.CHAMELEON_SCALE))
                .offerTo(exporter);
    }

    private void offerSpecialRecipe(RecipeExporter exporter, Identifier recipeId) {
        net.acidicts.chameleon.recipe.ChameleonCapturerFillingRecipe recipe =
                new net.acidicts.chameleon.recipe.ChameleonCapturerFillingRecipe(
                        net.minecraft.recipe.book.CraftingRecipeCategory.MISC);
        exporter.accept(recipeId, recipe, null);
    }
}
