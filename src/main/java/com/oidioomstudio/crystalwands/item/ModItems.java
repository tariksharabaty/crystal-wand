package com.oidioomstudio.crystalwands.item;

import com.oidioomstudio.crystalwands.CrystalWandsMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

import java.util.function.Function;

public class ModItems {
    public static final ResourceKey<Item> CRYSTAL_WAND_LV1_KEY = ResourceKey.create(
        Registries.ITEM,
        Identifier.fromNamespaceAndPath(CrystalWandsMod.MOD_ID, "crystal_wand_lv1")
    );
    public static final ResourceKey<Item> CRYSTAL_WAND_LV2_KEY = ResourceKey.create(
        Registries.ITEM,
        Identifier.fromNamespaceAndPath(CrystalWandsMod.MOD_ID, "crystal_wand_lv2")
    );
    public static final ResourceKey<Item> CRYSTAL_WAND_LV3_KEY = ResourceKey.create(
        Registries.ITEM,
        Identifier.fromNamespaceAndPath(CrystalWandsMod.MOD_ID, "crystal_wand_lv3")
    );

    public static final Item CRYSTAL_WAND_LV1 = registerItem(
        "crystal_wand_lv1",
        p -> new CrystalWandItem(p, 1),
        new Item.Properties()
            .setId(CRYSTAL_WAND_LV1_KEY)
            .stacksTo(1)
            .rarity(Rarity.UNCOMMON)
    );

    public static final Item CRYSTAL_WAND_LV2 = registerItem(
        "crystal_wand_lv2",
        p -> new CrystalWandItem(p, 2),
        new Item.Properties()
            .setId(CRYSTAL_WAND_LV2_KEY)
            .stacksTo(1)
            .rarity(Rarity.RARE)
    );

    public static final Item CRYSTAL_WAND_LV3 = registerItem(
        "crystal_wand_lv3",
        p -> new CrystalWandItem(p, 3),
        new Item.Properties()
            .setId(CRYSTAL_WAND_LV3_KEY)
            .stacksTo(1)
            .rarity(Rarity.EPIC)
    );

    private static Item registerItem(String name, Function<Item.Properties, Item> factory, Item.Properties properties) {
        ResourceKey<Item> key = ResourceKey.create(
            Registries.ITEM,
            Identifier.fromNamespaceAndPath(CrystalWandsMod.MOD_ID, name)
        );
        return Registry.register(BuiltInRegistries.ITEM, key, factory.apply(properties.setId(key)));
    }

    public static void registerModItems() {
        CrystalWandsMod.LOGGER.info("Registering items for {}", CrystalWandsMod.MOD_ID);
    }
}
