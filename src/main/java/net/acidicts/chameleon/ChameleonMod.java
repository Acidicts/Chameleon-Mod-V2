package net.acidicts.chameleon;

import net.acidicts.chameleon.block.ModBlocks;
import net.acidicts.chameleon.items.ModItemGroups;
import net.acidicts.chameleon.items.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChameleonMod implements ModInitializer {
	public static final String MOD_ID = "chameleon_mod";
    public static final String MOD_INFO = "Remake of my Chameleon Mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initialising " + MOD_ID + " !");
        LOGGER.info(MOD_INFO);

        ModItemGroups.registerItemGroups();
        ModItems.registerItems();
        ModBlocks.registerBlocks();

        LOGGER.info(MOD_ID + " Initialized!");
	}
}