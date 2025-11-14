package net.acidicts.chameleon;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.acidicts.chameleon.screen.ModScreenHandlers;
import net.acidicts.chameleon.screen.custom.IncubatorScreen;

public class ChameleonModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.INCUBATOR_SCREEN_HANDLER, IncubatorScreen::new);
    }
}
