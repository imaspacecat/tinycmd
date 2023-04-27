package org.dubiner.tinycmd.core.cmd;


import org.dubiner.tinycmd.core.sys.Sys;

public class InstantCmd extends FullCmd {
    public InstantCmd(Runnable runnable, Sys... systems) {
        super(runnable, () -> {}, () -> {}, () -> {}, () -> true, systems);
    }
}
