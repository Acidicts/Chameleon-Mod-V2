package net.acidicts.chameleon.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent COOKED_CHAMELEON = new FoodComponent.Builder().nutrition(6).saturationModifier(0.6F).build();
    public static final FoodComponent GOLDEN_CHAMELEON = new FoodComponent.Builder().nutrition(10).saturationModifier(1.2F)
            .statusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 200), 0.7f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1000, 1), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 600, 1), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 1000, 5), 0.2f)
            .alwaysEdible().build();
}
