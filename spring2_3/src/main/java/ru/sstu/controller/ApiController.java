package ru.sstu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.sstu.model.Comment;
import ru.sstu.model.db.Students;
import ru.sstu.service.AccpService;

import java.util.List;
import java.util.Random;

/**
 * Created by Shvarts on 20.01.2017.
 */
/*
REST - Representational State Transfer
1. Ресурсы
2. URI : http://myserver.ru/blog/users/6785
3. HTTP:
    GET  - получить
    POST - создать/изменить
    DELETE - удалить
    PUT - изменить/создать


 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private AccpService accpService;


    @RequestMapping(value = "/allStudents", method = RequestMethod.GET)
    public List<Students> allStudents()
    {
        return accpService.getAllStudents();
    }

    @RequestMapping(value = "/oneStudent/{id}", method = RequestMethod.GET)
    public Students allStudents(@PathVariable(value = "id") int id)
    {
        return accpService.getOneStudent(id);
    }

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String oneStudent(@RequestParam(value = "message") String message)
    {
        return message;
    }

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    public int randomInt()
    {
        Random r = new Random();
        return r.nextInt(100) + 1;
    }

    @RequestMapping(value = "/oneComment", method = RequestMethod.GET)
    public Comment oneComment()
    {
        return new Comment();
    }

    @RequestMapping(value = "/createComment", method = RequestMethod.POST)
    public Comment form1Handle(@ModelAttribute("newComment") Comment comment, ModelMap modelMap)
    {
        comment.setMessage("Вы мне сказали: " + comment.getMessage());
        return comment;
    }

}
