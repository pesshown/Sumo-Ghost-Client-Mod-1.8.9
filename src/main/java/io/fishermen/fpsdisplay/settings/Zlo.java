package io.fishermen.fpsdisplay.settings;

import pw.cinque.CommandSettings.CommandSettings;
import pw.cinque.timechanger.*;
import net.minecraftforge.client.event.*;
import net.minecraft.client.*;
import net.minecraft.entity.player.*;
import net.minecraftforge.fml.common.eventhandler.*;
import org.lwjgl.opengl.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.scoreboard.*;
import java.awt.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.enchantment.*;
import net.minecraft.item.*;

public class Zlo extends GuiSettings
{
    public static CommandSettings s;
    public static ClickListener i;
    public static ClickListener d;
    public static ClickListener h;
    
    public Zlo() {
        super(GuiSettings.a(new char[] { 'N', 'a', 'm', 'e', 'T', 'a', 'g', 's' }), "", Categories.Other, 0, -1);
        Zlo.s = new CommandSettings(GuiSettings.a(new char[] { 'S', 'c', 'a', 'l', 'e' }), 1.0, 0.0, 2.0, 0.1);
        Zlo.i = new ClickListener(GuiSettings.a(new char[] { 'I', 't', 'e', 'm', 's' }), true);
        Zlo.d = new ClickListener(GuiSettings.a(new char[] { 'D', 'i', 's', 't', 'a', 'n', 'c', 'e' }), false);
        Zlo.h = new ClickListener(GuiSettings.a(new char[] { 'H', 'e', 'a', 'l', 't', 'h' }), true);
        this.avav(Zlo.s);
        this.avav(Zlo.i);
        this.avav(Zlo.d);
        this.avav(Zlo.h);
    }
    
    @SubscribeEvent
    public void onPre(final RenderLivingEvent.Specials.Pre d) {
        if (d.entity.equals((Object)Minecraft.getMinecraft().thePlayer) || !(d.entity instanceof EntityPlayer)) {
            return;
        }
        this.x((EntityPlayer)d.entity, d.x, d.y, d.z);
        d.setCanceled(true);
    }
    
    public static boolean i(final float n, final float b, final float v) {
        return n >= b && n <= v;
    }
    
    public static String g(final int l) {
        String s = "";
        for (int i = 0; i < l; ++i) {
            s += " ";
        }
        return s;
    }
    
    public static float l(final float v, final int d) {
        return (float)(Math.floor(v * Math.pow(10.0, d)) / Math.pow(10.0, d));
    }
    
    public static void d(final float x, final float y, final float w, final float h, final int c) {
        GL11.glEnable(3042);
        GL11.glDisable(2884);
        GL11.glDisable(3553);
        GL11.glEnable(2848);
        GL11.glBlendFunc(770, 771);
        GL11.glLineWidth(1.0f);
        Minecraft.getMinecraft().getResourceManager();
        final float alpha = (c >> 24 & 0xFF) / 255.0f;
        final float red = (c >> 16 & 0xFF) / 255.0f;
        final float green = (c >> 8 & 0xFF) / 255.0f;
        final float blue = (c & 0xFF) / 255.0f;
        GL11.glColor4f(red, green, blue, alpha);
        GL11.glBegin(7);
        GL11.glVertex2d((double)x, (double)y);
        GL11.glVertex2d((double)(x + w), (double)y);
        GL11.glVertex2d((double)(x + w), (double)(y + h));
        GL11.glVertex2d((double)x, (double)(y + h));
        GL11.glEnd();
        GL11.glDisable(3042);
        GL11.glEnable(2884);
        GL11.glEnable(3553);
        GL11.glDisable(2848);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glShadeModel(7424);
        GL11.glDisable(3042);
        GL11.glEnable(3553);
    }
    
    private void x(final EntityPlayer e, final double x, double y, final double z) {
        y += (e.isSneaking() ? 0.5 : 0.7);
        String h = EnumChatFormatting.GREEN.toString();
        final double heaelth = Math.ceil(e.getHealth() + e.getAbsorptionAmount()) / 2.0;
        if (i((float)heaelth, 5.0f, 6.5f)) {
            h = EnumChatFormatting.YELLOW.toString();
        }
        else if (i((float)heaelth, 0.0f, 5.0f)) {
            h = EnumChatFormatting.RED.toString();
        }
        String d = EnumChatFormatting.GREEN.toString();
        if (i(Math.max(1.6f, Minecraft.getMinecraft().thePlayer.getDistanceToEntity((Entity)e)), 30.0f, 50.0f)) {
            d = EnumChatFormatting.DARK_GREEN.toString();
        }
        else if (i(Math.max(1.6f, Minecraft.getMinecraft().thePlayer.getDistanceToEntity((Entity)e)), 15.0f, 30.0f)) {
            d = EnumChatFormatting.YELLOW.toString();
        }
        else if (Math.max(1.6f, Minecraft.getMinecraft().thePlayer.getDistanceToEntity((Entity)e)) < 15.0f) {
            d = EnumChatFormatting.RED.toString();
        }

        final String na = ScorePlayerTeam.formatPlayerName(e.getTeam(), e.getDisplayNameString()).replace(" ", "").trim();
        final String k = (Zlo.h.i() ? (h + heaelth + " ") : "") + g(Minecraft.getMinecraft().fontRendererObj.getStringWidth(na) / 3) + (Zlo.d.i() ? (" " + d + l(Math.max(1.6f, Minecraft.getMinecraft().thePlayer.getDistanceToEntity((Entity)e)), 1) + "m") : " ");
        final int w = Minecraft.getMinecraft().fontRendererObj.getStringWidth((Zlo.h.i() ? (heaelth + " ") : "") + g(Minecraft.getMinecraft().fontRendererObj.getStringWidth(na) / 3) + (Zlo.d.i() ? (" " + l(Math.max(1.6f, Minecraft.getMinecraft().thePlayer.getDistanceToEntity((Entity)e)), 1) + "m") : " ")) / 2;
        final float o = (float)(Math.max(1.6f, Minecraft.getMinecraft().thePlayer.getDistanceToEntity((Entity)e)) / 125.0f * Zlo.s.g34());
        GL11.glPushMatrix();
        GL11.glTranslated(x, y + 1.4, z);
        GL11.glNormal3f(0.0f, 1.0f, 0.0f);
        final RenderManager renderManager = Zlo.mc.getRenderManager();
        GL11.glRotatef(-renderManager.playerViewY, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(renderManager.playerViewX, 1.0f, 0.0f, 0.0f);
        GL11.glScalef(-o, -o, o);
        GL11.glDisable(2896);
        GL11.glDisable(2929);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        final int f = new Color(20, 20, 20, 100).getRGB();
        d(-w - 4, -(Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT + 1), w * 2 + 5, Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT + 3, f);
        d(k, -w - 2, -(Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT - 1), -1);
        final int naa = e.isInvisible() ? 754431 : (e.isSneaking() ? 12257310 : -1);
        d(na, -w - 2 + Minecraft.getMinecraft().fontRendererObj.getStringWidth(Zlo.h.i() ? (h + heaelth + " ") : ""), -(Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT - 1), naa);
        GL11.glEnable(2929);
        GL11.glEnable(32823);
        GL11.glPolygonOffset(1.0f, -1.0E7f);
        if (Zlo.i.i()) {
            int a = 0;
            for (int i = 0; i < e.inventory.armorInventory.length; ++i) {
                if (e.inventory.armorInventory[i] != null) {
                    a -= 8;
                }
            }
            if (e.getHeldItem() != null) {
                a -= 8;
                final ItemStack r = e.getHeldItem().copy();
                if (r.hasEffect() && (r.getItem() instanceof ItemTool || r.getItem() instanceof ItemArmor)) {
                    r.stackSize = 1;
                }
                this.r(r, a, -26);
                a += 16;
            }
            for (int i = 0; i < e.inventory.armorInventory.length; ++i) {
                if (e.inventory.armorInventory[i] != null) {
                    final ItemStack r2 = e.inventory.armorInventory[i].copy();
                    if (r2.hasEffect() && (r2.getItem() instanceof ItemTool || r2.getItem() instanceof ItemArmor)) {
                        r2.stackSize = 1;
                    }
                    this.r(r2, a, -26);
                    a += 16;
                }
            }
        }
        GL11.glPolygonOffset(1.0f, 1000000.0f);
        GL11.glDisable(32823);
        GL11.glDisable(3042);
        GL11.glEnable(2896);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPopMatrix();
    }


    
    private void r(final ItemStack s, final int x, final int y) {
        Zlo.mc.getRenderItem().zLevel = -50.0f;
        Zlo.mc.getRenderItem().renderItemAndEffectIntoGUI(s, x, y);
        Zlo.mc.getRenderItem().renderItemOverlayIntoGUI(Zlo.mc.fontRendererObj, s, x, y, "");
        GL11.glDisable(2896);
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        this.x(s, x, y);
        GL11.glScalef(2.0f, 2.0f, 2.0f);
    }
    
    public static void d(final String str, final int x, final int y, final int c) {
        if (str == null) {
            return;
        }
        final boolean blend = GL11.glIsEnabled(3042);
        GL11.glDisable(3042);
        Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(str, (float)x, (float)y, c);
        if (blend) {
            GL11.glEnable(3042);
        }
    }
    
    private void x(final ItemStack s, final int x, final int y) {
        int n = y - 24;
        if (s.getItem() instanceof ItemArmor) {
            final int p = EnchantmentHelper.getEnchantmentLevel(Enchantment.protection.effectId, s);
            final int t = EnchantmentHelper.getEnchantmentLevel(Enchantment.thorns.effectId, s);
            final int u = EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, s);
            final int r = EnchantmentHelper.getEnchantmentLevel(Enchantment.featherFalling.effectId, s);
            if (p > 0) {
                d("pr" + p, x * 2, n, new Color(140, 140, 140).getRGB());
                n += 7;
            }
            if (t > 0) {
                d("th" + t, x * 2, n, new Color(140, 140, 140).getRGB());
                n += 7;
            }
            if (u > 0) {
                d("unb" + u, x * 2, n, new Color(140, 140, 140).getRGB());
                n += 7;
            }
            if (r > 0) {
                d("ff" + p, x * 2, n, new Color(140, 140, 140).getRGB());
                n += 7;
            }
        }
        else if (s.getItem() instanceof ItemBow) {
            final int p = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, s);
            final int pu = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, s);
            final int f = EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, s);
            final int u2 = EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, s);
            if (p > 0) {
                d("pow" + p, x * 2, n, new Color(140, 140, 140).getRGB());
                n += 7;
            }
            if (pu > 0) {
                d("kb" + pu, x * 2, n, new Color(140, 140, 140).getRGB());
                n += 7;
            }
            if (f > 0) {
                d("fl" + f, x * 2, n, new Color(140, 140, 140).getRGB());
                n += 7;
            }
            if (u2 > 0) {
                d("unb" + u2, x * 2, n, new Color(140, 140, 140).getRGB());
                n += 7;
            }
        }
        else if (s.getItem() instanceof ItemSword) {
            final int d = EnchantmentHelper.getEnchantmentLevel(Enchantment.sharpness.effectId, s);
            final int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.knockback.effectId, s);
            final int f = EnchantmentHelper.getEnchantmentLevel(Enchantment.fireAspect.effectId, s);
            final int u2 = EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, s);
            if (d > 0) {
                d("sh" + d, x * 2, n, new Color(140, 140, 140).getRGB());
                n += 7;
            }
            if (k > 0) {
                d("kb" + k, x * 2, n, new Color(140, 140, 140).getRGB());
                n += 7;
            }
            if (f > 0) {
                d("fa" + f, x * 2, n, new Color(140, 140, 140).getRGB());
                n += 7;
            }
            if (u2 > 0) {
                d("unb" + u2, x * 2, n, new Color(140, 140, 140).getRGB());
                n += 7;
            }
        }
        else if (s.getItem() instanceof ItemTool) {
            final int d = EnchantmentHelper.getEnchantmentLevel(Enchantment.efficiency.effectId, s);
            final int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, s);
            final int f = EnchantmentHelper.getEnchantmentLevel(Enchantment.silkTouch.effectId, s);
            final int u2 = EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, s);
            if (d > 0) {
                d("eff" + d, x * 2, n, new Color(140, 140, 140).getRGB());
                n += 7;
            }
            if (k > 0) {
                d("unb" + k, x * 2, n, new Color(140, 140, 140).getRGB());
                n += 7;
            }
            if (f > 0) {
                d("slk" + f, x * 2, n, new Color(140, 140, 140).getRGB());
                n += 7;
            }
            if (u2 > 0) {
                d("for" + u2, x * 2, n, new Color(140, 140, 140).getRGB());
                n += 7;
            }
        }
    }
}
