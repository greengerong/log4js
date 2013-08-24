package com.github.greengerong.log4js.model;

public enum Level {
    Debug(0), Info(1), Warn(2), Error(3), All(-1), Off(4);
    private int value;

    Level(int value) {

        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
