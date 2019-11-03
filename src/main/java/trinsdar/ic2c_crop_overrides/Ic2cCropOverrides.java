package trinsdar.ic2c_crop_overrides;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import de.ellpeck.actuallyadditions.mod.items.InitItems;
import ic2.api.classic.recipe.ClassicRecipes;
import ic2.core.IC2;
import ic2.core.block.crop.Ic2Crops;
import ic2.core.block.machine.low.TileEntityMacerator;
import ic2.core.platform.registry.Ic2Items;
import ic2.core.util.misc.StackUtil;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.logging.log4j.Logger;
import trinsdar.ic2c_crop_overrides.crops.CropRedWheat2;

import java.io.File;

@Mod(modid = Ic2cCropOverrides.MODID, name = Ic2cCropOverrides.NAME, version = Ic2cCropOverrides.VERSION, dependencies = Ic2cCropOverrides.DEPENDS)
public class Ic2cCropOverrides {
    public static final String MODID = "ic2c_crop_overrides";
    public static final String NAME = "Ic2c Crop Overrides";
    public static final String VERSION = "@VERSION@";
    public static final String DEPENDS = "required-after:ic2;required-after:ic2-classic-spmod;after:ic2c_extras";

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        logger = event.getModLog();
        MinecraftForge.EVENT_BUS.register(this);
        Ic2Crops.cropRedwheat = new CropRedWheat2();
        Ic2Crops.instance.registerCrop(Ic2Crops.cropRedwheat);
        if (Ic2cCropsConfig.generateExampleJson){
            JsonMaker.init(event);
        }
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        if (Ic2cCropsConfig.redwheat.changeDrops){
            Ic2Crops.instance.registerCropDisplayItem(Ic2Crops.cropRedwheat, GameRegistry.makeItemStack(Ic2cCropsConfig.redwheat.drop2, Ic2cCropsConfig.redwheat.drop2Meta, 1, null));
        }
        CropJsonLoader.load(getObject(new File(IC2.configFolder, "overrideCrops.json")));
    }

    @SubscribeEvent
    public void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.getModID().equals(MODID))
        {
            ConfigManager.sync(MODID, Config.Type.INSTANCE);
        }
    }

    private JsonObject getObject(File file) {
        try {
            if (file.exists()) {
                JsonElement obj = IC2.parser.parse(Files.toString(file, Charsets.UTF_8));
                if (obj != null && obj.isJsonObject()) {
                    return obj.getAsJsonObject();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new JsonObject();
    }
}
