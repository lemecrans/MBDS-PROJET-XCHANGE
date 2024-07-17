package com.mbds.xchange.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "chat")
public class Chat {
    @Id
    private String _id;
    private Utilisateur sender;
    private Utilisateur desti;
    private List<Message> discussion;

    public Utilisateur getSender() {
        return sender;
    }

    public Chat() {
    }

    public Chat(Utilisateur sender, Utilisateur desti, List<Message> discussion) {
        this.sender = sender;
        this.desti = desti;
        this.discussion = discussion;
    }

    public void setSender(Utilisateur sender) {
        this.sender = sender;
    }

    public Utilisateur getDesti() {
        return desti;
    }

    public void setDesti(Utilisateur desti) {
        this.desti = desti;
    }

    public List<Message> getDiscussion() {
        return discussion;
    }

    public void setDiscussion(List<Message> discussion) {
        this.discussion = discussion;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}

