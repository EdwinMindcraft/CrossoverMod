package mod.mindcraft.addon.crossover;

import mantle.pulsar.config.ForgeCFG;
import mantle.pulsar.control.PulseManager;
import mod.mindcraft.addon.crossover.christmas.ChristmasThing;
import mod.mindcraft.addon.crossover.tconstruct.metallurgy.MetallurgySupport;
import mod.mindcraft.addon.crossover.tconstruct.personal.MindStuff;
import mod.mindcraft.addon.crossover.tconstruct.utils.CrossoverEventHandler;
import mod.mindcraft.addon.crossover.tconstruct.utils.TiCUtils;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid="mcrossover", name="Crossover Mod", version="WIP -- 0.0.1", dependencies="required-after:TConstruct;after:Metallurgy;after:Mekanism")
public class CrossoverMain {
	
	public static final String MODID = "mcrossover";
	private static CrossoverEventHandler eventHandler = null;
	
	PulseManager pulsar = new PulseManager("mcrossover", new ForgeCFG(MODID, "Disable any part of the support"));
	
	@EventHandler
	public void preInit (FMLPreInitializationEvent e) {
		pulsar.registerPulse(new MindStuff());
		pulsar.registerPulse(new MetallurgySupport());
		pulsar.registerPulse(new ChristmasThing());
		pulsar.preInit(e);
        eventHandler = new CrossoverEventHandler();
        FMLCommonHandler.instance().bus().register(eventHandler);
        MinecraftForge.EVENT_BUS.register(eventHandler);
        
	}
	
	@EventHandler
	public void init (FMLInitializationEvent e) {
		pulsar.init(e);
		TiCUtils.registerBoltCasting();
		TiCUtils.registerChristmasBallCasting();
	}
	
	@EventHandler
	public void postInit (FMLPostInitializationEvent e) {
		pulsar.postInit(e);
	}
}
