package io.fishermen.fpsdisplay.settings;

import net.minecraftforge.fml.common.gameevent.*;
import net.minecraft.entity.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraft.client.*;

public class fl extends GuiSettings
{
    public fl() {
        super(a(new char[] { 'F', 'l', 'y' }), "", Categories.Other, 0, -1);
    }
    
    @SubscribeEvent
    public void a(final TickEvent.PlayerTickEvent a) {
        final int xd = 0;
        if (mc.gameSettings.keyBindJump.isKeyDown()) {
            mc.thePlayer.motionY = 1.0;
        }
        if (mc.gameSettings.keyBindSneak.isKeyDown()) {
            mc.thePlayer.motionY = -1.0;
        }
        if (i((Entity) mc.thePlayer) && !mc.gameSettings.keyBindJump.isKeyDown() && !mc.gameSettings.keyBindSneak.isKeyDown() && (mc.thePlayer.motionY <= -0.41 || mc.thePlayer.onGround)) {
            s(2.873);
            mc.thePlayer.motionY = -0.6;
        }
        if (!mc.gameSettings.keyBindJump.isKeyDown() && !mc.gameSettings.keyBindSneak.isKeyDown() && (mc.thePlayer.motionY <= -0.42 || mc.thePlayer.onGround)) {
            mc.thePlayer.motionY = 0.4;
        }
    }
    
    public static boolean i(final Entity ent) {
        return Minecraft.getMinecraft().thePlayer.moveForward != 0.0f || Minecraft.getMinecraft().thePlayer.moveStrafing != 0.0f;
    }
    
    public static float gg() {
        float v = Minecraft.getMinecraft().thePlayer.rotationYaw;
        if (Minecraft.getMinecraft().thePlayer.moveForward < 0.0f) {
            v += 180.0f;
        }
        float f = 1.0f;
        if (Minecraft.getMinecraft().thePlayer.moveForward < 0.0f) {
            f = -0.5f;
        }
        else if (Minecraft.getMinecraft().thePlayer.moveForward > 0.0f) {
            f = 0.5f;
        }
        else {
            f = 1.0f;
        }
        if (Minecraft.getMinecraft().thePlayer.moveStrafing > 0.0f) {
            v -= 90.0f * f;
        }
        if (Minecraft.getMinecraft().thePlayer.moveStrafing < 0.0f) {
            v += 90.0f * f;
        }
        v *= 0.017453292f;
        return v;
    }
    
    public static void s(final double s) {
        Minecraft.getMinecraft().thePlayer.motionX = -(Math.sin(gg()) * s);
        Minecraft.getMinecraft().thePlayer.motionZ = Math.cos(gg()) * s;
    }
}
