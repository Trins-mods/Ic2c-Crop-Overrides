package trinsdar.all_the_crops.crops.ic2overrides;

import de.ellpeck.actuallyadditions.mod.blocks.InitBlocks;
import ic2.api.crops.ICropTile;
import ic2.core.block.crop.crops.CropAurelia;
import net.minecraft.item.ItemStack;
import trinsdar.all_the_crops.Crops;
import trinsdar.all_the_crops.crops.CropResourceBase;

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
