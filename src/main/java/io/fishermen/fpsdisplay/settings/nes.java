package io.fishermen.fpsdisplay.settings;

import java.util.*;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraft.inventory.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.gui.*;
import net.minecraftforge.fml.common.eventhandler.*;
import pw.cinque.CommandSettings.CommandSettings;

public class nes extends GuiSettings
{
    protected long l;
    protected long g;
    public static CommandSettings d;
    public static CommandSettings r;
    protected Random rr;
    
    public nes() {
        super(a(new char[] { 'A', 'u', 't', 'o', 'A', 'r', 'm', 'o', 'r' }), "", Categories.Combat, 0, -1);
        this.l = -1L;
        this.rr = new Random();
        nes.d = new CommandSettings(a(new char[] { 'D', 'e', 'l', 'a', 'y' }), 100.0, 0.0, 300.0, 1.0);
        nes.r = new CommandSettings(a(new char[] { 'R', 'a', 'n', 'd', 'o', 'm' }), 50.0, 0.0, 100.0, 1.0);
        this.avav(nes.d);
        this.avav(nes.r);
    }
    
    public int m(final int n) {
        return (n > 0) ? this.rr.nextInt(n) : 0;
    }
    
    public boolean n(final long m) {
        return System.nanoTime() / 1000000L >= this.l + m;
    }
    
    public void a() {
        this.l = System.nanoTime() / 1000000L;
    }
    
    public void n() {
        final double d = nes.d.g34();
        final double r = this.m((int)nes.r.g34());
        this.g = (long)(d + r);
    }
    
    @SubscribeEvent
    public void a(final TickEvent.PlayerTickEvent e) {
        if (mc.thePlayer.openContainer != null && mc.thePlayer.openContainer instanceof ContainerChest) {
            final ContainerChest c = (ContainerChest) mc.thePlayer.openContainer;
            for (int i = 0; i < c.getLowerChestInventory().getSizeInventory(); ++i) {
                if (c.getLowerChestInventory().getStackInSlot(i) != null && this.n(this.g)) {
                    mc.playerController.windowClick(c.windowId, i, 0, 1, (EntityPlayer) mc.thePlayer);
                    this.n();
                    this.a();
                }
            }
            if (c.getInventory().isEmpty()) {
                mc.displayGuiScreen((GuiScreen)null);
            }
        }
    }
}
