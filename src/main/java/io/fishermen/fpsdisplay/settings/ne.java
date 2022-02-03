package io.fishermen.fpsdisplay.settings;

import net.minecraftforge.fml.common.gameevent.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraft.util.*;

public class ne extends GuiSettings
{
    public ne() {
        super(a(new char[] { 'S', 'p', 'e', 'e', 'd' }), "", Categories.Other, 0, -1);
    }
    
    @SubscribeEvent
    public void a(final TickEvent.PlayerTickEvent a) {
        if (mc.thePlayer.moveForward == 0.0f && mc.thePlayer.moveStrafing == 0.0f) {
            mc.thePlayer.motionX = 0.0;
            mc.thePlayer.motionZ = 0.0;
        }
        if (mc.thePlayer.onGround) {
            this.s(1.45);
            mc.thePlayer.motionY = 0.455;
        }
        else {
            final double n = mc.thePlayer.motionX * mc.thePlayer.motionX;
            this.s(Math.sqrt(n + mc.thePlayer.motionZ * mc.thePlayer.motionZ));
        }
    }
    
    public float gg() {
        float y = mc.thePlayer.rotationYaw;
        final float f = mc.thePlayer.moveForward;
        final float s = mc.thePlayer.moveStrafing;
        y += ((f < 0.0f) ? 180 : 0);
        if (s < 0.0f) {
            y += ((f == 0.0f) ? 90.0f : ((f < 0.0f) ? -45.0f : 45.0f));
        }
        if (s > 0.0f) {
            y -= ((f == 0.0f) ? 90.0f : ((f < 0.0f) ? -45.0f : 45.0f));
        }
        return y * 0.017453292f;
    }
    
    public void s(final double s) {
        mc.thePlayer.motionX = -MathHelper.sin(this.gg()) * s;
        mc.thePlayer.motionZ = MathHelper.cos(this.gg()) * s;
    }
}
