package io.fishermen.fpsdisplay.settings;

import java.util.*;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraft.client.settings.*;
import pw.cinque.CommandSettings.CommandSettings;

public class RR extends GuiSettings
{
    private long n;
    private long a;
    public static CommandSettings c;
    public Random random;
    
    public RR() {
        super(a(new char[] { 'W', 'T', 'a', 'p' }), "", Categories.Combat, 0, 0);
        this.n = 0L;
        this.a = 0L;
        this.random = new Random();
        this.avav(RR.c = new CommandSettings(a(new char[] { 'C', 'h', 'a', 'n', 'c', 'e' }), 90.0, 1.0, 100.0, 1.0));
    }
    
    @SubscribeEvent
    public void a(final AttackEntityEvent a) {
        if (!mc.thePlayer.isSprinting()) {
            return;
        }
        if ((int)RR.c.g34() >= this.random.nextInt(100) && this.a == 0L && this.n == 0L) {
            this.a = System.currentTimeMillis() + 40L + this.random.nextInt(325);
        }
    }
    
    @SubscribeEvent
    public void onTick(final TickEvent.RenderTickEvent ee) {
    	
    	 if (!RR.mc.gameSettings.keyBindAttack.isKeyDown()) {
        	 return;
        }
        	    if (!RR.mc.thePlayer.isInWater() == false) { 
      		      return;	 
      	     }
      	 
      	    if (!RR.mc.thePlayer.isInLava() == false) {
      	    	return;	 
      	      }
      	   
      	    if (!RR.mc.thePlayer.isOnLadder() == false) {
    	          return;	 
              }
      	     
      	   if (!RR.mc.thePlayer.onGround == true) { 
    		      return;	 
    	        }
      	     
      	     if (!RR.mc.thePlayer.isSneaking() == false) {
      	    	return;		 
               }
      	     
      	     if (!(RR.mc.thePlayer.getFoodStats().getFoodLevel() > 6)) {
      	    	return;	 
              }
        if (!mc.thePlayer.isSprinting() && this.a > 0L) {
            this.a = 0L;
            return;
        }
        if (System.currentTimeMillis() - this.a > 0L && this.a != 0L) {
            final int f = mc.gameSettings.keyBindForward.getKeyCode();
            KeyBinding.setKeyBindState(f, false);
            KeyBinding.onTick(f);
            this.n = System.currentTimeMillis() + 90L + this.random.nextInt(50);
            this.a = 0L;
        }
        else if (System.currentTimeMillis() - this.n > 0L && this.n != 0L) {
            final int g = mc.gameSettings.keyBindForward.getKeyCode();
            KeyBinding.setKeyBindState(g, true);
            KeyBinding.onTick(g);
            this.n = 0L;
        }
    }
}
