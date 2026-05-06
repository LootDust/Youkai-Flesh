package org.tlhstudio.youkaiflesh.init.registrate;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.tlhstudio.youkaiflesh.YoukaiFlesh;
import org.tlhstudio.youkaiflesh.content.item.food.FleshItem;
import org.tlhstudio.youkaiflesh.content.item.food.FleshSliceItem;
import org.tlhstudio.youkaiflesh.content.item.food.GlazeAppleItem;

public class YFItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(YoukaiFlesh.MOD_ID);

    public static final DeferredItem<Item> FLESH = ITEMS.register("flesh", FleshItem::new);
    public static final DeferredItem<Item> FLESH_SLICE = ITEMS.register("flesh_slice", FleshSliceItem::new);

    public static final DeferredItem<Item> GLAZED_APPLE = ITEMS.register("glazed_apple", GlazeAppleItem::new);
}
