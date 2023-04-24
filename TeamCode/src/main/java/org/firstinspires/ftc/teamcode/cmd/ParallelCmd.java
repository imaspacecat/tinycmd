package org.firstinspires.ftc.teamcode.cmd;

import org.firstinspires.ftc.teamcode.sys.Sys;

import java.util.Arrays;
import java.util.List;

// TODO test
public class ParallelCmd extends Cmd {
    private final List<Cmd> cmds;

    public ParallelCmd(Cmd... cmds) {
        for (Cmd c : cmds) {
            addSys(c.getSystems().toArray(new Sys[0]));
        }
        this.cmds = Arrays.asList(cmds);
    }

    @Override
    public void init() {
        cmds.forEach(Cmd::init);
    }

    @Override
    public void loop() {
        cmds.forEach(Cmd::loop);
    }

    @Override
    public void lastly() {
        cmds.forEach(Cmd::lastly);
    }

    @Override
    public boolean isDone() {
        return cmds.stream().allMatch(Cmd::isDone);
    }
}