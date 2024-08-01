package com.mbds.tpt_android.Util;

public class HistoryItem {
    private String timestamp;
    private String objectId;
    private String objectName;
    private String proprietaire;

    public HistoryItem(String timestamp, String objectId, String objectName, String proprietaire) {
        this.timestamp = timestamp;
        this.objectId = objectId;
        this.objectName = objectName;
        this.proprietaire = proprietaire;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getObjectId() {
        return objectId;
    }

    public String getObjectName() {
        return objectName;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }
}

