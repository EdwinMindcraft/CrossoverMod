package mod.mindcraft.addon.crossover.tconstruct.mekanism;

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
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;


@Pulse(id="Crossover Mekanism", modsRequired="Mekanism")
public class MekanismSupport {
	
	public static ItemStack ingotRefinedObsidian;
	public static ItemStack ingotOsmium;
	public static ItemStack ingotRefinedGlowstone;
	
	public static Fluid moltenRefinedObsidianFluid;
	public static Fluid moltenOsmiumFluid;
	public static Fluid moltenRefinedGlowstoneFluid;

	public static Block moltenRefinedObsidian;
	public static Block moltenOsmium;
	public static Block moltenRefinedGlowstone;

	@Handler
	public static void preInit (FMLPreInitializationEvent e) {
		ingotRefinedObsidian = OreDictionary.getOres("ingotRefinedObsidian").get(0);
		ingotOsmium = OreDictionary.getOres("ingotOsmium").get(0);
		ingotRefinedGlowstone = OreDictionary.getOres("ingotRefinedGlowstone").get(0);
		Block metalBlock = Block.getBlockFromItem(OreDictionary.getOres("blockRefinedObsidian").get(0).getItem());
		
		Entry<Block, Fluid> refinedObsidianEntry;
		Entry<Block, Fluid> osmiumEntry;
		Entry<Block, Fluid> refinedGlowstoneEntry;
		
		
		
		refinedObsidianEntry = TiCUtils.registerMaterial(43, "refined.obsidian", moltenRefinedObsidianFluid, moltenRefinedObsidian, metalBlock, 2, 1000, true);
		osmiumEntry = TiCUtils.registerMaterial(44, "osmium", moltenOsmiumFluid, moltenOsmium, metalBlock, 0, 550, true);
		refinedGlowstoneEntry = TiCUtils.registerMaterial(45, "refined.glowstone", moltenRefinedGlowstoneFluid, moltenRefinedGlowstone, metalBlock, 4, 200, true);
		
		moltenRefinedObsidian = refinedObsidianEntry.getKey();
		moltenOsmium = osmiumEntry.getKey();
		moltenRefinedGlowstone = refinedGlowstoneEntry.getKey();
		
		moltenRefinedObsidianFluid = refinedObsidianEntry.getValue();
		moltenOsmiumFluid = osmiumEntry.getValue();
		moltenRefinedGlowstoneFluid = refinedGlowstoneEntry.getValue();
		
		
		//TODO Colorize
		TiCUtils.registerPartMaterial(43, "RefinedObsidian", 4, 3000, 1200, 7, 3F, 5, 0F, EnumChatFormatting.DARK_PURPLE.toString(), 0x1e0053, 90, 6F, 1F, 1F);
		TiCUtils.registerPartMaterial(44, "Osmium", 3, 450, 750, 4, 1.5F, 1, 0F, EnumChatFormatting.BLUE.toString(), 0x43638a, 45, 3F, 0.25F, 1F);
		TiCUtils.registerPartMaterial(45, "RefinedGlowstone", 3, 100, 2000, 5, 0.25F, 0, 0F, EnumChatFormatting.YELLOW.toString(), 0xd2da0e, 15, 15F, 0.01F, 1F);

	}
	
	@Handler
	public static void init (FMLInitializationEvent e) {
		Block metalBlock = CrossoverMain.getBlockFromOreDictinaryName("blockRefinedObsidian");
		Block oreBlock = CrossoverMain.getBlockFromOreDictinaryName("oreOsmium");
		
		TiCUtils.addBasicMelting(ingotRefinedObsidian, false, null, new ItemStack(metalBlock, 1, 2), moltenRefinedObsidianFluid);
		TiCUtils.addBasicMelting(ingotOsmium,  true, new ItemStack(oreBlock, 1, 0), new ItemStack(metalBlock, 1, 0), moltenOsmiumFluid);
		TiCUtils.addBasicMelting(ingotRefinedGlowstone,  false, null, new ItemStack(metalBlock, 1, 4), moltenRefinedGlowstoneFluid);
		
		TiCUtils.addCasting(moltenRefinedObsidianFluid, 43);
		TiCUtils.addCasting(moltenOsmiumFluid, 44);
		TiCUtils.addCasting(moltenRefinedGlowstoneFluid, 45);
	}
	
	@Handler
	public static void postInit (FMLPostInitializationEvent e) {
		
	}
}
