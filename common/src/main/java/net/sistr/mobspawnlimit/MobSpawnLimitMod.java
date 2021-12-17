package net.sistr.mobspawnlimit;

import net.sistr.mobspawnlimit.config.MSLConfig;

public class MobSpawnLimitMod {

    public static void init() {
        MSLConfig.ConfigSaveLoad.INSTANCE.load();
        MSLConfig.ConfigSaveLoad.INSTANCE.save();
    }

}
