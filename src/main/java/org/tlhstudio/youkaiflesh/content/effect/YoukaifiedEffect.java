package org.tlhstudio.youkaiflesh.content.effect;

import dev.xkmc.l2core.base.effects.EffectUtil;
import dev.xkmc.youkaishomecoming.init.YoukaisHomecoming;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import org.tlhstudio.youkaiflesh.init.registrate.YFEffects;


public class YoukaifiedEffect extends MobEffect {

    public YoukaifiedEffect() {
        super(MobEffectCategory.NEUTRAL, 0xffffff);
        ResourceLocation rl = ResourceLocation.fromNamespaceAndPath(YoukaisHomecoming.MODID, "youkaified");
        addAttributeModifier(Attributes.MAX_HEALTH, rl, 20, AttributeModifier.Operation.ADD_VALUE);
        addAttributeModifier(Attributes.ATTACK_DAMAGE, rl, 0.5, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
        addAttributeModifier(Attributes.MOVEMENT_SPEED, rl, 0.3, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int lv) {
        if (entity instanceof Player player) {
            player.causeFoodExhaustion(0.02f);
            if (player.level().isClientSide()) return false;
            if (player.getFoodData().getFoodLevel() < 10) {
                EffectUtil.refreshEffect(entity, new MobEffectInstance(MobEffects.CONFUSION, 40, 0,
                        true, true), entity);
            }
            if (player.getFoodData().getFoodLevel() < 6) {
                player.removeEffect(YFEffects.YOUKAIFIED);
            }
            return true;
        }
        return false;
    }
}
