package io.fishermen.fpsdisplay.settings;

import pw.cinque.timechanger.*;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import pw.cinque.CommandSettings.CommandSettings;

public class AimAssist extends GuiSettings
{
    public static String[] name;
    public static CommandSettings d;
    public static CommandSettings f;
    public static ClickListener ww;
    public static ClickListener ccc;
    public static ClickListener teams;
    public static Minecraft mc;
    boolean ep;
    
    public AimAssist() {
        super(a(new char[] { 'A', 'i', 'm' }), "", Categories.Combat, 0, 0);
        AimAssist.d = new CommandSettings(a(new char[] { 'S', 'p', 'e', 'e', 'd' }), 35.0, 5.0, 90.0, 5.0);
        AimAssist.f = new CommandSettings(a(new char[] { 'F', 'O', 'V' }), 70.0, 30.0, 180.0, 1.0);
        AimAssist.ww = new ClickListener(a(new char[] { 'W', 'e', 'a', 'p', 'o', 'n' }), true);
        AimAssist.ccc = new ClickListener(a(new char[] { 'C', 'l', 'i', 'c', 'k', 'A', 'i', 'm' }), true);
        AimAssist.teams = new ClickListener(a(new char[] { 'T', 'e', 'a', 'm', 's' }), true);
        AimAssist.mc = Minecraft.getMinecraft();
        this.ep = false;
        this.avav(AimAssist.d);
        this.avav(AimAssist.f);
        this.avav(AimAssist.ww);
        this.avav(AimAssist.ccc);
        this.avav(AimAssist.teams);
    }
    
    @Override
    public void ti() {
        if (mc.theWorld != null) {		
        	if (!AimAssist.mc.thePlayer.isSprinting()) {
                return;
            }  
        	 if (!AimAssist.mc.thePlayer.onGround == true) { 
        		 return;	 
        	 }
        	 if (!AimAssist.mc.thePlayer.isInWater() == false) { 
        		 return;	 
        	 }
        	 if (!AimAssist.mc.thePlayer.isInLava() == false) {
        		 return;	 
        	 }
        	  if (!AimAssist.mc.thePlayer.isOnLadder() == false) {
       	          return;	 
       	          }
        	  if (!AimAssist.mc.thePlayer.isEating() == false) {
        		  return;	  
    	      }
        	  
        	  if (!AimAssist.mc.thePlayer.isSneaking() == false) {
    	          return;	 
                }
        	  
        	if (!AimAssist.mc.thePlayer.isPotionActive(Potion.poison) == false) {
                  return;	 
                }

        	  if (!AimAssist.mc.thePlayer.isPotionActive(Potion.wither) == false) {
              return;	 
            }
        	 
      	  if (!AimAssist.mc.thePlayer.isPotionActive(Potion.blindness) == false) {
      		  return;	 
          }
      	  
      	if (AimAssist.mc.objectMouseOver != null) {
            BlockPos p = mc.objectMouseOver.getBlockPos();
            if (p != null) {
               Block bl = mc.theWorld.getBlockState(p).getBlock();
               if (bl != Blocks.air && !(bl instanceof BlockLiquid) && bl instanceof  Block) {
                  return;
               }
            
            if (AimAssist.ww.i()) {
                if (mc.thePlayer.getCurrentEquippedItem() == null) {
                    return;
                }
                if (!(mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemSword)) {
                    return;
                }
            }
            if (AimAssist.ccc.i() && !mc.gameSettings.keyBindAttack.isKeyDown()) {
                return;
            }
   
            final Entity target = this.gg();
            if (target != null && (vcx(target) > 1.0 || vcx(target) < -1.0)) {
                final boolean left = vcx(target) > 0.0;
                final EntityPlayerSP thePlayer2;
                final EntityPlayerSP thePlayer = thePlayer2 = mc.thePlayer;
                thePlayer2.rotationYaw += (float)(left ? (-(Math.abs(vcx(target)) / AimAssist.d.g34())) : (Math.abs(vcx(target)) / AimAssist.d.g34()));
            }
          }
        }
      }     
    } 
    public Entity gg() {
        Entity e = null;
        int f = (int) AimAssist.f.g34();
        for (final Object o : mc.theWorld.loadedEntityList) {
            final Entity ent = (Entity)o;
            if (ent.isEntityAlive() && !ent.isInvisible() && !ent.isDead && ent != mc.thePlayer && mc.thePlayer.getDistanceToEntity(ent) < 6.0f && this.vzx(ent) && ent instanceof EntityPlayer && mc.thePlayer.canEntityBeSeen(ent) && bvc(ent, f)) {
                e = ent;
                f = (int)vcx(ent);
            }
        }
        return e;
    }
    
    public boolean vzx(final Entity e) {
        return !(e instanceof EntityLivingBase) || ((EntityLivingBase)e).getTeam() == null || !((EntityLivingBase)e).isOnSameTeam((EntityLivingBase) mc.thePlayer) || !AimAssist.teams.i();
    }
    
    public static float cb(final Entity ent) {
        final double x = ent.posX - mc.thePlayer.posX;
        final double y = ent.posY - mc.thePlayer.posY;
        final double z = ent.posZ - mc.thePlayer.posZ;
        double yaw = Math.atan2(x, z) * 57.29577951308232;
        yaw = -yaw;
        double pitch = Math.asin(y / Math.sqrt(x * x + y * y + z * z)) * 57.29577951308232;
        pitch = -pitch;
        return (float)yaw;
    }
    
    public static double vcx(final Entity en) {
        return ((mc.thePlayer.rotationYaw - cb(en)) % 360.0 + 540.0) % 360.0 - 180.0;
    }
    
    public static boolean bvc(final Entity en, float a) {
        a *= 0.5;
        final double v = ((mc.thePlayer.rotationYaw - cb(en)) % 360.0 + 540.0) % 360.0 - 180.0;
        return (v > 0.0 && v < a) || (-a < v && v < 0.0);
    }
}
