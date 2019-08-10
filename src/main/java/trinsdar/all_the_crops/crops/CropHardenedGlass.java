package trinsdar.all_the_crops.crops;

import cofh.thermalfoundation.init.TFBlocks;
import ic2.api.crops.ICropTile;
import net.minecraft.item.ItemStack;

public class CropHardenedGlass extends CropResourceBase {
    String oreName;
    int meta;
    public CropHardenedGlass(String id, int tier, int colorful, String[] attributes, ItemStack drop, int firstDuration, int secondDuration, int meta, int index) {
        super(id, tier, 2, 0, 0, colorful, 0, attributes, drop, firstDuration, secondDuration, index);
        this.meta = meta;
    }

    @Override
    public boolean canGrow(ICropTile cropTile) {
        return cropTile.getCurrentSize() < 3 || cropTile.getCurrentSize() == 3 && (CropResourceBase.isBlockStateBelow(cropTile, TFBlocks.blockGlass.getStateFromMeta(meta)));
    }
}
