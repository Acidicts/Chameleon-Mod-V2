package net.acidicts.chameleon;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChameleonMod implements ModInitializer {
	public static final String MOD_ID = "Chameleon Mod / Chameleon Mod Attempt 2";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initialising " + MOD_ID + " !");



        LOGGER.info(MOD_ID + " Initialized!");
	}
}