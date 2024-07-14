package de.cech12.woodenbucket.platform;

import de.cech12.woodenbucket.platform.services.IConfigHelper;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

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
        ModLoadingContext.get().getActiveContainer().registerConfig(ModConfig.Type.SERVER, SERVER_CONFIG);
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
