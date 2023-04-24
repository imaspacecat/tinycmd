package org.firstinspires.ftc.teamcode.cmd;

import org.firstinspires.ftc.teamcode.sys.Sys;


public class ParallelCmd extends Cmd {
    private final Cmd[] cmds;

    public ParallelCmd(Cmd... cmds) {
        for (Cmd c : cmds) {
            addSys(c.getSystems().toArray(new Sys[0]));
        }
        this.cmds = cmds;
    }

    @Override
    public void init() {
        for (Cmd cmd : cmds) {
            cmd.init();
        }
    }

    @Override
    public void loop() {
        for (Cmd cmd : cmds) {
            cmd.loop();
        }
    }

    @Override
    public void lastly() {
        for (Cmd cmd : cmds) {
            cmd.lastly();
        }
    }

    @Override
    public boolean isDone() {
        boolean done = true;
        for (Cmd cmd : cmds) {
            done = done && cmd.isDone();
        }

        return done;
    }
}
