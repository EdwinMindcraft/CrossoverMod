package mod.mindcraft.addon.crossover.tconstruct.enderio;

import java.util.Map.Entry;

import mantle.pulsar.pulse.Handler;
import mantle.pulsar.pulse.Pulse;
import mod.mindcraft.addon.crossover.CrossoverMain;
import mod.mindcraft.addon.crossover.tconstruct.utils.TiCUtils;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
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

	@Handler
	public static void preInit (FMLPreInitializationEvent e) {
		
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
		
		electricalSteelEntry = TiCUtils.registerMaterial(35, "electrical.steel", moltenElectricalSteelFluid, moltenElectricalSteel, ingotStorage, 0, 550, true);
		energiticAlloyEntry = TiCUtils.registerMaterial(36, "energitic.alloy", moltenEnergiticAlloyFluid, moltenEnergiticAlloy, ingotStorage, 1, 550, true);
		phasedGoldEntry = TiCUtils.registerMaterial(37, "phased.gold", moltenPhasedGoldFluid, moltenPhasedGold, ingotStorage, 2, 550, true);
		redstoneAlloyEntry = TiCUtils.registerMaterial(38, "redstone.alloy", moltenRedstoneAlloyFluid, moltenRedstoneAlloy, ingotStorage, 3, 550, true);
		conductiveIronEntry = TiCUtils.registerMaterial(39, "conductive.iron", moltenConductiveIronFluid, moltenConductiveIron, ingotStorage, 4, 550, true);
		phasedIronEntry = TiCUtils.registerMaterial(40, "phased.iron", moltenPhasedIronFluid, moltenPhasedIron, ingotStorage, 5, 550, true);
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

		TiCUtils.registerPartMaterial(35, "ElectricalSteel", 2, 500, 500, 2, 1.2F, 1, 0F, EnumChatFormatting.GRAY.toString(), 0x787878, 45, 2F, 0.25F, 1F);
		TiCUtils.registerPartMaterial(36, "EnergiticAlloy", 1, 250, 750, 3, 0.75F, 0, 0F, EnumChatFormatting.GOLD.toString(), 0xc26a01, 45, 4F, 1F, 1F);
		TiCUtils.registerPartMaterial(37, "PhasedGold", 2, 300, 700, 4, 0.75F, 0, 0F, EnumChatFormatting.GREEN.toString(), 0x8aac25, 45, 4F, 1F, 1F);
		TiCUtils.registerPartMaterial(38, "RedstoneAlloy", 0, 100, 900, 1, 1.5F, 0, 0F, EnumChatFormatting.RED.toString(), 0x781919, 45, 6F, 0.05F, 1F);
		TiCUtils.registerPartMaterial(39, "ConductiveIron", 2, 500, 500, 3, 1F, 1, 0F, EnumChatFormatting.RED.toString(), 0xd2a6a1, 45, 2F, 0.25F, 1F);
		TiCUtils.registerPartMaterial(40, "PhasedIron", 3, 750, 700, 3, 1.5F, 1, 0F, EnumChatFormatting.GREEN.toString(), 0x5b8364, 45, 2F, 0.25F, 1F);
		TiCUtils.registerPartMaterial(41, "DarkSteel", 4, 1000, 1000, 5, 2F, 2, 0F, EnumChatFormatting.DARK_GRAY.toString(), 0x2a2a2a, 45, 4F, 1F, 1F);
		TiCUtils.registerPartMaterial(42, "Soularium", 4, 1000, 1000, 5, 1.8F, 2, 0F, EnumChatFormatting.GOLD.toString(), 0x5a3e25, 45, 6F, 0.15F, 1F);
		
	}
	
	@Handler
	public static void init (FMLInitializationEvent e) {

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
	public static void postInit (FMLPostInitializationEvent e) {
		
	}
}
