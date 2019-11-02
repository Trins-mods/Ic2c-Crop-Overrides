package trinsdar.ic2c_crop_overrides;

import ic2.api.crops.CropCard;
import trinsdar.ic2c_extras.util.Registry;

public class Ic2cExtrasCompat {
    public static CropCard getCrop(){
        return Registry.cropPlumbilia;
    }
}
