package ru.sstu;

import java.util.Date;

/**
 * Created by Shvarts on 14.12.16.
 */
public class Comment {
    //POJO plain old java object

    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    private String content;
    private Date added;
}
