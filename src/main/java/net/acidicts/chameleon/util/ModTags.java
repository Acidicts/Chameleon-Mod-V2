package net.acidicts.chameleon.util;

import net.acidicts.chameleon.ChameleonMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_CHAMELEON_SCALE_TOOL = createTag("needs_chameleon_scale_tool");
        public static final TagKey<Block> INCORRECT_FOR_CHAMELEON_SCALE_TOOL = createTag("incorrect_for_chameleon_scale_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(ChameleonMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> CHAMELEON_MOD = createTag("chameleon_mod");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(ChameleonMod.MOD_ID, name));
        }
    }
}
