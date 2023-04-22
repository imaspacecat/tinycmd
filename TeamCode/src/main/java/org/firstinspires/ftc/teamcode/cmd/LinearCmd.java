package org.firstinspires.ftc.teamcode.cmd;

import org.firstinspires.ftc.teamcode.sys.Sys;


public class LinearCmd extends Cmd {
    private final Cmd[] cmds;
    private int index = 0;

    public LinearCmd(Cmd... cmds) {
        for (Cmd c : cmds) {
            addSys(c.getSystems().toArray(new Sys[0]));
        }
        this.cmds = cmds;
    }

    @Override
    public void init() {
        cmds[0].init();
    }

    @Override
    public void loop() {
        if (cmds[index].isDone()) {
            cmds[index].lastly();
            cmds[++index].init();
        } else {
            cmds[index].loop();
        }
    }

    @Override
    public void lastly() {
        cmds[cmds.length - 1].lastly();
    }

    @Override
    public boolean isDone() {
        return cmds[cmds.length - 1].isDone() && index == cmds.length - 1;
    }
}