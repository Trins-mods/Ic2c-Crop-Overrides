package trinsdar.resource_crops;

import ic2.core.block.crop.Ic2Crops;
import net.minecraftforge.fml.common.Mod;
import trinsdar.resource_crops.crops.ic2overrides.CropAurelia2;
import trinsdar.resource_crops.crops.ic2overrides.CropBlueWheat2;
import trinsdar.resource_crops.crops.ic2overrides.CropFerru2;
import trinsdar.resource_crops.crops.ic2overrides.CropRedWheat2;

@Mod(modid = ResourceCrops.MODID, name = ResourceCrops.NAME, version = ResourceCrops.VERSION, dependencies = ResourceCrops.DEPENDS)
public class ResourceCrops {
    public static final String MODID = "resource_crops";
    public static final String NAME = "Resource Crops";
    public static final String VERSION = "@VERSION@";
    public static final String DEPENDS = "required-after:ic2;required-after:ic2-classic-spmod;";

    static {
        Ic2Crops.cropAurelia = new CropAurelia2();
        Ic2Crops.cropFerru = new CropFerru2();
        Ic2Crops.cropBluewheat = new CropBlueWheat2();
        Ic2Crops.cropRedwheat = new CropRedWheat2();
    }
}
