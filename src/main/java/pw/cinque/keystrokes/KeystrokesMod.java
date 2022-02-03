package pw.cinque.keystrokes;

import io.fishermen.fpsdisplay.FPSRenderer;
import io.fishermen.fpsdisplay.settings.GuiSettings;
import net.minecraft.client.*;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.common.*;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraftforge.client.event.*;

@Mod(modid = "keystrokesmod", name = "KeystrokesMod", version = "0.1", acceptedMinecraftVersions = "[1.8.9]")
public class KeystrokesMod
{
    public static int location;
    public static int mode;
    public static Minecraft mc;
    public static FPSRenderer w;
    
    public KeystrokesMod() {
        KeystrokesMod.mc = Minecraft.getMinecraft();
        KeystrokesMod.w = new FPSRenderer();
    }
    
    @Mod.EventHandler
    public void init(final FMLInitializationEvent event) {
        FMLCommonHandler.instance().bus().register((Object)this);
        MinecraftForge.EVENT_BUS.register((Object)this);
        KeystrokesMod.w.m().r();
        final FPSRenderer w = KeystrokesMod.w;
        FPSRenderer.c = new Colors();
    }
    
    @SubscribeEvent
    public void o(final TickEvent.ClientTickEvent e) {
        if (KeystrokesMod.mc.theWorld != null && KeystrokesMod.mc.currentScreen == null) {
            for (final GuiSettings m : KeystrokesMod.w.m().g()) {
                m.kb();
                if (m.g3t()) {
                    m.ti();
                }
            }
        }
    }
    
    @SubscribeEvent
    public void m(final MouseEvent a) {
        for (final GuiSettings m : KeystrokesMod.w.m().g()) {
            if (m.g3t()) {
                m.uy();
            }
        }
        if (a.button == 0) {
            for (final GuiSettings m : KeystrokesMod.w.m().g()) {
                if (m.g3t()) {
                    if (a.buttonstate) {
                        m.l();
                    }
                    if (a.buttonstate) {
                        continue;
                    }
                    m.rz();
                }
            }
        }
    }
    
    static {
        KeystrokesMod.location = 1;
        KeystrokesMod.mode = 0;
    }
}
