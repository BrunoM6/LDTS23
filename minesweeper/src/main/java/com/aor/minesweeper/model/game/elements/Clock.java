package com.aor.minesweeper.model.game.elements;

import java.time.Duration;

public class Clock {
    private Duration timeLeft;
    private boolean isRunning;

    public Clock(int totalSeconds) {
        this.timeLeft = Duration.ofSeconds(totalSeconds);
        this.isRunning = false;
    }

    public Duration getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(Duration duration) {
        this.timeLeft = duration;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public void decrementOneSecond() {
        if(timeLeft.isZero()){
            this.setRunning(false);
        }
        else{
            timeLeft = timeLeft.minusSeconds(1);
        }
    }
}
