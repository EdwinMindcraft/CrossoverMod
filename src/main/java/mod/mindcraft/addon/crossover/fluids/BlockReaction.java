package mod.mindcraft.addon.crossover.fluids;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidBlock;

public class BlockReaction extends Block{

	private FluidState state;
	private FluidBundle bundle;
	private Fluid fluid;
	private int tickRate = 20;

	public BlockReaction(Material mat, FluidBundle bundle, FluidState state) {
		super(mat);
		this.bundle = bundle;
		this.state = state;
		this.fluid = bundle.getFluidByState(state);
        this.setTickRandomly(true);
        fluid.setBlock(this);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		super.updateTick(world, x, y, z, rand);
		Block blockN = world.getBlock(x+1, y, z);
		Block blockS = world.getBlock(x-1, y, z);
		Block blockE = world.getBlock(x, y, z+1);
		Block blockW = world.getBlock(x, y, z-1);
		Block blockU = world.getBlock(x, y+1, z);
		Block blockD = world.getBlock(x, y-1, z);
		
		boolean explode = false;
		float explosionStrength = 0F;
		int temp = 0;
		
		Block[] blocks = {blockN, blockS, blockE, blockW, blockU, blockS};
		
		for (Block block : blocks) {
			if((block instanceof BlockFluidBase) || (block instanceof BlockReaction)) {
				
				FluidState sUp = bundle.cycleState(state, true);
				FluidState sDown = bundle.cycleState(state, false);
				Fluid fluidUp = bundle.getFluidByState(sUp);
				Fluid fluidDown = bundle.getFluidByState(sDown);
				Fluid blockFluid;
				
				if (block instanceof BlockFluidBase) {
					blockFluid = ((BlockFluidBase)block).getFluid();
				} else {
					blockFluid = ((BlockReaction)block).getFluid();
				}
				int maxCapTemp = fluid.getTemperature() + 100;
				int minCapTemp = fluid.getTemperature() - 100;
				if (fluidUp != FluidRegistry.WATER) {
					maxCapTemp = fluidUp.getTemperature();
				}
				if (fluidDown != FluidRegistry.WATER) {
					minCapTemp = fluidDown.getTemperature();
				}
				
				if (!((blockFluid.getTemperature() <= maxCapTemp) && (blockFluid.getTemperature() >= minCapTemp))) {
					explode = true;
					explosionStrength += (Math.max(blockFluid.getTemperature(), fluid.getTemperature()) - Math.min(blockFluid.getTemperature(), fluid.getTemperature()))/100;
				}
				if (blockFluid.getTemperature() < fluid.getTemperature()) {
					temp--;
				}
				else if (blockFluid.getTemperature() > fluid.getTemperature()) {
					temp++;
				}
			}
		}
		
		if (explode) {
			FluidState sUp = bundle.cycleState(state, true);
			FluidState sDown = bundle.cycleState(state, false);
			Fluid fluidUp = bundle.getFluidByState(sUp);
			Fluid fluidDown = bundle.getFluidByState(sDown);		
			if (temp > 0 && fluidUp != FluidRegistry.WATER) {
				world.createExplosion(null, x, y, z, explosionStrength, false);
				world.setBlock(x, y, z, fluidUp.getBlock());
			}
			if (temp < 0 &&  fluidDown != FluidRegistry.WATER) {
				world.createExplosion(null, x, y, z, explosionStrength, false);
				world.setBlock(x, y, z, fluidDown.getBlock());
			}
			
		}
		
	}
	
	public Fluid getFluid() {
		return fluid;
	}
    @Override
    public void onBlockAdded(World world, int x, int y, int z)
    {
        world.scheduleBlockUpdate(x, y, z, this, tickRate );
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        world.scheduleBlockUpdate(x, y, z, this, tickRate);
    }


}
