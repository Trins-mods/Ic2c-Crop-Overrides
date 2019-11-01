package trinsdar.ic2c_crop_overrides.crops.ic2overrides;

import de.ellpeck.actuallyadditions.mod.blocks.InitBlocks;
import ic2.api.crops.ICropTile;
import ic2.core.block.crop.crops.CropRedWheat;
import trinsdar.ic2c_crop_overrides.crops.CropResourceBase;

public class CropRedWheat2 extends CropRedWheat {
    @Override
    public boolean canGrow(ICropTile cropTile) {
        return cropTile.getCurrentSize() < 5 ? super.canGrow(cropTile) : super.canGrow(cropTile) && CropResourceBase.isBlockStateBelow(cropTile, InitBlocks.blockCrystalEmpowered.getStateFromMeta(0));
    }
}
