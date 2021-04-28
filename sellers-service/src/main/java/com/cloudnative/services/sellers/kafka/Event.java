package com.cloudnative.services.sellers.kafka;

public class Event {
    
    private String type;
    private String info;

    public Event() {

    }

    public Event(String type, String info) {
        this.type = type;
        this.info = info;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return type + ", " + info + "!";
    }
    
}
