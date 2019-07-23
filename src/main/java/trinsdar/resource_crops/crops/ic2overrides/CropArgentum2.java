package trinsdar.resource_crops.crops.ic2overrides;

import ic2.api.crops.ICropTile;
import ic2.core.block.crop.crops.CropArgentum;
import net.minecraft.item.ItemStack;
import trinsdar.resource_crops.Crops;

public class CropArgentum2 extends CropArgentum {
    @Override
    public ItemStack getGain(ICropTile crop) {
        return Crops.getModMetaItem("thermalfoundation", "material", 66, 1).copy();
    }
}
