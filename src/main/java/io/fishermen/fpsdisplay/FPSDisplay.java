package io.fishermen.fpsdisplay;

import net.minecraftforge.client.event.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.*;
import net.minecraft.entity.item.*;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;

import java.util.*;

import io.fishermen.fpsdisplay.settings.AimAssist;
import io.fishermen.fpsdisplay.settings.GuiSettings;
import net.minecraft.util.*;
import pw.cinque.CommandSettings.CommandSettings;
import pw.cinque.timechanger.ClickListener;

public class FPSDisplay extends GuiSettings
{
    public static String a;
    public static String ab;
    public static CommandSettings min;
    public static CommandSettings max;
    public static CommandSettings ch;
    public static Minecraft mc;
    public static ClickListener Speed;
    public static ClickListener Sprint;
    public static ClickListener Weapon;
    public Random r;
    
    public FPSDisplay() {
        super(GuiSettings.a(new char[] { 'R', 'e', 'a', 'c', 'h' }), "", Categories.Combat, 0, -1);
        this.r = new Random();
        FPSDisplay.min = new CommandSettings(GuiSettings.a(new char[] { 'M', 'i', 'n' }), 3.0, 3.0, 6.0, 0.1);
        FPSDisplay.max = new CommandSettings(GuiSettings.a(new char[] { 'M', 'a', 'x' }), 3.1, 3.0, 6.0, 0.1);
        FPSDisplay.ch  = new CommandSettings(GuiSettings.a(new char[] { 'C', 'h', 'a', 'n', 'c', 'e' }), 80.0, 1.0, 100.0, 1.0);
        FPSDisplay.Speed = new ClickListener(a(new char[] { 'S', 'p', 'e', 'e', 'd' }), false);
        FPSDisplay.Sprint = new ClickListener(a(new char[] { 'S', 'p', 'r', 'i', 'n', 't', 'i', 'n', 'g' }), true);
        FPSDisplay.Weapon = new ClickListener(a(new char[] { 'W', 'e', 'a', 'p', 'o', 'n' }), false);
        FPSDisplay.mc = Minecraft.getMinecraft();
        this.avav(FPSDisplay.min);
        this.avav(FPSDisplay.max);
        this.avav(FPSDisplay.ch);
        this.avav(FPSDisplay.Speed);
        this.avav(FPSDisplay.Sprint);
        this.avav(FPSDisplay.Weapon);
    }
    
    @SubscribeEvent
    public void a(final MouseEvent a) {
    	  if (!FPSDisplay.mc.thePlayer.isInWater() == false) { 
   		      return;	 
   	     }
   	 
   	    if (!FPSDisplay.mc.thePlayer.isInLava() == false) {
   		     return;	 
   	      }
   	    
   	    if (!FPSDisplay.mc.thePlayer.isOnLadder() == false) {
   	          return;	 
	      }
   	    
   	 if (!FPSDisplay.mc.thePlayer.isSneaking() == false) {
   	          return;	 
         }
	 
   	   if (!(FPSDisplay.mc.thePlayer.getFoodStats().getFoodLevel() > 6)) {
   	             return;	 
            }
   	 
     	if (!FPSDisplay.mc.thePlayer.isPotionActive(Potion.poison) == false) {
            return;	 
          }
  	    if (!FPSDisplay.mc.thePlayer.isPotionActive(Potion.moveSlowdown) == false) {
         return;	 
       }
  
  	  if (!FPSDisplay.mc.thePlayer.isPotionActive(Potion.wither) == false) {
        return;	 
      }
  	 
	  if (!FPSDisplay.mc.thePlayer.isPotionActive(Potion.jump) == false) {
        return;	 
      }
  	 
	  if (!FPSDisplay.mc.thePlayer.isPotionActive(Potion.blindness) == false) {
		  return;	 
    }
	  if (FPSDisplay.Speed.i()) {
	       if (!FPSDisplay.mc.thePlayer.isPotionActive(Potion.moveSpeed)) {
          return;   
	         }
      }
           if (FPSDisplay.Sprint.i()) {
	       if (!FPSDisplay.mc.thePlayer.isSprinting()) {
           return;   
	         }
       }
         
        if (FPSDisplay.Weapon.i()) {
        	  if (FPSDisplay.mc.thePlayer.getCurrentEquippedItem() == null) {
                  return;
            }
        	  if (!(FPSDisplay.mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemSword) && !(FPSDisplay.mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemAxe)) {
                  return;
              }
        }
        
        Double random = Math.random();
        random *= 100.0;  
        
        final double d2 = FPSDisplay.min.g34() + this.r.nextDouble() * (FPSDisplay.max.g34() - FPSDisplay.min.g34());
        if (random < FPSDisplay.ch.g34()) {
        final Object[] objects = a(d2, 0.0, 0.0f);
        if (objects == null || objects[0] == null || objects[1] == null) {
      	  return;
      	}
        FPSDisplay.mc.objectMouseOver = new MovingObjectPosition((Entity)objects[0], (Vec3)objects[1]);
        FPSDisplay.mc.pointedEntity = (Entity)objects[0];
   	      }
      }
    public static Object[] a(final double d, final double expand, final float partialTicks) {
        final Entity var2 = FPSDisplay.mc.getRenderViewEntity();
        Entity entity = null;
        if (var2 == null || FPSDisplay.mc.theWorld == null) {
            return null;
        }
        FPSDisplay.mc.mcProfiler.startSection("pick");
        final Vec3 var3 = var2.getPositionEyes(0.0f);
        final Vec3 var4 = var2.getLook(0.0f);
        final Vec3 var5 = var3.addVector(var4.xCoord * d, var4.yCoord * d, var4.zCoord * d);
        Vec3 var6 = null;
        final float var7 = 1.0f;
        final List var8 = FPSDisplay.mc.theWorld.getEntitiesWithinAABBExcludingEntity(var2, var2.getEntityBoundingBox().addCoord(var4.xCoord * d, var4.yCoord * d, var4.zCoord * d).expand(1.0, 1.0, 1.0));
        double var9 = d;
        for (int var10 = 0; var10 < var8.size(); ++var10) {
            final Entity var11 = (Entity) var8.get(var10);
            if (var11.canBeCollidedWith()) {
                final float var12 = var11.getCollisionBorderSize();
                AxisAlignedBB var13 = var11.getEntityBoundingBox().expand((double)var12, (double)var12, (double)var12);
                var13 = var13.expand(expand, expand, expand);
                final MovingObjectPosition var14 = var13.calculateIntercept(var3, var5);
                if (var13.isVecInside(var3)) {
                    if (0.0 < var9 || var9 == 0.0) {
                        entity = var11;
                        var6 = ((var14 == null) ? var3 : var14.hitVec);
                        var9 = 0.0;
                    }
                }
                else if (var14 != null) {
                    final double var15 = var3.distanceTo(var14.hitVec);
                    if (var15 < var9 || var9 == 0.0) {
                        final boolean canRiderInteract = false;
                        if (var11 == var2.ridingEntity) {
                            if (var9 == 0.0) {
                                entity = var11;
                                var6 = var14.hitVec;
                            }
                        }
                        else {
                            entity = var11;
                            var6 = var14.hitVec;
                            var9 = var15;
                        }
                    }
                }
            }
        }
        if (var9 < d && !(entity instanceof EntityLivingBase) && !(entity instanceof EntityItemFrame) && ((EntityLivingBase)entity).canEntityBeSeen((Entity)(Minecraft.getMinecraft()).thePlayer)) {
            entity = null;
        }
        FPSDisplay.mc.mcProfiler.endSection();
        if (entity == null || var6 == null) {
            return null;
        }
        return new Object[] { entity, var6 };
    }
    
    static {
        FPSDisplay.a = new String(GuiSettings.a(new char[] { 'P', 'r', 'e', 's', 's', '.', '.' }));
        FPSDisplay.ab = new String(GuiSettings.a(new char[] { 'K', 'e', 'y', ':' }));
    }
}
