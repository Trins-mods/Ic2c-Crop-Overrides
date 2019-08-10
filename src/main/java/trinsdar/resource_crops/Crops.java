package trinsdar.resource_crops;

import com.sun.org.apache.xml.internal.security.Init;
import de.ellpeck.actuallyadditions.mod.items.InitItems;
import ic2.api.classic.crops.ClassicCrops;
import ic2.api.crops.CropCard;
import ic2.core.IC2;
import ic2.core.block.crop.Ic2Crops;
import mekanism.common.MekanismItems;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import trinsdar.resource_crops.crops.CropCanola;
import trinsdar.resource_crops.crops.CropEmpoweredBlockOnly;
import trinsdar.resource_crops.crops.CropBlockOnly;
import trinsdar.resource_crops.crops.CropFlax;
import trinsdar.resource_crops.crops.CropMiscBlockOnly;
import trinsdar.resource_crops.crops.CropHardenedGlass;
import trinsdar.resource_crops.crops.CropRice;

import java.util.LinkedHashMap;
import java.util.Map;

public class Crops {
    private static Map<CropCard, ItemStack> toRegister = new LinkedHashMap<>();
    private static ItemIcon canola = new ItemIcon("canolaIcon", "item_misc_canola");
    private static ItemIcon rice = new ItemIcon("riceIcon", "item_food_rice");
    private static ItemIcon coffee = new ItemIcon("coffeeIcon", "item_coffee_beans");
    public static CropCard cropDiamahlia = registerCrop(new CropEmpoweredBlockOnly("Diamahlia", 10, 3, new String[]{"Cyan", "Leaves", "Metal", "Gem"}, 2, new ItemStack(Items.DIAMOND), 1400, 2600, 0), new ItemStack(Items.DIAMOND));
    public static CropCard cropEmeryllis = registerCrop(new CropEmpoweredBlockOnly("Emeryllis", 10, 3, new String[]{"Green", "Leaves", "Metal", "Gem"}, 4, new ItemStack(Items.EMERALD), 1400, 2600, 1), new ItemStack(Items.EMERALD));
    public static CropCard cropBauxia = registerCrop(new CropHardenedGlass("Bauxia", 6, 1, new String[]{"LightGray", "Leaves", "Metal"}, getModMetaItem("thermalfoundation", "material", 68, 1), 800, 2000, 4, 2), getModMetaItem("thermalfoundation", "material", 68, 1));
    public static CropCard cropLimonite = registerCrop(new CropHardenedGlass("Limonite", 7, 1, new String[]{"Beige", "Leaves", "Metal"}, getModMetaItem("thermalfoundation", "material", 69, 1), 800, 2000, 5, 3), getModMetaItem("thermalfoundation", "material", 69, 1));
    public static CropCard cropOsmia = registerCrop(new CropBlockOnly("Osmia", 8, 2, new String[]{"LightBlue", "Leaves", "Metal"}, new ItemStack(MekanismItems.Dust, 1, 2), 1000, 2200, "Osmium", 4), new ItemStack(MekanismItems.Dust, 1, 2));
    public static CropCard cropSheldia = registerCrop(new CropHardenedGlass("Sheldia", 9, 2, new String[]{"Cerulean", "Leaves", "Metal"}, getModMetaItem("thermalfoundation", "material", 70, 1), 1200, 2400, 6, 5), getModMetaItem("thermalfoundation", "material", 70, 1));
    public static CropCard cropQuartzanthemum = registerCrop(new CropMiscBlockOnly("Quartzanthemum", 5, 1, new String[]{"White", "Leaves", "Metal", "Gem"}, 2, new ItemStack(Items.QUARTZ), 600, 1800, 6), new ItemStack(Items.QUARTZ));
    public static CropCard cropCanola = registerCrop(new CropCanola(), new ItemStack(canola));
    public static CropCard cropFlax = registerCrop(new CropFlax(), new ItemStack(Items.STRING));
    public static CropCard cropRice = registerCrop(new CropRice(), new ItemStack(rice));



    public static void registerCrops(){
        ClassicCrops crop = ClassicCrops.instance;
        IC2.getInstance().createItem(canola);
        IC2.getInstance().createItem(rice);
        IC2.getInstance().createItem(coffee);
        for (CropCard card : toRegister.keySet()){
            crop.registerCrop(card);
            crop.registerCropDisplayItem(card, toRegister.get(card));
        }
        crop.registerCropDisplayItem(Ic2Crops.cropCoffee, new ItemStack(coffee));
    }

    public static void registerSeeds(){
        ClassicCrops crop = ClassicCrops.instance;
        crop.registerBaseSeed(new ItemStack(InitItems.itemCanolaSeed), cropCanola,  1, 1, 1, 1);
        crop.registerBaseSeed(new ItemStack(InitItems.itemFlaxSeed), cropFlax, 1, 1, 1, 1);
        crop.registerBaseSeed(new ItemStack(InitItems.itemRiceSeed), cropRice, 1, 1, 1, 1);
        crop.registerBaseSeed(new ItemStack(InitItems.itemCoffeeSeed), Ic2Crops.cropCoffee, 1, 1, 1, 1);
    }

    public static CropCard registerCrop(CropCard card, ItemStack displayItem){
        toRegister.put(card, displayItem);
        return card;
    }

    public static ItemStack getModItem(String modname, String itemid, int amount) {
        String pair = modname + ":" + itemid;
        return new ItemStack(Item.getByNameOrId(pair), amount);
    }

    public static ItemStack getModMetaItem(String modname, String itemid, int meta, int amount) {
        String pair = modname + ":" + itemid;
        return new ItemStack(Item.getByNameOrId(pair), amount, meta);
    }
}
