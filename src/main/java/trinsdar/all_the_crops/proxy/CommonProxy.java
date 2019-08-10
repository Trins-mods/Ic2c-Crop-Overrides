package trinsdar.all_the_crops.proxy;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import trinsdar.all_the_crops.Crops;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        Crops.registerCrops();
    }
}
