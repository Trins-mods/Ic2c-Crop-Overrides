package trinsdar.resource_crops.crops;

import de.ellpeck.actuallyadditions.mod.blocks.InitBlocks;
import ic2.api.crops.CropProperties;
import ic2.api.crops.ICropTile;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.ItemStack;

public class CropAABlockOnly extends CropResourceBase {
    IBlockState blockUnderneath;

    public CropAABlockOnly(String id, int tier, int colorful, String[] attributes, IBlockState blockUnderneath, ItemStack drop, int firstDuration, int secondDuration, int index) {
        super(id, tier, 2, 0, 0, colorful, 0, attributes, drop, firstDuration, secondDuration, index);
        this.blockUnderneath = blockUnderneath;

    }

    @Override
    public boolean canGrow(ICropTile cropTile) {
        return cropTile.getCurrentSize() < 3 || cropTile.getCurrentSize() == 3 && (CropResourceBase.isBlockStateBelow(cropTile, blockUnderneath));
    }


}
