package pw.cinque.keystrokes;

import net.minecraft.client.gui.Gui;
import pw.cinque.keystrokes.render.*;
import pw.cinque.CommandSettings.*;
import net.minecraft.client.gui.*;
import java.awt.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.*;
import java.math.*;

public class KeystrokesGui extends Mode
{
    private boolean h;
    private CommandSettings v;
    private KeystrokesRenderer p;
    private int o;
    private int x;
    private int y;
    private boolean d;
    private double w;

    public KeystrokesGui(final CommandSettings v, final KeystrokesRenderer b, final int o) {
        this.d = false;
        this.v = v;
        this.p = b;
        this.x = b.p.gx() + b.p.gw();
        this.y = b.p.gy() + b.o;
        this.o = o;
    }

    @Override
    public void r() {
        Gui.drawRect(this.p.p.gx() + 4, this.p.p.gy() + this.o + 11, this.p.p.gx() + 4 + this.p.p.gw() - 8, this.p.p.gy() + this.o + 15, -12434108);
        Gui.drawRect(this.p.p.gx() + 4, this.p.p.gy() + this.o + 11, this.p.p.gx() + 4 + (int)this.w, this.p.p.gy() + this.o + 15, new Color(154, 2, 255).getRGB());
        GL11.glPushMatrix();
        GL11.glScaled(0.5, 0.5, 0.5);
        Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(String.valueOf(String.valueOf(this.v.g())) + ": " + this.v.g34(), (float)(int)((this.p.p.gx() + 4) * 2.0f), (float)(int)((this.p.p.gy() + this.o + 3) * 2.0f), -1);
        GL11.glPopMatrix();
    }
    
    @Override
    public void so(final int n) {
        this.o = n;
    }
    
    @Override
    public void uu(final int x, final int y) {
        this.h = (this.u(x, y) || this.i(x, y));
        this.y = this.p.p.gy() + this.o;
        this.x = this.p.p.gx();
        final double d = Math.min(this.p.p.gw() - 8, Math.max(0, x - this.x));
        this.w = (this.p.p.gw() - 8) * (this.v.g34() - this.v.g3i()) / (this.v.g3a() - this.v.g3i());
        if (this.d) {
            if (d == 0.0) {
                this.v.v(this.v.g3i());
            }
            else {
                final double n = r(d / (this.p.p.gw() - 8) * (this.v.g3a() - this.v.g3i()) + this.v.g3i(), 2);
                this.v.v(n);
            }
        }
    }
    
    private static double r(final double v, final int p) {
        if (p < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal bd = new BigDecimal(v);
        bd = bd.setScale(p, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    
    @Override
    public void cl(final int x, final int y, final int b) {
        if (this.u(x, y) && b == 0 && this.p.po) {
            this.d = true;
        }
        if (this.i(x, y) && b == 0 && this.p.po) {
            this.d = true;
        }
    }
    
    @Override
    public void mr(final int x, final int y, final int m) {
        this.d = false;
    }
    
    public boolean u(final int x, final int y) {
        return x > this.x && x < this.x + (this.p.p.gw() / 2 + 1) && y > this.y && y < this.y + 16;
    }
    
    public boolean i(final int x, final int y) {
        return x > this.x + this.p.p.gw() / 2 && x < this.x + this.p.p.gw() && y > this.y && y < this.y + 16;
    }
}

