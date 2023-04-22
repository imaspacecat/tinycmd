package org.firstinspires.ftc.teamcode.cmd;

import org.firstinspires.ftc.teamcode.sys.Sys;

public class InstantCmd extends FullCmd {
    public InstantCmd(Runnable runnable, Sys... systems) {
        super(runnable, () -> {}, () -> {}, () -> true, systems);
    }
}
