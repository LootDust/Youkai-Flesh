package org.tlhstudio.youkaiflesh.mixins;

import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;
import org.tlhstudio.youkaiflesh.content.api.mixinterface.IFDModTags;
import vectorwing.farmersdelight.common.tag.ModTags;

@Implements(
        @Interface(
                iface = IFDModTags.class,
                prefix = "oldModTags$"
        )
)
@Mixin(ModTags.class)
public class FDModTagMixin {
}
