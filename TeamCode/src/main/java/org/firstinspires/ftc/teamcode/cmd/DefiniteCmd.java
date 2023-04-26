package org.firstinspires.ftc.teamcode.cmd;

import org.firstinspires.ftc.teamcode.sys.Sys;

import java.util.function.BooleanSupplier;

public class DefiniteCmd extends FullCmd {
    public DefiniteCmd(Cmd cmd, BooleanSupplier condition) {
        super(cmd::init, cmd::loop, cmd::lastly, cmd::onInterrupt,
                condition, cmd.getSystems().toArray(new Sys[0]));
    }
}
