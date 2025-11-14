package net.acidicts.chameleon.entity;

import net.acidicts.chameleon.ChameleonMod;
import net.acidicts.chameleon.entity.client.ChameleonModel;
import net.acidicts.chameleon.entity.client.ChameleonRenderer;
import net.acidicts.chameleon.entity.custom.ChameleonEntity;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<ChameleonEntity> CHAMELEON = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(ChameleonMod.MOD_ID, "chameleon"),
            EntityType.Builder.create(ChameleonEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.4f, 0.3f).build());

    public static void registerEntities() {
        ChameleonMod.LOGGER.info("Registering Mod Entities for {}!", ChameleonMod.MOD_ID);

        FabricDefaultAttributeRegistry.register(ModEntities.CHAMELEON, ChameleonEntity.createAttributes());
    }

    public static void doEntityRegistries() {
        EntityModelLayerRegistry.registerModelLayer(ChameleonModel.CHAMELEON, ChameleonModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.CHAMELEON, ChameleonRenderer::new);
    }
}
