package mod.mindcraft.addon.crossover.fluids;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CrossoverFluidBlock extends BlockFluidClassic {

	String texture;
	IIcon flowTexture;
	IIcon stillTexture;
	boolean alpha = false;
	private boolean overwriteFluidIcons = true;
	
	public CrossoverFluidBlock(Fluid fluid, String texture) {
		super(fluid, Material.lava);
		this.texture = texture;
	}
	
    public CrossoverFluidBlock(Fluid fluid, String texture, boolean alpha)
    {
        this(fluid, texture);
        this.alpha = alpha;
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
