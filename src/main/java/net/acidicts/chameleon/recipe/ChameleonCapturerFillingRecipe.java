package net.acidicts.chameleon.recipe;

import net.acidicts.chameleon.entity.custom.ChameleonVariant;
import net.acidicts.chameleon.item.ModItems;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.recipe.input.CraftingRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.World;

public class ChameleonCapturerFillingRecipe extends SpecialCraftingRecipe {

    public ChameleonCapturerFillingRecipe(CraftingRecipeCategory category) {
        super(category);
    }

    @Override
    public boolean matches(CraftingRecipeInput input, World world) {
        boolean hasEmptyCapturer = false;
        boolean hasChameleonItem = false;
        int itemCount = 0;

        for (int i = 0; i < input.getSize(); i++) {
            ItemStack stack = input.getStackInSlot(i);
            if (!stack.isEmpty()) {
                itemCount++;

                if (stack.isOf(ModItems.CAPTURE_CHAMELEON)) {
                    // Check if it's empty (no custom data or no chameleon data)
                    NbtComponent nbtComponent = stack.getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT);
                    if (!nbtComponent.copyNbt().contains("Chameleon")) {
                        hasEmptyCapturer = true;
                    } else {
                        return false; // Already filled
                    }
                } else if (stack.isOf(ModItems.CHAMELEON)) {
                    hasChameleonItem = true;
                } else {
                    return false; // Invalid item
                }
            }
        }

        return hasEmptyCapturer && hasChameleonItem && itemCount == 2;
    }

    @Override
    public ItemStack craft(CraftingRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        ItemStack result = new ItemStack(ModItems.CAPTURE_CHAMELEON);

        // Create default chameleon data
        NbtCompound root = new NbtCompound();
        root.putString("Variant", ChameleonVariant.DEFAULT.name());
        root.putInt("TypeVariant", ChameleonVariant.DEFAULT.getId());
        root.putInt("Age", -24000); // Baby chameleon
        root.putFloat("Health", 12.0f); // Max health

        NbtCompound customData = new NbtCompound();
        customData.put("Chameleon", root);
        result.set(DataComponentTypes.CUSTOM_DATA, NbtComponent.of(customData));

        return result;
    }

    @Override
    public boolean fits(int width, int height) {
        return width * height >= 2;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.CHAMELEON_CAPTURER_FILLING;
    }
}

