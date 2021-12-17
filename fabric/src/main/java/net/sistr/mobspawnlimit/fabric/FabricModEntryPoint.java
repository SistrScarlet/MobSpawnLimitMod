package net.sistr.mobspawnlimit.fabric;

import net.fabricmc.api.ModInitializer;
import net.sistr.mobspawnlimit.MobSpawnLimitMod;

public class FabricModEntryPoint implements ModInitializer {
    @Override
    public void onInitialize() {
        MobSpawnLimitMod.init();
    }
}
