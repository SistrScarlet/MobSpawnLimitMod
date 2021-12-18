package net.sistr.mobspawnlimit.fabric;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import me.shedaniel.clothconfig2.impl.builders.SubCategoryBuilder;
import net.minecraft.text.TranslatableText;
import net.sistr.mobspawnlimit.config.MSLConfig;

public class ModMenuIntegration implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> {
            MSLConfig.ConfigSaveLoad.INSTANCE.load();
            ConfigBuilder builder = ConfigBuilder.create()
                    .setParentScreen(parent)
                    .setTitle(new TranslatableText("title.mobspawnlimit.config"));
            builder.setSavingRunnable(() -> {
                MSLConfig.ConfigSaveLoad.INSTANCE.save();
            });
            ConfigCategory general = builder.getOrCreateCategory(new TranslatableText("category.mobspawnlimit.general"));
            ConfigEntryBuilder entryBuilder = builder.entryBuilder();

            SubCategoryBuilder monster = entryBuilder.startSubCategory(new TranslatableText("option.mobspawnlimit.subcategory_monster"));
            monster.add(entryBuilder.startIntField(new TranslatableText("option.mobspawnlimit.capacity"), MSLConfig.MONSTER.capacity)
                    .setDefaultValue(70)
                    .setTooltip(new TranslatableText("option.mobspawnlimit.capacity_tooltip"))
                    .setSaveConsumer(newValue -> MSLConfig.MONSTER.capacity = newValue)
                    .build());
            monster.add(entryBuilder.startBooleanToggle(new TranslatableText("option.mobspawnlimit.peaceful"), MSLConfig.MONSTER.peaceful)
                    .setDefaultValue(false)
                    .setTooltip(new TranslatableText("option.mobspawnlimit.peaceful_tooltip"))
                    .setSaveConsumer(newValue -> MSLConfig.MONSTER.peaceful = newValue)
                    .build());
            monster.add(entryBuilder.startBooleanToggle(new TranslatableText("option.mobspawnlimit.rare"), MSLConfig.MONSTER.rare)
                    .setDefaultValue(false)
                    .setTooltip(new TranslatableText("option.mobspawnlimit.rare_tooltip"))
                    .setSaveConsumer(newValue -> MSLConfig.MONSTER.rare = newValue)
                    .build());
            monster.add(entryBuilder.startIntField(new TranslatableText("option.mobspawnlimit.immediate_despawn_range"), MSLConfig.MONSTER.immediateDespawnRange)
                    .setDefaultValue(128)
                    .setTooltip(new TranslatableText("option.mobspawnlimit.immediate_despawn_range_tooltip"))
                    .setSaveConsumer(newValue -> MSLConfig.MONSTER.immediateDespawnRange = newValue)
                    .build());
            monster.add(entryBuilder.startIntField(new TranslatableText("option.mobspawnlimit.despawn_start_range"), MSLConfig.MONSTER.despawnStartRange)
                    .setDefaultValue(32)
                    .setTooltip(new TranslatableText("option.mobspawnlimit.despawn_start_range_tooltip"))
                    .setSaveConsumer(newValue -> MSLConfig.MONSTER.despawnStartRange = newValue)
                    .build());
            general.addEntry(monster.build());

            SubCategoryBuilder creature = entryBuilder.startSubCategory(new TranslatableText("option.mobspawnlimit.subcategory_creature"));
            creature.add(entryBuilder.startIntField(new TranslatableText("option.mobspawnlimit.capacity"), MSLConfig.CREATURE.capacity)
                    .setDefaultValue(10)
                    .setTooltip(new TranslatableText("option.mobspawnlimit.capacity_tooltip"))
                    .setSaveConsumer(newValue -> MSLConfig.CREATURE.capacity = newValue)
                    .build());
            creature.add(entryBuilder.startBooleanToggle(new TranslatableText("option.mobspawnlimit.peaceful"), MSLConfig.CREATURE.peaceful)
                    .setDefaultValue(true)
                    .setTooltip(new TranslatableText("option.mobspawnlimit.peaceful_tooltip"))
                    .setSaveConsumer(newValue -> MSLConfig.CREATURE.peaceful = newValue)
                    .build());
            creature.add(entryBuilder.startBooleanToggle(new TranslatableText("option.mobspawnlimit.rare"), MSLConfig.CREATURE.rare)
                    .setDefaultValue(true)
                    .setTooltip(new TranslatableText("option.mobspawnlimit.rare_tooltip"))
                    .setSaveConsumer(newValue -> MSLConfig.CREATURE.rare = newValue)
                    .build());
            creature.add(entryBuilder.startIntField(new TranslatableText("option.mobspawnlimit.immediate_despawn_range"), MSLConfig.CREATURE.immediateDespawnRange)
                    .setDefaultValue(128)
                    .setTooltip(new TranslatableText("option.mobspawnlimit.immediate_despawn_range_tooltip"))
                    .setSaveConsumer(newValue -> MSLConfig.CREATURE.immediateDespawnRange = newValue)
                    .build());
            creature.add(entryBuilder.startIntField(new TranslatableText("option.mobspawnlimit.despawn_start_range"), MSLConfig.CREATURE.despawnStartRange)
                    .setDefaultValue(32)
                    .setTooltip(new TranslatableText("option.mobspawnlimit.despawn_start_range_tooltip"))
                    .setSaveConsumer(newValue -> MSLConfig.CREATURE.despawnStartRange = newValue)
                    .build());
            general.addEntry(creature.build());

            SubCategoryBuilder ambient = entryBuilder.startSubCategory(new TranslatableText("option.mobspawnlimit.subcategory_ambient"));
            ambient.add(entryBuilder.startIntField(new TranslatableText("option.mobspawnlimit.capacity"), MSLConfig.AMBIENT.capacity)
                    .setDefaultValue(15)
                    .setTooltip(new TranslatableText("option.mobspawnlimit.capacity_tooltip"))
                    .setSaveConsumer(newValue -> MSLConfig.AMBIENT.capacity = newValue)
                    .build());
            ambient.add(entryBuilder.startBooleanToggle(new TranslatableText("option.mobspawnlimit.peaceful"), MSLConfig.AMBIENT.peaceful)
                    .setDefaultValue(true)
                    .setTooltip(new TranslatableText("option.mobspawnlimit.peaceful_tooltip"))
                    .setSaveConsumer(newValue -> MSLConfig.AMBIENT.peaceful = newValue)
                    .build());
            ambient.add(entryBuilder.startBooleanToggle(new TranslatableText("option.mobspawnlimit.rare"), MSLConfig.AMBIENT.rare)
                    .setDefaultValue(false)
                    .setTooltip(new TranslatableText("option.mobspawnlimit.rare_tooltip"))
                    .setSaveConsumer(newValue -> MSLConfig.AMBIENT.rare = newValue)
                    .build());
            ambient.add(entryBuilder.startIntField(new TranslatableText("option.mobspawnlimit.immediate_despawn_range"), MSLConfig.AMBIENT.immediateDespawnRange)
                    .setDefaultValue(128)
                    .setTooltip(new TranslatableText("option.mobspawnlimit.immediate_despawn_range_tooltip"))
                    .setSaveConsumer(newValue -> MSLConfig.AMBIENT.immediateDespawnRange = newValue)
                    .build());
            ambient.add(entryBuilder.startIntField(new TranslatableText("option.mobspawnlimit.despawn_start_range"), MSLConfig.AMBIENT.despawnStartRange)
                    .setDefaultValue(32)
                    .setTooltip(new TranslatableText("option.mobspawnlimit.despawn_start_range_tooltip"))
                    .setSaveConsumer(newValue -> MSLConfig.AMBIENT.despawnStartRange = newValue)
                    .build());
            general.addEntry(ambient.build());

            SubCategoryBuilder waterCreature = entryBuilder.startSubCategory(new TranslatableText("option.mobspawnlimit.subcategory_water_creature"));
            waterCreature.add(entryBuilder.startIntField(new TranslatableText("option.mobspawnlimit.capacity"), MSLConfig.WATER_CREATURE.capacity)
                    .setDefaultValue(5)
                    .setTooltip(new TranslatableText("option.mobspawnlimit.capacity_tooltip"))
                    .setSaveConsumer(newValue -> MSLConfig.WATER_CREATURE.capacity = newValue)
                    .build());
            waterCreature.add(entryBuilder.startBooleanToggle(new TranslatableText("option.mobspawnlimit.peaceful"), MSLConfig.WATER_CREATURE.peaceful)
                    .setDefaultValue(true)
                    .setTooltip(new TranslatableText("option.mobspawnlimit.peaceful_tooltip"))
                    .setSaveConsumer(newValue -> MSLConfig.WATER_CREATURE.peaceful = newValue)
                    .build());
            waterCreature.add(entryBuilder.startBooleanToggle(new TranslatableText("option.mobspawnlimit.rare"), MSLConfig.WATER_CREATURE.rare)
                    .setDefaultValue(false)
                    .setTooltip(new TranslatableText("option.mobspawnlimit.rare_tooltip"))
                    .setSaveConsumer(newValue -> MSLConfig.WATER_CREATURE.rare = newValue)
                    .build());
            waterCreature.add(entryBuilder.startIntField(new TranslatableText("option.mobspawnlimit.immediate_despawn_range"), MSLConfig.WATER_CREATURE.immediateDespawnRange)
                    .setDefaultValue(128)
                    .setTooltip(new TranslatableText("option.mobspawnlimit.immediate_despawn_range_tooltip"))
                    .setSaveConsumer(newValue -> MSLConfig.WATER_CREATURE.immediateDespawnRange = newValue)
                    .build());
            waterCreature.add(entryBuilder.startIntField(new TranslatableText("option.mobspawnlimit.despawn_start_range"), MSLConfig.WATER_CREATURE.despawnStartRange)
                    .setDefaultValue(32)
                    .setTooltip(new TranslatableText("option.mobspawnlimit.despawn_start_range_tooltip"))
                    .setSaveConsumer(newValue -> MSLConfig.WATER_CREATURE.despawnStartRange = newValue)
                    .build());
            general.addEntry(waterCreature.build());

            SubCategoryBuilder waterAmbient = entryBuilder.startSubCategory(new TranslatableText("option.mobspawnlimit.subcategory_water_ambient"));
            waterAmbient.add(entryBuilder.startIntField(new TranslatableText("option.mobspawnlimit.capacity"), MSLConfig.WATER_AMBIENT.capacity)
                    .setDefaultValue(20)
                    .setTooltip(new TranslatableText("option.mobspawnlimit.capacity_tooltip"))
                    .setSaveConsumer(newValue -> MSLConfig.WATER_AMBIENT.capacity = newValue)
                    .build());
            waterAmbient.add(entryBuilder.startBooleanToggle(new TranslatableText("option.mobspawnlimit.peaceful"), MSLConfig.WATER_AMBIENT.peaceful)
                    .setDefaultValue(true)
                    .setTooltip(new TranslatableText("option.mobspawnlimit.peaceful_tooltip"))
                    .setSaveConsumer(newValue -> MSLConfig.WATER_AMBIENT.peaceful = newValue)
                    .build());
            waterAmbient.add(entryBuilder.startBooleanToggle(new TranslatableText("option.mobspawnlimit.rare"), MSLConfig.WATER_AMBIENT.rare)
                    .setDefaultValue(false)
                    .setTooltip(new TranslatableText("option.mobspawnlimit.rare_tooltip"))
                    .setSaveConsumer(newValue -> MSLConfig.WATER_AMBIENT.rare = newValue)
                    .build());
            waterAmbient.add(entryBuilder.startIntField(new TranslatableText("option.mobspawnlimit.immediate_despawn_range"), MSLConfig.WATER_AMBIENT.immediateDespawnRange)
                    .setDefaultValue(128)
                    .setTooltip(new TranslatableText("option.mobspawnlimit.immediate_despawn_range_tooltip"))
                    .setSaveConsumer(newValue -> MSLConfig.WATER_AMBIENT.immediateDespawnRange = newValue)
                    .build());
            waterAmbient.add(entryBuilder.startIntField(new TranslatableText("option.mobspawnlimit.despawn_start_range"), MSLConfig.WATER_AMBIENT.despawnStartRange)
                    .setDefaultValue(32)
                    .setTooltip(new TranslatableText("option.mobspawnlimit.despawn_start_range_tooltip"))
                    .setSaveConsumer(newValue -> MSLConfig.WATER_AMBIENT.despawnStartRange = newValue)
                    .build());
            general.addEntry(waterAmbient.build());

            SubCategoryBuilder misc = entryBuilder.startSubCategory(new TranslatableText("option.mobspawnlimit.subcategory_misc"));
            misc.add(entryBuilder.startIntField(new TranslatableText("option.mobspawnlimit.capacity"), MSLConfig.MISC.capacity)
                    .setDefaultValue(-1)
                    .setTooltip(new TranslatableText("option.mobspawnlimit.capacity_tooltip"))
                    .setSaveConsumer(newValue -> MSLConfig.MISC.capacity = newValue)
                    .build());
            misc.add(entryBuilder.startBooleanToggle(new TranslatableText("option.mobspawnlimit.peaceful"), MSLConfig.MISC.peaceful)
                    .setDefaultValue(true)
                    .setTooltip(new TranslatableText("option.mobspawnlimit.peaceful_tooltip"))
                    .setSaveConsumer(newValue -> MSLConfig.MISC.peaceful = newValue)
                    .build());
            misc.add(entryBuilder.startBooleanToggle(new TranslatableText("option.mobspawnlimit.rare"), MSLConfig.MISC.rare)
                    .setDefaultValue(true)
                    .setTooltip(new TranslatableText("option.mobspawnlimit.rare_tooltip"))
                    .setSaveConsumer(newValue -> MSLConfig.MISC.rare = newValue)
                    .build());
            misc.add(entryBuilder.startIntField(new TranslatableText("option.mobspawnlimit.immediate_despawn_range"), MSLConfig.MISC.immediateDespawnRange)
                    .setDefaultValue(128)
                    .setTooltip(new TranslatableText("option.mobspawnlimit.immediate_despawn_range_tooltip"))
                    .setSaveConsumer(newValue -> MSLConfig.MISC.immediateDespawnRange = newValue)
                    .build());
            misc.add(entryBuilder.startIntField(new TranslatableText("option.mobspawnlimit.despawn_start_range"), MSLConfig.MISC.despawnStartRange)
                    .setDefaultValue(32)
                    .setTooltip(new TranslatableText("option.mobspawnlimit.despawn_start_range_tooltip"))
                    .setSaveConsumer(newValue -> MSLConfig.MISC.despawnStartRange = newValue)
                    .build());
            general.addEntry(misc.build());

            return builder.build();
        };
    }

}
