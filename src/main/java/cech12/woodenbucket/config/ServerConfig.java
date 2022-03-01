package cech12.woodenbucket.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;

import java.nio.file.Path;

public class ServerConfig {

    public static ForgeConfigSpec SERVER_CONFIG;

    public static final ForgeConfigSpec.IntValue CRACKING_TEMPERATURE;
    public static final ForgeConfigSpec.IntValue BURNING_TEMPERATURE;
    public static final ForgeConfigSpec.IntValue FREEZING_TEMPERATURE;
    public static final ForgeConfigSpec.BooleanValue MILKING_ENABLED;
    public static final ForgeConfigSpec.BooleanValue FISH_OBTAINING_ENABLED;
    public static final ForgeConfigSpec.IntValue DURABILITY;

    static {
        final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.push("Balance Options");

        CRACKING_TEMPERATURE = builder
                .comment("Minimum temperature of fluid at which the Wooden Bucket breaks when emptied.")
                .defineInRange("crackingTemperature", 1000, -10000, 10000);

        BURNING_TEMPERATURE = builder
                .comment("Fluid temperature from which you get a burning effect if a bucket contains this fluid.")
                .defineInRange("burningTemperature", 1000, -10000, 10000);

        FREEZING_TEMPERATURE = builder
                .comment("Fluid temperature from which you get a freezing effect if a bucket contains this fluid.")
                .defineInRange("freezingTemperature", -1, -10000, 10000);

        MILKING_ENABLED = builder
                .comment("Whether or not milking entities with a Wooden Bucket should be enabled.")
                .define("milkingEnabled", true);

        FISH_OBTAINING_ENABLED = builder
                .comment("Whether or not obtaining fish with a Wooden Bucket should be enabled.")
                .define("fishObtainingEnabled", true);

        DURABILITY = builder
                .comment("Defines the maximum durability of a Wooden Bucket. (0 deactivates the durability)")
                .defineInRange("durability", 25, 0, 10000);

        builder.pop();

        SERVER_CONFIG = builder.build();
    }

    public static void loadConfig(ForgeConfigSpec spec, Path path) {
        final CommentedFileConfig configData = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();
        configData.load();
        spec.setConfig(configData);
    }

}
