package trinsdar.resource_crops.crops.ic2overrides;

import cofh.thermalfoundation.init.TFBlocks;
import ic2.api.crops.ICropTile;
import ic2.core.block.crop.crops.CropStannum;
import net.minecraft.item.ItemStack;
import trinsdar.resource_crops.Crops;
import trinsdar.resource_crops.crops.CropResourceBase;

public class CropStannum2 extends CropStannum {
    @Override
    public ItemStack getGain(ICropTile crop) {
        return Crops.getModMetaItem("thermalfoundation", "material", 65, 1).copy();
    }

    @Override
    public boolean canGrow(ICropTile cropTile) {
        return cropTile.getCurrentSize() < 3 || cropTile.getCurrentSize() == 3 && (CropResourceBase.isBlockStateBelow(cropTile, TFBlocks.blockGlass.getStateFromMeta(1)));
    }
}
