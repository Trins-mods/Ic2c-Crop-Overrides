package trinsdar.resource_crops;

import ic2.core.platform.textures.Ic2Icons;
import ic2.core.platform.textures.Sprites;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Icons {

    @SideOnly(Side.CLIENT)
    public static void loadSprites(){
        Ic2Icons.addSprite(new Sprites.SpriteData("crops", ResourceCrops.MODID + ":textures/crops.png", new Sprites.SpriteInfo(7, 1)));
        Ic2Icons.addTextureEntry(new Sprites.TextureEntry("crops", 0, 0, 7, 1));
        createAABlockSprite("block_canola_stage_1");
        createAABlockSprite("block_canola_stage_2");
        createAABlockSprite("block_canola_stage_3");
        createAABlockSprite("block_canola_stage_4");
        createAABlockSprite("block_rice_stage_1");
        createAABlockSprite("block_rice_stage_2");
        createAABlockSprite("block_rice_stage_3");
        createAABlockSprite("block_rice_stage_4");
        createAABlockSprite("block_rice_stage_5");
        createAABlockSprite("block_rice_stage_6");
        createAABlockSprite("block_flax_stage_1");
        createAABlockSprite("block_flax_stage_2");
        createAABlockSprite("block_flax_stage_3");
        createAABlockSprite("block_flax_stage_4");
        createAABlockSprite("block_flax_stage_5");
        createAABlockSprite("block_flax_stage_6");
        createAAItemSprite("item_coffee_beans");
        createAAItemSprite("item_food_rice");
        createAAItemSprite("item_misc_canola");
    }

    public static void createAABlockSprite(String id){
        Ic2Icons.addSprite(new Sprites.SpriteData(id, "actuallyadditions:textures/blocks/" + id + ".png", new Sprites.SpriteInfo(1, 1)));
        Ic2Icons.addTextureEntry(new Sprites.TextureEntry(id, 0, 0, 1, 1));
    }

    public static void createAAItemSprite(String id){
        Ic2Icons.addSprite(new Sprites.SpriteData(id, "actuallyadditions:textures/items/" + id + ".png", new Sprites.SpriteInfo(1, 1)));
        Ic2Icons.addTextureEntry(new Sprites.TextureEntry(id, 0, 0, 1, 1));
    }
}
