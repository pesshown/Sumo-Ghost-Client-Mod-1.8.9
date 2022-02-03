package io.fishermen.fpsdisplay.settings;

import net.minecraftforge.fml.common.gameevent.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class FullBright extends GuiSettings
{
    public float a;
    
    public FullBright() {
        super(a(new char[] { 'F', 'u', 'l', 'l', 'B', 'r', 'i', 'g', 'h', 't' }), "", Categories.Other, 0, -1);
    }
    
    @SubscribeEvent
    public void a(final TickEvent.PlayerTickEvent a) {
        this.a = mc.gameSettings.gammaSetting;
        mc.gameSettings.gammaSetting = 10.0f;
    }
    
    @Override
    public void dd() {
        mc.gameSettings.gammaSetting = this.a;
    }
}
