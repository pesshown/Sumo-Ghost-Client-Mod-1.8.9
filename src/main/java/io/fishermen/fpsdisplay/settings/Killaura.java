package io.fishermen.fpsdisplay.settings;

import pw.cinque.timechanger.*;
import net.minecraft.entity.*;
import net.minecraft.client.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.gameevent.*;
import java.util.*;

import io.fishermen.fpsdisplay.FPSDisplay;
import net.minecraftforge.fml.common.eventhandler.*;
import pw.cinque.CommandSettings.CommandSettings;

public class Killaura extends GuiSettings
{
    private long nd;
    public static CommandSettings range;
    public static CommandSettings angle;
    public static CommandSettings min;
    public static CommandSettings max;
    public static ClickListener bh;
    public static ClickListener click;
    boolean a;
    boolean b;
    public Random rand;
    protected long l;
    
    public Killaura() {
        super(GuiSettings.a(new char[] { 'K', 'i', 'l', 'l', 'A', 'u', 'r', 'a' }), "", Categories.Combat, 0, -1);
        this.a = true;
        this.b = false;
        this.rand = new Random();
        this.l = -1L;
        Killaura.range = new CommandSettings(GuiSettings.a(new char[] { 'R', 'a', 'n', 'g', 'e' }), 3.7, 1.0, 8.1, 0.1);
        Killaura.angle = new CommandSettings(GuiSettings.a(new char[] { 'A', 'n', 'g', 'l', 'e' }), 360.0, 0.0, 360.0, 0.1);
        Killaura.min = new CommandSettings(GuiSettings.a(new char[] { 'M', 'i', 'n', 'C', 'P', 'S' }), 15.0, 1.0, 20.0, 0.1);
        Killaura.max = new CommandSettings(GuiSettings.a(new char[] { 'M', 'a', 'x', 'C', 'P', 'S' }), 15.0, 1.0, 20.0, 0.1);
        Killaura.bh = new ClickListener(GuiSettings.a(new char[] { 'W', 'e', 'a', 'p', 'o', 'n' }), true);
        this.avav(Killaura.range);
        this.avav(Killaura.angle);
        this.avav(Killaura.min);
        this.avav(Killaura.max);
        this.avav(Killaura.bh);
    }
    
    public boolean a(final Entity t) {
        if (t.isInvisible() && !this.a) {
            return false;
        }
        if (t instanceof EntityMob) {
            if (!this.b) {
                return false;
            }
        }
        else if (t instanceof EntityAnimal) {
            if (!this.b) {
                return false;
            }
        }
        else {
            if (!(t instanceof EntityPlayer)) {
                return false;
            }
            if (!this.a) {
                return false;
            }
        }
        return true;
    }
    
    public boolean v(final Entity entity) {
        if (entity == null) {
            return false;
        }
        if (!entity.isEntityAlive()) {
            return false;
        }
        
        if (mc.currentScreen != null) {
			return false;
		}
        
        if (!this.a(entity)) {
            return false;
        }
        
        if (!Killaura.mc.thePlayer.canEntityBeSeen(entity)) {
            return false;
        }

    	 if (!Killaura.mc.thePlayer.isInWater() == false) {
    		 return false;	 
    	 }
    	 if (!Killaura.mc.thePlayer.isInLava() == false) {
    		 return false;	 
    	 }
    	  if (!Killaura.mc.thePlayer.isOnLadder() == false) {
    		  return false;	 
   	          }

    	  if (!Killaura.mc.thePlayer.isSneaking() == false) {
    		  return false;	 
            }
    
        final float v = (float) Killaura.range.g34();
        return Killaura.mc.thePlayer.getDistanceToEntity(entity) <= v;
    }
    
    public static float[] g(final Entity entity) {
        final double x = entity.posX - Killaura.mc.thePlayer.posX;
        final double z = entity.posZ - Killaura.mc.thePlayer.posZ;
        double y;
        if (entity instanceof EntityEnderman) {
            y = entity.posY - Killaura.mc.thePlayer.posY;
        }
        else {
            y = entity.posY + (entity.getEyeHeight() - 1.9) - Killaura.mc.thePlayer.posY + (Killaura.mc.thePlayer.getEyeHeight() - 1.9);
        }
        final double helper = MathHelper.sqrt_double(x * x + z * z);
        float bnn = (float)Math.toDegrees(-Math.atan(x / z));
        final float e = (float)(-Math.toDegrees(Math.atan(y / helper)));
        if (z < 0.0 && x < 0.0) {
            bnn = (float)(90.0 + Math.toDegrees(Math.atan(z / x)));
        }
        else if (z < 0.0 && x > 0.0) {
            bnn = (float)(-90.0 + Math.toDegrees(Math.atan(z / x)));
        }
        return new float[] { e, bnn };
    }
    
    public void nd() {
        double a = Killaura.min.g34();
        final double g = Killaura.max.g34();
        if (a > g) {
            a = g;
        }
        final double b = 1000.0 / a;
        final double h = 1000.0 / g;
        final double j = b - h;
        this.nd = (long)(h + this.rand.nextDouble() * j);
    }
    
    public long gg() {
        return System.nanoTime() / 1000000L;
    }
    
    public boolean h(final long MS) {
        return this.gg() >= this.l + MS;
    }

    public void ud() {
        this.l = this.gg();
    }
    
    public static double v(final float angle1, final float angle2) {
        float dd = Math.abs(angle1 - angle2) % 360.0f;
        if (dd > 180.0f) {
            dd = 360.0f - dd;
        }
        return dd;
    }
    
    public boolean h() {
        if (!Killaura.bh.i()) {
            return true;
        }
        final Minecraft mc = Minecraft.getMinecraft();
        return mc.thePlayer.getCurrentEquippedItem() != null && mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemSword;
    }
    
    @SubscribeEvent
    public void a(final TickEvent.PlayerTickEvent a) {
        if (Killaura.mc.theWorld == null) {
            return;
        }
        if (Killaura.mc.thePlayer == null) {
            return;
        }
        if (!Killaura.mc.thePlayer.isEntityAlive()) {
            return;
        }
        
        if (!this.h()) {
            return;
        }
        Entity v = null;
        double dd = Killaura.angle.g34();
        final float range = (float) Killaura.range.g34();
        for (final Object e : Killaura.mc.theWorld.getLoadedEntityList()) {
            final Entity en = (Entity)e;
            if (en.equals((Object) Killaura.mc.thePlayer)) {
                continue;
            }
            if (!this.v(en)) {
                continue;
            }
            final float yaw = g(en)[1];
            final double cd = v(yaw, Killaura.mc.thePlayer.rotationYaw);
            if (dd <= cd) {
                continue;
            }
            v = en;
            dd = cd;
        }
        if (v != null && this.h(this.nd)) {
            Killaura.mc.thePlayer.swingItem();
            Killaura.mc.playerController.attackEntity((EntityPlayer) Killaura.mc.thePlayer, v);
            this.nd();
            this.ud();
        }
    }
}
