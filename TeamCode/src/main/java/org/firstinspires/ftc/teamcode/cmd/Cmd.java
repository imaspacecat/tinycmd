package org.firstinspires.ftc.teamcode.cmd;

import org.firstinspires.ftc.teamcode.sys.Sys;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Cmd {
    private final Set<Sys> systems = new HashSet<>();
    private boolean interruptible = true;


    protected Cmd() {}

    protected Cmd(boolean interruptible) {
        this.interruptible = interruptible;
    }

    // TODO add method to run on interrupt

    public abstract void init();
    public void loop() {}
    public void lastly() {}
    public abstract boolean isDone();

    protected void addSys(Sys... systems) {
        this.systems.addAll(Arrays.asList(systems));
    }

    public Set<Sys> getSystems() {
        return systems;
    }

    public boolean isInterruptible() {
        return interruptible;
    }

    // TODO: make inline utilities such as `indefinite()`, `repeat(int n)`, `with(Command/Runnable)`
}
