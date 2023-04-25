package org.firstinspires.ftc.teamcode.cmd;


public class IndefiniteCmd extends Cmd {
    private final Cmd cmd;
    public IndefiniteCmd(Cmd cmd) {
        this.cmd = cmd;
        addSys(cmd.getSystems());
    }

    @Override
    public void init() {
        cmd.init();
    }

    @Override
    public void loop() {
        cmd.loop();
    }

    @Override
    public void onInterrupt() {
        cmd.onInterrupt();
    }

    @Override
    public boolean isDone() {
        return false;
    }
}
