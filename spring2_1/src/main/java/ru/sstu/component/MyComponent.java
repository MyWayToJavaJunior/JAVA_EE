package ru.sstu.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sstu.repository.CommentsDAO;
import ru.sstu.service.BlogService;

/**
 * Created by Shvarts on 13.01.2017.
 */
@Component
public class MyComponent {

    @Autowired
    public MyComponent(BlogService bs, CommentsDAO cd)
    {
        System.out.println("BS and CD : " + bs + " and " + cd);
    }
}
