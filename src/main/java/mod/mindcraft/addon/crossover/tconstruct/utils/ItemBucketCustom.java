package mod.mindcraft.addon.crossover.tconstruct.utils;

import tconstruct.TConstruct;
import tconstruct.smeltery.TinkerSmeltery;
import cpw.mods.fml.common.eventhandler.Event;
import mantle.world.WorldHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.fluids.BlockFluidFinite;

public class ItemBucketCustom extends ItemBucket {

    private Block isFull;
    
	public ItemBucketCustom(Block p_i45331_1_) {
		super(p_i45331_1_);
		isFull = p_i45331_1_;
		setContainerItem(Items.bucket);
	}
	   @Override
	    public ItemStack onItemRightClick (ItemStack stack, World world, EntityPlayer player)
	    {
	        float var4 = 1.0F;
	        double trueX = player.prevPosX + (player.posX - player.prevPosX) * (double) var4;
	        double trueY = player.prevPosY + (player.posY - player.prevPosY) * (double) var4 + 1.62D - (double) player.yOffset;
	        double trueZ = player.prevPosZ + (player.posZ - player.prevPosZ) * (double) var4;
	        boolean wannabeFull = false;
	        MovingObjectPosition position = this.getMovingObjectPositionFromPlayer(world, player, wannabeFull);

	        if (position == null)
	        {
	            return stack;
	        }
	        else
	        {
	            /*
	             * FillBucketEvent event = new FillBucketEvent(player, stack, world,
	             * position); if (MinecraftForge.EVENT_BUS.post(event)) { return
	             * stack; }
	             * 
	             * if (event.getResult() == Event.Result.ALLOW) { if
	             * (player.capabilities.isCreativeMode) { return stack; }
	             * 
	             * if (--stack.stackSize <= 0) { return event.result; }
	             * 
	             * if (!player.inventory.addItemStackToInventory(event.result)) {
	             * player.dropPlayerItem(event.result); }
	             * 
	             * return stack; }
	             */

	            if (position.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
	            {
	                int clickX = position.blockX;
	                int clickY = position.blockY;
	                int clickZ = position.blockZ;

	                if (!world.canMineBlock(player, clickX, clickY, clickZ))
	                {
	                    return stack;
	                }

	                if (position.sideHit == 0)
	                {
	                    --clickY;
	                }

	                if (position.sideHit == 1)
	                {
	                    ++clickY;
	                }

	                if (position.sideHit == 2)
	                {
	                    --clickZ;
	                }

	                if (position.sideHit == 3)
	                {
	                    ++clickZ;
	                }

	                if (position.sideHit == 4)
	                {
	                    --clickX;
	                }

	                if (position.sideHit == 5)
	                {
	                    ++clickX;
	                }

	                if (!player.canPlayerEdit(clickX, clickY, clickZ, position.sideHit, stack))
	                {
	                    return stack;
	                }

	                if (this.tryPlaceContainedLiquid(world, clickX, clickY, clickZ, stack.getItemDamage()) && !player.capabilities.isCreativeMode)
	                {
	                    return new ItemStack(Items.bucket);
	                }
	            }

	            return stack;
	        }
	    }
    
    public boolean tryPlaceContainedLiquid (World world, int clickX, int clickY, int clickZ, int type)
    {
        if (!WorldHelper.isAirBlock(world, clickX, clickY, clickZ) && world.getBlock(clickX, clickY, clickZ).getMaterial().isSolid())
        {
            return false;
        }
        else
        {
            try
            {
                if (isFull == null)
                    return false;

                int metadata = 0;
                if (isFull instanceof BlockFluidFinite)
                    metadata = 7;

                world.setBlock(clickX, clickY, clickZ, isFull, metadata, 0); // TODO: Merge liquids
            }
            catch (ArrayIndexOutOfBoundsException ex)
            {
                TConstruct.logger.warn("AIOBE occured when placing bucket into world; " + ex);
                return false;
            }

            return true;
        }
    }

}
