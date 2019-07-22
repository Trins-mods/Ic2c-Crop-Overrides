package trinsdar.resource_crops.proxy;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import trinsdar.resource_crops.Crops;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        Crops.preInit();
    }
}
