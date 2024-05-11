package de.cech12.woodenbucket.platform;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import de.cech12.woodenbucket.Constants;
import de.cech12.woodenbucket.platform.services.IConfigHelper;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.loading.FMLConfig;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

/**
 * The config service implementation for Forge.
 */
public class ForgeConfigHelper implements IConfigHelper {

    private static final ForgeConfigSpec SERVER_CONFIG;

    private static final ForgeConfigSpec.IntValue BREAK_TEMPERATURE;
    private static final ForgeConfigSpec.IntValue BURNING_TEMPERATURE;
    private static final ForgeConfigSpec.IntValue DURABILITY;
    private static final ForgeConfigSpec.BooleanValue FISH_OBTAINING_ENABLED;
    private static final ForgeConfigSpec.IntValue FREEZING_TEMPERATURE;
    private static final ForgeConfigSpec.BooleanValue MILKING_ENABLED;

    static {
        final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.push("Balance Options");

        BREAK_TEMPERATURE = builder
                .comment(BREAK_TEMPERATURE_DESCRIPTION)
                .defineInRange("crackingTemperature", BREAK_TEMPERATURE_DEFAULT, BREAK_TEMPERATURE_MIN, BREAK_TEMPERATURE_MAX);

        BURNING_TEMPERATURE = builder
                .comment(BURNING_TEMPERATURE_DESCRIPTION)
                .defineInRange("burningTemperature", BURNING_TEMPERATURE_DEFAULT, BURNING_TEMPERATURE_MIN, BURNING_TEMPERATURE_MAX);

        DURABILITY = builder
                .comment(DURABILITY_DESCRIPTION)
                .defineInRange("durability", DURABILITY_DEFAULT, DURABILITY_MIN, DURABILITY_MAX);

        FISH_OBTAINING_ENABLED = builder
                .comment(FISH_OBTAINING_ENABLED_DESCRIPTION)
                .define("fishObtainingEnabled", FISH_OBTAINING_ENABLED_DEFAULT);

        FREEZING_TEMPERATURE = builder
                .comment(FREEZING_TEMPERATURE_DESCRIPTION)
                .defineInRange("freezingTemperature", FREEZING_TEMPERATURE_DEFAULT, FREEZING_TEMPERATURE_MIN, FREEZING_TEMPERATURE_MAX);

        MILKING_ENABLED = builder
                .comment(MILKING_ENABLED_DESCRIPTION)
                .define("milkingEnabled", MILKING_ENABLED_DEFAULT);

        builder.pop();

        SERVER_CONFIG = builder.build();
    }

    @Override
    public void init() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, SERVER_CONFIG);
        Path path = FMLPaths.GAMEDIR.get().resolve(FMLConfig.defaultConfigPath()).resolve(Constants.MOD_ID + "-server.toml");
        final CommentedFileConfig configData = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();
        configData.load();
        SERVER_CONFIG.setConfig(configData);
    }

    @Override
    public int getBreakTemperature() {
        try {
            return BREAK_TEMPERATURE.get();
        } catch (IllegalStateException ex) {
            return BREAK_TEMPERATURE_DEFAULT;
        }
    }

    @Override
    public int getBurningTemperature() {
        try {
            return BURNING_TEMPERATURE.get();
        } catch (IllegalStateException ex) {
            return BURNING_TEMPERATURE_DEFAULT;
        }
    }

    @Override
    public int getDurability() {
        try {
            return DURABILITY.get();
        } catch (IllegalStateException ex) {
            return DURABILITY_DEFAULT;
        }
    }

    @Override
    public boolean isFishObtainingEnabled() {
        try {
            return FISH_OBTAINING_ENABLED.get();
        } catch (IllegalStateException ex) {
            return FISH_OBTAINING_ENABLED_DEFAULT;
        }
    }

    @Override
    public int getFreezingTemperature() {
        try {
            return FREEZING_TEMPERATURE.get();
        } catch (IllegalStateException ex) {
            return FREEZING_TEMPERATURE_DEFAULT;
        }
    }

    @Override
    public boolean isMilkingEnabled() {
        try {
            return MILKING_ENABLED.get();
        } catch (IllegalStateException ex) {
            return MILKING_ENABLED_DEFAULT;
        }
    }

}
