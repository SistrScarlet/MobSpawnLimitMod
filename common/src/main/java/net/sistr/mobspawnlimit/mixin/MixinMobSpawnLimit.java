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
        return switch ((SpawnGroup) (Object) this) {
            case MONSTER -> MSLConfig.MONSTER;
            case CREATURE -> MSLConfig.CREATURE;
            case AMBIENT -> MSLConfig.AMBIENT;
            case AXOLOTLS -> MSLConfig.AXOLOTLS;
            case UNDERGROUND_WATER_CREATURE -> MSLConfig.UNDERGROUND_WATER_CREATURE;
            case WATER_CREATURE -> MSLConfig.WATER_CREATURE;
            case WATER_AMBIENT -> MSLConfig.WATER_AMBIENT;
            case MISC -> MSLConfig.MISC;
        };
    }

}
