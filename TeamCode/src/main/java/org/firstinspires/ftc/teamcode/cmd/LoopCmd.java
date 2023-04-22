package org.firstinspires.ftc.teamcode.cmd;

import org.firstinspires.ftc.teamcode.sys.Sys;

public class LoopCmd extends FullCmd {
    public LoopCmd(Runnable runnable, Sys... systems) {
        super(() -> {}, runnable, () -> {}, () -> false, systems);
    }
}
