package net.acidicts.chameleon.entity.client;

import net.acidicts.chameleon.ChameleonMod;
import net.acidicts.chameleon.entity.custom.ChameleonEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class ChameleonRenderer extends MobEntityRenderer<ChameleonEntity, ChameleonModel<ChameleonEntity>> {
    public ChameleonRenderer(EntityRendererFactory.Context context) {
        super(context, new ChameleonModel<>(context.getPart(ChameleonModel.CHAMELEON)), 0.4f);
    }

    @Override
    public Identifier getTexture(ChameleonEntity entity) {
        return Identifier.of(ChameleonMod.MOD_ID, "textures/entity/chameleon/chameleon.png");
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
