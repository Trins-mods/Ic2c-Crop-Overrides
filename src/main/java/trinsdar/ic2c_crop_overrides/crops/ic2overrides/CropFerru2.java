package trinsdar.ic2c_crop_overrides.crops.ic2overrides;

import de.ellpeck.actuallyadditions.mod.blocks.InitBlocks;
import ic2.api.crops.ICropTile;
import ic2.core.block.crop.crops.CropFerru;
import net.minecraft.item.ItemStack;
import trinsdar.ic2c_crop_overrides.Crops;
import trinsdar.ic2c_crop_overrides.crops.CropResourceBase;

public class CropFerru2 extends CropFerru {
    @Override
    public boolean canGrow(ICropTile cropTile) {
        return cropTile.getCurrentSize() < 3 || cropTile.getCurrentSize() == 3 && (CropResourceBase.isBlockStateBelow(cropTile, InitBlocks.blockCrystalEmpowered.getStateFromMeta(5)));
    }

    @Override
    public ItemStack getGain(ICropTile crop) {
        return Crops.getModMetaItem("thermalfoundation", "material", 0, 1).copy();
    }
}
