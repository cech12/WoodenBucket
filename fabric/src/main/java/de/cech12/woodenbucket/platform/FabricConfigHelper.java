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

    @ConfigEntry.Gui.Tooltip(count = 5)
    @ConfigEntry.BoundedDiscrete(min = BREAK_TEMPERATURE_MIN, max = BREAK_TEMPERATURE_MAX)
    public long BREAK_TEMPERATURE = BREAK_TEMPERATURE_DEFAULT;

    @ConfigEntry.Gui.Tooltip(count = 5)
    @ConfigEntry.BoundedDiscrete(min = BURNING_TEMPERATURE_MIN, max = BURNING_TEMPERATURE_MAX)
    public long BURNING_TEMPERATURE = BURNING_TEMPERATURE_DEFAULT;

    @ConfigEntry.Gui.Tooltip(count = 4)
    @ConfigEntry.BoundedDiscrete(min = DURABILITY_MIN, max = DURABILITY_MAX)
    public long DURABILITY = DURABILITY_DEFAULT;

    @ConfigEntry.Gui.Tooltip(count = 4)
    public boolean FISH_OBTAINING_ENABLED = FISH_OBTAINING_ENABLED_DEFAULT;

    @ConfigEntry.Gui.Tooltip(count = 5)
    @ConfigEntry.BoundedDiscrete(min = FREEZING_TEMPERATURE_MIN, max = FREEZING_TEMPERATURE_MAX)
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
        return (int) getConfig().BREAK_TEMPERATURE;
    }

    @Override
    public int getBurningTemperature() {
        return (int) getConfig().BURNING_TEMPERATURE;
    }

    @Override
    public int getDurability() {
        return (int) getConfig().DURABILITY;
    }

    @Override
    public boolean isFishObtainingEnabled() {
        return getConfig().FISH_OBTAINING_ENABLED;
    }

    @Override
    public int getFreezingTemperature() {
        return (int) getConfig().FREEZING_TEMPERATURE;
    }

    @Override
    public boolean isMilkingEnabled() {
        return getConfig().MILKING_ENABLED;
    }

}
