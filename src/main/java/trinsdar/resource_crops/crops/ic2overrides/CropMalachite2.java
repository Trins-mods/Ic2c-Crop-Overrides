package trinsdar.resource_crops.crops.ic2overrides;

import ic2.api.crops.ICropTile;
import ic2.core.block.crop.crops.CropMalachite;
import net.minecraft.item.ItemStack;
import trinsdar.resource_crops.Crops;

public class CropMalachite2 extends CropMalachite {
    @Override
    public ItemStack getGain(ICropTile crop) {
        return Crops.getModMetaItem("thermalfoundation", "material", 64, 1).copy();
    }
}
