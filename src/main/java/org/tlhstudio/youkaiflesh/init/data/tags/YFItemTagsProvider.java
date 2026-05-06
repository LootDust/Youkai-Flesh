package org.tlhstudio.youkaiflesh.init.data.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.tlhstudio.youkaiflesh.YoukaiFlesh;
import org.tlhstudio.youkaiflesh.init.registrate.YFTags;
import org.tlhstudio.youkaiflesh.init.registrate.YFItems;

import java.util.concurrent.CompletableFuture;

public class YFItemTagsProvider extends ItemTagsProvider {
    public YFItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagsProvider.TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, YoukaiFlesh.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(YFTags.Items.FLESH_FOOD)
                .add(YFItems.FLESH.get())
                .add(YFItems.FLESH_SLICE.get());

        tag(YFTags.Items.RAW_FLESH)
                .add(YFItems.FLESH.get())
                .add(YFItems.FLESH_SLICE.get());
    }
}
