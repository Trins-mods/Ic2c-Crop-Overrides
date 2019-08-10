package trinsdar.all_the_crops.crops.ic2overrides;

import cofh.thermalfoundation.init.TFBlocks;
import ic2.api.crops.ICropTile;
import ic2.core.block.crop.crops.CropMalachite;
import net.minecraft.item.ItemStack;
import trinsdar.all_the_crops.Crops;
import trinsdar.all_the_crops.crops.CropResourceBase;

public class CropMalachite2 extends CropMalachite {
    @Override
    public ItemStack getGain(ICropTile crop) {
        return Crops.getModMetaItem("thermalfoundation", "material", 64, 1).copy();
    }

    @Override
    public boolean canGrow(ICropTile cropTile) {
        return cropTile.getCurrentSize() < 3 || cropTile.getCurrentSize() == 3 && (CropResourceBase.isBlockStateBelow(cropTile, TFBlocks.blockGlass.getStateFromMeta(0)));
    }
}
