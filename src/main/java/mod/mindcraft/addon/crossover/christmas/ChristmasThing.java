package mod.mindcraft.addon.crossover.christmas;

import java.util.Map.Entry;

import mantle.pulsar.pulse.Handler;
import mantle.pulsar.pulse.Pulse;
import mod.mindcraft.addon.crossover.CrossoverMain;
import mod.mindcraft.addon.crossover.christmas.utils.BlockCustomOre;
import mod.mindcraft.addon.crossover.christmas.utils.ItemCustom;
import mod.mindcraft.addon.crossover.christmas.world.ChristmasWorldGenerator;
import mod.mindcraft.addon.crossover.tconstruct.utils.BlockMetalCustom;
import mod.mindcraft.addon.crossover.tconstruct.utils.TiCUtils;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.gen.structure.StructureMineshaftPieces.Cross;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import tconstruct.TConstruct;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.crafting.FluidType;
import tconstruct.library.crafting.LiquidCasting;
import tconstruct.library.crafting.PatternBuilder;
import tconstruct.library.crafting.Smeltery;
import tconstruct.library.crafting.ToolBuilder;
import tconstruct.library.tools.DualMaterialToolPart;
import tconstruct.library.weaponry.AmmoItem;
import tconstruct.tools.TinkerTools;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder("mcrossover")
@Pulse(id="Crossover Christmas")
public class ChristmasThing {
	
	
	public static DualMaterialToolPart partBall;
	public static AmmoItem christmasBall;
	public static Block christmasBallBlock;
	
	public static Block oreYellowDecorative = new BlockCustomOre().setBlockTextureName("mcrossover:christmas/ore_yellow").setBlockName("ore.yellow").setHardness(2F);
	public static Block oreRedDecorative = new BlockCustomOre().setBlockTextureName("mcrossover:christmas/ore_red").setBlockName("ore.red").setHardness(2F);
	public static Block oreGreenDecorative = new BlockCustomOre().setBlockTextureName("mcrossover:christmas/ore_green").setBlockName("ore.green").setHardness(2F);
	public static Block oreBlueDecorative = new BlockCustomOre().setBlockTextureName("mcrossover:christmas/ore_blue").setBlockName("ore.blue").setHardness(2F);
	public static Block oreWhiteDecorative = new BlockCustomOre().setBlockTextureName("mcrossover:christmas/ore_white").setBlockName("ore.white").setHardness(2F);
	public static Block oreBlackDecorative = new BlockCustomOre().setBlockTextureName("mcrossover:christmas/ore_black").setBlockName("ore.black").setHardness(2F);
	
	public static Block[] ores = { oreYellowDecorative, oreRedDecorative,
			oreGreenDecorative, oreBlueDecorative, oreWhiteDecorative,
			oreBlackDecorative };

	public static Block blockYellowDecorative = new BlockMetalCustom().setBlockTextureName("mcrossover:christmas/block_yellow").setBlockName("block.yellow").setHardness(2F);
	public static Block blockRedDecorative = new BlockMetalCustom().setBlockTextureName("mcrossover:christmas/block_red").setBlockName("block.red").setHardness(2F);
	public static Block blockGreenDecorative = new BlockMetalCustom().setBlockTextureName("mcrossover:christmas/block_green").setBlockName("block.green").setHardness(2F);
	public static Block blockBlueDecorative = new BlockMetalCustom().setBlockTextureName("mcrossover:christmas/block_blue").setBlockName("block.blue").setHardness(2F);
	public static Block blockWhiteDecorative = new BlockMetalCustom().setBlockTextureName("mcrossover:christmas/block_white").setBlockName("block.white").setHardness(2F);
	public static Block blockBlackDecorative = new BlockMetalCustom().setBlockTextureName("mcrossover:christmas/block_black").setBlockName("block.black").setHardness(2F);
	
	public static Block[] blocks = { blockYellowDecorative, blockRedDecorative,
			blockGreenDecorative, blockBlueDecorative, blockWhiteDecorative,
			blockBlackDecorative };

	public static Item dustYellowDecorative = new ItemCustom().setTextureName("mcrossover:christmas/dust_yellow").setUnlocalizedName("dust.yellow");
	public static Item dustRedDecorative = new ItemCustom().setTextureName("mcrossover:christmas/dust_red").setUnlocalizedName("dust.red");
	public static Item dustGreenDecorative = new ItemCustom().setTextureName("mcrossover:christmas/dust_green").setUnlocalizedName("dust.green");
	public static Item dustBlueDecorative = new ItemCustom().setTextureName("mcrossover:christmas/dust_blue").setUnlocalizedName("dust.blue");
	public static Item dustWhiteDecorative = new ItemCustom().setTextureName("mcrossover:christmas/dust_white").setUnlocalizedName("dust.white");
	public static Item dustBlackDecorative = new ItemCustom().setTextureName("mcrossover:christmas/dust_black").setUnlocalizedName("dust.black");

	public static Item[] dusts = { dustYellowDecorative, dustRedDecorative,
			dustGreenDecorative, dustBlueDecorative, dustWhiteDecorative,
			dustBlackDecorative };

	public static Item ingotYellowDecorative = new ItemCustom().setTextureName("mcrossover:christmas/ingot_yellow").setUnlocalizedName("ingot.yellow");
	public static Item ingotRedDecorative = new ItemCustom().setTextureName("mcrossover:christmas/ingot_red").setUnlocalizedName("ingot.red");
	public static Item ingotGreenDecorative = new ItemCustom().setTextureName("mcrossover:christmas/ingot_green").setUnlocalizedName("ingot.green");
	public static Item ingotBlueDecorative = new ItemCustom().setTextureName("mcrossover:christmas/ingot_blue").setUnlocalizedName("ingot.blue");
	public static Item ingotWhiteDecorative = new ItemCustom().setTextureName("mcrossover:christmas/ingot_white").setUnlocalizedName("ingot.white");
	public static Item ingotBlackDecorative = new ItemCustom().setTextureName("mcrossover:christmas/ingot_black").setUnlocalizedName("ingot.black");
	
	public static Item[] ingots = { ingotYellowDecorative, ingotRedDecorative,
			ingotGreenDecorative, ingotBlueDecorative, ingotWhiteDecorative,
			ingotBlackDecorative };

	public static Fluid fluidYellowDecorative;
	public static Fluid fluidRedDecorative;
	public static Fluid fluidGreenDecorative;
	public static Fluid fluidBlueDecorative;
	public static Fluid fluidWhiteDecorative;
	public static Fluid fluidBlackDecorative;
	
	public static Fluid[] fluids = { fluidYellowDecorative, fluidRedDecorative,
			fluidGreenDecorative, fluidBlueDecorative, fluidWhiteDecorative,
			fluidBlackDecorative };

	public static int[] primaryColors = { 0xffff00, 0xff0000, 0x00ff00,
			0x0000ff, 0xffffff, 0x000000 };

	public static String[] chatColors = { "\u00a7e", "\u00a74", "\u00a7a",
			"\u00a71", "\u00a7f", "\u00a70" };
	
	public static Block fluidBlockYellowDecorative;
	public static Block fluidBlockRedDecorative;
	public static Block fluidBlockGreenDecorative;
	public static Block fluidBlockBlueDecorative;
	public static Block fluidBlockWhiteDecorative;
	public static Block fluidBlockBlackDecorative;

	public static Block[] fluidsBlocks = { fluidBlockYellowDecorative,
			fluidBlockRedDecorative, fluidBlockGreenDecorative,
			fluidBlockBlueDecorative, fluidBlockWhiteDecorative,
			fluidBlockBlackDecorative };

	
	@Handler
	public void preInit (FMLPreInitializationEvent e) {
		
//		christmasBallBlock = new ChristmasBallBlock();
//		
//		partBall = new DualMaterialToolPart("_ball", "Ball");
//		GameRegistry.registerItem(partBall, "ChristmasBallPart");
		String[] oreNames = {
				oreYellowDecorative.getUnlocalizedName().substring(5),
				oreRedDecorative.getUnlocalizedName().substring(5),
				oreGreenDecorative.getUnlocalizedName().substring(5),
				oreBlueDecorative.getUnlocalizedName().substring(5),
				oreWhiteDecorative.getUnlocalizedName().substring(5),
				oreBlackDecorative.getUnlocalizedName().substring(5) };

		String[] blockNames = {
				blockYellowDecorative.getUnlocalizedName().substring(5),
				blockRedDecorative.getUnlocalizedName().substring(5),
				blockGreenDecorative.getUnlocalizedName().substring(5),
				blockBlueDecorative.getUnlocalizedName().substring(5),
				blockWhiteDecorative.getUnlocalizedName().substring(5),
				blockBlackDecorative.getUnlocalizedName().substring(5) };

		String[] ingotNames = {
				ingotYellowDecorative.getUnlocalizedName(),
				ingotRedDecorative.getUnlocalizedName(),
				ingotGreenDecorative.getUnlocalizedName(),
				ingotBlueDecorative.getUnlocalizedName(),
				ingotWhiteDecorative.getUnlocalizedName(),
				ingotBlackDecorative.getUnlocalizedName()};

		String[] dustNames = {
				dustYellowDecorative.getUnlocalizedName(),
				dustRedDecorative.getUnlocalizedName(),
				dustGreenDecorative.getUnlocalizedName(),
				dustBlueDecorative.getUnlocalizedName(),
				dustWhiteDecorative.getUnlocalizedName(),
				dustBlackDecorative.getUnlocalizedName()};
		
		String[] fluidNames = {
				"YellowDecorative",
				"RedDecorative",
				"GreenDecorative",
				"BlueDecorative",
				"WhiteDecorative",
				"BlackDecorative"};
		String[][] names = { oreNames, blockNames, ingotNames, dustNames, fluidNames };
		
		registerAll(names);
	}
	
	@Handler
	public void init (FMLInitializationEvent e) {
		GameRegistry.registerWorldGenerator(new ChristmasWorldGenerator(), 0);
		ToolBuilder tb = ToolBuilder.instance;
//		christmasBall = new ChristmasBallAmmo();
//		tb.addNormalToolRecipe(christmasBall, partBall, TinkerTools.toolRod);
//		GameRegistry.registerItem(christmasBall, "christmasball");
	}
	
	@Handler
	public void postInit (FMLPostInitializationEvent e) {
		
	}
	
	private void registerAll (String [][] names) {
		for (int i = 0; i < ores.length ;i++) {
			System.out.println("Pass Number : " + i);
			ores[i].setHarvestLevel("pickaxe", 2);
			blocks[i].setHarvestLevel("pickaxe", 2);
			GameRegistry.registerBlock(ores[i], names[0][i]);
			GameRegistry.registerBlock(blocks[i], names[1][i]);
			GameRegistry.registerItem(dusts[i], names[3][i]);
			GameRegistry.registerItem(ingots[i], names[2][i]);
			Entry<Block, Fluid> entry;
			entry = TiCUtils.registerMaterial(125+i, names[4][i], fluids[i], fluidsBlocks[i], blocks[i], 0, 550, true);
			fluids[i] = entry.getValue();
			fluidsBlocks[i] = entry.getKey();
			TiCUtils.registerPartMaterial(125+i, names[4][i], 2, 400, 700, 3, 1F, 0, 0.0F, chatColors [i], primaryColors [i], 20, 2.0F, 0.1F, 100F);
			TiCUtils.addBasicMelting(new ItemStack(ingots[i]), true, ores[i], new ItemStack(blocks[i]), fluids[i]);
			TiCUtils.addBasicMelting(new ItemStack(dusts[i]), true, ores[i], new ItemStack(blocks[i]), fluids[i]);
			TiCUtils.addCasting(fluids[i], 125+i);
			Smeltery.addMelting(FluidType.getFluidType(fluids[i]), new ItemStack(dusts[i]), 0, TConstruct.ingotLiquidValue);
			CrossoverMain.addOreProcess(ingots[i], blocks[i], ores[i]);
			TiCUtils.registerUnknownThing(new ItemStack(ingots[i]), new ItemStack(blocks[i]), names[4][i]);
		}
	}
	
}
