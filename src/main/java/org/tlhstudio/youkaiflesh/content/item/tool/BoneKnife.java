package org.tlhstudio.youkaiflesh.content.item.tool;

import net.minecraft.world.item.Tier;
import org.tlhstudio.youkaiflesh.api.item.tool.YFTiers;
import vectorwing.farmersdelight.common.item.KnifeItem;

public class BoneKnife extends KnifeItem {
    public BoneKnife(Tier tier, Properties properties) {
        super(YFTiers.Bone, properties);
    }
}
