package org.dubiner.tinycmd.core.cmd;


import org.dubiner.tinycmd.core.sys.Sys;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BooleanSupplier;

public abstract class Cmd {
    private final Set<Sys> systems = new HashSet<>();
    private boolean interruptible = true;

    public abstract void init();
    public void loop() {}
    public void lastly() {}
    public void onInterrupt() {}
    public abstract boolean isDone();

    protected void addSys(Sys... systems) {
        this.systems.addAll(Arrays.asList(systems));
    }

    protected void addSys(Set<Sys> systems) {
        this.systems.addAll(systems);
    }

    public Set<Sys> getSystems() {
        return systems;
    }

    protected void setInterruptible(boolean interruptible) {
        this.interruptible = interruptible;
    }

    public boolean isInterruptible() {
        return interruptible;
    }

    public Cmd with(Cmd... cmds) {
        ParallelCmd parallelCmd = new ParallelCmd(this);
        parallelCmd.add(cmds);
        return parallelCmd;
    }

    public Cmd then(Cmd... cmds) {
        LinearCmd linearCmd = new LinearCmd(this);
        linearCmd.add(cmds);
        return linearCmd;
    }

    public Cmd indefinitely() {
        return new IndefiniteCmd(this);
    }

    public Cmd until(BooleanSupplier condition) {
        return new DefiniteCmd(this, condition);
    }

    public Cmd repeat(int n) {
        LinearCmd linearCmd = new LinearCmd(this);
        for (int i = 0; i < n-1; i++) {
            linearCmd.add(this);
        }
        return linearCmd;
    }
}
