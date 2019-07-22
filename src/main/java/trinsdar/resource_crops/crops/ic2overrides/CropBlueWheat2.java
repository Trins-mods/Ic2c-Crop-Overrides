package trinsdar.resource_crops.crops.ic2overrides;

import de.ellpeck.actuallyadditions.mod.blocks.InitBlocks;
import ic2.api.crops.ICropTile;
import ic2.core.block.crop.crops.CropBlueWheat;
import trinsdar.resource_crops.crops.CropResourceBase;

public class CropBlueWheat2 extends CropBlueWheat {
    @Override
    public boolean canGrow(ICropTile cropTile) {
        return cropTile.getCurrentSize() < 5 ? super.canGrow(cropTile) : super.canGrow(cropTile) && CropResourceBase.isBlockStateBelow(cropTile, InitBlocks.blockCrystalEmpowered.getStateFromMeta(1));
    }
}
