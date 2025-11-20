package net.acidicts.chameleon.datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.acidicts.chameleon.ChameleonMod;
import net.acidicts.chameleon.block.ModBlocks;
import net.acidicts.chameleon.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

import java.util.Optional;


public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.INCUBATOR);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.CHAMELEON, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_CHAMELEON, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHAMELEON_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEEL_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEEL_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHAMELEON_SCALE, Models.GENERATED);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CHAMELEON_SCALE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CHAMELEON_SCALE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CHAMELEON_SCALE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CHAMELEON_SCALE_BOOTS));

        itemModelGenerator.register(ModItems.CHAMELEON_SCALE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CHAMELEON_SCALE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CHAMELEON_SCALE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CHAMELEON_SCALE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CHAMELEON_SCALE_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.CHAMELEON_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));

        // Generate chameleon capturer models with overrides
        generateChameleonCapturerModels(itemModelGenerator);
    }

    private void generateChameleonCapturerModels(ItemModelGenerator itemModelGenerator) {
        // Generate the filled model (simple generated model)
        Identifier filledModelId = Identifier.of(ChameleonMod.MOD_ID, "item/chameleon_capturer_filled");
        Models.GENERATED.upload(
            filledModelId,
            TextureMap.layer0(Identifier.of(ChameleonMod.MOD_ID, "item/chameleon_capture_full")),
            itemModelGenerator.writer
        );

        // Generate the main model with overrides
        Identifier mainModelId = ModelIds.getItemModelId(ModItems.CAPTURE_CHAMELEON);

        // Create custom JSON with overrides
        itemModelGenerator.writer.accept(mainModelId, () -> {
            JsonObject json = new JsonObject();
            json.addProperty("parent", "item/generated");

            // Add textures
            JsonObject textures = new JsonObject();
            textures.addProperty("layer0", "chameleon_mod:item/chameleon_capture_empty");
            json.add("textures", textures);

            // Add overrides
            JsonArray overrides = new JsonArray();
            JsonObject override = new JsonObject();

            JsonObject predicate = new JsonObject();
            predicate.addProperty("chameleon_mod:filled", 1.0);
            override.add("predicate", predicate);
            override.addProperty("model", "chameleon_mod:item/chameleon_capturer_filled");

            overrides.add(override);
            json.add("overrides", overrides);

            return json;
        });
    }
}
