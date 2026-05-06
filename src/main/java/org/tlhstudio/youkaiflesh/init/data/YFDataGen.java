package org.tlhstudio.youkaiflesh.init.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.tlhstudio.youkaiflesh.YoukaiFlesh;
import org.tlhstudio.youkaiflesh.init.data.tags.YFBlockTagsProvider;
import org.tlhstudio.youkaiflesh.init.data.tags.YFItemTagsProvider;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = YoukaiFlesh.MOD_ID)
public class YFDataGen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper helper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        BlockTagsProvider blockTagsProvider = new YFBlockTagsProvider(output, lookupProvider, helper);
        generator.addProvider(event.includeServer(), new YFItemTagsProvider(output, lookupProvider, blockTagsProvider.contentsGetter(), helper));
    }
}
