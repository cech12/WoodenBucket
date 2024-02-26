package de.cech12.woodenbucket.platform.services;

/**
 * Common configuration helper service interface.
 */
public interface IConfigHelper {

    /** Default value of break temperature */
    int BREAK_TEMPERATURE_DEFAULT = 1000;
    /** Default value of burning temperature */
    int BURNING_TEMPERATURE_DEFAULT = 1000;
    /** Default value of durability */
    int DURABILITY_DEFAULT = 25;
    /** Default value of fish obtaining option */
    boolean FISH_OBTAINING_ENABLED_DEFAULT = true;
    /** Default value of freezing temperature */
    int FREEZING_TEMPERATURE_DEFAULT = -1;
    /** Default value of milking option */
    boolean MILKING_ENABLED_DEFAULT = true;


    /**
     * Initialization method for the Service implementations.
     */
    void init();

    /**
     * Gets the configured break temperature value.
     *
     * @return configured break temperature value
     */
    int getBreakTemperature();

    /**
     * Gets the configured burning temperature value.
     *
     * @return configured burning temperature value
     */
    int getBurningTemperature();

    /**
     * Gets the configured durability value.
     *
     * @return configured durability value
     */
    int getDurability();

    /**
     * Gets the fish obtaining enabled value.
     *
     * @return configured fish obtaining enabled value
     */
    boolean isFishObtainingEnabled();

    /**
     * Gets the configured freezing temperature value.
     *
     * @return configured freezing temperature value
     */
    int getFreezingTemperature();

    /**
     * Gets the configured milking enabled value.
     *
     * @return configured milking enabled value
     */
    boolean isMilkingEnabled();

}