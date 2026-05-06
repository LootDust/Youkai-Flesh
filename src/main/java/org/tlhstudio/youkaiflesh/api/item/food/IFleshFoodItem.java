package org.tlhstudio.youkaiflesh.api.item.food;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.loading.FMLEnvironment;
import org.jetbrains.annotations.Nullable;
import org.tlhstudio.youkaiflesh.init.config.YFConfig;
import org.tlhstudio.youkaiflesh.init.registrate.YFEffects;

public interface IFleshFoodItem extends ItemLike {

    @Nullable
    static Player getPlayer() {
        if (FMLEnvironment.dist == Dist.CLIENT) {
            return Minecraft.getInstance().player;
        }
        return null;
    }

    default @Nullable FoodProperties getFleshFoodProps(@Nullable FoodProperties originalProperties, @Nullable LivingEntity entity) {
        if (originalProperties == null) return null;

        double factor = entity != null ? (entity.hasEffect(YFEffects.YOUKAIFYING) ?
                YFConfig.FLESH_FOOD_YOUKAIFYING_MULTIPLIER.get() : entity.hasEffect(YFEffects.YOUKAIFIED) ?
                YFConfig.FLESH_FOOD_YOUKAIFIED_MULTIPLIER.get() : 1) : 1;

        FoodProperties.Builder builder = new FoodProperties.Builder();
        builder.nutrition((int)(Math.round(originalProperties.nutrition() * factor)));
        builder.saturationModifier((int)(Math.round(originalProperties.saturation() * factor)));
        if (originalProperties.canAlwaysEat()) builder.alwaysEdible();

        return builder.build();
    }

    default Component getFleshName(ItemStack stack) {
        Player player = getPlayer();
        Component name;
        if (player != null) {
            if (player.hasEffect(YFEffects.YOUKAIFIED)) {
                name = Component.translatable("youkaisflesh.flesh.villager");
            } else if (player.hasEffect(YFEffects.YOUKAIFYING)) {
                name = Component.translatable("youkaisflesh.flesh.familiar");
            } else {
                name = Component.translatable("youkaisflesh.flesh.unknown");
            }
        } else {
            name = Component.translatable("youkaisflesh.flesh.unknown");
        }
        return Component.translatable(asItem().getDescriptionId(stack), name);
    }

    default void consume(Player consumer, double defaultYoukaifyingTimeMultiplier, double addedYoukaifyingTimeMultiplier, double addedYoukaifiedTimeMultiplier) {
        if (consumer.level().isClientSide()) return;
        if (consumer.hasEffect(YFEffects.YOUKAIFIED)) {
            MobEffectInstance effect = consumer.getEffect(YFEffects.YOUKAIFIED);
            if (effect != null) {
                int duration = effect.getDuration() + (int)(Math.round(YFConfig.ADDED_YOUKAIFIED_TIME.get() * addedYoukaifiedTimeMultiplier));
                consumer.addEffect(new MobEffectInstance(YFEffects.YOUKAIFIED,
                        duration, 0, true, false, true));
            }
        } else if (consumer.hasEffect(YFEffects.YOUKAIFYING)) {
            MobEffectInstance effect = consumer.getEffect(YFEffects.YOUKAIFYING);
            if (effect != null) {
                int duration = effect.getDuration() + (int)(Math.round(YFConfig.ADDED_YOUKAIFYING_TIME.get() * addedYoukaifyingTimeMultiplier));
                if (duration > YFConfig.START_YOUKAIFIED_TIME.get()) {
                    duration = YFConfig.DEFAULT_YOUKAIFIED_TIME.get();
                    consumer.removeEffect(YFEffects.YOUKAIFYING);
                    consumer.addEffect(new MobEffectInstance(YFEffects.YOUKAIFIED,
                            duration, 0, true, false, true));
                } else {
                    consumer.addEffect(new MobEffectInstance(YFEffects.YOUKAIFYING,
                            duration, 0, false, false, false));
                }
            }
        } else {
            if (consumer.getRandom().nextDouble() < YFConfig.FLESH_FOOD_YOUKAIFYING_CHANCE.get()) {
                int duration = (int)(Math.round(YFConfig.DEFAULT_YOUKAIFYING_TIME.get() * defaultYoukaifyingTimeMultiplier));
                consumer.addEffect(new MobEffectInstance(YFEffects.YOUKAIFYING,
                        duration, 0, false, false, false));
                duration = YFConfig.FLESH_FOOD_NAUSEA_TIME.get();
                consumer.addEffect(new MobEffectInstance(MobEffects.CONFUSION,
                        duration, 0, false, false, true));
            }
        }
    }

}