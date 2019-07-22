package trinsdar.resource_crops;

import ic2.core.platform.textures.Ic2Icons;
import ic2.core.platform.textures.Sprites;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Icons {

    @SideOnly(Side.CLIENT)
    public static void loadSprites(){
        Ic2Icons.addSprite(new Sprites.SpriteData("crops", ResourceCrops.MODID + ":textures/sprites/crops.png", new Sprites.SpriteInfo(7, 1)));
        Ic2Icons.addTextureEntry(new Sprites.TextureEntry("crops", 0, 0, 7, 1));
    }
}
