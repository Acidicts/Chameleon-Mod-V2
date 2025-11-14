package net.acidicts.chameleon.entity.client;

import net.acidicts.chameleon.ChameleonMod;
import net.acidicts.chameleon.entity.custom.ChameleonEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;


public class ChameleonModel<T extends ChameleonEntity> extends SinglePartEntityModel<T> {
    public static final EntityModelLayer CHAMELEON = new EntityModelLayer(Identifier.of(ChameleonMod.MOD_ID, "chameleon"), "main");

    private final ModelPart chameleon;
    private final ModelPart head;

    public ChameleonModel(ModelPart root) {
        this.chameleon = root.getChild("chameleon");
        this.head = this.chameleon.getChild("head");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData chameleon = modelPartData.addChild("chameleon", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, 22.0F, -2.0F));

        ModelPartData body = chameleon.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -3.0F, -1.0F, 4.0F, 3.0F, 9.0F, new Dilation(0.0F))
                .uv(0, 12).cuboid(-2.0F, -4.0F, 0.0F, 2.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData tail = chameleon.addChild("tail", ModelPartBuilder.create().uv(18, 18).cuboid(-2.0F, -3.0F, -5.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 23).cuboid(-1.5F, -2.0F, -3.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(26, 7).cuboid(-1.5F, -1.0F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 13.0F));

        ModelPartData head = chameleon.addChild("head", ModelPartBuilder.create().uv(8, 21).cuboid(-1.0F, 0.0F, -2.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(18, 12).cuboid(-1.0F, -3.0F, -3.0F, 2.0F, 3.0F, 3.0F, new Dilation(0.0F))
                .uv(0, 21).cuboid(-1.0F, -4.0F, -2.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(26, 4).cuboid(-1.0F, -2.0F, -4.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, -1.0F, -1.0F));

        ModelPartData legs = chameleon.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, 1.0F, 1.0F));

        ModelPartData front_left_leg = legs.addChild("front_left_leg", ModelPartBuilder.create().uv(26, 18).cuboid(0.0F, 0.0F, -2.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(22, 23).cuboid(-0.5F, -3.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(12, 24).cuboid(0.0F, -2.0F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData back_left_leg = legs.addChild("back_left_leg", ModelPartBuilder.create().uv(12, 27).cuboid(0.0F, 1.0F, -1.5F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 28).cuboid(0.0F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 24).cuboid(-0.5F, -2.0F, -1.5F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.0F, 6.0F));

        ModelPartData front_right_leg = legs.addChild("front_right_leg", ModelPartBuilder.create().uv(24, 27).cuboid(0.0F, 0.0F, -2.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(8, 28).cuboid(0.0F, -2.0F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(26, 0).cuboid(0.5F, -3.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, 0.0F, 0.0F));

        ModelPartData back_right_leg = legs.addChild("back_right_leg", ModelPartBuilder.create().uv(18, 27).cuboid(-1.0F, 1.0F, -1.5F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(4, 28).cuboid(-1.0F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(6, 24).cuboid(-0.5F, -2.0F, -1.5F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -1.0F, 6.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }
    @Override
    public void setAngles(ChameleonEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(ChameleonAnimations.ANIM_CHAMELEON_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, ChameleonAnimations.ANIM_CHAMELEON_IDLE, ageInTicks, 1f);
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        chameleon.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return chameleon;
    }
}