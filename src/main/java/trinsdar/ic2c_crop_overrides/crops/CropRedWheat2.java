package trinsdar.ic2c_crop_overrides.crops;

import ic2.api.crops.ICropTile;
import ic2.core.IC2;
import ic2.core.block.crop.crops.CropRedWheat;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import trinsdar.ic2c_crop_overrides.Ic2cCropOverrides;
import trinsdar.ic2c_crop_overrides.Ic2cCropsConfig;

public class CropRedWheat2 extends CropRedWheat {
    boolean changeDrops;
    String drop1;
    int drop1Meta;
    String drop2;
    int drop2Meta;
    boolean addRequiredBlock;
    boolean ore;
    String blockName;
    int blockMeta;

    public CropRedWheat2(){
        super();
        changeDrops = Ic2cCropsConfig.redwheat.changeDrops;
        drop1 = Ic2cCropsConfig.redwheat.drop1;
        drop1Meta = Ic2cCropsConfig.redwheat.drop1Meta;
        drop2 = Ic2cCropsConfig.redwheat.drop2;
        drop2Meta = Ic2cCropsConfig.redwheat.drop2Meta;
        addRequiredBlock = Ic2cCropsConfig.redwheat.addRequiredBlock;
        ore = Ic2cCropsConfig.redwheat.ore;
        blockName = Ic2cCropsConfig.redwheat.blockName;
        blockMeta = Ic2cCropsConfig.redwheat.blockMeta;
    }

    @Override
    public boolean canGrow(ICropTile cropTile) {
        if (addRequiredBlock){
            if (ore){
                return cropTile.getCurrentSize() < 5 ? super.canGrow(cropTile) : super.canGrow(cropTile) && cropTile.isBlockBelow(blockName);
            } else {
                Block block = Block.getBlockFromName(blockName);
                if (block != null){
                    if (blockMeta == 0){
                        return cropTile.getCurrentSize() < 5 ? super.canGrow(cropTile) : super.canGrow(cropTile) && cropTile.isBlockBelow(block);
                    }
                    return cropTile.getCurrentSize() < 5 ? super.canGrow(cropTile) : super.canGrow(cropTile) && isBlockStateBelow(cropTile, block.getStateFromMeta(blockMeta));
                }

            }
        }
        return super.canGrow(cropTile);
    }

    @Override
    public ItemStack getGain(ICropTile crop) {
        if (changeDrops){
            return !this.getWorld(crop).isBlockPowered(crop.getLocation()) && !IC2.random.nextBoolean() ? GameRegistry.makeItemStack(drop1, drop1Meta, 1, null) : GameRegistry.makeItemStack(drop2, drop2Meta, 1, null);
        }
        return super.getGain(crop);
    }

    public static boolean isBlockStateBelow(ICropTile tile, IBlockState state){
        return tile.getWorldObj().getBlockState(tile.getPosition().down(2)) == state;
    }
}
