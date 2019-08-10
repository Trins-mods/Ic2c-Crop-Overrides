package trinsdar.all_the_crops.crops;

import de.ellpeck.actuallyadditions.mod.blocks.InitBlocks;
import ic2.api.crops.ICropTile;
import net.minecraft.item.ItemStack;

public class CropEmpoweredBlockOnly extends CropResourceBase {
    int meta;

    public CropEmpoweredBlockOnly(String id, int tier, int colorful, String[] attributes, int meta, ItemStack drop, int firstDuration, int secondDuration, int index) {
        super(id, tier, 2, 0, 0, colorful, 0, attributes, drop, firstDuration, secondDuration, index);
        this.meta = meta;
    }

    @Override
    public boolean canGrow(ICropTile cropTile) {
        return cropTile.getCurrentSize() < 3 || cropTile.getCurrentSize() == 3 && (isBlockStateBelow(cropTile, InitBlocks.blockCrystalEmpowered.getStateFromMeta(meta)));
    }


}
