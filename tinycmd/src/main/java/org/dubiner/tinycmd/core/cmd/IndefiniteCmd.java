package org.dubiner.tinycmd.core.cmd;


import org.dubiner.tinycmd.core.sys.Sys;

public class IndefiniteCmd extends CustomCmd {
    public IndefiniteCmd(Cmd cmd) {
        super(cmd::init, cmd::loop, cmd::lastly, cmd::onInterrupt,
                () -> false, cmd.getSystems().toArray(new Sys[0]));
    }
}
