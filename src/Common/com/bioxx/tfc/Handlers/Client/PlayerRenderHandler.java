package com.bioxx.tfc.Handlers.Client;

import com.bioxx.tfc.Core.TFC_Core;
import com.bioxx.tfc.Items.ItemBlocks.ItemBarrels;
import com.bioxx.tfc.api.TFCItems;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import net.minecraftforge.client.event.RenderPlayerEvent.Specials.Pre;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import com.bioxx.tfc.Core.Player.InventoryPlayerTFC;
import com.bioxx.tfc.Items.ItemQuiver;
import com.bioxx.tfc.Render.RenderLargeItem;
import com.bioxx.tfc.Render.RenderQuiver;

public class PlayerRenderHandler {

	public static final RenderQuiver RENDER_QUIVER = new RenderQuiver();
	public static final RenderLargeItem RENDER_LARGE = new RenderLargeItem();

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onPlayerRenderTick(/*RenderPlayerEvent.Specials.*/Pre e) {
		EntityLivingBase el = e.entityLiving;

		if(el instanceof EntityPlayer){
			if(((EntityPlayer)el).inventory instanceof InventoryPlayerTFC){
				//ItemStack equipables[] = TFC_Core.getBack((EntityPlayer)el);
				ItemStack[] equipables = ((InventoryPlayerTFC)((EntityPlayer)el).inventory).extraEquipInventory;






				for(ItemStack i : equipables){
					if(i != null && i.getItem() instanceof ItemQuiver){
						RENDER_QUIVER.render(e.entityLiving,i,e.renderer);
					}
					else if(i != null){

						RENDER_LARGE.render((EntityPlayer)el,i,e);
					}
				}
			}
		}
	}
	private int checkShield(EntityPlayer player) {
		//Checking for an equipped shield
		if (player.inventory instanceof InventoryPlayerTFC) {
			ItemStack[] extraEquipInv = ((InventoryPlayerTFC) player.inventory).extraEquipInventory;
			boolean hasShield = false;

			for (ItemStack itemStack : extraEquipInv) {
				if (itemStack != null && itemStack.getItem() instanceof ItemBarrels) {
					hasShield = true;
					break;
				}
			}

			//if(!hasShield) {
			return 0;
			//}
			//}

		/*//Checking for a shield mount (TRUE if a player is holding weapon in the main hand)
		if(player.getCurrentEquippedItem() != null) {
		if(player.getCurrentEquippedItem().getItem() instanceof ItemWeapon
		|| player.getCurrentEquippedItem().getItem() instanceof ItemCustomAxe) {
		return EnumShieldStatus.IN_HAND;
		}
		}

		return EnumShieldStatus.ON_BACK;*/

		}
		return 0;
	}
	@SubscribeEvent
	public void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent e) {

	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onPlayerTick(TickEvent.PlayerTickEvent e) {
		/*if (e.side.isClient()) {
		
		}*/
	}
}
