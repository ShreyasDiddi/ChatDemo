package com.a6studios.chatdemo;

/**
 * Created by HP on 1/15/2018.
 */

public class Message {
    boolean sent;
    String msg;

    public Message(){}
    public Message(boolean sent, String msg) {
        this.sent = sent;
        this.msg = msg;
    }

    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
        String modifieds = msg.replaceAll("^\\s+","");
        this.msg = modifieds.replaceAll("\\s+$","");
    }
}
