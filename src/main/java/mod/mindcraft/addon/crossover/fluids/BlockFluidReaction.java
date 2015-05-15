package mod.mindcraft.addon.crossover.fluids;

import java.util.Random;

import mod.mindcraft.addon.crossover.CrossoverMain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFluidReaction extends BlockFluidClassic {

	String texture;
	IIcon flowTexture;
	IIcon stillTexture;
	boolean alpha = false;
	private boolean overwriteFluidIcons = true;
	private FluidBundle bundle;
	private FluidState state;
	
	public BlockFluidReaction(FluidBundle fluid, Material material,  String texture, FluidState state, boolean alpha) {
		super(fluid.getFluidByState(state), material);
		this.texture = texture;
		this.alpha = alpha;
		this.bundle = fluid;
		this.state = state;
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
		Fluid fluid = this.getFluid();
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
			if (temp > 0 && fluidUp != FluidRegistry.WATER && this.isSourceBlock(world, x, y, z)) {
				world.createExplosion(null, x, y, z, explosionStrength, false);
				world.setBlock(x, y, z, fluidUp.getBlock());
			}
			else if (temp > 0 && fluidUp != FluidRegistry.WATER) {
				world.setBlock(x, y, z, Blocks.air);
			}
			if (temp < 0 &&  fluidDown != FluidRegistry.WATER && this.isSourceBlock(world, x, y, z)) {
				world.createExplosion(null, x, y, z, explosionStrength, false);
				world.setBlock(x, y, z, fluidDown.getBlock());
			}
			else if (temp < 0 && fluidUp != FluidRegistry.WATER) {
				world.setBlock(x, y, z, Blocks.air);
			}
			
		}
		
	}
	
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		super.onEntityCollidedWithBlock(world, x, y, z, entity);
		Fluid fluid = this.getFluid();
		
		if (fluid.getTemperature() < 260) {
			int damage = Math.max((260 - fluid.getTemperature()) / 20, 1);
			entity.attackEntityFrom(DamageSource.lava, damage);
		}
		
	}
	
	@Override
	public void registerBlockIcons(IIconRegister register) {
		stillTexture = register.registerIcon("mcrossover:" + texture);
		flowTexture = register.registerIcon("mcrossover:" + texture + "_flow");
        if (overwriteFluidIcons)
            this.getFluid().setIcons(stillTexture, flowTexture);
	}
	
    @Override
    public int getRenderBlockPass ()
    {
        return alpha ? 1 : 0;
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon (int side, int meta)
    {
        if (side == 0 || side == 1)
            return stillTexture;
        return flowTexture;
    }

    public void suppressOverwritingFluidIcons ()
    {
        overwriteFluidIcons = false;
    }
    
    

}
