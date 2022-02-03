package io.fishermen.fpsdisplay.settings;

import pw.cinque.timechanger.*;
import pw.cinque.CommandSettings.CommandSettings;
import java.util.*;
import java.lang.reflect.*;
import net.minecraft.client.gui.*;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraft.client.settings.*;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSword;
import net.minecraft.client.gui.inventory.*;
import org.lwjgl.input.*;

import io.fishermen.fpsdisplay.FPSDisplay;
import net.minecraftforge.client.event.*;
import net.minecraftforge.common.*;
import net.minecraftforge.fml.common.eventhandler.*;
import java.nio.*;

public class Wool extends GuiSettings
{
    public static CommandSettings mcc;
    public static CommandSettings mca;
    public static ClickListener iff;
    public static ClickListener bh;
    private long nlu;
    private long nld;
    private long nru;
    private long nrd;
    private long nd;
    private long ne;
    private double drr;
    private boolean dr;
    private Method gg;
    public Random r;
    private static Field bst;
    private static Field fff;
    private static Field bff;
    
    public Wool() {
        super(GuiSettings.a(new char[] { 'A', 'u', 't', 'o', 'C', 'l', 'i', 'c', 'k' }), "", Categories.Combat, 0, 0);
        this.r = new Random();
        Wool.mcc = new CommandSettings(GuiSettings.a(new char[] { 'M', 'i', 'n', 'C', 'P', 'S' }), 7.0, 1.0, 20.0, 0.1);
        Wool.mca = new CommandSettings(GuiSettings.a(new char[] { 'M', 'a', 'x', 'C', 'P', 'S' }), 12.0, 1.0, 20.0, 0.1);
        Wool.iff = new ClickListener(GuiSettings.a(new char[] { 'I', 'n', 'v', ' ', 'F', 'i', 'l', 'l' }), true);
        Wool.bh = new ClickListener(GuiSettings.a(new char[] { 'B', 'l', 'o', 'c', 'k', ' ', 'H', 'i', 't' }), false);
        this.avav(Wool.mcc);
        this.avav(Wool.mca);
        this.avav(Wool.bh);
        this.avav(Wool.iff);
        try {
            this.gg = GuiScreen.class.getDeclaredMethod("func_73864_a", Integer.TYPE, Integer.TYPE, Integer.TYPE);
        }
        catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    
    @SubscribeEvent
    public void onTick(final TickEvent.RenderTickEvent e) {
        if (Wool.mc.currentScreen == null) {
            Mouse.poll();
            if (Mouse.isButtonDown(0)) {
                if (this.nld > 0L && this.nlu > 0L) {
                    if (System.currentTimeMillis() > this.nld) {
                        final int attackKeyBind = Wool.mc.gameSettings.keyBindAttack.getKeyCode();
                        KeyBinding.setKeyBindState(attackKeyBind, true);
                        KeyBinding.onTick(attackKeyBind);
                        s(0, true);
                        this.vcx();
                    }
                    else if (System.currentTimeMillis() > this.nlu) {
                        KeyBinding.setKeyBindState(Wool.mc.gameSettings.keyBindAttack.getKeyCode(), false);
                        s(0, false);
                    }
                }
                else {
                    this.vcx();
                }
                final boolean bh = Wool.bh.i();
                if (bh && Mouse.isButtonDown(1)) {
                    if (this.nrd > 0L && this.nru > 0L) {
                        if (System.currentTimeMillis() > this.nrd) {
                            KeyBinding.setKeyBindState(Wool.mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                            KeyBinding.onTick(Wool.mc.gameSettings.keyBindUseItem.getKeyCode());
                            s(1, true);
                            this.v1c();
                        }
                        else if (System.currentTimeMillis() > this.nru) {
                            final int useItemKeyBind = Wool.mc.gameSettings.keyBindUseItem.getKeyCode();
                            KeyBinding.setKeyBindState(useItemKeyBind, false);
                            s(1, false);
                        }
                    }
                    else {
                        this.v1c();
                    }
                }
                else {
                    final long n = 0L;
                    this.nru = 0L;
                    this.nrd = 0L;
                }
            }
            else {
                final long n2 = 0L;
                this.nru = 0L;
                this.nrd = 0L;
                this.nlu = 0L;
                this.nld = 0L;
            }
        }
        
        else if (Wool.mc.currentScreen instanceof GuiInventory) {
            if (Mouse.isButtonDown(0) && (Keyboard.isKeyDown(54) || Keyboard.isKeyDown(42))) {
                final boolean inventoryFill = Wool.iff.i();
                if (!inventoryFill) {
                    return;
                }
                if (this.nlu == 0L || this.nld == 0L) {
                    this.vcx();
                    return;
                }
                if (System.currentTimeMillis() > this.nld) {
                    this.vcx();
                    this.c(Wool.mc.currentScreen);
                }
            }
            else {
                final long n3 = 0L;
                this.nru = 0L;
                this.nrd = 0L;
                this.nlu = 0L;
                this.nld = 0L;
            }
        }
       }
    private void vcx() {
        final double mcc = Wool.mcc.g34();
        final double mca = Wool.mca.g34();
        if (mcc > mca) {
            return;
        }
        final double CPS = mcc + this.r.nextDouble() * (mca - mcc);
        long delay = (int)Math.round(1000.0 / CPS);
        if (System.currentTimeMillis() > this.nd) {
            if (!this.dr && this.r.nextInt(100) >= 85) {
                this.dr = true;
                this.drr = 1.1 + this.r.nextDouble() * 0.15;
            }
            else {
                this.dr = false;
            }
            this.nd = System.currentTimeMillis() + 500L + this.r.nextInt(1500);
        }
        if (this.dr) {
            delay *= (long)this.drr;
        }
        if (System.currentTimeMillis() > this.ne) {
            if (this.r.nextInt(100) >= 80) {
                delay += 50L + this.r.nextInt(150);
            }
            this.ne = System.currentTimeMillis() + 500L + this.r.nextInt(1500);
        }
        this.nld = System.currentTimeMillis() + delay;
        this.nlu = System.currentTimeMillis() + delay / 2L - this.r.nextInt(10);
    }
    
    public static void s(final int button, final boolean state) {
        final MouseEvent m = new MouseEvent();
        Wool.fff.setAccessible(true);
        try {
            Wool.fff.set(m, button);
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Wool.fff.setAccessible(false);
        Wool.bst.setAccessible(true);
        try {
            Wool.bst.set(m, state);
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Wool.bst.setAccessible(false);
        MinecraftForge.EVENT_BUS.post((Event)m);
        try {
            Wool.bff.setAccessible(true);
            final ByteBuffer buffer = (ByteBuffer)Wool.bff.get(null);
            Wool.bff.setAccessible(false);
            buffer.put(button, (byte)(state ? 1 : 0));
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    
    private void v1c() {
        final double mcc = 4.0;
        final double mca = 6.0;
        final double CPS = 4.0 + this.r.nextDouble() * 2.0;
        final long delay = (int)Math.round(1000.0 / CPS);
        this.nrd = System.currentTimeMillis() + delay;
        this.nru = System.currentTimeMillis() + 20L + this.r.nextInt(30);
    }
    
    private void c(final GuiScreen s) {
        final int var1 = Mouse.getX() * s.width / Wool.mc.displayWidth;
        final int var2 = s.height - Mouse.getY() * s.height / Wool.mc.displayHeight - 1;
        final int var3 = 0;
        try {
            this.gg.setAccessible(true);
            this.gg.invoke(s, var1, var2, 0);
            this.gg.setAccessible(false);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    static {
        try {
            Wool.fff = MouseEvent.class.getDeclaredField("button");
        }
        catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        try {
            Wool.bst = MouseEvent.class.getDeclaredField("buttonstate");
        }
        catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        try {
            Wool.bff = Mouse.class.getDeclaredField("buttons");
        }
        catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
