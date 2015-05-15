package mod.mindcraft.addon.crossover.fluids;

import com.sun.org.apache.regexp.internal.recompile;

import net.minecraft.block.Block;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidBundle {
	
	private Fluid solid;
	private Fluid liquid;
	private Fluid gas;
	private Fluid plasma;
	
	public FluidBundle(Fluid solid, Fluid liquid, Fluid gas, Fluid plasma) {
		this.solid = solid;
		this.liquid = liquid;
		this.gas = gas;
		this.plasma = plasma;
	}
	
	public Fluid getFluidByState (FluidState state) {
		switch (state) {
		case SOLID:
			return check(solid);
		case GAS:
			return check(gas);
		case LIQUID:
			return check(liquid);
		case PLASMA:
			return check(plasma);
		default:
			return FluidRegistry.WATER;
		}
	}
	
	private Fluid check(Fluid b) {
		if (b != null) {
			return b;
		}
		return FluidRegistry.WATER;
	}
	
	public FluidState cycleState (FluidState s, boolean up) {
		if (up) {
			switch (s) {
			case SOLID: return FluidState.LIQUID;
			case LIQUID: return FluidState.GAS;
			case GAS: return FluidState.PLASMA;
			default: return FluidState.PLASMA;
			}
		}
		else {
			switch (s) {
			case PLASMA: return FluidState.GAS;
			case LIQUID: return FluidState.SOLID;
			case GAS: return FluidState.LIQUID;
			default: return FluidState.SOLID;
			}
			
		}
	}
}
