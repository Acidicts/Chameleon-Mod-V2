package net.acidicts.chameleon.item;

import net.acidicts.chameleon.ChameleonMod;
import net.acidicts.chameleon.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup CHAMELEON_MOD = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ChameleonMod.MOD_ID, "chameleon_mod"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.CHAMELEON))
                    .displayName(Text.translatable("itemgroup.chameleon_mod.chameleon_mod"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.CHAMELEON);
                        entries.add(ModItems.COOKED_CHAMELEON);

                        entries.add(ModItems.CHAMELEON_EGG);
                        entries.add(ModItems.CHAMELEON_SPAWN_EGG);

                        entries.add(ModItems.CAPTURE_CHAMELEON);

                        entries.add(ModItems.CHAMELEON_SCALE);
                        entries.add(ModItems.CHAMELEON_SCALE_HELMET);
                        entries.add(ModItems.CHAMELEON_SCALE_CHESTPLATE);
                        entries.add(ModItems.CHAMELEON_SCALE_LEGGINGS);
                        entries.add(ModItems.CHAMELEON_SCALE_BOOTS);

                        entries.add(ModItems.CHAMELEON_SCALE_SWORD);
                        entries.add(ModItems.CHAMELEON_SCALE_PICKAXE);
                        entries.add(ModItems.CHAMELEON_SCALE_AXE);
                        entries.add(ModItems.CHAMELEON_SCALE_SHOVEL);
                        entries.add(ModItems.CHAMELEON_SCALE_HOE);

                        entries.add(ModItems.STEEL_INGOT);
                        entries.add(ModItems.STEEL_DUST);
                        entries.add(ModBlocks.INCUBATOR);
                    })
                    .build());

    public static void registerItemGroups() {
        ChameleonMod.LOGGER.info("Registering Item Groups for {}", ChameleonMod.MOD_ID);
        ChameleonMod.LOGGER.info("Item Groups for {} registered", ChameleonMod.MOD_ID);
    }
}
