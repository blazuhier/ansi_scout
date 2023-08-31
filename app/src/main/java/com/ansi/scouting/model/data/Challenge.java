package com.ansi.scouting.model.data;

public class Challenge {
    public String date;

    public String description;

    public String img;

    public String title;

    public Challenge() {
    }

    public Challenge(String date, String description, String img, String title) {
        this.date = date;
        this.description = description;
        this.img = img;
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
