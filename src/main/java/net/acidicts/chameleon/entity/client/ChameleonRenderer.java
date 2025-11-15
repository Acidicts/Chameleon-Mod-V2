package net.acidicts.chameleon.entity.client;

import com.google.common.collect.Maps;
import net.acidicts.chameleon.ChameleonMod;
import net.acidicts.chameleon.entity.custom.ChameleonEntity;
import net.acidicts.chameleon.entity.custom.ChameleonVariant;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.HashMap;
import java.util.Map;

public class ChameleonRenderer extends MobEntityRenderer<ChameleonEntity, ChameleonModel<ChameleonEntity>> {
    private static final Map<ChameleonVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(ChameleonVariant.class), map -> {
                map.put(ChameleonVariant.DEFAULT,
                        Identifier.of(ChameleonMod.MOD_ID, "textures/entity/chameleon/chameleon0.png"));
                map.put(ChameleonVariant.ORCHID,
                        Identifier.of(ChameleonMod.MOD_ID, "textures/entity/chameleon/chameleon1.png"));
                map.put(ChameleonVariant.WATER,
                        Identifier.of(ChameleonMod.MOD_ID, "textures/entity/chameleon/chameleon2.png"));
            });

    public ChameleonRenderer(EntityRendererFactory.Context context) {
        super(context, new ChameleonModel<>(context.getPart(ChameleonModel.CHAMELEON)), 0.4f);
    }

    @Override
    public Identifier getTexture(ChameleonEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public void render(ChameleonEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if (livingEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
