package org.tlhstudio.youkaiflesh.content.item.food;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.tlhstudio.youkaiflesh.api.item.food.FleshFoodItem;
import org.tlhstudio.youkaiflesh.init.config.YFConfig;

public class CookedFleshItem extends FleshFoodItem {

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity consumer) {
        ItemStack remains = super.finishUsingItem(stack, level, consumer);
        if (consumer instanceof Player player) {
            consume(player, 1.0, YFConfig.COOKED_FLESH_YOUKAIFYING_TIME_MULTIPLIER.get(), YFConfig.COOKED_FLESH_YOUKAIFIED_TIME_MULTIPLIER.get());
        }
        return remains;
    }
}
