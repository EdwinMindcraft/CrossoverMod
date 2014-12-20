package mod.mindcraft.addon.crossover.tconstruct.utils;

import java.util.logging.Logger;

import net.minecraftforge.fluids.FluidRegistry.FluidRegisterEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class CrossoverEventHandler {
	
	
	@SubscribeEvent
	public void onFluidRegistered (FluidRegisterEvent e) {
		Logger log = Logger.getLogger("Crossover");
		
		System.out.println("Fluid : " + e.fluidName + " - Id : " + e.fluidID);
		System.out.println("Succesfully Registered");
		e.setResult(Result.ALLOW);
	}

}
