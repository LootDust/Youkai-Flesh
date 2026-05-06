package org.tlhstudio.youkaiflesh.init.registrate;

import com.tterrag.registrate.builders.NoConfigBuilder;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import dev.xkmc.l2core.init.reg.registrate.LegacyHolder;
import dev.xkmc.l2core.init.reg.registrate.SimpleEntry;
import dev.xkmc.youkaishomecoming.init.YoukaisHomecoming;
import net.minecraft.world.effect.MobEffect;
import org.tlhstudio.youkaiflesh.content.effect.YoukaifiedEffect;
import org.tlhstudio.youkaiflesh.content.effect.YoukaifyingEffect;

public class YFEffects {
    public static final LegacyHolder<MobEffect> YOUKAIFIED = genEffect("youkaified", YoukaifiedEffect::new, "You are a Youkai now");
    public static final LegacyHolder<MobEffect> YOUKAIFYING = genEffect("youkaifying", YoukaifyingEffect::new, "You are becoming a Youkai");

    private static <T extends MobEffect> LegacyHolder<MobEffect> genEffect(String name, NonNullSupplier<T> sup, String desc) {
        return new SimpleEntry(((NoConfigBuilder) YoukaisHomecoming.REGISTRATE.effect(name, sup, desc).lang(MobEffect::getDescriptionId)).register());
    }
}
