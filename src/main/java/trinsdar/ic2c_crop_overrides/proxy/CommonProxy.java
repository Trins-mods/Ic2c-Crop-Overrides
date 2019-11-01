package trinsdar.ic2c_crop_overrides.proxy;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import trinsdar.ic2c_crop_overrides.Crops;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        Crops.registerCrops();
    }
}
