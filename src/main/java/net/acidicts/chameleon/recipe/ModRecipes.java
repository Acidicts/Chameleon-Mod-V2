package net.acidicts.chameleon.recipe;

import net.acidicts.chameleon.ChameleonMod;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {

    public static final RecipeSerializer<ChameleonCapturerFillingRecipe> CHAMELEON_CAPTURER_FILLING =
            Registry.register(Registries.RECIPE_SERIALIZER,
                    Identifier.of(ChameleonMod.MOD_ID, "chameleon_capturer_filling"),
                    new SpecialRecipeSerializer<>(ChameleonCapturerFillingRecipe::new));

    public static void registerRecipes() {
        ChameleonMod.LOGGER.info("Registering Recipe Serializers for " + ChameleonMod.MOD_ID);
    }
}

