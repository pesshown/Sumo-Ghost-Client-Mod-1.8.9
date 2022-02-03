package io.fishermen.fpsdisplay.settings;

import java.util.*;

import io.fishermen.fpsdisplay.FPSDisplay;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.*;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.eventhandler.*;
import pw.cinque.CommandSettings.CommandSettings;
import pw.cinque.timechanger.ClickListener;

public class KbModifier extends GuiSettings
{
    public static CommandSettings x;
    public static CommandSettings y;
    public static CommandSettings cha;
    public static ClickListener click;
    public static ClickListener Sprint;
    public static ClickListener Weapon;
    public static ClickListener ground;

    boolean lpx;
    public Random random;
    
    public KbModifier() {
        super(a(new char[] { 'V', 'e', 'l', 'o', 'c', 'i', 't', 'y' }), "", Categories.Combat, 0, 0);
        this.random = new Random();
        this.lpx = false;
        KbModifier.x = new CommandSettings(a(new char[] { 'X' }), 90.0, 1.0, 100.0, 1.0);
        KbModifier.y = new CommandSettings(a(new char[] { 'Y' }), 100.0, 1.0, 100.0, 1.0);
        KbModifier.cha = new CommandSettings(a(new char[] { 'C', 'h', 'a', 'n', 'c', 'e' }), 80.0, 1.0, 100.0, 1.0);
        KbModifier.click = new ClickListener(a(new char[]  { 'C', 'l', 'i', 'c', 'k' }), true);
        KbModifier.Sprint = new ClickListener(a(new char[] { 'S', 'p', 'r', 'i', 'n', 't', 'i', 'n', 'g' }), false);
        KbModifier.Weapon = new ClickListener(a(new char[] { 'W', 'e', 'a', 'p', 'o', 'n' }), false);
        KbModifier.ground = new ClickListener(a(new char[] { 'O', 'n', 'l', 'y', ' ','G', 'r', 'o', 'u', 'n', 'd' }), true);
        this.avav(KbModifier.x);
        this.avav(KbModifier.y);
        this.avav(KbModifier.cha);
        this.avav(KbModifier.click);
        this.avav(KbModifier.Sprint);
        this.avav(KbModifier.Weapon);
        this.avav(KbModifier.ground);
    }
    
    @SubscribeEvent
    public void onTick(final TickEvent.RenderTickEvent ee) {
    if ((Minecraft.getMinecraft()).thePlayer == null) {
    	       return;
    	     }
      if ((Minecraft.getMinecraft()).theWorld == null) {
    	       return;
    	     }
   	     if (!KbModifier.mc.thePlayer.isInWater() == false) { 
   		      return;	 
   	     }
   	 
   	    if (!KbModifier.mc.thePlayer.isInLava() == false) {
   		     return;	 
   	      }
   	 
   	     if (!KbModifier.mc.thePlayer.isEating() == false) {
   	         return;	 
	      }
   	     
   	     if (!KbModifier.mc.thePlayer.isSneaking() == false) {
	          return;	 
            }
   	     
   	     if (!(KbModifier.mc.thePlayer.getFoodStats().getFoodLevel() > 6)) {
          return;	 
           }
   	  
   	     if (!KbModifier.mc.thePlayer.movementInput.jump == false) { 
   	    	return;
   	        }
   	     
   	     if (!KbModifier.mc.thePlayer.isPotionActive(Potion.poison) == false) {
           return;	 
            }
   	  
   	    if (!KbModifier.mc.thePlayer.isPotionActive(Potion.moveSlowdown) == false) {
          return;	 
           }
   	 
   	    if (!KbModifier.mc.thePlayer.isPotionActive(Potion.wither) == false) {
         return;	 
         }
   	 
	    if (!KbModifier.mc.thePlayer.isPotionActive(Potion.jump) == false) {
         return;	 
         }
   	 
	    if (!KbModifier.mc.thePlayer.isPotionActive(Potion.blindness) == false) {
		  return;	 
          }
	 
   	    if (!KbModifier.mc.gameSettings.keyBindJump.isKeyDown() == false) {
	        return;
          }

    if (!KbModifier.mc.gameSettings.keyBindSneak.isKeyDown() == false) {
   	    return;
        }  
              
    if (KbModifier.click.i() && !KbModifier.mc.gameSettings.keyBindAttack.isKeyDown()) {
             this.lpx = false;
             return;
          }  
    
    if (KbModifier.ground.i()) {
   	   if (!KbModifier.mc.thePlayer.onGround) { 
              return;   
   	         }
          }
    if (KbModifier.Sprint.i()) {
  	    if (!KbModifier.mc.thePlayer.isSprinting()) {
         return;   
  	         }
         }
    if (KbModifier.Weapon.i()) {
      if (KbModifier.mc.thePlayer.getCurrentEquippedItem() == null) {
                return;
          }
     if (!( KbModifier.mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemSword) && !(KbModifier.mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemAxe)) {
         return;
        }
      }
        Double random = Math.random();
        random *= 100.0;
        if (mc.thePlayer.hurtTime == mc.thePlayer.maxHurtTime && mc.thePlayer.maxHurtTime > 0) {
           if (random < KbModifier.cha.g34()) {
            final EntityPlayerSP thePlayer4;
            final EntityPlayerSP thePlayer = thePlayer4 = mc.thePlayer;
            thePlayer4.motionX *= KbModifier.x.g34() / 100.0;
            final EntityPlayerSP thePlayer5;
            final EntityPlayerSP thePlayer2 = thePlayer5 = mc.thePlayer;
            thePlayer5.motionY *= KbModifier.y.g34() / 100.0;
            final EntityPlayerSP thePlayer6;
            final EntityPlayerSP thePlayer3 = thePlayer6 = mc.thePlayer;
            thePlayer6.motionZ *= KbModifier.x.g34() / 100.0;
           }
        }
      } 
  }