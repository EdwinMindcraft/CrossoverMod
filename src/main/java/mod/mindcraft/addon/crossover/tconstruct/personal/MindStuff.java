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
		
		moltenMindSteelBlock = new BlockMetalCustom().setHardness(2.0F).setBlockName("mindsteel.block").setBlockTextureName("mcrossover:mindstuff/mindsteel_block");
		GameRegistry.registerBlock(moltenMindSteelBlock, "mindsteel.block");
		Entry<Block, Fluid> mindsteelEntry;
		mindsteelEntry = TiCUtils.registerMaterial(150, "MindSteel", moltenMindSteelFluid, moltenMindSteel, moltenMindSteelBlock, 550, true);
		moltenMindSteel = mindsteelEntry.getKey();
		moltenMindSteelFluid = mindsteelEntry.getValue();
		TiCUtils.registerPartMaterial(150, "MindSteel", 5, 2500, 2000, 10, 2.4F, 3, 0F, EnumChatFormatting.LIGHT_PURPLE.toString(), 0xff99ff, 50, 5.5F, 0F, 1F);
	
		moltenEnderIronBlock = new BlockMetalCustom().setHardness(2.0F).setBlockName("enderiron.block").setBlockTextureName("mcrossover:mindstuff/enderiron_block");
		GameRegistry.registerBlock(moltenEnderIronBlock, "enderiron.block");
		Entry<Block, Fluid> enderEntry;
		enderEntry = TiCUtils.registerMaterial(151, "EnderIron", moltenEnderIronFluid, moltenEnderIron, moltenEnderIronBlock, 550, true);
		moltenEnderIron = enderEntry.getKey();
		moltenEnderIronFluid = enderEntry.getValue();
		TiCUtils.registerPartMaterial(151, "EnderIron", 4, 1000, 10000, 20, 1.0F, 1, 0F, EnumChatFormatting.GREEN.toString(), 0x13523b, 3, 5.5F, 0F, 1F);		

		moltenStartMetalBlock = new BlockMetalCustom().setHardness(2.0F).setBlockName("startmetal.block").setBlockTextureName("mcrossover:mindstuff/startmetal_block");
		GameRegistry.registerBlock(moltenStartMetalBlock, "startmetal.block");
		Entry<Block, Fluid> startEntry;
		startEntry = TiCUtils.registerMaterial(152, "StartMetal", moltenStartMetalFluid, moltenStartMetal, moltenStartMetalBlock, 550, true);
		moltenStartMetal = startEntry.getKey();
		moltenStartMetalFluid = startEntry.getValue();
		TiCUtils.registerPartMaterial(152, "StartMetal", 4, 2000, 10000, 20, 1.0F, 1, 0F, EnumChatFormatting.WHITE.toString(), 0xffffff, 3, 5.5F, 0F, 1F);	

		moltenStartBlock = new BlockMetalCustom().setHardness(2.0F).setBlockName("start.block").setBlockTextureName("mcrossover:mindstuff/start_block");
		GameRegistry.registerBlock(moltenStartBlock, "start.block");
		Entry<Block, Fluid> startCEntry;
		startCEntry = TiCUtils.registerMaterial(153, "Start", moltenStartFluid, moltenStart, moltenStartBlock, 550, true);
		moltenStart = startCEntry.getKey();
		moltenStartFluid = startCEntry.getValue();
		
		tabMaterials = new CreativeTabs("mcrossover.materials") {public Item getTabIconItem() {return startCrystal;}};

		startCrystal = new ItemCustom().setTextureName("mcrossover:mindstuff/crystal_start").setUnlocalizedName("start.crystal").setCreativeTab(tabMaterials);
		ingotStartMetal = new ItemCustom().setTextureName("mcrossover:mindstuff/ingot_startmetal").setUnlocalizedName("start.ingot").setCreativeTab(tabMaterials);
		ingotEnderIron = new ItemCustom().setTextureName("mcrossover:mindstuff/ingot_enderiron").setUnlocalizedName("ender.ingot").setCreativeTab(tabMaterials);
		ingotMindSteel = new ItemCustom().setTextureName("mcrossover:mindstuff/ingot_mindsteel").setUnlocalizedName("mindsteel.ingot").setCreativeTab(tabMaterials);
		
		GameRegistry.registerItem(startCrystal, "start.crystal");
		GameRegistry.registerItem(ingotStartMetal, "start.ingot");
		GameRegistry.registerItem(ingotEnderIron, "ender.ingot");
		GameRegistry.registerItem(ingotMindSteel, "mindsteel.ingot");
	}
	
	@Handler
	public void init(FMLInitializationEvent e) {
		addRecipes();
        Smeltery.addAlloyMixing(new FluidStack(moltenMindSteelFluid, (int) (TConstruct.nuggetLiquidValue * 2)), new FluidStack(moltenEnderIronFluid, TConstruct.nuggetLiquidValue),new FluidStack(moltenStartMetalFluid, 16));
		TiCUtils.addBasicMelting(new ItemStack(ingotMindSteel), false, null, new ItemStack(moltenMindSteelBlock), moltenMindSteelFluid);
		TiCUtils.addCasting(moltenMindSteelFluid, 150);
		
        Smeltery.addAlloyMixing(new FluidStack(moltenEnderIronFluid, (int) (TConstruct.nuggetLiquidValue * 2)), new FluidStack(TinkerSmeltery.moltenIronFluid, TConstruct.nuggetLiquidValue),new FluidStack(TinkerSmeltery.moltenEnderFluid, TConstruct.nuggetLiquidValue));
		TiCUtils.addBasicMelting(new ItemStack(ingotEnderIron), false, null, new ItemStack(moltenEnderIronBlock), moltenEnderIronFluid);
		TiCUtils.addCasting(moltenEnderIronFluid, 151);

        Smeltery.addAlloyMixing(new FluidStack(moltenStartMetalFluid, (int) (TConstruct.nuggetLiquidValue * 2)), new FluidStack(TinkerSmeltery.moltenIronFluid, TConstruct.nuggetLiquidValue),new FluidStack(moltenStartFluid, TConstruct.nuggetLiquidValue));
		TiCUtils.addBasicMelting(new ItemStack(ingotStartMetal), false, null, new ItemStack(moltenEnderIronBlock), moltenEnderIronFluid);
		TiCUtils.addCasting(moltenEnderIronFluid, 152);
		
		TiCUtils.addBasicMelting(new ItemStack(startCrystal), false, null, new ItemStack(moltenStartBlock), moltenStartFluid);
	}
	
	@Handler
	public void postInit(FMLPostInitializationEvent e) {
		
	}
	
	private void addRecipes() {
		GameRegistry.addRecipe(new ItemStack(startCrystal), new Object[]{
			" I ",
			"HGH",
			" I ",
			Character.valueOf('G'), Items.emerald,
			Character.valueOf('I'), Items.blaze_rod,
			Character.valueOf('H'), Items.ender_pearl
		});
		
		GameRegistry.addRecipe(new ItemStack(startCrystal), new Object[]{
			" H ",
			"IGI",
			" H ",
			Character.valueOf('G'), Items.emerald,
			Character.valueOf('I'), Items.blaze_rod,
			Character.valueOf('H'), Items.ender_pearl
		});
	}
	
}
