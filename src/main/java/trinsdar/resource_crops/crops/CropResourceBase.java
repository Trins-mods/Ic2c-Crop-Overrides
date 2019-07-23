package trinsdar.resource_crops.crops;

import ic2.api.crops.CropProperties;
import ic2.api.crops.ICropTile;
import ic2.core.block.crop.crops.CropCardBase;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class CropResourceBase extends CropCardBase {
    String[] attributes;
    String id;
    ItemStack drop;
    int firstDuration;
    int secondDuration;
    int index;
    public CropResourceBase(String id, int tier, int chemistry, int consumable, int defensive, int colorful, int weed, String[] attributes, ItemStack drop, int firstDuration, int secondDuration, int index) {
        super(new CropProperties(tier, chemistry, consumable, defensive, colorful, weed));
        this.attributes = attributes;
        this.id = id;
        this.drop = drop;
        this.firstDuration = firstDuration;
        this.secondDuration = secondDuration;
        this.index = index;
    }

    @Override
    public String getOwner() {
        return "resource";
    }

    @Override
    public String getUnlocalizedName() {
        return "resource.crop." + this.getId() + ".name";
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String[] getAttributes() {
        return attributes;
    }

    @Override
    public ItemStack getGain(ICropTile iCropTile) {
        return drop;
    }

    @Override
    public double dropGainChance() {
        return super.dropGainChance() / 2.0D;
    }

    @Override
    public int getGrowthDuration(ICropTile cropTile) {
        return cropTile.getCurrentSize() == 3 ? secondDuration : firstDuration;
    }

    @Override
    public int getMaxSize() {
        return 4;
    }

    @Override
    public int getOptimalHarvestSize(ICropTile cropTile) {
        return 4;
    }

    @Override
    public boolean canBeHarvested(ICropTile cropTile) {
        return cropTile.getCurrentSize() == 4;
    }

    @Override
    public int getSizeAfterHarvest(ICropTile cropTile) {
        return 2;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public TextureAtlasSprite getTexture(int state) {
        return state == 4 ? this.getSprite("crops")[index] : this.getSprite("bc")[31 + state];
    }

    public static boolean isBlockStateBelow(ICropTile tile, IBlockState state){
        return tile.getWorldObj().getBlockState(tile.getPosition().down(2)) == state;
    }
}
