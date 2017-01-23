package ru.sstu.service;

import org.springframework.stereotype.Service;
import ru.sstu.model.Comment;
import ru.sstu.repository.CommentsDAO;

import java.util.List;

/**
 * Created by Shvarts on 13.01.2017.
 */
//@Component
@Service
public class BlogService {

    public CommentsDAO getCommentsDAO() {
        return commentsDAO;
    }

    public void setCommentsDAO(CommentsDAO commentsDAO) {
        this.commentsDAO = commentsDAO;
    }

    private CommentsDAO commentsDAO;

    public List<Comment> getAllComments()
    {
        return commentsDAO.all();
    }
}
