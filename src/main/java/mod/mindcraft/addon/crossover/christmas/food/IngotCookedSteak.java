package mod.mindcraft.addon.crossover.christmas.food;

import java.util.List;

import mod.mindcraft.addon.crossover.christmas.ChristmasThing;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class IngotCookedSteak extends ItemFood{
	IIcon icon;

	public IngotCookedSteak() {
		super(8, 5F, true);
		setHasSubtypes(true);
		setMaxDamage(0);
	}
	
	@Override
	public int getColorFromItemStack(ItemStack is, int m) {
		return ChristmasThing.primaryColors[is.getItemDamage()];
	}
	
	@Override
	public void getSubItems(Item thisItem, CreativeTabs tab, List subItems) {
		for (int i = 0; i < 6; i++) {
			ItemStack is = new ItemStack(thisItem, 1, i);
			subItems.add(is);
			thisItem.setCreativeTab(CreativeTabs.tabFood);
		}
	}
	
	@Override
	public IIcon getIconFromDamage(int p_77617_1_) {
		return icon;
	}
	
	@Override
	public void registerIcons(IIconRegister iconR) {
		icon = iconR.registerIcon("mcrossover:christmas/food/steakCooked");
	}
	
	@Override
	public String getUnlocalizedName(ItemStack i) {
		// TODO Auto-generated method stub
		return "steak.cooked" + ChristmasThing.ingots[i.getItemDamage()].getUnlocalizedName();
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World w, EntityPlayer player) {
		if (!w.isRemote) {
			switch (stack.getItemDamage()) {
			case 0:
				player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 20*120, 1));
				break;
			case 1:
				player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 20*120, 1));
				break;
			case 2:
				player.addPotionEffect(new PotionEffect(Potion.jump.id, 20*120, 1));
				break;
			case 3:
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 20*120, 1));
				break;
			case 4:
				player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 20*120, 1));
				break;
			case 5:
				player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 20*120, 1));
				break;
			default:
				break;
			}
		}
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player,List list, boolean bool) {
		switch (stack.getItemDamage()) {
		case 0:
			list.add("yellow.steak.cooked.lore");
			break;
		case 1:
			list.add("red.steak.cooked.lore");
			break;
		case 2:
			list.add("green.steak.cooked.lore");
			break;
		case 3:
			list.add("blue.steak.cooked.lore");
			break;
		case 4:
			list.add("white.steak.cooked.lore");
			break;
		case 5:
			list.add("black.steak.cooked.lore");
			break;
		default:
			break;
		}
	}

}
