package pw.cinque.keystrokes.render;

import pw.cinque.timechanger.*;
import pw.cinque.keystrokes.*;
import org.lwjgl.opengl.*;
import java.awt.*;
import net.minecraft.client.*;

public class Key extends Mode
{
    private boolean h;
    private ClickListener op;
    private KeystrokesRenderer p;
    private int o;
    private int x;
    private int y;
    
    public Key(final ClickListener op, final KeystrokesRenderer b, final int o) {
        this.op = op;
        this.p = b;
        this.x = b.p.gx() + b.p.gw();
        this.y = b.p.gy() + b.o;
        this.o = o;
    }
    
    public static void e() {
        GL11.glDisable(2929);
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glDepthMask(true);
        GL11.glEnable(2848);
        GL11.glHint(3154, 4354);
        GL11.glHint(3155, 4354);
    }
    
    public static void d() {
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glEnable(2929);
        GL11.glDisable(2848);
        GL11.glHint(3154, 4352);
        GL11.glHint(3155, 4352);
    }
    
    public static void d(final float x, final float y, final float x1, final float y1, final int c) {
        e();
        b(c);
        d(x, y, x1, y1);
        d();
    }
    
    public static void d(final float x, final float y, final float x1, final float y1) {
        GL11.glBegin(7);
        GL11.glVertex2f(x, y1);
        GL11.glVertex2f(x1, y1);
        GL11.glVertex2f(x1, y);
        GL11.glVertex2f(x, y);
        GL11.glEnd();
    }
    
    public static void b(final int h) {
        final float a = (h >> 24 & 0xFF) / 255.0f;
        final float r = (h >> 16 & 0xFF) / 255.0f;
        final float g = (h >> 8 & 0xFF) / 255.0f;
        final float b = (h & 0xFF) / 255.0f;
        GL11.glColor4f(r, g, b, a);
    }
    
    @Override
    public void r() {
        d((float)(this.p.p.gx() + 1), (float)(this.p.p.gy() + this.o + 1), (float)(this.p.p.gx() + 6 + this.p.p.gw() - 7), (float)(this.p.p.gy() + this.o + 11), this.op.i() ? new Color(154, 2, 255).getRGB() : -12434108);
        GL11.glPushMatrix();
        GL11.glScaled(0.5, 0.5, 0.5);
        Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(this.op.g(), (float)((this.p.p.gx() + 4) * 2), (float)((this.p.p.gy() + this.o + 4) * 2), -1);
        GL11.glPopMatrix();
    }
    
    @Override
    public void so(final int n) {
        this.o = n;
    }
    
    @Override
    public void uu(final int x, final int y) {
        this.h = this.i(x, y);
        this.y = this.p.p.gy() + this.o;
        this.x = this.p.p.gx();
    }
    
    @Override
    public void cl(final int x, final int y, final int b) {
        if (this.i(x, y) && b == 0 && this.p.po) {
            this.op.t();
        }
    }
    
    public boolean i(final int x, final int y) {
        return x > this.x && x < this.x + this.p.p.gw() && y > this.y && y < this.y + 11;
    }
}