package trinsdar.ic2c_crop_overrides.crops.ic2overrides;

import de.ellpeck.actuallyadditions.mod.blocks.InitBlocks;
import ic2.api.crops.ICropTile;
import ic2.core.block.crop.crops.CropAurelia;
import net.minecraft.item.ItemStack;
import trinsdar.ic2c_crop_overrides.Crops;
import trinsdar.ic2c_crop_overrides.crops.CropResourceBase;

public class CropAurelia2 extends CropAurelia {
    @Override
    public boolean canGrow(ICropTile cropTile) {
        return cropTile.getCurrentSize() < 3 || cropTile.getCurrentSize() == 3 && (CropResourceBase.isBlockStateBelow(cropTile, InitBlocks.blockCrystalEmpowered.getStateFromMeta(3)));
    }

    @Override
    public ItemStack getGain(ICropTile crop) {
        return Crops.getModMetaItem("thermalfoundation", "material", 1, 1).copy();
    }
}
