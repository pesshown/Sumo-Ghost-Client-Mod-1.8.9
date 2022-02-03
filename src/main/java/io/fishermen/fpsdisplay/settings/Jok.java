package io.fishermen.fpsdisplay.settings;

import java.util.*;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraft.client.*;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import java.lang.reflect.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class Jok extends GuiSettings
{
    public Random r;
    
    public Jok() {
        super(a(new char[] { 'F', 'a', 's', 't', 'P', 'l', 'a', 'c', 'e' }), "", Categories.Other, 0, -1);
        this.r = new Random();
    }
    
    @SubscribeEvent
    public void a(final TickEvent.PlayerTickEvent a) { 
        ItemStack item = mc.thePlayer.getHeldItem();
         if (item == null || !(item.getItem() instanceof ItemBlock)) {
        	 return;
        	 
              }
        try {
            final Field field = Minecraft.class.getDeclaredField("field_71467_ac");
            field.setAccessible(true);
            final Field field2 = field;
            final Minecraft mc = Jok.mc;
            field2.set(Minecraft.getMinecraft(), 0);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
