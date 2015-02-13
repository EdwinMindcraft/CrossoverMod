package mod.mindcraft.addon.crossover.tconstruct.personal;

import java.util.Map.Entry;

import mantle.pulsar.pulse.Handler;
import mantle.pulsar.pulse.Pulse;
import mod.mindcraft.addon.crossover.CrossoverMain;
import mod.mindcraft.addon.crossover.christmas.utils.ItemCustom;
import mod.mindcraft.addon.crossover.tconstruct.utils.BlockMetalCustom;
import mod.mindcraft.addon.crossover.tconstruct.utils.TiCUtils;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import sun.nio.cs.ext.MacCroatian;
import tconstruct.TConstruct;
import tconstruct.library.crafting.Smeltery;
import tconstruct.smeltery.TinkerSmeltery;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder("mcrossover")
@Pulse(id="Crossover Personnal Stuff")
public class MindStuff {
	
	public static Fluid moltenMindSteelFluid;
	public static Block moltenMindSteel;
	public static Block moltenMindSteelBlock;
	
	public static Fluid moltenEnderIronFluid;
	public static Block moltenEnderIron;
	public static Block moltenEnderIronBlock;
	
	public static Fluid moltenStartMetalFluid;
	public static Block moltenStartMetal;
	public static Block moltenStartMetalBlock;

	public static Fluid moltenStartFluid;
	public static Block moltenStart;
	public static Block moltenStartBlock;
	
	public static Item startCrystal;
	public static Item ingotStartMetal;
	public static Item ingotEnderIron;
	public static Item ingotMindSteel;
	
	public static CreativeTabs tabMaterials;

	@Handler
	public void preInit(FMLPreInitializationEvent e) {
		
		moltenMindSteelBlock = new BlockMetalCustom().setHardness(2.0F).setBlockName("mindsteel.block").setBlockTextureName("mcrossover:mindstuff/block_mindsteel");
		GameRegistry.registerBlock(moltenMindSteelBlock, "mindsteel.block");
		Entry<Block, Fluid> mindsteelEntry;
		mindsteelEntry = TiCUtils.registerMaterial(150, "MindSteel", moltenMindSteelFluid, moltenMindSteel, moltenMindSteelBlock, 550, true);
		moltenMindSteel = mindsteelEntry.getKey();
		moltenMindSteelFluid = mindsteelEntry.getValue();
		TiCUtils.registerPartMaterial(150, "MindSteel", 5, 2500, 3000, 20, 2.4F, 3, 0F, EnumChatFormatting.LIGHT_PURPLE.toString(), 0xff99ff, 20, 9F, 0.05F, 1F);
	
		moltenEnderIronBlock = new BlockMetalCustom().setHardness(2.0F).setBlockName("enderiron.block").setBlockTextureName("mcrossover:mindstuff/block_enderiron");
		GameRegistry.registerBlock(moltenEnderIronBlock, "enderiron.block");
		Entry<Block, Fluid> enderEntry;
		enderEntry = TiCUtils.registerMaterial(151, "EnderIron", moltenEnderIronFluid, moltenEnderIron, moltenEnderIronBlock, 550, true);
		moltenEnderIron = enderEntry.getKey();
		moltenEnderIronFluid = enderEntry.getValue();
		TiCUtils.registerPartMaterial(151, "EnderIron", 4, 1000, 1000, 10, 2.0F, 0, 0F, EnumChatFormatting.GREEN.toString(), 0x13523b, 30, 5.5F, 1F, 1F);		

		moltenStartMetalBlock = new BlockMetalCustom().setHardness(2.0F).setBlockName("startmetal.block").setBlockTextureName("mcrossover:mindstuff/block_startmetal");
		GameRegistry.registerBlock(moltenStartMetalBlock, "startmetal.block");
		Entry<Block, Fluid> startEntry;
		startEntry = TiCUtils.registerMaterial(152, "StartMetal", moltenStartMetalFluid, moltenStartMetal, moltenStartMetalBlock, 550, true);
		moltenStartMetal = startEntry.getKey();
		moltenStartMetalFluid = startEntry.getValue();
		TiCUtils.registerPartMaterial(152, "StartMetal", 4, 2000, 2500, 15, 0.5F, 2, 0F, EnumChatFormatting.WHITE.toString(), 0xffeeff, 10, 5.5F, 0.25F, 1F);	

		moltenStartBlock = new BlockMetalCustom().setHardness(2.0F).setBlockName("start.block").setBlockTextureName("mcrossover:mindstuff/block_start");
		GameRegistry.registerBlock(moltenStartBlock, "start.block");
		Entry<Block, Fluid> startCEntry;
		startCEntry = TiCUtils.registerMaterial(153, "Start", moltenStartFluid, moltenStart, moltenStartBlock, 550, false);
		moltenStart = startCEntry.getKey();
		moltenStartFluid = startCEntry.getValue();
		
		tabMaterials = new CreativeTabs("mcrossover.materials") {public Item getTabIconItem() {return startCrystal;}};

		startCrystal = new ItemCustom().setTextureName("mcrossover:mindstuff/gem_start").setUnlocalizedName("crystal.start").setCreativeTab(tabMaterials);
		ingotStartMetal = new ItemCustom().setTextureName("mcrossover:mindstuff/ingot_startmetal").setUnlocalizedName("ingot.start").setCreativeTab(tabMaterials);
		ingotEnderIron = new ItemCustom().setTextureName("mcrossover:mindstuff/ingot_enderiron").setUnlocalizedName("ingot.ender").setCreativeTab(tabMaterials);
		ingotMindSteel = new ItemCustom().setTextureName("mcrossover:mindstuff/ingot_mindsteel").setUnlocalizedName("ingot.mindsteel").setCreativeTab(tabMaterials);
		
		GameRegistry.registerItem(startCrystal, "crystal.start");
		GameRegistry.registerItem(ingotStartMetal, "ingot.start");
		GameRegistry.registerItem(ingotEnderIron, "ingot.ender");
		GameRegistry.registerItem(ingotMindSteel, "ingot.mindsteel");
	}
	
	@Handler
	public void init(FMLInitializationEvent e) {
		addRecipes();
        Smeltery.addAlloyMixing(new FluidStack(moltenMindSteelFluid, (int) (TConstruct.nuggetLiquidValue * 2)), new FluidStack(moltenEnderIronFluid, TConstruct.nuggetLiquidValue),new FluidStack(moltenStartMetalFluid, 16));
		TiCUtils.addBasicMelting(new ItemStack(ingotMindSteel), false, null, new ItemStack(moltenMindSteelBlock), moltenMindSteelFluid);
		TiCUtils.addCasting(moltenMindSteelFluid, 150);
		
        Smeltery.addAlloyMixing(new FluidStack(moltenEnderIronFluid, (int) (TConstruct.nuggetLiquidValue * 2)), new FluidStack(moltenStartFluid, TConstruct.nuggetLiquidValue),new FluidStack(TinkerSmeltery.moltenEnderFluid, TConstruct.nuggetLiquidValue));
		TiCUtils.addBasicMelting(new ItemStack(ingotEnderIron), false, null, new ItemStack(moltenEnderIronBlock), moltenEnderIronFluid);
		TiCUtils.addCasting(moltenEnderIronFluid, 151);

        Smeltery.addAlloyMixing(new FluidStack(moltenStartMetalFluid, (int) (TConstruct.nuggetLiquidValue * 2)), new FluidStack(TinkerSmeltery.moltenIronFluid, TConstruct.nuggetLiquidValue),new FluidStack(moltenStartFluid, TConstruct.nuggetLiquidValue));
		TiCUtils.addBasicMelting(new ItemStack(ingotStartMetal), false, null, new ItemStack(moltenEnderIronBlock), moltenEnderIronFluid);
		TiCUtils.addCasting(moltenEnderIronFluid, 152);
		
		TiCUtils.addBasicMelting(new ItemStack(startCrystal), false, null, new ItemStack(moltenStartBlock), moltenStartFluid);
		
		TiCUtils.registerUnknownThing(new ItemStack(ingotEnderIron), new ItemStack(moltenEnderIronBlock), "EnderIron");
		TiCUtils.registerUnknownThing(new ItemStack(ingotStartMetal), new ItemStack(moltenStartMetalBlock), "StartMetal");
		TiCUtils.registerUnknownThing(new ItemStack(ingotMindSteel), new ItemStack(moltenMindSteelBlock), "MindSteel");
		
		CrossoverMain.addBlockRecipe(ingotEnderIron, moltenEnderIronBlock);
		CrossoverMain.addBlockRecipe(ingotMindSteel, moltenMindSteelBlock);
		CrossoverMain.addBlockRecipe(ingotStartMetal, moltenStartMetalBlock);
	}
	
	@Handler
	public void postInit(FMLPostInitializationEvent e) {
		
	}
	
	private void addRecipes() {
		GameRegistry.addRecipe(new ItemStack(startCrystal), new Object[]{
			"OIO",
			"HGH",
			"OIO",
			Character.valueOf('G'), Items.nether_star,
			Character.valueOf('I'), Items.blaze_rod,
			Character.valueOf('H'), Items.ender_pearl,
			Character.valueOf('O'), Items.diamond
		});
		
		GameRegistry.addRecipe(new ItemStack(startCrystal), new Object[]{
			"OHO",
			"IGI",
			"OHO",
			Character.valueOf('G'), Items.nether_star,
			Character.valueOf('I'), Items.blaze_rod,
			Character.valueOf('H'), Items.ender_pearl,
			Character.valueOf('O'), Items.diamond
		});
		GameRegistry.addRecipe(new ItemStack(Blocks.dragon_egg), new Object[]{
			"III",
			"IGI",
			"III",
			Character.valueOf('I'), startCrystal,
			Character.valueOf('G'), moltenEnderIronBlock
		});
	}
	
}
