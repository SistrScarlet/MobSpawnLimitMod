package net.sistr.mobspawnlimit.mixin;

import net.minecraft.entity.SpawnGroup;
import net.sistr.mobspawnlimit.config.MSLConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SpawnGroup.class)
public class MixinMobSpawnLimit {
    private MSLConfig.SpawnGroupSetting setting;

    @Inject(method = "getCapacity", at = @At("HEAD"), cancellable = true)
    public void onGetCapacity(CallbackInfoReturnable<Integer> cir) {
        settingCheck();
        cir.setReturnValue(setting.capacity);
    }

    @Inject(method = "isPeaceful", at = @At("HEAD"), cancellable = true)
    public void onIsPeaceful(CallbackInfoReturnable<Boolean> cir) {
        settingCheck();
        cir.setReturnValue(setting.peaceful);
    }

    @Inject(method = "isRare", at = @At("HEAD"), cancellable = true)
    public void onIsRare(CallbackInfoReturnable<Boolean> cir) {
        settingCheck();
        cir.setReturnValue(setting.rare);
    }

    @Inject(method = "getImmediateDespawnRange", at = @At("HEAD"), cancellable = true)
    public void onGetImmediateDespawnRange(CallbackInfoReturnable<Integer> cir) {
        settingCheck();
        cir.setReturnValue(setting.immediateDespawnRange);
    }

    @Inject(method = "getDespawnStartRange", at = @At("HEAD"), cancellable = true)
    public void onGetDespawnStartRange(CallbackInfoReturnable<Integer> cir) {
        settingCheck();
        cir.setReturnValue(setting.despawnStartRange);
    }

    private void settingCheck() {
        if (setting == null) {
            setting = getSetting();
        }
    }

    private MSLConfig.SpawnGroupSetting getSetting() {
        switch ((SpawnGroup) (Object) this) {
            case MONSTER:
                return MSLConfig.MONSTER;
            case CREATURE:
                return MSLConfig.CREATURE;
            case AMBIENT:
                return MSLConfig.AMBIENT;
            case WATER_CREATURE:
                return MSLConfig.WATER_CREATURE;
            case WATER_AMBIENT:
                return MSLConfig.WATER_AMBIENT;
            default:
                return MSLConfig.MISC;
        }
    }

}
