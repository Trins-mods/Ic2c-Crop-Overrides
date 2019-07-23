package trinsdar.resource_crops;

import ic2.core.block.crop.Ic2Crops;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import trinsdar.ic2c_extras.util.Registry;
import trinsdar.resource_crops.crops.ic2overrides.CropArgentum2;
import trinsdar.resource_crops.crops.ic2overrides.CropAurelia2;
import trinsdar.resource_crops.crops.ic2overrides.CropBlueWheat2;
import trinsdar.resource_crops.crops.ic2overrides.CropFerru2;
import trinsdar.resource_crops.crops.ic2overrides.CropMalachite2;
import trinsdar.resource_crops.crops.ic2overrides.CropPlumbilia2;
import trinsdar.resource_crops.crops.ic2overrides.CropRedWheat2;
import trinsdar.resource_crops.crops.ic2overrides.CropStannum2;
import trinsdar.resource_crops.proxy.CommonProxy;

@Mod(modid = ResourceCrops.MODID, name = ResourceCrops.NAME, version = ResourceCrops.VERSION, dependencies = ResourceCrops.DEPENDS)
public class ResourceCrops {
    public static final String MODID = "resource_crops";
    public static final String NAME = "Resource Crops";
    public static final String VERSION = "@VERSION@";
    public static final String DEPENDS = "required-after:ic2;required-after:ic2-classic-spmod;required-after:actuallyadditions;required-after:thermalfoundation;required-after:mekanism";

    @SidedProxy(clientSide = "trinsdar." + MODID + ".proxy.ClientProxy", serverSide = "trinsdar." + MODID + ".proxy.CommonProxy")
    public static CommonProxy proxy;

    static {
        Ic2Crops.cropArgentum = new CropArgentum2();
        Ic2Crops.cropAurelia = new CropAurelia2();
        Ic2Crops.cropFerru = new CropFerru2();
        Ic2Crops.cropMalachite = new CropMalachite2();
        Registry.cropPlumbilia = new CropPlumbilia2();
        Ic2Crops.cropStannum = new CropStannum2();
        Ic2Crops.cropBluewheat = new CropBlueWheat2();
        Ic2Crops.cropRedwheat = new CropRedWheat2();
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        proxy.preInit(event);
        Ic2Crops crops = Ic2Crops.instance;
        System.out.println(Crops.getModMetaItem("thermalfoundation", "material", 66, 1));
        crops.registerCropDisplayItem(Ic2Crops.cropArgentum, Crops.getModMetaItem("thermalfoundation", "material", 66, 1));
        crops.registerCropDisplayItem(Ic2Crops.cropAurelia, Crops.getModMetaItem("thermalfoundation", "material", 1, 1));
        crops.registerCropDisplayItem(Ic2Crops.cropFerru, Crops.getModMetaItem("thermalfoundation", "material", 0, 1));
        crops.registerCropDisplayItem(Ic2Crops.cropMalachite, Crops.getModMetaItem("thermalfoundation", "material", 64, 1));
        crops.registerCropDisplayItem(Registry.cropPlumbilia, Crops.getModMetaItem("thermalfoundation", "material", 67, 1));
        crops.registerCropDisplayItem(Ic2Crops.cropStannum, Crops.getModMetaItem("thermalfoundation", "material", 65, 1));
    }
}
