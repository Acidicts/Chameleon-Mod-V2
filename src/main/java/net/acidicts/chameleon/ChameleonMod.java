package net.acidicts.chameleon;

import net.acidicts.chameleon.block.ModBlocks;
import net.acidicts.chameleon.block.entity.ModBlockEntities;
import net.acidicts.chameleon.entity.ModEntities;
import net.acidicts.chameleon.item.ModItemGroups;
import net.acidicts.chameleon.item.ModItems;
import net.acidicts.chameleon.recipe.ModRecipes;
import net.acidicts.chameleon.screen.ModScreenHandlers;
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

        ModBlockEntities.registerBlockEntities();
        ModScreenHandlers.registerScreenHandlers();

        ModEntities.registerEntities();

        ModRecipes.registerRecipes();

        LOGGER.info(MOD_ID + " Initialized!");

	}
}