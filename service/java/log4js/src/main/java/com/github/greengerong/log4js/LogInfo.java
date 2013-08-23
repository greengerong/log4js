package com.github.greengerong.log4js;

public class LogInfo {

    private Level level = Level.Info;
    private String msg;
    private String data;

    public LogInfo(Level level) {
        this.level = level;
    }

    public LogInfo() {
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
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
