package org.dubiner.tinycmd.core.cmd;


import org.dubiner.tinycmd.core.sys.Sys;

import java.util.function.BooleanSupplier;

public class DefiniteCmd extends FullCmd {
    public DefiniteCmd(Cmd cmd, BooleanSupplier condition) {
        super(cmd::init, cmd::loop, cmd::lastly, cmd::onInterrupt,
                condition, cmd.getSystems().toArray(new Sys[0]));
    }
}
