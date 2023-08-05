package com.example.demo.entity;

public class ChatsDetails {
    private String id;            // unique id for all the messages.
    private String time;          // accurate up to millisecs
    private String message;
    private String status;
    // will be set to "sent" from user and "received" or may be to "read" for the end user and will be set to null if deleted.
    private String sentOrReceived;
    // will be set to either "sent" or "received" i.e. either the user1 has sent that message or received that message from user2.

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
