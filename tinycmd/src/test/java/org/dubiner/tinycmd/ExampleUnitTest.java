package org.dubiner.tinycmd;

import org.dubiner.tinycmd.core.Scheduler;
import org.dubiner.tinycmd.core.cmd.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    enum State {
        A,
        B,
        C
    }

    @Test
    public void switchCmd() {
        Supplier<State> supplier = () -> State.A;

        Map<Object, Cmd> a = new HashMap<>();
        a.put(State.A, new InstantCmd(() -> System.out.println("helo")));
        a.put(State.B, new InstantCmd(() -> System.out.println("amogus")));

        SwitchCmd switchCmd = new SwitchCmd(() -> State.B, a);
        Scheduler.add(switchCmd);
        Scheduler.tick();
        Scheduler.getCmds().forEach(System.out::println);
        Scheduler.tick();
        Scheduler.getCmds().forEach(System.out::println);
    }

    @Test
    public void e() {
        Scheduler.add(new IndefiniteCmd(new InstantCmd(() -> System.out.println("amogus"))));
        Scheduler.tick();
        Scheduler.tick();
        Scheduler.tick();
    }

    @Test
    public void booleanCmd() {
        BooleanCmd cmd = new BooleanCmd(new InstantCmd(() -> System.out.println("true")),
                new InstantCmd(() -> System.out.println("asdasdasd")).repeat(3), () -> false);
        Scheduler.add(cmd);
        Scheduler.tick();
        Scheduler.tick();
        Scheduler.tick();
        Scheduler.tick();
        Scheduler.tick();

    }
}