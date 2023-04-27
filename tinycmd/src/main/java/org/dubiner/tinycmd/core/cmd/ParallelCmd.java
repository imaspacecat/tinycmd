package org.dubiner.tinycmd.core.cmd;


// TODO test ParallelCmd
public class ParallelCmd extends GroupCmd {
    public ParallelCmd(Cmd... cmds) {
        super(cmds);
    }

    @Override
    public void init() {
        super.init();
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