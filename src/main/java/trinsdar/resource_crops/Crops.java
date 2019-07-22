package trinsdar.resource_crops;

import de.ellpeck.actuallyadditions.mod.blocks.InitBlocks;
import de.ellpeck.actuallyadditions.mod.items.InitItems;
import ic2.api.crops.CropCard;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import trinsdar.resource_crops.crops.CropAABlockOnly;

public class Crops {
    public static CropCard cropDiamahlia = new CropAABlockOnly("Diamahlia", 10, 3, new String[]{"Cyan", "Leaves", "Metal", "Gem"}, InitBlocks.blockCrystalEmpowered.getStateFromMeta(2), new ItemStack(Items.DIAMOND), 1400, 2600, 0);

    public static void preInit(){

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
