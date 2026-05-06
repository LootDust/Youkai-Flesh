package org.tlhstudio.youkaiflesh.init.data.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.tlhstudio.youkaiflesh.YoukaiFlesh;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class YFBlockTagsProvider extends BlockTagsProvider {
    public YFBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper helper) {
        super(output, lookupProvider, YoukaiFlesh.MOD_ID, helper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

    }
}
