package com.oidioomstudio.crystalwands.client;

import com.oidioomstudio.crystalwands.CrystalWandsMod;
import com.oidioomstudio.olib.client.OModMenuApi;

public class ModMenuIntegration extends OModMenuApi {
    @Override
    protected String getModId() {
        return CrystalWandsMod.MOD_ID;
    }
}

