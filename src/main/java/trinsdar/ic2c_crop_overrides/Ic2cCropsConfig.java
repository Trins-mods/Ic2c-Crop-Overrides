package trinsdar.ic2c_crop_overrides;

import ic2.core.block.crop.Ic2Crops;
import net.minecraftforge.common.config.Config;

@Config( modid = Ic2cCropOverrides.MODID, name = "ic2/ic2c_crop_overrides")
public class Ic2cCropsConfig {

    @Config.Comment({
            "Use this to override redwheat if you want the drops to still use the redstone affected drop configuration.",
            "Currently only usable for overriding the drops and whether it requires a block underneath"
    })
    @Config.RequiresMcRestart
    public static Redwheat redwheat = new Redwheat();

    public static class Redwheat{
        @Config.Comment("Determines whether or not the drops of redwheat are changed. Will also change the display item of redwheat to be the second drop if true.")
        public boolean changeDrops = false;

        @Config.Comment("Name of item. format is modid:itemid.")
        public String drop1 = "minecraft:wheat";

        @Config.RangeInt(min = 0)
        public int drop1Meta = 0;

        @Config.Comment("Name of item. format is modid:itemid.")
        public String drop2 = "minecraft:redstone";

        @Config.RangeInt(min = 0)
        public int drop2Meta = 0;

        @Config.Comment("Determines whether or not redwheat requires a block underneath.")
        public boolean addRequiredBlock = false;

        @Config.Comment("Determines whether or not the block underneath looks for an oredict or exact block name.")
        public boolean ore = false;

        @Config.Comment("Name of block or oredict. format for block is modid:blockid; format for oredict is orename, for example blockCopper. ")
        public String blockName = "modid:blockid";

        @Config.RangeInt(min = 0, max = 15)
        public int blockMeta = 0;
    }
}
