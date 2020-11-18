package com.codelin.bean;

import java.util.Date;

/**
 * @author ISheep
 * @create 2020/11/17 10:27
 */
public class ChatMsg {
    private String from;
    private String to;
    private String content;
    private Date date;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
