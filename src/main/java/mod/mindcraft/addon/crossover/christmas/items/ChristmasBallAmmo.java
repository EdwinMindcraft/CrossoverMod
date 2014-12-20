//package mod.mindcraft.addon.crossover.christmas.items;
//
//import java.util.List;
//
//import mod.mindcraft.addon.crossover.christmas.ChristmasThing;
//import net.minecraft.creativetab.CreativeTabs;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemStack;
//import net.minecraft.world.World;
//import tconstruct.library.TConstructRegistry;
//import tconstruct.library.crafting.ToolBuilder;
//import tconstruct.library.tools.CustomMaterial;
//import tconstruct.library.tools.FletchingMaterial;
//import tconstruct.library.tools.FletchlingLeafMaterial;
//import tconstruct.library.weaponry.AmmoItem;
//import tconstruct.tools.TinkerTools;
//
//public class ChristmasBallAmmo extends AmmoItem {
//
//	public ChristmasBallAmmo() {
//		super(0, "Christmas Balls");
//	}
//
//	@Override
//	public String getIconSuffix(int partType) {
//        switch (partType)
//        {
//            case 0:
//                return "_ball_head";
//            case 1:
//                return ""; // Doesn't break
//            case 3:
//                return "_ball_handle";
//            default:
//                return "";
//        }
//	}
//
//	@Override
//	public String getEffectSuffix() {
//		return "_ball_effect";
//	}
//
//	@Override
//	public String getDefaultFolder() {
//		return "ball";
//	}
//
//	@Override
//	public Item getHeadItem() {
//		return ChristmasThing.partBall;
//	}
//
//	@Override
//	public Item getAccessoryItem() {
//		return TinkerTools.toolRod;
//	}
//
//	@Override
//	public String[] getTraits() {
//		return new String[] { "ammo" };
//	}
//	
//	@Override
//    public boolean onItemUse (ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float clickX, float clickY, float clickZ) {
//		if (!player.isSneaking()) {
//			return false;
//		}		
//        else if (!world.getBlock(x, y, z).getMaterial().isSolid())
//        {
//            return false;
//        }
//		
//		switch (side) {
//		case 0:y--;
//		case 1:y++;
//		case 2:z--;
//		case 3:z++;
//		case 4:x--;
//		case 5:x++;
//		default:;
//		}
//		
//		if (player.capabilities.isCreativeMode) {
//			
//		}
//		else {
//			player.inventory.consumeInventoryItem(stack.getItem());			
//		}
//		
//		world.setBlock(x, y, z, ChristmasThing.christmasBallBlock);
//		
//		return true;
//	}
//	
//	@Override
//	public void buildTool(int id, String name, List list) {
//		
//        ItemStack tool = ToolBuilder.instance.buildTool(new ItemStack(getHeadItem(), 1, id), new ItemStack(getAccessoryItem()), null, "");
//        if (tool != null)
//        {
//            tool.getTagCompound().getCompoundTag("InfiTool").setBoolean("Built", true);
//            list.add(tool);
//        }
//	}
//	
//    @Override
//    public void registerPartPaths (int index, String[] location)
//    {
//        headStrings.put(index, location[0]);
//    }
//
//    @Override
//    public void registerAlternatePartPaths (int index, String[] location)
//    {
//        accessoryStrings.put(index, location[3]);
//    }
//    
//    @Override
//    public void getSubItems(Item id, CreativeTabs tab, List list) {
//        super.getSubItems(id, tab, list);
//    }
//    
//    @Override
//    protected int getDefaultColor(int renderPass, int materialID) {
//        if(renderPass != 2)
//            return super.getDefaultColor(renderPass, materialID);
//
//        CustomMaterial mat = TConstructRegistry.getCustomMaterial(materialID, FletchingMaterial.class);
//        if(mat == null) {
//            TConstructRegistry.getCustomMaterial(materialID, FletchlingLeafMaterial.class);
//            return 0xffffff;
//        }
//
//        return mat.color;
//    }
//}
