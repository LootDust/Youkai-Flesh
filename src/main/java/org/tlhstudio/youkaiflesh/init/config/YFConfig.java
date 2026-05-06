package org.tlhstudio.youkaiflesh.init.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class YFConfig {
    @Deprecated
    public static ModConfigSpec CLIENT_CONFIG;
    public static ModConfigSpec COMMON_CONFIG;
    @Deprecated
    public static ModConfigSpec SERVER_CONFIG;


    public static ModConfigSpec.IntValue DEFAULT_YOUKAIFYING_TIME;
    public static ModConfigSpec.IntValue ADDED_YOUKAIFYING_TIME;
    public static ModConfigSpec.IntValue START_YOUKAIFIED_TIME;
    public static ModConfigSpec.IntValue DEFAULT_YOUKAIFIED_TIME;
    public static ModConfigSpec.IntValue ADDED_YOUKAIFIED_TIME;

    @Deprecated
    public static ModConfigSpec.DoubleValue YOUKAIFYING_NUTRITION_CONSUMING_MULTIPLIER;
    @Deprecated
    public static ModConfigSpec.DoubleValue YOUKAIFYING_SATURATION_CONSUMING_MULTIPLIER;
    @Deprecated
    public static ModConfigSpec.DoubleValue YOUKAIFIED_NUTRITION_CONSUMING_MULTIPLIER;
    @Deprecated
    public static ModConfigSpec.DoubleValue YOUKAIFIED_SATURATION_CONSUMING_MULTIPLIER;


    public static ModConfigSpec.DoubleValue FLESH_FOOD_YOUKAIFYING_CHANCE;
    @Deprecated
    public static ModConfigSpec.IntValue FLESH_FOOD_FIRST_NAUSEA_TIME;
    public static ModConfigSpec.IntValue FLESH_FOOD_NAUSEA_TIME;
    public static ModConfigSpec.DoubleValue FLESH_FOOD_YOUKAIFYING_MULTIPLIER;
    public static ModConfigSpec.DoubleValue FLESH_FOOD_YOUKAIFIED_MULTIPLIER;


    @Deprecated
    public static ModConfigSpec.DoubleValue FLESH_YOUKAIFYING_TIME_MULTIPLIER;
    @Deprecated
    public static ModConfigSpec.DoubleValue FLESH_YOUKAIFIED_TIME_MULTIPLIER;
    public static ModConfigSpec.DoubleValue FLESH_SLICE_YOUKAIFYING_TIME_MULTIPLIER;
    public static ModConfigSpec.DoubleValue FLESH_SLICE_YOUKAIFIED_TIME_MULTIPLIER;

    public static ModConfigSpec.DoubleValue COOKED_FLESH_YOUKAIFYING_TIME_MULTIPLIER;
    public static ModConfigSpec.DoubleValue COOKED_FLESH_YOUKAIFIED_TIME_MULTIPLIER;
    public static ModConfigSpec.DoubleValue COOKED_FLESH_SLICE_YOUKAIFYING_TIME_MULTIPLIER;
    public static ModConfigSpec.DoubleValue COOKED_FLESH_SLICE_YOUKAIFIED_TIME_MULTIPLIER;

    public static ModConfigSpec.DoubleValue FLESH_STEW_YOUKAIFYING_TIME_MULTIPLIER;
    public static ModConfigSpec.DoubleValue FLESH_STEW_YOUKAIFIED_TIME_MULTIPLIER;
    @Deprecated
    public static ModConfigSpec.DoubleValue FLESH_BOILED_DUMPLING_YOUKAIFYING_TIME_MULTIPLIER;
    @Deprecated
    public static ModConfigSpec.DoubleValue FLESH_BOILED_DUMPLING_YOUKAIFIED_TIME_MULTIPLIER;
    @Deprecated
    public static ModConfigSpec.DoubleValue FLESH_BUN_YOUKAIFYING_TIME_MULTIPLIER;
    @Deprecated
    public static ModConfigSpec.DoubleValue FLESH_BUN_YOUKAIFIED_TIME_MULTIPLIER;
    @Deprecated
    public static ModConfigSpec.DoubleValue FLESH_NOODLES_YOUKAIFYING_TIME_MULTIPLIER;
    @Deprecated
    public static ModConfigSpec.DoubleValue FLESH_NOODLES_YOUKAIFIED_TIME_MULTIPLIER;
    @Deprecated
    public static ModConfigSpec.DoubleValue FLESH_ROLL_YOUKAIFYING_TIME_MULTIPLIER;
    @Deprecated
    public static ModConfigSpec.DoubleValue FLESH_ROLL_YOUKAIFIED_TIME_MULTIPLIER;
    @Deprecated
    public static ModConfigSpec.DoubleValue GLAZED_APPLE_YOUKAIFYING_TIME_MULTIPLIER;
    @Deprecated
    public static ModConfigSpec.DoubleValue GLAZED_APPLE_YOUKAIFIED_TIME_MULTIPLIER;
    @Deprecated
    public static ModConfigSpec.DoubleValue FLESH_FEAST_YOUKAIFYING_TIME_MULTIPLIER;
    @Deprecated
    public static ModConfigSpec.DoubleValue FLESH_FEAST_YOUKAIFIED_TIME_MULTIPLIER;

    static {
        ModConfigSpec.Builder commmonConfigBuilder = new ModConfigSpec.Builder();

        commmonConfigBuilder.push("Youkai's Flesh");

            commmonConfigBuilder.push("Effects");

                DEFAULT_YOUKAIFYING_TIME = commmonConfigBuilder.comment("Default time in ticks of youkaifying effect when you are entering youkaifying.")
                        .defineInRange("default_youkaifying_time", 1200, 0, Integer.MAX_VALUE);
                ADDED_YOUKAIFYING_TIME = commmonConfigBuilder.comment("Added time in ticks of youkaifying effect when you eating flesh foods.")
                        .defineInRange("added_youkaifying_time", 600, 0, Integer.MAX_VALUE);
                START_YOUKAIFIED_TIME = commmonConfigBuilder.comment("The minimal time threshold (in ticks) starting transfering into youkaified from youkaifying.")
                        .defineInRange("start_youkaified_time", 6000, 0, Integer.MAX_VALUE);
                DEFAULT_YOUKAIFIED_TIME = commmonConfigBuilder.comment("Default time in ticks of youkaified effect when you are transferred into youkai. (-1 as infinite)")
                        .defineInRange("default_youkaified_time", 24000, -1, Integer.MAX_VALUE);
                ADDED_YOUKAIFIED_TIME = commmonConfigBuilder.comment("Added time in ticks of youkaified effect when you eating flesh foods.")
                        .defineInRange("added_youkaified_time", 1200, 0, Integer.MAX_VALUE);

            commmonConfigBuilder.pop();

            commmonConfigBuilder.push("Foods");

                FLESH_FOOD_YOUKAIFYING_CHANCE = commmonConfigBuilder.comment("")
                        .defineInRange("flesh_food_youkaifying_chance", 0.2, 0.0, 1.0);
                FLESH_FOOD_NAUSEA_TIME = commmonConfigBuilder.comment("")
                        .defineInRange("flesh_food_nausea_time", 100, 0, Integer.MAX_VALUE);
                FLESH_FOOD_YOUKAIFYING_MULTIPLIER = commmonConfigBuilder.comment("")
                        .defineInRange("flesh_food_youkaifying_multiplier", 2.0, 0.0, Double.MAX_VALUE);
                FLESH_FOOD_YOUKAIFIED_MULTIPLIER = commmonConfigBuilder.comment("")
                        .defineInRange("flesh_food_youkaifying_multiplier", 3.0, 0.0, Double.MAX_VALUE);
                commmonConfigBuilder.comment("");
                FLESH_SLICE_YOUKAIFYING_TIME_MULTIPLIER = commmonConfigBuilder.comment("")
                        .defineInRange("flesh_slice_youkaifying_time_multiplier", 1.2, 0.0, Double.MAX_VALUE);
                FLESH_SLICE_YOUKAIFIED_TIME_MULTIPLIER = commmonConfigBuilder.comment("")
                        .defineInRange("flesh_slice_youkaified_time_multiplier", 1.2, 0.0, Double.MAX_VALUE);
                COOKED_FLESH_YOUKAIFYING_TIME_MULTIPLIER = commmonConfigBuilder.comment("")
                        .defineInRange("cooked_flesh_youkaifying_time_multiplier", 0.7, 0.0, Double.MAX_VALUE);
                COOKED_FLESH_YOUKAIFIED_TIME_MULTIPLIER = commmonConfigBuilder.comment("")
                        .defineInRange("cooked_flesh_youkaified_time_multiplier", 0.7, 0.0, Double.MAX_VALUE);
                COOKED_FLESH_SLICE_YOUKAIFYING_TIME_MULTIPLIER = commmonConfigBuilder.comment("")
                        .defineInRange("cooked_flesh_youkaifying_time_multiplier", 0.9, 0.0, Double.MAX_VALUE);
                COOKED_FLESH_SLICE_YOUKAIFIED_TIME_MULTIPLIER = commmonConfigBuilder.comment("")
                        .defineInRange("cooked_flesh_youkaified_time_multiplier", 0.9, 0.0, Double.MAX_VALUE);
                commmonConfigBuilder.comment("");
                FLESH_STEW_YOUKAIFYING_TIME_MULTIPLIER = commmonConfigBuilder.comment("")
                        .defineInRange("flesh_stew_youkaifying_time_multiplier", 1.5, 0.0, Double.MAX_VALUE);
                FLESH_STEW_YOUKAIFIED_TIME_MULTIPLIER = commmonConfigBuilder.comment("")
                        .defineInRange("flesh_stew_youkaified_time_multiplier", 1.5, 0.0, Double.MAX_VALUE);


            commmonConfigBuilder.pop();

        commmonConfigBuilder.pop();

        COMMON_CONFIG = commmonConfigBuilder.build();
    }
}
