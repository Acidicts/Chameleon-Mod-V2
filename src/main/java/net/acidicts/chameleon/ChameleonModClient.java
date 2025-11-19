package net.acidicts.chameleon;

import net.acidicts.chameleon.entity.ModEntities;
import net.acidicts.chameleon.item.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.acidicts.chameleon.screen.ModScreenHandlers;
import net.acidicts.chameleon.screen.custom.IncubatorScreen;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.util.Identifier;

public class ChameleonModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.INCUBATOR_SCREEN_HANDLER, IncubatorScreen::new);

        ModEntities.doEntityRegistries();

        registerModelPredicates();
    }

    private void registerModelPredicates() {
        // Register predicate for ChameleonCapturer to change texture based on whether it has a chameleon
        ModelPredicateProviderRegistry.register(ModItems.CAPTURE_CHAMELEON,
                Identifier.of(ChameleonMod.MOD_ID, "filled"),
                (stack, world, entity, seed) -> {
                    if (!stack.contains(DataComponentTypes.CUSTOM_DATA)) {
                        return 0.0f;
                    }
                    NbtComponent nbtComponent = stack.getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT);
                    return nbtComponent.copyNbt().contains("Chameleon") ? 1.0f : 0.0f;
                });
    }
}
