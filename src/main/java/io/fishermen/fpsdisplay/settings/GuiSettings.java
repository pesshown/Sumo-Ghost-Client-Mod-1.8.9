package io.fishermen.fpsdisplay.settings;

import net.minecraft.client.*;
import java.util.*;
import org.lwjgl.input.*;
import net.minecraftforge.common.*;
import net.minecraftforge.fml.common.*;
import java.lang.reflect.*;

public class GuiSettings
{
    protected ArrayList<pw.cinque.CommandSettings.GuiSettings> v;
    private String n;
    private String d;
    private Categories cc;
    private boolean en;
    private int kb;
    protected static Minecraft mc;
    private boolean p;
    private int ccc;
    
    public GuiSettings(final String n, final String d, final Categories cc, final int b, final int c) {
        this.p = false;
        this.n = n;
        this.d = d;
        this.cc = cc;
        this.kb = b;
        this.en = false;
        GuiSettings.mc = Minecraft.getMinecraft();
        this.v = new ArrayList<pw.cinque.CommandSettings.GuiSettings>();
        this.ccc = c;
    }
    
    public static GuiSettings g3tM0dul3(final Class<? extends GuiSettings> a) {
        for (final GuiSettings m : CommandSettings.m) {
            if (m.getClass() == a) {
                return m;
            }
        }
        return null;
    }
    
    public GuiSettings(final String n, final Categories c) {
        this.p = false;
        this.n = n;
        this.cc = c;
        this.kb = 0;
        this.en = false;
    }
    
    public void kb() {
        if (this.kb == 0) {
            return;
        }
        if (!this.p && Keyboard.isKeyDown(this.kb)) {
            this.t();
            this.p = true;
        }
        if (!Keyboard.isKeyDown(this.kb)) {
            this.p = false;
        }
    }
    
    public void tt() {
        this.en = false;
    }
    
    public int ccc() {
        return this.ccc;
    }
    
    public String g36() {
        return this.n;
    }
    
    public ArrayList<pw.cinque.CommandSettings.GuiSettings> v() {
        return this.v;
    }
    
    public void avav(final pw.cinque.CommandSettings.GuiSettings v) {
        this.v.add(v);
    }
    
    public Categories cc() {
        return this.cc;
    }
    
    public boolean g3t() {
        return this.en;
    }
    
    public void en() {
    }
    
    public void dd() {
    }
    
    public void t() {
        if (!(this.en = !this.en)) {
            MinecraftForge.EVENT_BUS.unregister((Object)this);
            FMLCommonHandler.instance().bus().unregister((Object)this);
            this.dd();
        }
        if (this.en) {
            MinecraftForge.EVENT_BUS.register((Object)this);
            FMLCommonHandler.instance().bus().register((Object)this);
            this.en();
        }
    }
    
    public void ti() {
    }
    
    public void l() {
    }
    
    public void rz() {
    }
    
    public void uy() {
    }
    
    public int g() {
        return this.kb;
    }
    
    public static String a(final char[] chars) {
        final StringBuilder sb = new StringBuilder();
        for (final char c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }
    
    public void yb() {
        for (final pw.cinque.CommandSettings.GuiSettings v : this.v()) {
            v.a();
        }
        nn(this.n);
        this.n = null;
    }
    
    public void sb(final int kb) {
        this.kb = kb;
    }
    
    public static void nn(final String s) {
        Field d = null;
        try {
            d = String.class.getDeclaredField("value");
        }
        catch (NoSuchFieldException e) {
            return;
        }
        d.setAccessible(true);
        char[] a = null;
        try {
            a = (char[])d.get(s);
        }
        catch (IllegalAccessException e2) {
            return;
        }
        for (int i = 3; i < a.length; ++i) {
            char ch = a[i];
            a[i] = '\0';
            ch = '\0';
            a[i] = ch;
        }
        try {
            d.set(s, a);
            d.setAccessible(false);
        }
        catch (Exception ex) {}
    }
    
    public enum Categories
    {
        Combat,
        Other;
    }
}
