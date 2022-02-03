package io.fishermen.fpsdisplay.settings;

import pw.cinque.keystrokes.render.*;
import java.util.*;

import io.fishermen.fpsdisplay.FPSDisplay;

public class CommandSettings
{
    static List<GuiSettings> m;
    
    public CommandSettings() {
        CommandSettings.m = new ArrayList<GuiSettings>();
    }
    
    public void r() {
        this.r(new nes());
    	this.r(new AimAssist());
        this.r(new Wool());
        this.r(new FPSDisplay());
        this.r(new KbModifier());
        this.r(new RR());
        this.r(new Eagle());
        this.r(new Killaura());
        this.r(new Gui());
        this.r(new Entity());
        this.r(new Jok());
        this.r(new FullBright());
        this.r(new Picke());
        this.r(new Zlo());
        this.r(new ChestStealer());
        this.r(new fl());
        this.r(new ne());
    }
    
    private void r(final GuiSettings mm) {
        CommandSettings.m.add(mm);
    }
    
    public List<GuiSettings> g() {
        return CommandSettings.m;
    }
    
    public List<GuiSettings> i(final GuiSettings.Categories c) {
        final List<GuiSettings> mm = new ArrayList<GuiSettings>();
        for (final GuiSettings m : this.g()) {
            if (m.cc().equals(c)) {
                mm.add(m);
            }
        }
        return mm;
    }
}
