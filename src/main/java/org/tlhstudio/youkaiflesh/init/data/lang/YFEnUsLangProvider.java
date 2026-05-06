package org.tlhstudio.youkaiflesh.init.data.lang;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.tlhstudio.youkaiflesh.YoukaiFlesh;
import org.tlhstudio.youkaiflesh.init.registrate.YFBlocks;
import org.tlhstudio.youkaiflesh.init.registrate.YFItems;

public class YFEnUsLangProvider extends LanguageProvider {
    public YFEnUsLangProvider(PackOutput output, String locale) {
        super(output, YoukaiFlesh.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        // Blocks
        add(YFBlocks.FLESH_FEAST.get(), "%1$s Feast");
        // Effects
        // Items
        add(YFItems.FLESH.get(), "%1$s");
        add(YFItems.FLESH_SLICE.get(), "%1$s Slice");
        add(YFItems.GLAZED_APPLE.get(), "Glazed Apple");
        // Misc
        add("youkaisflesh.flesh.unknown", "Weird Meat");
        add("youkaisflesh.flesh.familiar", "Suspicious Meat");
        add("youkaisflesh.flesh.villager", "Flesh");
    }
}
