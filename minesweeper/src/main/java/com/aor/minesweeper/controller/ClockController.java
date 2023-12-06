package com.aor.minesweeper.controller;

import com.aor.minesweeper.model.game.elements.Clock;
import java.util.Timer;
import java.util.TimerTask;

public class ClockController {
    private final Clock clock;
    private Timer timer;

    public ClockController(Clock clock) {
        this.clock = clock;
    }

    public void start() {
        if (!clock.isRunning() && !clock.getTimeLeft().isZero()) {
            clock.setRunning(true);
            timer = new Timer(true);
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    clock.decrementOneSecond();
                    if (clock.getTimeLeft().isZero()) {
                        clock.setRunning(false);
                        stop();
                        // You can also notify the game state that the time is up.
                    }
                    // Here you should also trigger the clock view to update.
                }
            }, 1000, 1000);
        }
    }

    public void stop() {
        if (clock.isRunning()) {
            clock.setRunning(false);
            if (timer != null) {
                timer.cancel();
            }
        }
    }

    public Clock getClock() {
        return clock;
    }

    // Additional methods for interacting with the clock can be added here,
    // such as reset, add time, subtract time, etc.
}
