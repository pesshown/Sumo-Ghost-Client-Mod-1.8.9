package pw.cinque.timechanger;

import net.minecraft.client.gui.Gui;
import pw.cinque.keystrokes.*;
import java.util.*;
import net.minecraft.client.gui.*;
import pw.cinque.keystrokes.render.*;
import java.awt.*;
import org.lwjgl.opengl.*;

import io.fishermen.fpsdisplay.settings.GuiSettings;

public class CPSMod
{
    public ArrayList<Mode> c;
    public GuiSettings.Categories ca;
    private boolean on;
    private int w;
    private int y;
    private int x;
    private int bh;
    private boolean id;
    public int xx;
    public int yy;
    public boolean n4m;
    public String pvp;
    public boolean pin;
    
    public CPSMod(final GuiSettings.Categories cat) {
        this.n4m = false;
        this.pin = false;
        this.c = new ArrayList<Mode>();
        this.ca = cat;
        this.w = 92;
        this.x = 5;
        this.y = 5;
        this.bh = 13;
        this.xx = 0;
        this.on = false;
        this.id = false;
        int tY = this.bh + 3;
        for (final GuiSettings m : KeystrokesMod.w.m().i(this.ca)) {
            final KeystrokesRenderer b = new KeystrokesRenderer(m, this, tY);
            this.c.add(b);
            tY += 16;
        }
    }
    
    public CPSMod(final String d) {
        this.n4m = false;
        this.pin = false;
        this.c = new ArrayList<Mode>();
        this.w = 92;
        this.x = 5;
        this.y = 5;
        this.bh = 13;
        this.xx = 0;
        this.on = false;
        this.id = false;
        final int tY = this.bh;
        this.pvp = d;
        this.n4m = true;
    }
    
    public ArrayList<Mode> gc() {
        return this.c;
    }
    
    public void x(final int n) {
        this.x = n;
    }
    
    public void y(final int y) {
        this.y = y;
    }
    
    public void d(final boolean d) {
        this.id = d;
    }
    
    public boolean p() {
        return this.pin;
    }
    
    public void cv(final boolean on) {
        this.pin = on;
    }
    
    public boolean fv() {
        return this.on;
    }
    
    public void oo(final boolean on) {
        this.on = on;
    }
    
    public void rf(final FontRenderer f) {
        this.w = 92;
        if (!this.c.isEmpty() && this.on) {
            int h = 0;
            for (final Mode c : this.c) {
                h += c.gh();
            }
            Gui.drawRect(this.x - 2, this.y, this.x + this.w + 2, this.y + this.bh + h + 4, -14145496);
        }
        Key.d((float)(this.x - 2), (float)this.y, (float)(this.x + this.w + 2), (float)(this.y + this.bh + 3), -14145496);
        f.drawStringWithShadow(this.n4m ? this.pvp : this.ca.name(), (float)(this.x + 2), (float)(this.y + 4), -5592406);
        if (this.n4m) {
            return;
        }
        Key.d((float)(this.x + 92 - 13 - 13), this.y + 2.0f, (float)(this.x + this.w - 14), (float)(this.y + this.bh + 1), this.on ? new Color(154, 2, 255).getRGB() : -12434108);
        Key.d((float)(this.x + 93 - 13), this.y + 2.0f, (float)(this.x + this.w), (float)(this.y + this.bh + 1), this.pin ? new Color(154, 2, 255).getRGB() : -12434108);
        GL11.glPushMatrix();
        GL11.glTranslated(0.5, 0.0, 0.0);
        f.drawStringWithShadow(this.on ? "-" : "+", (float)(this.x + 81 - 12), (float)(this.y + 4), -5592406);
        GL11.glPopMatrix();
        if (this.on && !this.c.isEmpty()) {
            for (final Mode c2 : this.c) {
                c2.r();
            }
        }
    }
    
    public void r() {
        int o = this.bh + 3;
        for (final Mode c : this.c) {
            c.so(o);
            o += c.gh();
        }
    }
    
    public int gx() {
        return this.x;
    }
    
    public int gy() {
        return this.y;
    }
    
    public int gw() {
        return this.w;
    }
    
    public void up(final int x, final int y) {
        if (this.id) {
            this.x(x - this.xx);
            this.y(y - this.yy);
        }
    }
    
    public boolean i(final int x, final int y) {
        return x >= this.x + 92 - 13 && x <= this.x + this.w && y >= this.y + 2.0f && y <= this.y + this.bh + 1;
    }
    
    public boolean d(final int x, final int y) {
        return x >= this.x + 92 - 13 - 13 && x <= this.x + this.w - 14 && y >= this.y + 2.0f && y <= this.y + this.bh + 1;
    }
    
    public boolean v(final int x, final int y) {
        return x >= this.x && x <= this.x + this.w && y >= this.y && y <= this.y + this.bh;
    }
}
