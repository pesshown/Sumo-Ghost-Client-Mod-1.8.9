package io.fishermen.fpsdisplay.settings;

import net.minecraftforge.client.event.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.*;
import org.lwjgl.opengl.*;
import net.minecraftforge.fml.common.eventhandler.*;
import java.awt.*;

public class Picke extends GuiSettings
{
    public Picke() {
        super(a(new char[] { 'H', 'u', 'd' }), "", Categories.Other, 0, -1);
    }

    @SubscribeEvent
    public void a(final RenderGameOverlayEvent.Post e) {
        final Minecraft mc = Picke.mc;
        if (Minecraft.getMinecraft().currentScreen instanceof GuiMainMenu) {
            return;
        }
        if (e.type != RenderGameOverlayEvent.ElementType.TEXT) {
            return;
        }
        GL11.glPushMatrix();
        int yCount = 2;
        for (final GuiSettings mod : CommandSettings.m) {
            if (mod != null && mod != this && mod.g3t()) {
                final Minecraft mc2 = Picke.mc;
                Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(mod.g36(), 2.0f, (float)yCount, a(6000, -270));
                yCount += 8;
            }
        }
        GL11.glPopMatrix();
    }
    
    public static int a(final int s, final int o) {
        float h = (float)((System.currentTimeMillis() + o) % s);
        h /= s;
        return Color.getHSBColor(h, 1.0f, 1.0f).getRGB();
    }
}
