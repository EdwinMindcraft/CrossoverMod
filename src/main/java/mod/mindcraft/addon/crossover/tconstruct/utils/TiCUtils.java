package mod.mindcraft.addon.crossover.tconstruct.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import mod.mindcraft.addon.crossover.christmas.ChristmasThing;
import mod.mindcraft.addon.crossover.fluids.CrossoverFluidBlock;
import mod.mindcraft.addon.crossover.tconstruct.metallurgy.enums.EnumMetallurgyMaterials;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;
import tconstruct.TConstruct;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.client.TConstructClientRegistry;
import tconstruct.library.crafting.CastingRecipe;
import tconstruct.library.crafting.FluidType;
import tconstruct.library.crafting.LiquidCasting;
import tconstruct.library.crafting.PatternBuilder;
import tconstruct.library.crafting.Smeltery;
import tconstruct.library.tools.DualMaterialToolPart;
import tconstruct.library.util.IPattern;
import tconstruct.library.util.IToolPart;
import tconstruct.smeltery.TinkerSmeltery;
import tconstruct.tools.TinkerTools;
import tconstruct.weaponry.TinkerWeaponry;
import cpw.mods.fml.common.registry.GameRegistry;

public class TiCUtils {
	
	public static Entry registerMaterial(int fluidId, String fluidName, Fluid fluid, Block fluidBlock, Block metalBlock, int meltTemperature, boolean isToolPart) {
		
		fluid = new Fluid(fluidName.toLowerCase() + ".molten").setDensity(3000).setViscosity(6000).setTemperature(1300);
		boolean isFluidPreReg = !FluidRegistry.registerFluid(fluid);
		fluidBlock = new CrossoverFluidBlock(fluid, fluidName.toLowerCase()).setBlockName("fluid.molten." + fluidName.toLowerCase());
		GameRegistry.registerBlock(fluidBlock, "fluid.molten." + fluidName.toLowerCase());
		if (isFluidPreReg)
		{
			fluid = FluidRegistry.getFluid(fluidName.toLowerCase() + ".molten");
			Block regMoltenFluidBlock = fluid.getBlock();
			if (regMoltenFluidBlock != null)
			{
				((CrossoverFluidBlock) fluidBlock).suppressOverwritingFluidIcons();
				fluidBlock = regMoltenFluidBlock;
			}
			else
				fluid.setBlock(fluidBlock);
		}
		FluidType.registerFluidType(fluidName, metalBlock, 0, meltTemperature, fluid, isToolPart);
		Map<Block, Fluid> thing = new HashMap<Block, Fluid>();
		thing.put(fluidBlock, fluid);
		Entry<Block, Fluid> val = null;
		for (Entry<Block, Fluid> entry : thing.entrySet()) {
			val = entry;
		}
		return val;	
	}
	
	public static Entry registerMaterial(int fluidId, String fluidName, Fluid fluid, Block fluidBlock, Block metalBlock, int metadata, int meltTemperature, boolean isToolPart) {
		
		fluid = new Fluid( "molten." + fluidName.toLowerCase()).setDensity(3000).setViscosity(6000).setTemperature(1300);
		boolean isFluidPreReg = !FluidRegistry.registerFluid(fluid);
		fluidBlock = new CrossoverFluidBlock(fluid, fluidName.toLowerCase()).setBlockName("fluid.molten." + fluidName.toLowerCase());
		GameRegistry.registerBlock(fluidBlock, "fluid.molten." + fluidName.toLowerCase());
		if (isFluidPreReg)
		{
			fluid = FluidRegistry.getFluid("molten" + fluidName.toLowerCase() );
			Block regMoltenFluidBlock = fluid.getBlock();
			if (regMoltenFluidBlock != null)
			{
				((CrossoverFluidBlock) fluidBlock).suppressOverwritingFluidIcons();
				fluidBlock = regMoltenFluidBlock;
			}
			else
				fluid.setBlock(fluidBlock);
		}
		fluid.setBlock(fluidBlock);
		FluidType.registerFluidType(fluidName, metalBlock, metadata, meltTemperature, fluid, isToolPart);
		Map<Block, Fluid> thing = new HashMap<Block, Fluid>();
		thing.put(fluidBlock, fluid);
		Entry<Block, Fluid> val = null;
		for (Entry<Block, Fluid> entry : thing.entrySet()) {
			val = entry;
		}
		return val;
	}
	
	public static void registerPartMaterial(int materialId, String name, EnumMetallurgyMaterials mat) {
		registerPartMaterial(materialId, name, mat.getMiningLevel(), mat.getDurability(), mat.getMiningSpeed(), mat.getDamage(), mat.getHandleModifier(), mat.getReinforced(), mat.getStonebound(), mat.getChatColor(), mat.getColor(), mat.getDrawSpeed(), mat.getSpeedMax(), mat.getMass(), mat.getFragility());
	}
	
	public static void registerPartMaterial(int materialId, String name, int harvesetLevel, int durability, int miningSpeed, int attack, float handleModifier, int reinforced, float stonebound, String style, int primaryColor, int drawSpeed, float speedMax, float mass, float fragility) {
		//Part registry
		TConstructRegistry.addToolMaterial(materialId, name, harvesetLevel, durability, miningSpeed, attack, handleModifier, reinforced, stonebound, style, primaryColor);
		TConstructRegistry.addDefaultToolPartMaterial(materialId);
		TConstructRegistry.addDefaultShardMaterial(materialId);
        TConstructRegistry.addBowMaterial(materialId, drawSpeed, speedMax);
        TConstructRegistry.addArrowMaterial(materialId, mass,  fragility);
        PatternBuilder pb = PatternBuilder.instance;
		pb.registerMaterialSet(name, new ItemStack(TinkerTools.toolShard, 1, materialId), new ItemStack(TinkerTools.toolRod, 1, materialId), materialId);
	}
	
	public static void addBasicMelting(ItemStack ingot, boolean isOre, Block oreBlock, ItemStack metalBlock, Fluid fluid) {
		LiquidCasting basinCasting = TConstructRegistry.getBasinCasting();
        LiquidCasting tableCasting = TConstructRegistry.instance.getTableCasting();
		
        ItemStack ingotcast = new ItemStack(TinkerSmeltery.metalPattern, 1, 0);
		
        basinCasting.addCastingRecipe(metalBlock, new FluidStack(fluid, TConstruct.blockLiquidValue), null, true, 100);
        tableCasting.addCastingRecipe(ingot, new FluidStack(fluid, TConstruct.ingotLiquidValue), ingotcast, false, 50);
		Smeltery.addMelting(FluidType.getFluidType(fluid), ingot, 0, TConstruct.ingotLiquidValue);
		if (isOre) {
			Smeltery.addMelting(FluidType.getFluidType(fluid), new ItemStack(oreBlock), 0, TConstruct.ingotLiquidValue*2);
		}
		Smeltery.addMelting(FluidType.getFluidType(fluid),ingot, 0, TConstruct.blockLiquidValue);
	}
	
	public static void registerUnknownThing (ItemStack ingot, ItemStack block, String materialName) {
		PatternBuilder.instance.registerMaterial(ingot, 2, materialName);		
		PatternBuilder.instance.registerMaterial(block, 18, materialName);		
	}
	
	public static void addCasting(Fluid fluid, int fluidId) {
        LiquidCasting tableCasting = TConstructRegistry.instance.getTableCasting();
        Item[] patternOutputs = new Item[] { TinkerWeaponry.partShuriken, TinkerWeaponry.partCrossbowLimb, TinkerWeaponry.partCrossbowBody, TinkerWeaponry.partBowLimb };
        int fluidAmount = 0;
        
        for (int iter = 0; iter < TinkerTools.patternOutputs.length; iter++)
        {
            if (TinkerTools.patternOutputs[iter] != null)
            {
            	ItemStack cast = new ItemStack(TinkerSmeltery.metalPattern, 1, iter + 1);
                fluidAmount = ((IPattern) TinkerSmeltery.metalPattern).getPatternCost(cast) * TConstruct.ingotLiquidValue / 2;
                ItemStack metalCast = new ItemStack(TinkerTools.patternOutputs[iter], 1, fluidId);
                tableCasting.addCastingRecipe(metalCast, new FluidStack(fluid, fluidAmount), cast, 50);
                Smeltery.addMelting(FluidType.getFluidType(fluid), metalCast, 0, fluidAmount);
            }
        }
        
        
        
        for (int iter = 0; iter < patternOutputs.length; iter++)
        {
        	ItemStack cast = new ItemStack(TinkerWeaponry.metalPattern, 1, iter);
            int fluidAmount2 = TinkerWeaponry.metalPattern.getPatternCost(cast) * TConstruct.ingotLiquidValue / 2;
            ItemStack metalCast = new ItemStack(patternOutputs[iter], 1, fluidId);
            tableCasting.addCastingRecipe(metalCast, new FluidStack(fluid, fluidAmount2), cast, 50);
            Smeltery.addMelting(FluidType.getFluidType(fluid), metalCast, 0, fluidAmount2);
        }
        
        ItemStack arrowCast = new ItemStack(TinkerSmeltery.metalPattern, 1, 25);
        int arrowFluidAmount = ((IPattern)TinkerSmeltery.metalPattern).getPatternCost(arrowCast) * TConstruct.ingotLiquidValue / 2;
        ItemStack arrowMetalCast = new ItemStack(TinkerWeaponry.arrowhead, 1, fluidId);
        tableCasting.addCastingRecipe(arrowMetalCast, new FluidStack(fluid, arrowFluidAmount), arrowCast, 50);
        Smeltery.addMelting(FluidType.getFluidType(fluid), arrowMetalCast, 0, arrowFluidAmount);
        

	}
    public static void registerBoltCasting()
    {
        LiquidCasting tb = TConstructRegistry.getTableCasting();

        for(Map.Entry<String, FluidType> entry : FluidType.fluidTypes.entrySet()) {
            if(!entry.getValue().isToolpart)
                continue;
            FluidStack liquid = new FluidStack(entry.getValue().fluid, TConstruct.ingotLiquidValue);
            CastingRecipe recipe = tb.getCastingRecipe(liquid, new ItemStack(TinkerSmeltery.metalPattern, 1, 2)); // pickaxe
            if(recipe == null)
                continue;

            int matID = recipe.getResult().getItemDamage();

            for(Integer id : TConstructRegistry.toolMaterials.keySet()) {
                ItemStack rod = new ItemStack(TinkerTools.toolRod, 1, id);
                if(((IToolPart)TinkerTools.toolRod).getMaterialID(rod) == -1)
                    continue;

                tb.addCastingRecipe(DualMaterialToolPart.createDualMaterial(TinkerWeaponry.partBolt, id, matID), liquid, rod, true, 150);
            }
        }
    }
    
    public static void registerChristmasBallCasting()
    {
        LiquidCasting tb = TConstructRegistry.getTableCasting();

        for(Map.Entry<String, FluidType> entry : FluidType.fluidTypes.entrySet()) {
            if(!entry.getValue().isToolpart)
                continue;
            FluidStack liquid = new FluidStack(entry.getValue().fluid, TConstruct.ingotLiquidValue);
            CastingRecipe recipe = tb.getCastingRecipe(liquid, new ItemStack(TinkerSmeltery.metalPattern, 1, 2)); //pickaxe
            if(recipe == null)
                continue;

            int matID = recipe.getResult().getItemDamage();

            for(Integer id : TConstructRegistry.toolMaterials.keySet()) {
                ItemStack rod = new ItemStack(TinkerTools.frypanHead, 1, id);
                if(((IToolPart)TinkerTools.frypanHead).getMaterialID(rod) == -1)
                    continue;

                tb.addCastingRecipe(DualMaterialToolPart.createDualMaterial(ChristmasThing.partBall, id, matID), liquid, rod, true, 150);
            }
        }
    }
}
