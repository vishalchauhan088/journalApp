package com.vishalchauhan0688.journalApp.entity;

public class JournalEntry {

    private long id;
    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String toString(){
        return "id:" + this.id + "\ttitle" + this.title + "\tcontent: " + this.content;
    }
}
