package at.flabs.mods.energycraft;

import java.io.File;
import java.util.HashMap;

import at.flabs.mods.energycraft.electrics.ECElectrics;
import at.flabs.mods.energycraft.mechanics.ECMechanics;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Vars.modid, name = Vars.name, version = Vars.version)
@NetworkMod
public class EnergyCraft {
    
    @Instance
    public static EnergyCraft instance;
    
    @EventHandler
    public void init(FMLPreInitializationEvent evt) {
        Configuration config = new Configuration(new File(evt.getModConfigurationDirectory(), "EnergyCraft.cfg"));
        HashMap<String, Integer> ids = new HashMap<String, Integer>();
        ECMechanics.instance = new ECMechanics();
        ECElectrics.instance = new ECElectrics();
        
        config.load();
        int i = 0;
        for (String s : Vars.BIDNames) {
            ids.put(s, config.getBlock(s, Vars.startBID + i).getInt());
        }
        i = 0;
        for (String s : Vars.IIDNames) {
            ids.put(s, config.getItem(s, Vars.startIID + i).getInt());
        }
        config.save();
        
        ECMechanics.instance.init(ids);
        ECElectrics.instance.init(ids);
        LanguageRegistry.instance().loadLocalization(EnergyCraft.class.getResource("/assets/energycraft/lang/en_US.lang"), "en_US", false);
    }
    
}
