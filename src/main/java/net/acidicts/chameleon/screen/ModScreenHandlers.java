package net.acidicts.chameleon.screen;

import net.acidicts.chameleon.ChameleonMod;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.acidicts.chameleon.screen.custom.IncubatorScreenHandler;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {
    public static final ScreenHandlerType<IncubatorScreenHandler> INCUBATOR_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(ChameleonMod.MOD_ID, "incubator_screen_handler"),
                    new ExtendedScreenHandlerType<>(IncubatorScreenHandler::new, BlockPos.PACKET_CODEC));


    public static void registerScreenHandlers() {
        ChameleonMod.LOGGER.info("Registering Screen Handlers for " + ChameleonMod.MOD_ID);
    }
}