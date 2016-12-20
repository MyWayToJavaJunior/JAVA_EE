package ru.sstu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Shvarts on 14.12.16.
 */
public class BlogBean implements Serializable {


    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    private String post = "<p><i>Всё прошло хорошо</i>, но не очень</p>", title = "О путешествии в Москву";

    public String getNewComment() {
        return newComment;
    }

    public void setNewComment(String newComment) {

        System.out.println("======================\nНОВЫЙ КОММЕНТ = " + newComment +" от автора  " + login);
        if(newComment != null && login != null)
        {
            if(!newComment.isEmpty() && !login.isEmpty())
            {
                Comment c = new Comment();
                c.setContent(newComment);
                c.setAdded(new Date());
                c.setAuthor(login);
                login = null;


                System.out.println("Комментарий добавлен!");

                comments.add(c);

            }
        }
        this.newComment = newComment;
    }

    private String newComment;

    public String getLogin() {

        return login;
    }

    public void setLogin(String login) {
        if(login != null)
            if(!login.isEmpty())
                this.login = login;
    }

    private String login;

    private List<Comment> comments = new ArrayList<Comment>();
}
