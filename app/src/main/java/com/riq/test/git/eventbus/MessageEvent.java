package com.riq.test.git.eventbus;

/**
 * Created by dreamriq on 2017/8/4.
 */

public class MessageEvent {
    private String msg;

    public MessageEvent(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
