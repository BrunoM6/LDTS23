package com.aor.minesweeper.viewer;

import com.aor.minesweeper.model.game.elements.Clock;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import static jdk.jfr.internal.Utils.formatDuration;

public class ClockViewer {
    private Screen screen;

    public ClockViewer(Screen screen) {
        this.screen = screen;
    }

    public void draw(Clock clock, int x, int y) {
        TextGraphics textGraphics = screen.newTextGraphics();

        String timeLeftString = formatDuration(clock.getTimeLeft());
        textGraphics.putString(new TerminalPosition(x, y), timeLeftString);

        if (!clock.isRunning()) {
            textGraphics.putString(new TerminalPosition(x, y + 1), "PAUSED");
        }
    }

}
