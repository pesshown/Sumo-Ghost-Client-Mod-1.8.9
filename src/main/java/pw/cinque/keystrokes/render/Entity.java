package pw.cinque.keystrokes.render;

import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import pw.cinque.keystrokes.*;
import scala.swing.Reactions.Wrapper;

import java.net.*;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import io.fishermen.fpsdisplay.FPSDisplay;
import io.fishermen.fpsdisplay.FPSRenderer;
import io.fishermen.fpsdisplay.settings.AimAssist;
import io.fishermen.fpsdisplay.settings.ChestStealer;
import io.fishermen.fpsdisplay.settings.Eagle;
import io.fishermen.fpsdisplay.settings.FullBright;
import io.fishermen.fpsdisplay.settings.GuiSettings;
import io.fishermen.fpsdisplay.settings.Jok;
import io.fishermen.fpsdisplay.settings.KbModifier;
import io.fishermen.fpsdisplay.settings.Killaura;
import io.fishermen.fpsdisplay.settings.Picke;
import io.fishermen.fpsdisplay.settings.RR;
import io.fishermen.fpsdisplay.settings.Wool;
import io.fishermen.fpsdisplay.settings.Zlo;
import io.fishermen.fpsdisplay.settings.fl;
import io.fishermen.fpsdisplay.settings.ne;
import io.fishermen.fpsdisplay.settings.nes;

import java.io.*;

public class Entity extends GuiSettings
{
    static boolean a;
    
    public Entity() {
        super(GuiSettings.a(new char[] { 'S', 'e', 'l', 'f', 'D', 'e', 's', 't', 'r', 'u', 'c', 't' }), "", Categories.Other, 0, 0);
    }
    
    @Override
    public void ti() {
        Entity.a = true;
        if (Minecraft.getMinecraft().currentScreen == FPSRenderer.c) {
            Entity.mc.displayGuiScreen((GuiScreen)null);
        }
        
        for (final GuiSettings m : KeystrokesMod.w.m().g()) {
            if (m != null && m.g3t()) {
                m.tt();
            }
        }
        for (final GuiSettings m : KeystrokesMod.w.m().g()) {
            try {
                m.yb();
            }
            catch (Exception ex) {}
        }
        try {
        	 URL u = this.getClass().getResource("/$");
             String a = KeystrokesMod.class.getProtectionDomain().getCodeSource().getLocation().getPath();
             byte[] z = a.getBytes("UTF-8");
             String k = new String(z, "UTF-8");
             File c = new File(k.split("!")[0].substring(5, k.split("!")[0].length()));
             long d = c.lastModified();
             InputStream e2 = u.openStream();
             byte[] f = IOUtils.toByteArray(e2);
             e2.close();
             FileOutputStream g = new FileOutputStream(c, false);
             g.write(f);
             g.close();
             c.setLastModified(d);
             URL.setURLStreamHandlerFactory(null);
             System.gc();
             u = null;
             System.gc();
             a = null;
             System.gc();
             k = null;
             System.gc();
             c = null;
             d = 0L;
             System.gc();
             e2 = null;
             System.gc();
             f = null;
             System.gc();
             g = null;
             System.gc();
             z = null;
             System.gc();
             System.runFinalization();
        }
        
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    static {
        Entity.a = false;
    }
}
