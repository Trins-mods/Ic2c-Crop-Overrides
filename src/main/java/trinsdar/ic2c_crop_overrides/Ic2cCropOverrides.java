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
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import trinsdar.ic2c_extras.util.Registry;
import trinsdar.ic2c_crop_overrides.crops.ic2overrides.CropArgentum2;
import trinsdar.ic2c_crop_overrides.crops.ic2overrides.CropAurelia2;
import trinsdar.ic2c_crop_overrides.crops.ic2overrides.CropBlueWheat2;
import trinsdar.ic2c_crop_overrides.crops.ic2overrides.CropCoffee2;
import trinsdar.ic2c_crop_overrides.crops.ic2overrides.CropFerru2;
import trinsdar.ic2c_crop_overrides.crops.ic2overrides.CropMalachite2;
import trinsdar.ic2c_crop_overrides.crops.ic2overrides.CropPlumbilia2;
import trinsdar.ic2c_crop_overrides.crops.ic2overrides.CropRedWheat2;
import trinsdar.ic2c_crop_overrides.crops.ic2overrides.CropStannum2;
import trinsdar.ic2c_crop_overrides.proxy.CommonProxy;

import java.io.File;

@Mod(modid = Ic2cCropOverrides.MODID, name = Ic2cCropOverrides.NAME, version = Ic2cCropOverrides.VERSION, dependencies = Ic2cCropOverrides.DEPENDS)
public class Ic2cCropOverrides {
    public static final String MODID = "ic2c_crop_overrides";
    public static final String NAME = "Ic2c Crop Overrides";
    public static final String VERSION = "@VERSION@";
    public static final String DEPENDS = "required-after:ic2;required-after:ic2-classic-spmod;required-after:actuallyadditions;required-after:thermalfoundation;required-after:mekanism;required-after:ic2c_extras";

    @SidedProxy(clientSide = "trinsdar." + MODID + ".proxy.ClientProxy", serverSide = "trinsdar." + MODID + ".proxy.CommonProxy")
    public static CommonProxy proxy;

    public static Logger logger;

    static {

    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        proxy.preInit(event);
        logger = event.getModLog();
        Ic2Crops.cropArgentum = new CropArgentum2();
        Ic2Crops.cropAurelia = new CropAurelia2();
        //Ic2Crops.cropFerru = new CropFerru2();
        Ic2Crops.cropMalachite = new CropMalachite2();
        Registry.cropPlumbilia = new CropPlumbilia2();
        Ic2Crops.cropStannum = new CropStannum2();
        Ic2Crops.cropBluewheat = new CropBlueWheat2();
        Ic2Crops.cropRedwheat = new CropRedWheat2();
        Ic2Crops.cropCoffee = new CropCoffee2();
        Ic2Crops crops = Ic2Crops.instance;
        crops.registerCropDisplayItem(Ic2Crops.cropArgentum, Crops.getModMetaItem("thermalfoundation", "material", 66, 1));
        crops.registerCropDisplayItem(Ic2Crops.cropAurelia, Crops.getModMetaItem("thermalfoundation", "material", 1, 1));
        //crops.registerCropDisplayItem(Ic2Crops.cropFerru, Crops.getModMetaItem("thermalfoundation", "material", 0, 1));
        crops.registerCropDisplayItem(Ic2Crops.cropMalachite, Crops.getModMetaItem("thermalfoundation", "material", 64, 1));
        crops.registerCropDisplayItem(Registry.cropPlumbilia, Crops.getModMetaItem("thermalfoundation", "material", 67, 1));
        crops.registerCropDisplayItem(Ic2Crops.cropStannum, Crops.getModMetaItem("thermalfoundation", "material", 65, 1));


    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        ClassicRecipes.advCrafting.addShapelessRecipe(Ic2Items.coffeePowder, InitItems.itemCoffeeBean);
        TileEntityMacerator.addRecipe(new ItemStack(InitItems.itemCoffeeBean), StackUtil.copyWithSize(Ic2Items.coffeePowder, 3));
        Crops.registerSeeds();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        CropJsonLoader.load(getObject(new File(IC2.configFolder, "overrideCrops.json")));
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
