package ru.sstu.repository;

import org.springframework.stereotype.Repository;
import ru.sstu.model.Comment;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Shvarts on 13.01.2017.
 */
//@Component
@Repository
public class CommentsDAO //Data Access Object
{
    private List<Comment> comments = Arrays.asList(
            new Comment("123","efgerhgtr"),
            new Comment("1ergr23","574575675678"),
            new Comment("1","57457567erghrw6juhryhtyjhyjhyj5678")

    );



    public List<Comment> all()
    {
        return comments;
    }

    public Comment one(int index)
    {
        return comments.get(index);
    }

    public void add(Comment c)
    {
        comments.add(c);
    }

}
