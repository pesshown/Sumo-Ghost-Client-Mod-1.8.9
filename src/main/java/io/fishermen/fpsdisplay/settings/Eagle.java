package io.fishermen.fpsdisplay.settings;
import net.minecraft.util.*;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import pw.cinque.timechanger.ClickListener;
import io.fishermen.fpsdisplay.settings.GuiSettings.Categories;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.*;
import net.minecraft.item.*;

public class Eagle extends GuiSettings
{

	  public static Minecraft mc;

  public Eagle() {
	  super(GuiSettings.a(new char[] { 'E', 'a', 'g', 'l', 'e' }), "", Categories.Combat, 0, -1);
        Eagle.mc = Minecraft.getMinecraft();
        
        
    }
  
    @SubscribeEvent
   	public void onTick(final TickEvent e) { 
    	  if (!Eagle.mc.thePlayer.movementInput.jump == false) { 
     	    	return;
     	 }
    	  
    		if (!AimAssist.mc.thePlayer.isSprinting() == false) { 
                return;
            }  
 
	     if (!Eagle.mc.thePlayer.isInWater() == false) { 
		      return;	 
	     }
	 
	    if (!Eagle.mc.thePlayer.isInLava() == false) {
		     return;	 
	      }
    	  
        try {
            if (Eagle.mc.currentScreen == null && this.getItem() && Eagle.mc.theWorld.isAirBlock(new BlockPos(Eagle.mc.thePlayer.posX, Eagle.mc.thePlayer.posY - 1.0, Eagle.mc.thePlayer.posZ))) {
                KeyBinding.setKeyBindState(Eagle.mc.gameSettings.keyBindSneak.getKeyCode(), true);
            }
            else {
                KeyBinding.setKeyBindState(Eagle.mc.gameSettings.keyBindSneak.getKeyCode(), false);
            }
        }
        catch (Exception ex) {}
    }
    
    private boolean getItem() {
        return Eagle.mc.thePlayer.getCurrentEquippedItem() != null && !(Eagle.mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemSnow) && Item.getIdFromItem(Eagle.mc.thePlayer.getCurrentEquippedItem().getItem()) != 30 && Eagle.mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemBlock;
    }
    
    @Override
    public void dd() {
        KeyBinding.setKeyBindState(Eagle.mc.gameSettings.keyBindSneak.getKeyCode(), false);
    }
}
