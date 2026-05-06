package org.tlhstudio.youkaiflesh.init.registrate;


import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.tlhstudio.youkaiflesh.YoukaiFlesh;

public class YFTags {

    public class Items {
        public static final TagKey<Item> FLESH_FOOD = tag("flesh_food");
        public static final TagKey<Item> RAW_FLESH = tag("raw_flesh");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(YoukaiFlesh.MOD_ID, name));
        }
        private static TagKey<Item> commonTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
        }
        private static TagKey<Item> modTag(String modid, String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(modid, name));
        }
    }
}
