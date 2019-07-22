package trinsdar.resource_crops;

import net.minecraftforge.fml.common.Mod;

@Mod(modid = ResourceCrops.MODID, name = ResourceCrops.NAME, version = ResourceCrops.VERSION, dependencies = ResourceCrops.DEPENDS)
public class ResourceCrops {
    public static final String MODID = "resource_crops";
    public static final String NAME = "Resource Crops";
    public static final String VERSION = "@VERSION@";
    public static final String DEPENDS = "required-after:ic2;required-after:ic2-classic-spmod;";
}
