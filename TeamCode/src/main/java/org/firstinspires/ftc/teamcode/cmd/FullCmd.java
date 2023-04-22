package org.firstinspires.ftc.teamcode.cmd;

import org.firstinspires.ftc.teamcode.sys.Sys;

import java.util.function.BooleanSupplier;

public class FullCmd extends Cmd {
    private final Runnable init, loop, lastly;
    private final BooleanSupplier done;

    public FullCmd(Runnable init, Runnable loop, Runnable lastly, BooleanSupplier done, Sys... systems) {
        this.init = init;
        this.loop = loop;
        this.lastly = lastly;
        this.done = done;
        addSys(systems);
    }

    @Override
    public void init() {
        init.run();
    }

    @Override
    public void loop() {
        loop.run();
    }

    @Override
    public void lastly() {
        lastly.run();
    }

    @Override
    public boolean isDone() {
        return done.getAsBoolean();
    }
}
