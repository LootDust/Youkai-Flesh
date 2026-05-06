package org.tlhstudio.youkaiflesh.api.item.food;

import dev.xkmc.youkaishomecoming.content.item.food.YHFoodItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public abstract class FleshFoodItem extends YHFoodItem implements IFleshFoodItem {

    public FleshFoodItem() {
        super(new Properties());
    }

    public FleshFoodItem(Properties properties) {
        super(properties);
    }


    @Override
    public @Nullable FoodProperties getFoodProperties(@NotNull ItemStack stack, @Nullable LivingEntity entity) {
        return getFleshFoodProps(super.getFoodProperties(stack, entity), entity);
    }

    @Override
    public @NotNull Component getName(@NotNull ItemStack stack) {
        return getFleshName(stack);
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity consumer) {
        return super.finishUsingItem(stack, level, consumer);
    }
}
