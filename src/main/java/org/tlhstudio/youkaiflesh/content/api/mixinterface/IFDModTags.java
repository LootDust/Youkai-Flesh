package org.tlhstudio.youkaiflesh.content.api.mixinterface;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import vectorwing.farmersdelight.FarmersDelight;

public interface IFDModTags {
    @Deprecated(forRemoval = true)
    TagKey<Item> CABBAGE_ROLL_INGREDIENTS = ItemTags.create(ResourceLocation.fromNamespaceAndPath(FarmersDelight.MODID, "cabbage_roll_ingredients"));
}