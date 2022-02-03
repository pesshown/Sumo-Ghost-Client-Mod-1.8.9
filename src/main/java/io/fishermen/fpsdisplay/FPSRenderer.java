package io.fishermen.fpsdisplay;

import io.fishermen.fpsdisplay.settings.CommandSettings;
import pw.cinque.keystrokes.*;

public class FPSRenderer
{
    public static CommandSettings m;
    public static Colors c;
    
    public FPSRenderer() {
        FPSRenderer.m = new CommandSettings();
    }
    
    public CommandSettings m() {
        return FPSRenderer.m;
    }
}
