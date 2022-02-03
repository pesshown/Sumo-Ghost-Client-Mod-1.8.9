package io.fishermen.fpsdisplay.settings;

import java.util.*;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraft.client.gui.inventory.*;
import net.minecraft.entity.player.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraft.item.*;
import net.minecraft.enchantment.*;
import pw.cinque.CommandSettings.CommandSettings;

public class ChestStealer extends GuiSettings
{
    protected long l;
    protected long g;
    public static CommandSettings d;
    protected Random rr;
    private static long t;
    
    public ChestStealer() {
        super(a(new char[] { 'C', 'h', 'e', 's', 't', 'S', 't', 'e', 'a', 'l', 'e', 'r' }), "", Categories.Other, 0, -1);
        this.l = -1L;
        this.rr = new Random();
        this.avav(ChestStealer.d = new CommandSettings(a(new char[] { 'D', 'e', 'l', 'a', 'y' }), 100.0, 0.0, 300.0, 1.0));
    }
    
    @SubscribeEvent
    public void a(final TickEvent.PlayerTickEvent e) {
        if (mc.thePlayer != null && (mc.currentScreen == null || mc.currentScreen instanceof GuiInventory)) {
            int s = -1;
            double m = -1.0;
            int n = -1;
            for (int i = 9; i < 45; ++i) {
                final ItemStack b = mc.thePlayer.inventoryContainer.getSlot(i).getStack();
                if (b != null && (this.g(b) || (this.f(b) && !this.g(b)))) {
                    if (this.f(b) && n == -1) {
                        n = this.s(b);
                    }
                    final double v = this.h(b);
                    if (v >= m) {
                        s = i;
                        m = v;
                    }
                }
            }
            if (s != -1 && this.s((long) ChestStealer.d.g34())) {
                if (n != -1) {
                    mc.playerController.windowClick(mc.thePlayer.inventoryContainer.windowId, 4 + n, 1, 4, (EntityPlayer) mc.thePlayer);
                }
                mc.playerController.windowClick(mc.thePlayer.inventoryContainer.windowId, s, 0, 1, (EntityPlayer) mc.thePlayer);
            }
        }
    }
    
    public boolean s(final long t) {
        if (pp() >= t) {
            ChestStealer.t = System.nanoTime() / 1000000L;
            return true;
        }
        return false;
    }
    
    public static long pp() {
        return System.nanoTime() / 1000000L - ChestStealer.t;
    }
    
    private boolean f(final ItemStack c) {
        if (c.getItem() instanceof ItemArmor) {
            if (mc.thePlayer.getEquipmentInSlot(1) != null && c.getUnlocalizedName().contains("boots") && this.h(c) + ((ItemArmor)c.getItem()).damageReduceAmount > this.h(mc.thePlayer.getEquipmentInSlot(1)) + ((ItemArmor) mc.thePlayer.getEquipmentInSlot(1).getItem()).damageReduceAmount) {
                return true;
            }
            if (mc.thePlayer.getEquipmentInSlot(2) != null && c.getUnlocalizedName().contains("leggings") && this.h(c) + ((ItemArmor)c.getItem()).damageReduceAmount > this.h(mc.thePlayer.getEquipmentInSlot(2)) + ((ItemArmor) mc.thePlayer.getEquipmentInSlot(2).getItem()).damageReduceAmount) {
                return true;
            }
            if (mc.thePlayer.getEquipmentInSlot(3) != null && c.getUnlocalizedName().contains("chestplate") && this.h(c) + ((ItemArmor)c.getItem()).damageReduceAmount > this.h(mc.thePlayer.getEquipmentInSlot(3)) + ((ItemArmor) mc.thePlayer.getEquipmentInSlot(3).getItem()).damageReduceAmount) {
                return true;
            }
            if (mc.thePlayer.getEquipmentInSlot(4) != null && c.getUnlocalizedName().contains("helmet") && this.h(c) + ((ItemArmor)c.getItem()).damageReduceAmount > this.h(mc.thePlayer.getEquipmentInSlot(4)) + ((ItemArmor) mc.thePlayer.getEquipmentInSlot(4).getItem()).damageReduceAmount) {
                return true;
            }
        }
        return false;
    }
    
    private int s(final ItemStack s) {
        if (s.getItem() instanceof ItemArmor) {
            if (mc.thePlayer.getEquipmentInSlot(1) != null && s.getUnlocalizedName().contains("boots") && this.h(s) + ((ItemArmor)s.getItem()).damageReduceAmount > this.h(mc.thePlayer.getEquipmentInSlot(1)) + ((ItemArmor) mc.thePlayer.getEquipmentInSlot(1).getItem()).damageReduceAmount) {
                return 4;
            }
            if (mc.thePlayer.getEquipmentInSlot(2) != null && s.getUnlocalizedName().contains("leggings") && this.h(s) + ((ItemArmor)s.getItem()).damageReduceAmount > this.h(mc.thePlayer.getEquipmentInSlot(2)) + ((ItemArmor) mc.thePlayer.getEquipmentInSlot(2).getItem()).damageReduceAmount) {
                return 3;
            }
            if (mc.thePlayer.getEquipmentInSlot(3) != null && s.getUnlocalizedName().contains("chestplate") && this.h(s) + ((ItemArmor)s.getItem()).damageReduceAmount > this.h(mc.thePlayer.getEquipmentInSlot(3)) + ((ItemArmor) mc.thePlayer.getEquipmentInSlot(3).getItem()).damageReduceAmount) {
                return 2;
            }
            if (mc.thePlayer.getEquipmentInSlot(4) != null && s.getUnlocalizedName().contains("helmet") && this.h(s) + ((ItemArmor)s.getItem()).damageReduceAmount > this.h(mc.thePlayer.getEquipmentInSlot(4)) + ((ItemArmor) mc.thePlayer.getEquipmentInSlot(4).getItem()).damageReduceAmount) {
                return 1;
            }
        }
        return -1;
    }
    
    private boolean g(final ItemStack s) {
        return (mc.thePlayer.getEquipmentInSlot(1) == null && s.getUnlocalizedName().contains("boots")) || (mc.thePlayer.getEquipmentInSlot(2) == null && s.getUnlocalizedName().contains("leggings")) || (mc.thePlayer.getEquipmentInSlot(3) == null && s.getUnlocalizedName().contains("chestplate")) || (mc.thePlayer.getEquipmentInSlot(4) == null && s.getUnlocalizedName().contains("helmet"));
    }
    
    private double h(final ItemStack s) {
        if (!(s.getItem() instanceof ItemArmor)) {
            return 0.0;
        }
        return ((ItemArmor)s.getItem()).damageReduceAmount + (100 - ((ItemArmor)s.getItem()).damageReduceAmount * 4) * EnchantmentHelper.getEnchantmentLevel(Enchantment.protection.effectId, s) * 4 * 0.0075;
    }
    
    static {
        ChestStealer.t = 0L;
    }
}
