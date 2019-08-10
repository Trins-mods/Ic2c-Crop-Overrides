package trinsdar.all_the_crops.crops;

import de.ellpeck.actuallyadditions.mod.items.InitItems;
import ic2.api.crops.CropProperties;
import ic2.api.crops.ICropTile;
import ic2.core.block.crop.crops.CropCardBase;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CropCanola extends CropCardBase {
    public CropCanola() {
        super(new CropProperties(2, 1, 1, 0, 5, 1));
    }

    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getTexture(int state) {
        return this.getSprite("block_canola_stage_" + state)[0];
    }

    @Override
    public String getOwner() {
        return "actuallyadditions";
    }

    @Override
    public String getId() {
        return "canola";
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
        return 4;
    }

    @Override
    public String[] getAttributes() {
        return new String[]{"Canola", "Flower", "Yellow"};
    }

    @Override
    public boolean canGrow(ICropTile cropTile) {
        return cropTile.getCurrentSize() <= 3 && cropTile.getLightLevel() >= 10;
    }

    @Override
    public boolean canBeHarvested(ICropTile cropTile) {
        return cropTile.getCurrentSize() == 4;
    }

    @Override
    public ItemStack getGain(ICropTile crop) {
        return new ItemStack(InitItems.itemMisc, 1, 13);
    }

    @Override
    public ItemStack getSeeds(ICropTile crop) {
        return new ItemStack(InitItems.itemCanolaSeed);
    }

    @Override
    public int getSizeAfterHarvest(ICropTile cropTile) {
        return 3;
    }

    @Override
    public int getGrowthDuration(ICropTile cropTile) {
        return cropTile.getCurrentSize() == 3 ? 600 : 400;
    }

    @Override
    public int getOptimalHarvestSize(ICropTile cropTile) {
        return 4;
    }
}
