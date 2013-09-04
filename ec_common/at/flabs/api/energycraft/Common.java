package at.flabs.api.energycraft;

import cpw.mods.fml.common.Loader;
import net.minecraft.creativetab.CreativeTabs;

public class Common {
    /**
     * The Creative Tab of EnergyCraft, null if not installed
     */
    public static CreativeTabs creativeTab = null;
    
    /**
     * If EnergyCraft is installed
     */
    public static boolean isInstalled(){
        return Loader.isModLoaded("energycraft");
    }
}
