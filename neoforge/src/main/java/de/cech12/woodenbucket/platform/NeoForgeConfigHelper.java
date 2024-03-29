package de.cech12.woodenbucket.platform;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import de.cech12.woodenbucket.Constants;
import de.cech12.woodenbucket.platform.services.IConfigHelper;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.loading.FMLConfig;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.nio.file.Path;

/**
 * The config service implementation for NeoForge.
 */
public class NeoForgeConfigHelper implements IConfigHelper {

    private static final ModConfigSpec SERVER_CONFIG;

    private static final ModConfigSpec.IntValue BREAK_TEMPERATURE;
    private static final ModConfigSpec.IntValue BURNING_TEMPERATURE;
    private static final ModConfigSpec.IntValue DURABILITY;
    private static final ModConfigSpec.BooleanValue FISH_OBTAINING_ENABLED;
    private static final ModConfigSpec.IntValue FREEZING_TEMPERATURE;
    private static final ModConfigSpec.BooleanValue MILKING_ENABLED;

    static {
        final ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        builder.push("Balance Options");

        BREAK_TEMPERATURE = builder
                .comment("Minimum temperature of fluid at which the Wooden Bucket breaks when emptied. (-1 means that bucket never breaks caused by high fluid temperature)")
                .defineInRange("crackingTemperature", BREAK_TEMPERATURE_DEFAULT, -10000, 10000);

        BURNING_TEMPERATURE = builder
                .comment("Fluid temperature from which you get a burning effect if a bucket contains this fluid.")
                .defineInRange("burningTemperature", BURNING_TEMPERATURE_DEFAULT, -10000, 10000);

        DURABILITY = builder
                .comment("Defines the maximum durability of a Wooden Bucket. (0 deactivates the durability)")
                .defineInRange("durability", DURABILITY_DEFAULT, 0, 10000);

        FISH_OBTAINING_ENABLED = builder
                .comment("Whether or not obtaining fish with a Wooden Bucket should be enabled.")
                .define("fishObtainingEnabled", FISH_OBTAINING_ENABLED_DEFAULT);

        FREEZING_TEMPERATURE = builder
                .comment("Fluid temperature from which you get a freezing effect if a bucket contains this fluid.")
                .defineInRange("freezingTemperature", FREEZING_TEMPERATURE_DEFAULT, -10000, 10000);

        MILKING_ENABLED = builder
                .comment("Whether or not milking entities with a Ceramic Bucket should be enabled.")
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
