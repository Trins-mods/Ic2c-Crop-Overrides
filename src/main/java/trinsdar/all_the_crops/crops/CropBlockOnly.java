package trinsdar.all_the_crops.crops;

import ic2.api.crops.ICropTile;
import net.minecraft.item.ItemStack;

public class CropBlockOnly extends CropResourceBase {
    String oreName;
    public CropBlockOnly(String id, int tier, int colorful, String[] attributes, ItemStack drop, int firstDuration, int secondDuration, String oreName, int index) {
        super(id, tier, 2, 0, 0, colorful, 0, attributes, drop, firstDuration, secondDuration, index);
        this.oreName = oreName;
    }

    @Override
    public boolean canGrow(ICropTile cropTile) {
        return cropTile.getCurrentSize() < 3 || cropTile.getCurrentSize() == 3 && (cropTile.isBlockBelow("block" + oreName));
    }
}
