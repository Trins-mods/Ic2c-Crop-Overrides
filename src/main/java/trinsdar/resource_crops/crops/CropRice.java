package trinsdar.resource_crops.crops;

import de.ellpeck.actuallyadditions.mod.items.InitItems;
import ic2.api.crops.CropProperties;
import ic2.api.crops.ICropTile;
import ic2.core.block.crop.crops.CropCardBase;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CropRice extends CropCardBase {
    public CropRice() {
        super(new CropProperties(1, 0, 4, 0, 1, 1));
    }

    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getTexture(int state) {
        int secondState = state - 1;
        return state < 3 ? this.getSprite("block_rice_stage_" + state)[0] : this.getSprite("block_rice_stage_" + secondState)[0];
    }

    @Override
    public String getOwner() {
        return "actuallyadditions";
    }

    @Override
    public String getId() {
        return "rice";
    }

    @Override
    public String getUnlocalizedName() {
        return "actuallyadditions.crop." + this.getId() + ".name";
    }

    @Override
    public String getDiscoveredBy() {
        return "Oly206";
    }

    @Override
    public int getMaxSize() {
        return 7;
    }

    @Override
    public String[] getAttributes() {
        return new String[]{"White", "Rice", "Food", "Wheat"};
    }

    @Override
    public boolean canGrow(ICropTile cropTile) {
        return cropTile.getCurrentSize() <= 6 && cropTile.getLightLevel() >= 10 && cropTile.getTerrainHumidity() >= 10;
    }

    @Override
    public boolean canBeHarvested(ICropTile cropTile) {
        return cropTile.getCurrentSize() == 7;
    }

    @Override
    public ItemStack getGain(ICropTile crop) {
        return new ItemStack(InitItems.itemFoods, 1, 16);
    }

    @Override
    public ItemStack getSeeds(ICropTile crop) {
        return new ItemStack(InitItems.itemRiceSeed);
    }

    @Override
    public int getSizeAfterHarvest(ICropTile cropTile) {
        return 2;
    }

    @Override
    public int getGrowthDuration(ICropTile cropTile) {
        return 200;
    }

    @Override
    public int getOptimalHarvestSize(ICropTile cropTile) {
        return 7;
    }
}
