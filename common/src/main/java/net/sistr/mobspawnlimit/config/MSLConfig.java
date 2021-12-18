package net.sistr.mobspawnlimit.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.shedaniel.architectury.platform.Platform;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MSLConfig {
    public static final SpawnGroupSetting MONSTER = new SpawnGroupSetting(70, false, false, 128, 32);
    public static final SpawnGroupSetting CREATURE = new SpawnGroupSetting(10, true, true, 128, 32);
    public static final SpawnGroupSetting AMBIENT = new SpawnGroupSetting(15, true, false, 128, 32);
    public static final SpawnGroupSetting WATER_CREATURE = new SpawnGroupSetting(5, true, false, 128, 32);
    public static final SpawnGroupSetting WATER_AMBIENT = new SpawnGroupSetting(20, true, false, 64, 32);
    public static final SpawnGroupSetting MISC = new SpawnGroupSetting(-1, true, true, 128, 32);

    public static class ConfigSaveLoad {
        public static ConfigSaveLoad INSTANCE = new ConfigSaveLoad();
        public final SpawnGroupSetting monster = MONSTER;
        public final SpawnGroupSetting creature = CREATURE;
        public final SpawnGroupSetting ambient = AMBIENT;
        public final SpawnGroupSetting waterCreature = WATER_CREATURE;
        public final SpawnGroupSetting waterAmbient = WATER_AMBIENT;
        public final SpawnGroupSetting misc = MISC;

        public void load() {
            Path path = Paths.get(Platform.getConfigFolder().toString(), "mobspawnlimit.json");
            //ファイル無かったら死ぬ
            if (Files.notExists(path)) {
                return;
            }

            try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                ConfigSaveLoad configSaveLoad = gson.fromJson(reader, ConfigSaveLoad.class);
                this.monster.copy(configSaveLoad.monster);
                this.creature.copy(configSaveLoad.creature);
                this.ambient.copy(configSaveLoad.ambient);
                this.waterCreature.copy(configSaveLoad.waterCreature);
                this.waterAmbient.copy(configSaveLoad.waterAmbient);
                this.misc.copy(configSaveLoad.misc);
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

        }

        public void save() {
            Path path = Paths.get(Platform.getConfigFolder().toString(), "mobspawnlimit.json");
            //ファイルなかったら作る
            if (Files.notExists(path)) {
                try {
                    Files.createFile(path);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }

            try (OutputStream os = Files.newOutputStream(path)) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String setting = gson.toJson(this);
                os.write(setting.getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }

    }

    public static class SpawnGroupSetting {
        public int capacity;
        public boolean peaceful;
        public boolean rare;
        public int immediateDespawnRange;
        public int despawnStartRange;

        public SpawnGroupSetting(int capacity, boolean peaceful, boolean rare, int immediateDespawnRange, int despawnStartRange) {
            this.capacity = capacity;
            this.peaceful = peaceful;
            this.rare = rare;
            this.immediateDespawnRange = immediateDespawnRange;
            this.despawnStartRange = despawnStartRange;
        }

        public void copy(SpawnGroupSetting setting) {
            this.capacity = setting.capacity;
            this.peaceful = setting.peaceful;
            this.rare = setting.rare;
            this.immediateDespawnRange = setting.immediateDespawnRange;
            this.despawnStartRange = setting.despawnStartRange;
        }
    }


}
