package org.firstinspires.ftc.teamcode.cmd;


import org.firstinspires.ftc.teamcode.sys.Sys;

public class IndefiniteCmd extends FullCmd {
    public IndefiniteCmd(Cmd cmd) {
        super(cmd::init, cmd::loop, cmd::lastly, cmd::onInterrupt,
                () -> false, cmd.getSystems().toArray(new Sys[0]));
    }
}
