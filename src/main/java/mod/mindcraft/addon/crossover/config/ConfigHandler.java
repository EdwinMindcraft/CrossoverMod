package mod.mindcraft.addon.crossover.config;

import java.io.File;
import java.io.IOException;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ConfigHandler {
	
	File configFile;
	Configuration christmasCfg;
	Configuration enderIOSupportCfg;
	Configuration metallurgySupportCfg;
	Configuration mekanimSupportCfg;
	Configuration mindStuffCfg;
	Configuration specialFluidsCfg;
	
	public ConfigHandler (FMLPreInitializationEvent e) throws IOException {
		configFile = new File (e.getModConfigurationDirectory().getCanonicalPath(), "MCrossover");
		String configPath = configFile.getCanonicalPath();
		System.out.println(configPath);
		File config = new File (configPath);
		File christmasFile = new File (configPath, "Christmas.cfg");
		File enderIOFile = new File (configPath, "EnderIO.cfg");
		File metallurgyFile = new File (configPath, "Metallurgy.cfg");
		File mekanismFile = new File (configPath, "Mekanism.cfg");
		File mindStuffFile = new File (configPath, "MindStuff.cfg");
		File specialFluidFile = new File (configPath, "SpecialFluids.cfg");
		if (!config.exists()) config.mkdirs();
		if (!christmasFile.exists()) christmasFile.createNewFile();
		if (!christmasFile.exists()) christmasFile.createNewFile();
		if (!enderIOFile.exists()) enderIOFile.createNewFile();
		if (!metallurgyFile.exists()) metallurgyFile.createNewFile();
		if (!mekanismFile.exists()) mekanismFile.createNewFile();
		if (!mindStuffFile.exists()) mindStuffFile.createNewFile();
		if (!specialFluidFile.exists()) specialFluidFile.createNewFile();
		christmasCfg = new Configuration(christmasFile);
		enderIOSupportCfg = new Configuration(enderIOFile);
		metallurgySupportCfg = new Configuration(metallurgyFile);
		mekanimSupportCfg = new Configuration(mekanismFile);
		mindStuffCfg = new Configuration(mindStuffFile);
		specialFluidsCfg = new Configuration(specialFluidFile);
	}
		
	public Stats initChristmasToolStats () {
		christmasCfg.load();
		int id = christmasCfg.getInt("MaterialIDs", "ToolStats", 125, 0, 255, "");
		int hl = christmasCfg.getInt("HarvestLevel", "ToolStats", 2, 0, 20, "");
		int d = christmasCfg.getInt("Durability", "ToolStats", 400, 0, 5000, "");
		int ms = christmasCfg.getInt("MiningSpeed", "ToolStats", 700, 0, 5000, "");
		int a = christmasCfg.getInt("Attack", "ToolStats", 3, 0, 1000, "");
		float hm = christmasCfg.getFloat("HandleModifier", "ToolStats", 1.0F, 0, 255, "");
		int r = christmasCfg.getInt("Reinforced", "ToolStats", 0, 0, 255, "0 - 255");
		float sb = christmasCfg.getFloat("StoneBound", "ToolStats", 0.0F, 0F, 5F, "");
		int ds = christmasCfg.getInt("DrawSpeed", "ToolStats", 20, 0, 255, "");
		float sm = christmasCfg.getFloat("SpeedMax", "ToolStats", 2.0F, 0, 200F, "");
		float m = christmasCfg.getFloat("Mass", "ToolStats", 0.1F, 0, 50F, "");
		float f = christmasCfg.getFloat("Fragility", "ToolStats", 100F, 0, 100F, "");
		christmasCfg.save();
		return new Stats(id, hl, d, ms, a, hm, r, sb, ds, sm, m, f);
	}
	
	public int initChristmasMeltTemperature () {
		christmasCfg.load();
		int meltTemp = christmasCfg.getInt("MeltTemperature", christmasCfg.CATEGORY_GENERAL, 550, 0, 5000, "");
		christmasCfg.save();
		return meltTemp;
	}

	public int initChristmasHarvestLevel () {
		christmasCfg.load();
		int meltTemp = christmasCfg.getInt("BlockHarvestLevel", christmasCfg.CATEGORY_GENERAL, 2, 0, 20, "");
		christmasCfg.save();
		return meltTemp;
	}
	
	public Stats initEnderIOElectricalSteelStats () {
		enderIOSupportCfg.load();
		int id = enderIOSupportCfg.getInt("MaterialID", "ElectricalSteel", 35, 0, 255, "");
		int hl = enderIOSupportCfg.getInt("HarvestLevel", "ElectricalSteel", 2, 0, 20, "");
		int d = enderIOSupportCfg.getInt("Durability", "ElectricalSteel", 500, 0, 5000, "");
		int ms = enderIOSupportCfg.getInt("MiningSpeed", "ElectricalSteel", 500, 0, 5000, "");
		int a = enderIOSupportCfg.getInt("Attack", "ElectricalSteel", 2, 0, 1000, "");
		float hm = enderIOSupportCfg.getFloat("HandleModifier", "ElectricalSteel", 1.2F, 0, 255, "");
		int r = enderIOSupportCfg.getInt("Reinforced", "ElectricalSteel", 1, 0, 255, "0 - 255");
		float sb = enderIOSupportCfg.getFloat("StoneBound", "ElectricalSteel", 0.0F, 0F, 5F, "");
		int ds = enderIOSupportCfg.getInt("DrawSpeed", "ElectricalSteel", 45, 0, 255, "");
		float sm = enderIOSupportCfg.getFloat("SpeedMax", "ElectricalSteel", 2.0F, 0, 200F, "");
		float m = enderIOSupportCfg.getFloat("Mass", "ElectricalSteel", 1F, 0, 50F, "");
		float f = enderIOSupportCfg.getFloat("Fragility", "ElectricalSteel", 1F, 0, 100F, "");
		enderIOSupportCfg.save();
		return new Stats(id, hl, d, ms, a, hm, r, sb, ds, sm, m, f);
	}

	public Stats initEnderIOEnergiticAlloyStats () {
		enderIOSupportCfg.load();
		int id = enderIOSupportCfg.getInt("MaterialID", "EnergiticAlloy", 36, 0, 255, "");
		int hl = enderIOSupportCfg.getInt("HarvestLevel", "EnergiticAlloy", 1, 0, 20, "");
		int d = enderIOSupportCfg.getInt("Durability", "EnergiticAlloy", 250, 0, 5000, "");
		int ms = enderIOSupportCfg.getInt("MiningSpeed", "EnergiticAlloy", 750, 0, 5000, "");
		int a = enderIOSupportCfg.getInt("Attack", "EnergiticAlloy", 3, 0, 1000, "");
		float hm = enderIOSupportCfg.getFloat("HandleModifier", "EnergiticAlloy", 0.75F, 0, 255, "");
		int r = enderIOSupportCfg.getInt("Reinforced", "EnergiticAlloy", 0, 0, 255, "0 - 255");
		float sb = enderIOSupportCfg.getFloat("StoneBound", "EnergiticAlloy", 0.0F, 0F, 5F, "");
		int ds = enderIOSupportCfg.getInt("DrawSpeed", "EnergiticAlloy", 45, 0, 255, "");
		float sm = enderIOSupportCfg.getFloat("SpeedMax", "EnergiticAlloy", 4.0F, 0, 200F, "");
		float m = enderIOSupportCfg.getFloat("Mass", "EnergiticAlloy", 1F, 0, 50F, "");
		float f = enderIOSupportCfg.getFloat("Fragility", "EnergiticAlloy", 1F, 0, 100F, "");
		enderIOSupportCfg.save();
		return new Stats(id, hl, d, ms, a, hm, r, sb, ds, sm, m, f);
	}

	public Stats initEnderIOPhasedGoldStats () {
		enderIOSupportCfg.load();
		int id = enderIOSupportCfg.getInt("MaterialID", "PhasedGold", 37, 0, 255, "");
		int hl = enderIOSupportCfg.getInt("HarvestLevel", "PhasedGold", 2, 0, 20, "");
		int d = enderIOSupportCfg.getInt("Durability", "PhasedGold", 300, 0, 5000, "");
		int ms = enderIOSupportCfg.getInt("MiningSpeed", "PhasedGold", 700, 0, 5000, "");
		int a = enderIOSupportCfg.getInt("Attack", "PhasedGold", 4, 0, 1000, "");
		float hm = enderIOSupportCfg.getFloat("HandleModifier", "PhasedGold", 0.75F, 0, 255, "");
		int r = enderIOSupportCfg.getInt("Reinforced", "PhasedGold", 0, 0, 255, "0 - 255");
		float sb = enderIOSupportCfg.getFloat("StoneBound", "PhasedGold", 0.0F, 0F, 5F, "");
		int ds = enderIOSupportCfg.getInt("DrawSpeed", "PhasedGold", 45, 0, 255, "");
		float sm = enderIOSupportCfg.getFloat("SpeedMax", "PhasedGold", 4.0F, 0, 200F, "");
		float m = enderIOSupportCfg.getFloat("Mass", "PhasedGold", 1F, 0, 50F, "");
		float f = enderIOSupportCfg.getFloat("Fragility", "PhasedGold", 1F, 0, 100F, "");
		enderIOSupportCfg.save();
		return new Stats(id, hl, d, ms, a, hm, r, sb, ds, sm, m, f);
	}
	
	public Stats initEnderIORedstoneAlloyStats () {
		enderIOSupportCfg.load();
		int id = enderIOSupportCfg.getInt("MaterialID", "RedstoneAlloy", 38, 0, 255, "");
		int hl = enderIOSupportCfg.getInt("HarvestLevel", "RedstoneAlloy", 2, 0, 20, "");
		int d = enderIOSupportCfg.getInt("Durability", "RedstoneAlloy", 500, 0, 5000, "");
		int ms = enderIOSupportCfg.getInt("MiningSpeed", "RedstoneAlloy", 500, 0, 5000, "");
		int a = enderIOSupportCfg.getInt("Attack", "RedstoneAlloy", 3, 0, 1000, "");
		float hm = enderIOSupportCfg.getFloat("HandleModifier", "RedstoneAlloy", 1.3F, 0, 255, "");
		int r = enderIOSupportCfg.getInt("Reinforced", "RedstoneAlloy", 1, 0, 255, "0 - 255");
		float sb = enderIOSupportCfg.getFloat("StoneBound", "RedstoneAlloy", 0.0F, 0F, 5F, "");
		int ds = enderIOSupportCfg.getInt("DrawSpeed", "RedstoneAlloy", 45, 0, 255, "");
		float sm = enderIOSupportCfg.getFloat("SpeedMax", "RedstoneAlloy", 6.0F, 0, 200F, "");
		float m = enderIOSupportCfg.getFloat("Mass", "RedstoneAlloy", 0.05F, 0, 50F, "");
		float f = enderIOSupportCfg.getFloat("Fragility", "RedstoneAlloy", 1F, 0, 100F, "");
		enderIOSupportCfg.save();
		return new Stats(id, hl, d, ms, a, hm, r, sb, ds, sm, m, f);
	}

	public Stats initEnderIOConductiveIronStats () {
		enderIOSupportCfg.load();
		int id = enderIOSupportCfg.getInt("MaterialID", "ConductiveIron", 39, 0, 255, "");
		int hl = enderIOSupportCfg.getInt("HarvestLevel", "ConductiveIron", 0, 0, 20, "");
		int d = enderIOSupportCfg.getInt("Durability", "ConductiveIron", 100, 0, 5000, "");
		int ms = enderIOSupportCfg.getInt("MiningSpeed", "ConductiveIron", 900, 0, 5000, "");
		int a = enderIOSupportCfg.getInt("Attack", "ConductiveIron", 1, 0, 1000, "");
		float hm = enderIOSupportCfg.getFloat("HandleModifier", "ConductiveIron", 1.5F, 0, 255, "");
		int r = enderIOSupportCfg.getInt("Reinforced", "ConductiveIron", 0, 0, 255, "0 - 255");
		float sb = enderIOSupportCfg.getFloat("StoneBound", "ConductiveIron", 0.0F, 0F, 5F, "");
		int ds = enderIOSupportCfg.getInt("DrawSpeed", "ConductiveIron", 45, 0, 255, "");
		float sm = enderIOSupportCfg.getFloat("SpeedMax", "ConductiveIron", 6.0F, 0, 200F, "");
		float m = enderIOSupportCfg.getFloat("Mass", "ConductiveIron", 0.25F, 0, 50F, "");
		float f = enderIOSupportCfg.getFloat("Fragility", "ConductiveIron", 1F, 0, 100F, "");
		enderIOSupportCfg.save();
		return new Stats(id, hl, d, ms, a, hm, r, sb, ds, sm, m, f);
	}
	
	public Stats initEnderIOPhasedIronStats () {
		enderIOSupportCfg.load();
		int id = enderIOSupportCfg.getInt("MaterialID", "PhasedIron", 40, 0, 255, "");
		int hl = enderIOSupportCfg.getInt("HarvestLevel", "PhasedIron", 3, 0, 20, "");
		int d = enderIOSupportCfg.getInt("Durability", "PhasedIron", 750, 0, 5000, "");
		int ms = enderIOSupportCfg.getInt("MiningSpeed", "PhasedIron", 700, 0, 5000, "");
		int a = enderIOSupportCfg.getInt("Attack", "PhasedIron", 3, 0, 1000, "");
		float hm = enderIOSupportCfg.getFloat("HandleModifier", "PhasedIron", 1.5F, 0, 255, "");
		int r = enderIOSupportCfg.getInt("Reinforced", "PhasedIron", 1, 0, 255, "0 - 255");
		float sb = enderIOSupportCfg.getFloat("StoneBound", "PhasedIron", 0.0F, 0F, 5F, "");
		int ds = enderIOSupportCfg.getInt("DrawSpeed", "PhasedIron", 45, 0, 255, "");
		float sm = enderIOSupportCfg.getFloat("SpeedMax", "PhasedIron", 2.0F, 0, 200F, "");
		float m = enderIOSupportCfg.getFloat("Mass", "PhasedIron", 0.25F, 0, 50F, "");
		float f = enderIOSupportCfg.getFloat("Fragility", "PhasedIron", 1F, 0, 100F, "");
		enderIOSupportCfg.save();
		return new Stats(id, hl, d, ms, a, hm, r, sb, ds, sm, m, f);
	}
	
	public Stats initEnderIODarkSteelStats () {
		enderIOSupportCfg.load();
		int id = enderIOSupportCfg.getInt("MaterialID", "DarkSteel", 41, 0, 255, "");
		int hl = enderIOSupportCfg.getInt("HarvestLevel", "DarkSteel", 4, 0, 20, "");
		int d = enderIOSupportCfg.getInt("Durability", "DarkSteel", 1000, 0, 5000, "");
		int ms = enderIOSupportCfg.getInt("MiningSpeed", "DarkSteel", 1000, 0, 5000, "");
		int a = enderIOSupportCfg.getInt("Attack", "DarkSteel", 5, 0, 1000, "");
		float hm = enderIOSupportCfg.getFloat("HandleModifier", "DarkSteel", 2F, 0, 255, "");
		int r = enderIOSupportCfg.getInt("Reinforced", "DarkSteel", 2, 0, 255, "0 - 255");
		float sb = enderIOSupportCfg.getFloat("StoneBound", "DarkSteel", 0.0F, 0F, 5F, "");
		int ds = enderIOSupportCfg.getInt("DrawSpeed", "DarkSteel", 45, 0, 255, "");
		float sm = enderIOSupportCfg.getFloat("SpeedMax", "DarkSteel", 4.0F, 0, 200F, "");
		float m = enderIOSupportCfg.getFloat("Mass", "DarkSteel", 1F, 0, 50F, "");
		float f = enderIOSupportCfg.getFloat("Fragility", "DarkSteel", 1F, 0, 100F, "");
		enderIOSupportCfg.save();
		return new Stats(id, hl, d, ms, a, hm, r, sb, ds, sm, m, f);
	}

	public Stats initEnderIOSoulariumStats () {
		enderIOSupportCfg.load();
		int id = enderIOSupportCfg.getInt("MaterialID", "Soularium", 42, 0, 255, "");
		int hl = enderIOSupportCfg.getInt("HarvestLevel", "Soularium", 4, 0, 20, "");
		int d = enderIOSupportCfg.getInt("Durability", "Soularium", 1000, 0, 5000, "");
		int ms = enderIOSupportCfg.getInt("MiningSpeed", "Soularium", 1000, 0, 5000, "");
		int a = enderIOSupportCfg.getInt("Attack", "Soularium", 5, 0, 1000, "");
		float hm = enderIOSupportCfg.getFloat("HandleModifier", "Soularium", 1.8F, 0, 255, "");
		int r = enderIOSupportCfg.getInt("Reinforced", "Soularium", 2, 0, 255, "0 - 255");
		float sb = enderIOSupportCfg.getFloat("StoneBound", "Soularium", 0.0F, 0F, 5F, "");
		int ds = enderIOSupportCfg.getInt("DrawSpeed", "Soularium", 45, 0, 255, "");
		float sm = enderIOSupportCfg.getFloat("SpeedMax", "Soularium", 6.0F, 0, 200F, "");
		float m = enderIOSupportCfg.getFloat("Mass", "Soularium", 0.15F, 0, 50F, "");
		float f = enderIOSupportCfg.getFloat("Fragility", "Soularium", 1F, 0, 100F, "");
		enderIOSupportCfg.save();
		return new Stats(id, hl, d, ms, a, hm, r, sb, ds, sm, m, f);
	}

}
