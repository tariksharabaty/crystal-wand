package com.oidioomstudio.crystalwands.config;

import com.oidioomstudio.olib.config.OConfigHolder;

public final class CrystalWandsConfig {
    public static class Data {
        public int cooldownTier1 = 25; // 1.25s
        public int cooldownTier2 = 45; // 2.25s
        public int cooldownTier3 = 70; // 3.5s
        public boolean enableSoundEffects = true;
        public boolean enableParticleEffects = true;
        public double tier3Damage = 12.0;
        public double tier2Damage = 6.0;
    }

    private static final OConfigHolder<Data> HOLDER = new OConfigHolder<>(
            "crystal_wands",
            Data.class,
            Data::new
    );

    private static Data current = new Data();

    public static void load() {
        current = HOLDER.load();
    }

    public static void save() {
        HOLDER.save();
    }

    public static Data get() {
        if (current == null) {
            load();
        }
        return current;
    }
}

