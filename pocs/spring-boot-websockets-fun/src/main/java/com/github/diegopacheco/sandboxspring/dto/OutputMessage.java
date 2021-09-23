package com.github.diegopacheco.sandboxspring.dto;

public class OutputMessage {

    private String from;
    private String text;
    private String time;

    public OutputMessage(){}

    public OutputMessage(String from, String text, String time) {
        this.from = from;
        this.text = text;
        this.time = time;
    }

    public String getFrom() {
        return from;
    }
    public String getText() {
        return text;
    }
    public String getTime() {
        return time;
    }

    public void setFrom(String from) {
        this.from = from;
    }
    public void setText(String text) {
        this.text = text;
    }
    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "OutputMessage{" +
                "from='" + from + '\'' +
                ", text='" + text + '\'' +
                ", time=" + time +
                '}';
    }
}
