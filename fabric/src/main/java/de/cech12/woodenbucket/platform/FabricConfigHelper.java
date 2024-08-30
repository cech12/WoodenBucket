package de.cech12.woodenbucket.platform;

import de.cech12.woodenbucket.Constants;
import de.cech12.woodenbucket.platform.services.IConfigHelper;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;

/**
 * The config service implementation for Fabric.
 */
@Config(name = Constants.MOD_ID)
public class FabricConfigHelper implements ConfigData, IConfigHelper {

    @ConfigEntry.Gui.Tooltip(count = 6)
    public long BREAK_TEMPERATURE = BREAK_TEMPERATURE_DEFAULT;

    @ConfigEntry.Gui.Tooltip(count = 6)
    public long BURNING_TEMPERATURE = BURNING_TEMPERATURE_DEFAULT;

    @ConfigEntry.Gui.Tooltip(count = 5)
    public long DURABILITY = DURABILITY_DEFAULT;

    @ConfigEntry.Gui.Tooltip(count = 4)
    public boolean FISH_OBTAINING_ENABLED = FISH_OBTAINING_ENABLED_DEFAULT;

    @ConfigEntry.Gui.Tooltip(count = 6)
    public long FREEZING_TEMPERATURE = FREEZING_TEMPERATURE_DEFAULT;

    @ConfigEntry.Gui.Tooltip(count = 4)
    public boolean MILKING_ENABLED = MILKING_ENABLED_DEFAULT;

    @Override
    public void init() {
        AutoConfig.register(FabricConfigHelper.class, Toml4jConfigSerializer::new);
    }

    private FabricConfigHelper getConfig() {
        return AutoConfig.getConfigHolder(FabricConfigHelper.class).getConfig();
    }

    @Override
    public int getBreakTemperature() {
        return Math.clamp((int) getConfig().BREAK_TEMPERATURE, BREAK_TEMPERATURE_MIN, BREAK_TEMPERATURE_MAX);
    }

    @Override
    public int getBurningTemperature() {
        return Math.clamp((int) getConfig().BURNING_TEMPERATURE, BURNING_TEMPERATURE_MIN, BURNING_TEMPERATURE_MAX);
    }

    @Override
    public int getDurability() {
        return Math.clamp((int) getConfig().DURABILITY, DURABILITY_MIN, DURABILITY_MAX);
    }

    @Override
    public boolean isFishObtainingEnabled() {
        return getConfig().FISH_OBTAINING_ENABLED;
    }

    @Override
    public int getFreezingTemperature() {
        return Math.clamp((int) getConfig().FREEZING_TEMPERATURE, FREEZING_TEMPERATURE_MIN, FREEZING_TEMPERATURE_MAX);
    }

    @Override
    public boolean isMilkingEnabled() {
        return getConfig().MILKING_ENABLED;
    }

}
