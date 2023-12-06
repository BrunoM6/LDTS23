package com.aor.minesweeper.viewer;

import com.aor.minesweeper.gui.LanternaGUI;
import com.aor.minesweeper.model.game.elements.Clock;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import static jdk.jfr.internal.Utils.formatDuration;

public class ClockViewer {
    public void draw(Clock clock, int x, int y, LanternaGUI gui) {
        gui.drawClock(clock, x, y);
    }
}
