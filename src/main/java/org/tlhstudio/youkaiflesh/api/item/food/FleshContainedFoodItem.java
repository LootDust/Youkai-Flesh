package org.tlhstudio.youkaiflesh.api.item.food;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public abstract class FleshContainedFoodItem extends FleshFoodItem {
    protected ItemStack remains;

    public FleshContainedFoodItem() {
        this(Items.BOWL);
    }

    public FleshContainedFoodItem(ItemLike remains) {
        super(new Properties().stacksTo(16));
        this.remains = new ItemStack(remains);
    }

    @Override
    public @NotNull ItemStack getCraftingRemainingItem(@NotNull ItemStack itemStack) {
        return super.getCraftingRemainingItem(remains);
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity consumer) {
        if (consumer instanceof Player player) consume(player, 1.0, 1.0, 1.0);
        return remains;
    }
}
