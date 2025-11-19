package net.acidicts.chameleon.mixin;

import net.acidicts.chameleon.item.ModItems;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ArmorFeatureRenderer.class)
public class ArmorFeatureRendererMixin {

    @Inject(method = "render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/entity/LivingEntity;FFFFFF)V", at = @At("HEAD"), cancellable = true)
    private void onRenderArmor(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, LivingEntity entity, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        if (entity instanceof PlayerEntity player) {
            if (hasFullChameleonArmor(player) && player.isSneaking()) {
                // Cancel armor rendering
                ci.cancel();
            }
        }
    }

    private boolean hasFullChameleonArmor(PlayerEntity player) {
        ItemStack helmet = player.getEquippedStack(EquipmentSlot.HEAD);
        ItemStack chestplate = player.getEquippedStack(EquipmentSlot.CHEST);
        ItemStack leggings = player.getEquippedStack(EquipmentSlot.LEGS);
        ItemStack boots = player.getEquippedStack(EquipmentSlot.FEET);

        return !helmet.isEmpty() && helmet.getItem() == ModItems.CHAMELEON_SCALE_HELMET &&
               !chestplate.isEmpty() && chestplate.getItem() == ModItems.CHAMELEON_SCALE_CHESTPLATE &&
               !leggings.isEmpty() && leggings.getItem() == ModItems.CHAMELEON_SCALE_LEGGINGS &&
               !boots.isEmpty() && boots.getItem() == ModItems.CHAMELEON_SCALE_BOOTS;
    }
}

