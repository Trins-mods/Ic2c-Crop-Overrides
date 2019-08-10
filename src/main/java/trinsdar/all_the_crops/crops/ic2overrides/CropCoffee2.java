package trinsdar.all_the_crops.crops.ic2overrides;

import de.ellpeck.actuallyadditions.mod.items.InitItems;
import ic2.api.crops.ICropTile;
import ic2.core.block.crop.crops.CropCoffee;
import net.minecraft.item.ItemStack;

public class CropCoffee2 extends CropCoffee {
    @Override
    public ItemStack getGain(ICropTile crop) {
        return new ItemStack(InitItems.itemCoffeeBean);
    }

    @Override
    public ItemStack getSeeds(ICropTile crop) {
        return new ItemStack(InitItems.itemCoffeeSeed);
    }
}
