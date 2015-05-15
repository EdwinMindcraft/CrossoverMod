package mod.mindcraft.addon.crossover.specialfluids;

import mantle.pulsar.pulse.Handler;
import mantle.pulsar.pulse.Pulse;
import mod.mindcraft.addon.crossover.fluids.BlockFluidReaction;
import mod.mindcraft.addon.crossover.fluids.BlockReaction;
import mod.mindcraft.addon.crossover.fluids.FluidBundle;
import mod.mindcraft.addon.crossover.fluids.FluidState;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder("mcrossover")
@Pulse(id="Crossover Personnal Stuff")
public class SpecialFluids {
	
	public static Fluid cryoBlock;
	public static Fluid cryoFluid;
	public static Fluid cryoGaz;
	public static Fluid cryoPlasma;
	public static FluidBundle cryoFluidBundle;
	public static Block cryoBlockBlock;
	public static Block cryoFluidBlock;
	public static Block cryoGasBlock;
	public static Block cryoPlasmaBlock;
	public static Fluid NULL_FLUID;
	
	
	@Handler
	public void preInit (FMLPreInitializationEvent e) {
		NULL_FLUID = new Fluid("NULL_FLUID");
		cryoBlock = new Fluid("cryoblock").setTemperature(-195);
		cryoFluid = new Fluid("croyfluid").setTemperature(95).setViscosity(3000);
		cryoGaz = new Fluid("cryogaz").setTemperature(295).setGaseous(true).setDensity(-1000).setViscosity(2000);
		cryoPlasma = new Fluid("cryoplasma").setTemperature(700).setGaseous(true).setDensity(-1000).setViscosity(500);
		
		FluidRegistry.registerFluid(cryoBlock);
		FluidRegistry.registerFluid(cryoFluid);
		FluidRegistry.registerFluid(cryoGaz);
		FluidRegistry.registerFluid(cryoPlasma);
		
		cryoFluidBundle = new FluidBundle(cryoBlock, cryoFluid, cryoGaz, cryoPlasma);
		
		cryoBlockBlock = new BlockReaction(Material.ice, cryoFluidBundle, FluidState.SOLID).setBlockName("randomBlock");
		cryoFluidBlock = new BlockFluidReaction(cryoFluidBundle, Material.water, "cryofluid", FluidState.LIQUID, false).setBlockName("randomBlock2");
		cryoGasBlock = new BlockFluidReaction(cryoFluidBundle, Material.water, "cryogas", FluidState.GAS, true).setBlockName("randomBlock3");
		cryoPlasmaBlock = new BlockFluidReaction(cryoFluidBundle, Material.water, "cryoplasma", FluidState.PLASMA, true).setBlockName("randomBlock4");
		
		GameRegistry.registerBlock(cryoBlockBlock, "randomBlock");
		GameRegistry.registerBlock(cryoFluidBlock, "randomBlock2");
		GameRegistry.registerBlock(cryoGasBlock, "randomBlock3");
		GameRegistry.registerBlock(cryoPlasmaBlock, "randomBlock4");
	}

	@Handler
	public void init (FMLInitializationEvent e) {
		
	}

	@Handler
	public void postInit (FMLPostInitializationEvent e) {
		
	}
}
