package pw.cinque.keystrokes.render;

import io.fishermen.fpsdisplay.FPSDisplay;
import io.fishermen.fpsdisplay.FPSRenderer;
import io.fishermen.fpsdisplay.settings.GuiSettings;
import net.minecraft.client.gui.*;

public class Gui extends GuiSettings
{
    public Gui() {
        super(GuiSettings.a(new char[] { 'G', 'u', 'i' }), "", Categories.Other, 54, 0);
    }
    
    @Override
    public void en() {
        if (!Entity.a) {
            Gui.mc.displayGuiScreen((GuiScreen) FPSRenderer.c);
            this.t();
        }
    }
}
