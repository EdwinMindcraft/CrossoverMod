package mod.mindcraft.addon.crossover.tconstruct.enderio;

import java.io.IOException;
import java.util.Map.Entry;

import mantle.pulsar.pulse.Handler;
import mantle.pulsar.pulse.Pulse;
import mod.mindcraft.addon.crossover.CrossoverMain;
import mod.mindcraft.addon.crossover.config.ConfigHandler;
import mod.mindcraft.addon.crossover.config.Stats;
import mod.mindcraft.addon.crossover.tconstruct.utils.TiCUtils;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder("mcrossover")
@Pulse(id="Crossover EnderIO", modsRequired="EnderIO")
public class EnderIOSupport {
	
	public static Block moltenElectricalSteel;
	public static Block moltenEnergiticAlloy;
	public static Block moltenPhasedGold;
	public static Block moltenRedstoneAlloy;
	public static Block moltenConductiveIron;
	public static Block moltenPhasedIron;
	public static Block moltenDarkSteel;
	public static Block moltenSoularium;
	
	public static Fluid moltenElectricalSteelFluid;
	public static Fluid moltenEnergiticAlloyFluid;
	public static Fluid moltenPhasedGoldFluid;
	public static Fluid moltenRedstoneAlloyFluid;
	public static Fluid moltenConductiveIronFluid;
	public static Fluid moltenPhasedIronFluid;
	public static Fluid moltenDarkSteelFluid;
	public static Fluid moltenSoulariumFluid;
	
	public static ItemStack ingotElectricalSteel;
	public static ItemStack ingotEnergiticAlloy;
	public static ItemStack ingotPhasedGold;
	public static ItemStack ingotRedstoneAlloy;
	public static ItemStack ingotConductiveIron;
	public static ItemStack ingotPhasedIron;
	public static ItemStack ingotDarkSteel;
	public static ItemStack ingotSoularium;
	
	private Stats electricalSteelStats;
	private Stats energiticAlloyStats;
	private Stats phasedGoldStats;
	private Stats redstoneAlloyStats;
	private Stats conductiveIronStats;
	private Stats phasedIronStats;
	private Stats darkSteelStats;
	private Stats soulariumStats;

	@Handler
	public void preInit (FMLPreInitializationEvent e) {
		
		try {
			electricalSteelStats = new ConfigHandler(e).initEnderIOElectricalSteelStats();
			energiticAlloyStats = new ConfigHandler(e).initEnderIOEnergiticAlloyStats();
			phasedGoldStats = new ConfigHandler(e).initEnderIOPhasedGoldStats();
			redstoneAlloyStats = new ConfigHandler(e).initEnderIORedstoneAlloyStats();
			conductiveIronStats = new ConfigHandler(e).initEnderIOConductiveIronStats();
			phasedIronStats = new ConfigHandler(e).initEnderIOPhasedIronStats();
			darkSteelStats = new ConfigHandler(e).initEnderIODarkSteelStats();
			soulariumStats = new ConfigHandler(e).initEnderIOSoulariumStats();
		} catch (IOException er) {
			er.printStackTrace();
		}
		
		ingotElectricalSteel = CrossoverMain.getItemStackFromOreDictinaryName("ingotElectricalSteel");
		ingotEnergiticAlloy = CrossoverMain.getItemStackFromOreDictinaryName("ingotEnergeticAlloy");
		ingotPhasedGold = CrossoverMain.getItemStackFromOreDictinaryName("ingotPhasedGold");
		ingotRedstoneAlloy = CrossoverMain.getItemStackFromOreDictinaryName("ingotRedstoneAlloy");
		ingotConductiveIron = CrossoverMain.getItemStackFromOreDictinaryName("ingotConductiveIron");
		ingotPhasedIron = CrossoverMain.getItemStackFromOreDictinaryName("ingotPhasedIron");
		ingotDarkSteel = CrossoverMain.getItemStackFromOreDictinaryName("ingotDarkSteel");
		ingotSoularium = CrossoverMain.getItemStackFromOreDictinaryName("ingotSoularium");
		
		Block ingotStorage = CrossoverMain.getBlockFromOreDictinaryName("blockElectricalSteel");
		
		Entry<Block, Fluid> electricalSteelEntry;
		Entry<Block, Fluid> energiticAlloyEntry;
		Entry<Block, Fluid> phasedGoldEntry;
		Entry<Block, Fluid> redstoneAlloyEntry;
		Entry<Block, Fluid> conductiveIronEntry;
		Entry<Block, Fluid> phasedIronEntry;
		Entry<Block, Fluid> darkSteelEntry;
		Entry<Block, Fluid> soulariumEntry;
		
		electricalSteelEntry = TiCUtils.registerMaterial(electricalSteelStats.getMaterialId(), "electrical.steel", moltenElectricalSteelFluid, moltenElectricalSteel, ingotStorage, 0, 550, true);
		energiticAlloyEntry = TiCUtils.registerMaterial(energiticAlloyStats.getMaterialId(), "energitic.alloy", moltenEnergiticAlloyFluid, moltenEnergiticAlloy, ingotStorage, 1, 550, true);
		phasedGoldEntry = TiCUtils.registerMaterial(phasedGoldStats.getMaterialId(), "phased.gold", moltenPhasedGoldFluid, moltenPhasedGold, ingotStorage, 2, 550, true);
		redstoneAlloyEntry = TiCUtils.registerMaterial(redstoneAlloyStats.getMaterialId(), "redstone.alloy", moltenRedstoneAlloyFluid, moltenRedstoneAlloy, ingotStorage, 3, 550, true);
		conductiveIronEntry = TiCUtils.registerMaterial(39, "conductive.iron", moltenConductiveIronFluid, moltenConductiveIron, ingotStorage, 4, 550, true);
		phasedIronEntry = TiCUtils.registerMaterial(43, "phased.iron", moltenPhasedIronFluid, moltenPhasedIron, ingotStorage, 5, 550, true);
		darkSteelEntry = TiCUtils.registerMaterial(41, "dark.steel", moltenDarkSteelFluid, moltenDarkSteel, ingotStorage, 6, 550, true);
		soulariumEntry = TiCUtils.registerMaterial(42, "soularium", moltenSoulariumFluid, moltenSoularium, ingotStorage, 7, 550, true);
		
		moltenElectricalSteel = electricalSteelEntry.getKey();
		moltenEnergiticAlloy = energiticAlloyEntry.getKey();
		moltenPhasedGold = phasedGoldEntry.getKey();
		moltenRedstoneAlloy = redstoneAlloyEntry.getKey();
		moltenConductiveIron = conductiveIronEntry.getKey();
		moltenPhasedIron = phasedIronEntry.getKey();
		moltenDarkSteel = darkSteelEntry.getKey();
		moltenSoularium = soulariumEntry.getKey();
		
		moltenElectricalSteelFluid = electricalSteelEntry.getValue();
		moltenEnergiticAlloyFluid = energiticAlloyEntry.getValue();
		moltenPhasedGoldFluid = phasedGoldEntry.getValue();
		moltenRedstoneAlloyFluid = redstoneAlloyEntry.getValue();
		moltenConductiveIronFluid = conductiveIronEntry.getValue();
		moltenPhasedIronFluid = phasedIronEntry.getValue();
		moltenDarkSteelFluid = darkSteelEntry.getValue();
		moltenSoulariumFluid = soulariumEntry.getValue();

		TiCUtils.registerPartMaterial("ElectricalSteel", EnumChatFormatting.GRAY.toString(), 0x787878, electricalSteelStats);
		TiCUtils.registerPartMaterial("EnergiticAlloy", EnumChatFormatting.GOLD.toString(), 0xc26a01, energiticAlloyStats);
		TiCUtils.registerPartMaterial("PhasedGold", EnumChatFormatting.GREEN.toString(), 0x8aac25, phasedGoldStats);
		TiCUtils.registerPartMaterial("RedstoneAlloy", EnumChatFormatting.RED.toString(), 0x781919, redstoneAlloyStats);
		TiCUtils.registerPartMaterial("ConductiveIron", EnumChatFormatting.RED.toString(), 0xd2a6a1, conductiveIronStats);
		TiCUtils.registerPartMaterial("PhasedIron", EnumChatFormatting.GREEN.toString(), 0x5b8364, phasedIronStats);
		TiCUtils.registerPartMaterial("DarkSteel", EnumChatFormatting.DARK_GRAY.toString(), 0x2a2a2a, darkSteelStats);
		TiCUtils.registerPartMaterial("Soularium", EnumChatFormatting.GOLD.toString(), 0x5a3e25, soulariumStats);
		
	}
	
	@Handler
	public void init (FMLInitializationEvent e) {

		Block ingotStorage = CrossoverMain.getBlockFromOreDictinaryName("blockElectricalSteel");

		TiCUtils.addBasicMelting(ingotElectricalSteel,  false, null, new ItemStack(ingotStorage, 1, 0), moltenElectricalSteelFluid);
		TiCUtils.addBasicMelting(ingotEnergiticAlloy,  false, null, new ItemStack(ingotStorage, 1, 1), moltenEnergiticAlloyFluid);
		TiCUtils.addBasicMelting(ingotPhasedGold,  false, null, new ItemStack(ingotStorage, 1, 2), moltenPhasedGoldFluid);
		TiCUtils.addBasicMelting(ingotRedstoneAlloy,  false, null, new ItemStack(ingotStorage, 1, 3), moltenRedstoneAlloyFluid);
		TiCUtils.addBasicMelting(ingotConductiveIron,  false, null, new ItemStack(ingotStorage, 1, 4), moltenConductiveIronFluid);
		TiCUtils.addBasicMelting(ingotPhasedIron,  false, null, new ItemStack(ingotStorage, 1, 5), moltenPhasedIronFluid);
		TiCUtils.addBasicMelting(ingotDarkSteel,  false, null, new ItemStack(ingotStorage, 1, 6), moltenDarkSteelFluid);
		TiCUtils.addBasicMelting(ingotSoularium,  false, null, new ItemStack(ingotStorage, 1, 7), moltenSoulariumFluid);
		
		TiCUtils.addCasting(moltenElectricalSteelFluid, 35);
		TiCUtils.addCasting(moltenEnergiticAlloyFluid, 36);
		TiCUtils.addCasting(moltenPhasedGoldFluid, 37);
		TiCUtils.addCasting(moltenRedstoneAlloyFluid, 38);
		TiCUtils.addCasting(moltenConductiveIronFluid, 39);
		TiCUtils.addCasting(moltenPhasedIronFluid, 40);
		TiCUtils.addCasting(moltenDarkSteelFluid, 41);
		TiCUtils.addCasting(moltenSoulariumFluid, 42);
	}
	
	@Handler
	public void postInit (FMLPostInitializationEvent e) {
		
	}
}
