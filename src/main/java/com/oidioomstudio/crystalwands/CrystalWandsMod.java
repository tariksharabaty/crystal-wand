package com.oidioomstudio.crystalwands;

import com.oidioomstudio.crystalwands.config.CrystalWandsConfig;
import com.oidioomstudio.crystalwands.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrystalWandsMod implements ModInitializer {
    public static final String MOD_ID = "crystal_wands";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final ResourceKey<CreativeModeTab> CRYSTAL_WANDS_TAB_KEY = ResourceKey.create(
        Registries.CREATIVE_MODE_TAB,
        Identifier.fromNamespaceAndPath(MOD_ID, "crystal_wands_tab")
    );

    public static final CreativeModeTab CRYSTAL_WANDS_TAB = FabricCreativeModeTab.builder()
        .icon(() -> new ItemStack(ModItems.CRYSTAL_WAND_LV3))
        .title(Component.translatable("itemGroup.crystal_wands"))
        .displayItems((itemDisplayParameters, output) -> {
            output.accept(ModItems.CRYSTAL_WAND_LV1);
            output.accept(ModItems.CRYSTAL_WAND_LV2);
            output.accept(ModItems.CRYSTAL_WAND_LV3);
        })
        .build();

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Crystal Wands mod by Oidioom (Developer: Tarek Sharabaty)...");
        CrystalWandsConfig.load();

        // Register items
        ModItems.registerModItems();
        com.oidioomstudio.olib.api.OCreativeTabs.accept(ModItems.CRYSTAL_WAND_LV1);
        com.oidioomstudio.olib.api.OCreativeTabs.accept(ModItems.CRYSTAL_WAND_LV2);
        com.oidioomstudio.olib.api.OCreativeTabs.accept(ModItems.CRYSTAL_WAND_LV3);

        // Register dedicated creative mode tab
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CRYSTAL_WANDS_TAB_KEY, CRYSTAL_WANDS_TAB);

        // Also add to vanilla TOOLS_AND_UTILITIES creative tab
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(output -> {
            output.accept(ModItems.CRYSTAL_WAND_LV1);
            output.accept(ModItems.CRYSTAL_WAND_LV2);
            output.accept(ModItems.CRYSTAL_WAND_LV3);
        });

        LOGGER.info("Crystal Wands mod initialized successfully!");
    }
}
