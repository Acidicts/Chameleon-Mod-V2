package net.acidicts.chameleon.items;

import net.acidicts.chameleon.ChameleonMod;
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
                        entries.add(ModItems.CHAMELEON_EGG);
                        entries.add(ModItems.STEEL_INGOT);
                        entries.add(ModItems.STEEL_DUST);
                    })
                    .build());

    public static void registerItemGroups() {
        ChameleonMod.LOGGER.info("Registering Item Groups for {}", ChameleonMod.MOD_ID);
        ChameleonMod.LOGGER.info("Item Groups for {} registered", ChameleonMod.MOD_ID);
    }
}
