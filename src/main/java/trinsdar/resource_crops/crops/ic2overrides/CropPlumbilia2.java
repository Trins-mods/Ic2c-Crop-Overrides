package trinsdar.resource_crops.crops.ic2overrides;

import ic2.api.crops.ICropTile;
import net.minecraft.item.ItemStack;
import trinsdar.ic2c_extras.blocks.CropPlumbilia;
import trinsdar.resource_crops.Crops;

public class CropPlumbilia2 extends CropPlumbilia {
    @Override
    public ItemStack getGain(ICropTile crop) {
        return Crops.getModMetaItem("thermalfoundation", "material", 67, 1).copy();
    }
}
