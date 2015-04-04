package mod.mindcraft.addon.crossover;

import java.util.ArrayList;
import java.util.logging.Logger;

import mantle.pulsar.config.ForgeCFG;
import mantle.pulsar.control.PulseManager;
import mod.mindcraft.addon.crossover.christmas.ChristmasThing;
import mod.mindcraft.addon.crossover.tconstruct.enderio.EnderIOSupport;
import mod.mindcraft.addon.crossover.tconstruct.mekanism.MekanismSupport;
import mod.mindcraft.addon.crossover.tconstruct.metallurgy.MetallurgySupport;
import mod.mindcraft.addon.crossover.tconstruct.personal.MindStuff;
import mod.mindcraft.addon.crossover.tconstruct.utils.CrossoverEventHandler;
import mod.mindcraft.addon.crossover.tconstruct.utils.TiCUtils;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid="mcrossover", name="Crossover Mod", version="WIP -- 0.0.1", dependencies="required-after:TConstruct;after:Metallurgy;after:Mekanism;after:EnderIO")
public class CrossoverMain {
	
	public static final String MODID = "mcrossover";
	private static CrossoverEventHandler eventHandler = null;
	public static Logger log = Logger.getLogger("MCrossover");
	
	PulseManager pulsar = new PulseManager("mcrossover", new ForgeCFG(MODID, "Disable any part of the support"));
	
	@EventHandler
	public void preInit (FMLPreInitializationEvent e) {
		pulsar.registerPulse(new MindStuff());
		pulsar.registerPulse(new MetallurgySupport());
		pulsar.registerPulse(new ChristmasThing());
		pulsar.registerPulse(new EnderIOSupport());
		pulsar.registerPulse(new MekanismSupport());
		pulsar.preInit(e);
        eventHandler = new CrossoverEventHandler();
        FMLCommonHandler.instance().bus().register(eventHandler);
        MinecraftForge.EVENT_BUS.register(eventHandler);
	}
	
	@EventHandler
	public void init (FMLInitializationEvent e) {
		pulsar.init(e);
		TiCUtils.registerBoltCasting();
	}
	
	@EventHandler
	public void postInit (FMLPostInitializationEvent e) {
		pulsar.postInit(e);
	}
	

	
	public static void addBlockRecipe (Item ingot, Block block) {
		GameRegistry.addShapelessRecipe(new ItemStack(ingot, 9), block);
		GameRegistry.addRecipe(new ItemStack(block), new Object[]{
			"###",
			"###",
			"###",
			Character.valueOf('#'), ingot
		});	
	}
	
	
	public static void addOreProcess(Item ingot, Block block, Block ore) {
		addBlockRecipe(ingot, block);
		GameRegistry.addSmelting(new ItemStack(ore), new ItemStack(ingot), 0.2F);
	}
	
	public static Block getBlockFromOreDictinaryName(String name) {
		ArrayList<ItemStack> list = OreDictionary.getOres(name);
		if ((list.size() != 0)){
			return Block.getBlockFromItem(list.get(0).getItem());
		}
		else {
			log.severe("Block : " + name + " is undefined in OreDictinary");
			log.severe("You should never have seen tyhis message, if you do, please check your code");
			
			return null;
		}
	}
	
	public static Item getItemFromOreDictinaryName(String name) {
		ArrayList<ItemStack> list = OreDictionary.getOres(name);
		if ((list.size() != 0)){
			return list.get(0).getItem();
		}
		else {
			log.severe("Item : " + name + " is undefined in OreDictinary");
			log.severe("You should never have seen tyhis message, if you do, please check your code");
			
			return null;
		}
	}
	
	public static ItemStack getItemStackFromOreDictinaryName(String name) {
		ArrayList<ItemStack> list = OreDictionary.getOres(name);
		if (list.size() != 0){
			return list.get(0);
		}
		else {
			log.severe("ItemStack : " + name + " is undefined in OreDictinary");
			log.severe("You should never have seen tyhis message, if you do, please check your code");
			
			return null;
		}
	}
}
