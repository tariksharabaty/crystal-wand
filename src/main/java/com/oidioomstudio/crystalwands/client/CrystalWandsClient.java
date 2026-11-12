package com.oidioomstudio.crystalwands.client;

import com.oidioomstudio.crystalwands.CrystalWandsMod;
import com.oidioomstudio.crystalwands.config.CrystalWandsConfig;
import com.oidioomstudio.olib.api.OConfigCategory;
import com.oidioomstudio.olib.api.OConfigRegistry;
import com.oidioomstudio.olib.api.OModConfig;
import com.oidioomstudio.olib.api.options.BooleanOption;
import com.oidioomstudio.olib.api.options.FloatSliderOption;
import com.oidioomstudio.olib.api.options.IntegerSliderOption;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.network.chat.Component;

public class CrystalWandsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        registerConfig();
    }

    private static void registerConfig() {
        CrystalWandsConfig.Data cfg = CrystalWandsConfig.get();

        OConfigRegistry.register(
                OModConfig.builder(CrystalWandsMod.MOD_ID, Component.translatable("itemGroup.crystal_wands"), "1.1.2")
                        .category(OConfigCategory.builder("general", Component.translatable("crystal_wands.config.general"))
                                .group("cooldowns", Component.translatable("crystal_wands.config.cooldowns"), g -> g
                                        .add(IntegerSliderOption.builder("cd_tier1", Component.translatable("crystal_wands.config.cd_tier1"))
                                                .range(5, 100, 5)
                                                .defaultValue(cfg.cooldownTier1)
                                                .getter(() -> cfg.cooldownTier1)
                                                .setter(v -> cfg.cooldownTier1 = v)
                                                .build())
                                        .add(IntegerSliderOption.builder("cd_tier2", Component.translatable("crystal_wands.config.cd_tier2"))
                                                .range(10, 200, 5)
                                                .defaultValue(cfg.cooldownTier2)
                                                .getter(() -> cfg.cooldownTier2)
                                                .setter(v -> cfg.cooldownTier2 = v)
                                                .build())
                                        .add(IntegerSliderOption.builder("cd_tier3", Component.translatable("crystal_wands.config.cd_tier3"))
                                                .range(20, 300, 10)
                                                .defaultValue(cfg.cooldownTier3)
                                                .getter(() -> cfg.cooldownTier3)
                                                .setter(v -> cfg.cooldownTier3 = v)
                                                .build())
                                )
                                .group("features", Component.translatable("crystal_wands.config.features"), g -> g
                                        .add(BooleanOption.builder("enable_sounds", Component.translatable("crystal_wands.config.enable_sounds"))
                                                .defaultValue(cfg.enableSoundEffects)
                                                .getter(() -> cfg.enableSoundEffects)
                                                .setter(v -> cfg.enableSoundEffects = v)
                                                .build())
                                        .add(BooleanOption.builder("enable_particles", Component.translatable("crystal_wands.config.enable_particles"))
                                                .defaultValue(cfg.enableParticleEffects)
                                                .getter(() -> cfg.enableParticleEffects)
                                                .setter(v -> cfg.enableParticleEffects = v)
                                                .build())
                                        .add(FloatSliderOption.builder("tier3_damage", Component.translatable("crystal_wands.config.tier3_damage"))
                                                .range(2.0f, 40.0f, 1.0f)
                                                .defaultValue((float) cfg.tier3Damage)
                                                .getter(() -> (float) cfg.tier3Damage)
                                                .setter(v -> cfg.tier3Damage = v)
                                                .build())
                                )
                                .build())
                        .onSave(CrystalWandsConfig::save)
                        .build()
        );
    }
}
