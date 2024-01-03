package de.cech12.woodenbucket;

import de.cech12.woodenbucket.platform.Services;

/**
 * A static class for all loaders which initializes everything which is used by all loaders.
 */
public class CommonLoader {

    /**
     * Initialize method that should be called by every loader mod in the constructor.
     */
    public static void init() {
        Services.CONFIG.init();
    }

    private CommonLoader() {}

}
