//package mod.mindcraft.addon.crossover.christmas.blocks;
//
//import net.minecraft.block.material.Material;
//import net.minecraft.client.renderer.texture.IIconRegister;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.util.IIcon;
//import net.minecraft.world.World;
//import tconstruct.tools.blocks.EquipBlock;
//
//public class ChristmasBallBlock extends EquipBlock{
//
//	IIcon icon;
//	
//	public ChristmasBallBlock() {
//		super(Material.glass);
//	}
//	
//    @Override
//    public String getTextureDomain (int textureNameIndex)
//    {
//        return "mcrossover:christmas/";
//    }
//    
//    @Override
//    public Integer getGui (World world, int x, int y, int z, EntityPlayer entityplayer)
//    {
//        return null;
//    }
//    
//    @Override
//    public int getRenderType() {
//    	return 1;
//    }
//    
//    @Override
//    public void registerBlockIcons(IIconRegister par1IconRegister) {
//    	//icon = par1IconRegister.registerIcon("");
//    }
//    
//    @Override
//    public String[] getTextureNames() {
//    	return new String[]{"christmas_ball"};
//    }
//    
//    
//}
