package com.github.greengerong.log4js.model;

import java.io.Serializable;

public class LogInfo implements Serializable {

    private Level level = Level.Info;
    private String msg;
    private String data;

    public void setLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
