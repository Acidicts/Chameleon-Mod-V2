package net.acidicts.chameleon.item.items;

import net.acidicts.chameleon.entity.ModEntities;
import net.acidicts.chameleon.entity.custom.ChameleonEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class ChameleonCapturer extends Item {

    private static final String ROOT = "Chameleon";
    private static final String NAME = "Name";
    private static final String VARIANT = "Variant";
    private static final String TYPE_VARIANT = "TypeVariant";
    private static final String AGE = "Age";
    private static final String HEALTH = "Health";

    public ChameleonCapturer(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (!(entity instanceof ChameleonEntity chameleon)) {
            return ActionResult.PASS;
        }
        if (user.getWorld().isClient) {
            return ActionResult.SUCCESS;
        }
        // Already holding a captured chameleon
        if (hasChameleon(stack)) {
            return ActionResult.FAIL;
        }

        NbtCompound root = new NbtCompound();
        if (chameleon.hasCustomName()) {
            root.putString(NAME, chameleon.getCustomName().getString());
        }
        root.putString(VARIANT, chameleon.getVariant().name());
        root.putInt(TYPE_VARIANT, chameleon.getTypeVariant());
        root.putInt(AGE, chameleon.getBreedingAge());
        root.putFloat(HEALTH, chameleon.getHealth());

        NbtCompound customData = new NbtCompound();
        customData.put(ROOT, root);
        stack.set(DataComponentTypes.CUSTOM_DATA, NbtComponent.of(customData));

        chameleon.discard();
        return ActionResult.SUCCESS;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (world.isClient) {
            return TypedActionResult.pass(stack);
        }
        if (hasChameleon(stack)) {
            // Perform raycast to find the block the player is looking at
            net.minecraft.util.hit.HitResult hitResult = user.raycast(5.0, 0.0f, false);

            if (hitResult.getType() != net.minecraft.util.hit.HitResult.Type.BLOCK) {
                return TypedActionResult.fail(stack);
            }

            net.minecraft.util.hit.BlockHitResult blockHitResult = (net.minecraft.util.hit.BlockHitResult) hitResult;
            net.minecraft.util.math.BlockPos blockPos = blockHitResult.getBlockPos();
            net.minecraft.util.math.Vec3d spawnPos = net.minecraft.util.math.Vec3d.ofBottomCenter(blockPos).add(0, 1, 0);

            ChameleonEntity chameleon = ModEntities.CHAMELEON.create(world);

            if (chameleon == null) {
                return TypedActionResult.fail(stack);
            }

            NbtComponent nbtComponent = stack.getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT);
            NbtCompound root = nbtComponent.copyNbt().getCompound(ROOT);

            if (root.contains(NAME)) {
                chameleon.setCustomName(Text.of(root.getString(NAME)));
                chameleon.setCustomNameVisible(true);
            }

            // Restore variant using NBT
            NbtCompound entityNbt = new NbtCompound();
            entityNbt.putInt("Variant", root.getInt(TYPE_VARIANT));
            chameleon.readCustomDataFromNbt(entityNbt);

            chameleon.setBreedingAge(root.getInt(AGE));
            chameleon.setHealth(root.getFloat(HEALTH));

            chameleon.refreshPositionAndAngles(spawnPos.x, spawnPos.y, spawnPos.z, user.getYaw(), 0.0f);
            world.spawnEntity(chameleon);

            // Clear stored data
            stack.remove(DataComponentTypes.CUSTOM_DATA);
            return TypedActionResult.success(stack);
        }
        return TypedActionResult.pass(stack);
    }

    private boolean hasChameleon(ItemStack stack) {
        if (!stack.contains(DataComponentTypes.CUSTOM_DATA)) {
            return false;
        }
        NbtComponent nbtComponent = stack.getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT);
        return nbtComponent.copyNbt().contains(ROOT);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, net.minecraft.item.tooltip.TooltipType type) {
        if (hasChameleon(stack)) {
            NbtComponent nbtComponent = stack.getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT);
            NbtCompound root = nbtComponent.copyNbt().getCompound(ROOT);

            tooltip.add(Text.literal("Captured Chameleon").formatted(net.minecraft.util.Formatting.GREEN));

            if (root.contains(NAME)) {
                tooltip.add(Text.literal("Name: ").formatted(net.minecraft.util.Formatting.GRAY)
                    .append(Text.literal(root.getString(NAME)).formatted(net.minecraft.util.Formatting.WHITE)));
            }

            tooltip.add(Text.literal("Variant: ").formatted(net.minecraft.util.Formatting.GRAY)
                .append(Text.literal(formatVariantName(root.getString(VARIANT))).formatted(net.minecraft.util.Formatting.AQUA)));

            int age = root.getInt(AGE);
            String ageText = age < 0 ? "Baby" : "Adult";
            tooltip.add(Text.literal("Age: ").formatted(net.minecraft.util.Formatting.GRAY)
                .append(Text.literal(ageText).formatted(net.minecraft.util.Formatting.YELLOW)));

            float health = root.getFloat(HEALTH);
            tooltip.add(Text.literal("Health: ").formatted(net.minecraft.util.Formatting.GRAY)
                .append(Text.literal(String.format("%.1f", health)).formatted(net.minecraft.util.Formatting.RED)));

            tooltip.add(Text.literal(""));
            tooltip.add(Text.literal("Right Click to release").formatted(net.minecraft.util.Formatting.DARK_GRAY, net.minecraft.util.Formatting.ITALIC));
        } else {
            tooltip.add(Text.literal("Empty").formatted(net.minecraft.util.Formatting.GRAY));
            tooltip.add(Text.literal("Right Click a Chameleon to capture").formatted(net.minecraft.util.Formatting.DARK_GRAY, net.minecraft.util.Formatting.ITALIC));
        }
    }

    private String formatVariantName(String variant) {
        if (variant == null || variant.isEmpty()) {
            return "Unknown";
        }
        // Convert BLUE_CHAMELEON to Blue Chameleon
        String[] parts = variant.toLowerCase().split("_");
        StringBuilder formatted = new StringBuilder();
        for (String part : parts) {
            if (formatted.length() > 0) {
                formatted.append(" ");
            }
            formatted.append(Character.toUpperCase(part.charAt(0))).append(part.substring(1));
        }
        return formatted.toString();
    }
}
