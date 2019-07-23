package trinsdar.resource_crops.crops.ic2overrides;

import de.ellpeck.actuallyadditions.mod.blocks.InitBlocks;
import ic2.api.crops.ICropTile;
import ic2.core.block.crop.crops.CropFerru;
import net.minecraft.item.ItemStack;
import trinsdar.resource_crops.Crops;
import trinsdar.resource_crops.crops.CropResourceBase;

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
