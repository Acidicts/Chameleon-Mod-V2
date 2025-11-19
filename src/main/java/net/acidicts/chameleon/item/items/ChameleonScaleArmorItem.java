package net.acidicts.chameleon.item.items;

import net.acidicts.chameleon.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.world.World;

public class ChameleonScaleArmorItem extends ArmorItem {
    public ChameleonScaleArmorItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient() && entity instanceof PlayerEntity player) {
            if (hasFullChameleonArmor(player) && player.isSneaking()) {
                // Apply invisibility effect
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 20, 0, false, false, false));
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private boolean hasFullChameleonArmor(PlayerEntity player) {
        ItemStack helmet = player.getInventory().getArmorStack(3);
        ItemStack chestplate = player.getInventory().getArmorStack(2);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack boots = player.getInventory().getArmorStack(0);

        return !helmet.isEmpty() && helmet.getItem() == ModItems.CHAMELEON_SCALE_HELMET &&
               !chestplate.isEmpty() && chestplate.getItem() == ModItems.CHAMELEON_SCALE_CHESTPLATE &&
               !leggings.isEmpty() && leggings.getItem() == ModItems.CHAMELEON_SCALE_LEGGINGS &&
               !boots.isEmpty() && boots.getItem() == ModItems.CHAMELEON_SCALE_BOOTS;
    }
}

