package trinsdar.resource_crops;

import com.sun.scenario.effect.Crop;
import de.ellpeck.actuallyadditions.mod.blocks.InitBlocks;
import de.ellpeck.actuallyadditions.mod.items.InitItems;
import ic2.api.classic.crops.ClassicCrops;
import ic2.api.crops.CropCard;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import trinsdar.resource_crops.crops.CropAABlockOnly;
import trinsdar.resource_crops.crops.CropBlockOnly;
import trinsdar.resource_crops.crops.CropOreAndBlock;

import java.util.HashMap;
import java.util.Map;

public class Crops {
    private static Map<CropCard, ItemStack> toRegister = new HashMap<>();
    public static CropCard cropDiamahlia = registerCrop(new CropAABlockOnly("Diamahlia", 10, 3, new String[]{"Cyan", "Leaves", "Metal", "Gem"}, InitBlocks.blockCrystalEmpowered.getStateFromMeta(2), new ItemStack(Items.DIAMOND), 1400, 2600, 0), new ItemStack(Items.DIAMOND));
    public static CropCard cropEmeryllis = registerCrop(new CropAABlockOnly("Emeryllis", 10, 3, new String[]{"Green", "Leaves", "Metal", "Gem"}, InitBlocks.blockCrystalEmpowered.getStateFromMeta(4), new ItemStack(Items.EMERALD), 1400, 2600, 1), new ItemStack(Items.EMERALD));
    public static CropCard cropBauxia = registerCrop(new CropOreAndBlock("Bauxia", 6, 1, new String[]{"LightGray", "Leaves", "Metal"}, getModMetaItem("thermalfoundation", "material", 68, 1), 800, 2000, "Aluminum", 2), getModMetaItem("thermalfoundation", "material", 68, 1));
    public static CropCard cropLimonite = registerCrop(new CropOreAndBlock("Limonite", 7, 1, new String[]{"Beige", "Leaves", "Metal"}, getModMetaItem("thermalfoundation", "material", 69, 1), 800, 2000, "Nickel", 3), getModMetaItem("thermalfoundation", "material", 69, 1));
    public static CropCard cropOsmia = registerCrop(new CropBlockOnly("Osmia", 8, 2, new String[]{"LightBlue", "Leaves", "Metal"}, getModMetaItem("mekanism", "dust", 2, 1), 1000, 2200, "Osmium", 4), getModMetaItem("mekanism", "dust", 2, 1));
    public static CropCard cropSheldia = registerCrop(new CropOreAndBlock("Sheldia", 9, 2, new String[]{"Cerulean", "Leaves", "Metal"}, getModMetaItem("thermalfoundation", "material", 70, 1), 1200, 2400, "Platinum", 5), getModMetaItem("thermalfoundation", "material", 70, 1));
    public static CropCard cropQuartzanthemum = registerCrop(new CropAABlockOnly("Quartzanthemum", 5, 1, new String[]{"White", "Leaves", "Metal", "Gem"}, InitBlocks.blockMisc.getStateFromMeta(2), new ItemStack(Items.QUARTZ), 600, 1800, 6), new ItemStack(Items.QUARTZ));

    public static void registerCrops(){
        ClassicCrops crop = ClassicCrops.instance;
        for (CropCard card : toRegister.keySet()){
            crop.registerCrop(card);
            crop.registerCropDisplayItem(card, toRegister.get(card));
        }
    }

    public static CropCard registerCrop(CropCard card, ItemStack displayItem){
        toRegister.put(card, displayItem);
        return card;
    }

    public static ItemStack getModItem(String modname, String itemid, int amount) {
        String pair = modname + ":" + itemid;
        return new ItemStack(Item.getByNameOrId(pair), amount);
    }


    public static ItemStack getModMetaItem(String modname, String itemid, int meta, int size) {
        String pair = modname + ":" + itemid;
        return GameRegistry.makeItemStack(pair, meta, size, null);
    }
}
