package org.dubiner.tinycmd.core;


import org.dubiner.tinycmd.core.cmd.Cmd;

import java.util.HashSet;
import java.util.Set;

// TODO test onInterrupt
public final class Scheduler {
    private static final Set<Cmd> cmds = new HashSet<>();

    public static void add(Cmd cmd) {
        Set<Cmd> toRemove = new HashSet<>();
        if (!cmds.contains(cmd)) {
            for (Cmd c : cmds) {
                if (c.getSystems().stream().anyMatch(sys -> cmd.getSystems().contains(sys))) {
                    if (c.isInterruptible()) {
                        toRemove.add(c);
                    } else {
                        return;
                    }
                }
            }
            toRemove.forEach(Cmd::onInterrupt);
            cmds.removeAll(toRemove);
            cmds.add(cmd);
            cmd.init();
        }
    }

    public static void tick() {
        cmds.stream().filter(Cmd::isDone).forEach(Cmd::lastly);
        cmds.removeIf(Cmd::isDone);
        cmds.forEach(Cmd::loop);
    }

    public static void clear() {
        cmds.clear();
    }

    public static Set<Cmd> getCmds() {
        return cmds;
    }
}