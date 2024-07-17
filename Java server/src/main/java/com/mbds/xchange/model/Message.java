package com.mbds.xchange.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

public class Message {
    @Id
    private String _id;
    private Utilisateur sender;
    private String message;
    private LocalDateTime event_date;
    public Message(Utilisateur sender, String message) {
        this.sender=sender;
        this.message=message;
        this.event_date=LocalDateTime.now();
    }
    public Message() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public Utilisateur getSender() {
        return sender;
    }
    public void setSender(Utilisateur sender) {
        this.sender = sender;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public LocalDateTime getEvent_date() {
        return event_date;
    }
    public void setEvent_date(LocalDateTime event_date) {
        this.event_date = event_date;
    }
    
    
}
