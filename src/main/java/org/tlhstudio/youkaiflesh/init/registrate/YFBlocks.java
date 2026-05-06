package org.tlhstudio.youkaiflesh.init.registrate;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.tlhstudio.youkaiflesh.YoukaiFlesh;
import org.tlhstudio.youkaiflesh.content.block.food.FleshFeastBlock;

import java.util.function.Supplier;

public class YFBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(YoukaiFlesh.MOD_ID);

    public static final DeferredBlock<Block> FLESH_FEAST = registerBlock("flesh_feast", FleshFeastBlock::new);

    private static <T extends Block> void registerBlockItems(String name, DeferredBlock<T> block) {
        YFItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> dBlock = BLOCKS.register(name, block);
        registerBlockItems(name, dBlock);
        return dBlock;
    }
}
