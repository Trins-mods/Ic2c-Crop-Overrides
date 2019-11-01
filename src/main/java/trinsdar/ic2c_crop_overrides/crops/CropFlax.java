package trinsdar.ic2c_crop_overrides.crops;

import de.ellpeck.actuallyadditions.mod.items.InitItems;
import ic2.api.crops.CropProperties;
import ic2.api.crops.ICropTile;
import ic2.core.block.crop.crops.CropCardBase;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CropFlax extends CropCardBase {
    public CropFlax() {
        super(new CropProperties(2, 1, 2, 0, 3, 0));
    }

    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getTexture(int state) {
        return this.getSprite("block_flax_stage_" + state)[0];
    }

    @Override
    public String getOwner() {
        return "actuallyadditions";
    }

    @Override
    public String getId() {
        return "flax";
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
        return 6;
    }

    @Override
    public String[] getAttributes() {
        return new String[]{"Magenta", "Leaves", "Ingredient"};
    }

    @Override
    public boolean canGrow(ICropTile cropTile) {
        return cropTile.getCurrentSize() <= 5 && cropTile.getLightLevel() >= 10;
    }

    @Override
    public boolean canBeHarvested(ICropTile cropTile) {
        return cropTile.getCurrentSize() == 6;
    }

    @Override
    public ItemStack getGain(ICropTile crop) {
        return new ItemStack(Items.STRING, 1);
    }

    @Override
    public ItemStack getSeeds(ICropTile crop) {
        return new ItemStack(InitItems.itemFlaxSeed);
    }

    @Override
    public int getSizeAfterHarvest(ICropTile cropTile) {
        return 4;
    }

    @Override
    public int getGrowthDuration(ICropTile cropTile) {
        return cropTile.getCurrentSize() < 4 ? 300 : 200;
    }

    @Override
    public int getOptimalHarvestSize(ICropTile cropTile) {
        return 6;
    }
}
