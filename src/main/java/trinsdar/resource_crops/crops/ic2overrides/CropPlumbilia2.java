package trinsdar.resource_crops.crops.ic2overrides;

import cofh.thermalfoundation.init.TFBlocks;
import ic2.api.crops.ICropTile;
import net.minecraft.item.ItemStack;
import trinsdar.ic2c_extras.blocks.CropPlumbilia;
import trinsdar.resource_crops.Crops;
import trinsdar.resource_crops.crops.CropResourceBase;

public class CropPlumbilia2 extends CropPlumbilia {
    @Override
    public ItemStack getGain(ICropTile crop) {
        return Crops.getModMetaItem("thermalfoundation", "material", 67, 1).copy();
    }

    @Override
    public boolean canGrow(ICropTile cropTile) {
        return cropTile.getCurrentSize() < 3 || cropTile.getCurrentSize() == 3 && (CropResourceBase.isBlockStateBelow(cropTile, TFBlocks.blockGlass.getStateFromMeta(3)));
    }
}
