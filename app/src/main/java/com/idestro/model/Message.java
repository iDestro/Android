package com.idestro.model;

public class Message {

    private String name;
    private String content;
    private String imageUrl;
    private String pushTime;

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setPushTime(String pushTime) {
        this.pushTime = pushTime;
    }

    public String getName() {
        return this.name;
    }

    public String getContent() {
        return this.content;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getPushTime() {
        return this.pushTime;
    }
}
