package net.acidicts.chameleon.block.entity;

import net.acidicts.chameleon.ChameleonMod;
import net.acidicts.chameleon.block.ModBlocks;
import net.acidicts.chameleon.block.entity.custom.IncubatorBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModBlockEntities {
    public static final BlockEntityType<IncubatorBlockEntity> INCUBATOR_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(ChameleonMod.MOD_ID, "incubator_be"),
                    BlockEntityType.Builder.create(IncubatorBlockEntity::new, ModBlocks.INCUBATOR).build(null));

    public static void registerBlockEntities() {
        ChameleonMod.LOGGER.info("Registering ModBlockEntities");
    }
}
