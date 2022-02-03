package pw.cinque.timechanger;

import pw.cinque.CommandSettings.*;

public class ClickListener extends GuiSettings
{
    private String n;
    private boolean v;
    
    public ClickListener(final String n, final boolean v) {
        super(n);
        this.n = n;
        this.v = v;
    }
    
    @Override
    public String g() {
        return this.n;
    }
    
    public boolean i() {
        return this.v;
    }
    
    public void t() {
        this.v = !this.v;
    }
}
