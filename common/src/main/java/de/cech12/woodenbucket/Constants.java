package de.cech12.woodenbucket;

import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class that contains all common constants.
 */
public class Constants {

    /** mod id */
    public static final String MOD_ID = "woodenbucket";
    /** mod name*/
    public static final String MOD_NAME = "Wooden Bucket";
    /** Logger instance */
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

    public static final String WOODEN_BUCKET_NAME = "wooden_bucket";

    private Constants() {}

    public static Identifier id(String name) {
        return Identifier.fromNamespaceAndPath(MOD_ID, name);
    }

}