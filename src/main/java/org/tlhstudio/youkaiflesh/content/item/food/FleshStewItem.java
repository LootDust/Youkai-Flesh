package org.tlhstudio.youkaiflesh.content.item.food;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.tlhstudio.youkaiflesh.api.item.food.FleshContainedFoodItem;
import org.tlhstudio.youkaiflesh.init.config.YFConfig;

public class FleshStewItem extends FleshContainedFoodItem {
    public FleshStewItem() {
        super();
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity consumer) {
        if (consumer instanceof Player player) {
            consume(player, 1.0, YFConfig.FLESH_STEW_YOUKAIFYING_TIME_MULTIPLIER.get(), YFConfig.FLESH_STEW_YOUKAIFIED_TIME_MULTIPLIER.get());
        }
        return remains;
    }
}
