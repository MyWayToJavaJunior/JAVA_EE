package ru.sstu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.sstu.model.Comment;
import ru.sstu.service.BlogService;

import java.util.Date;

/**
 * Created by Shvarts on 11.01.2017.
 */
@Controller
@RequestMapping("/")
public class MainController {

    public BlogService getBlogService() {
        return blogService;
    }

    @Autowired
    @Qualifier("blogServiceBean")
    public void setBlogService(BlogService blogService) {
        this.blogService = blogService;
    }

    private BlogService blogService;


    @RequestMapping("/")
    public String index()
    {
        return "index";
    }

    @RequestMapping("*")
    @ResponseBody
    public String fallbackMethod() {
        return "fallback method";
    }

    @RequestMapping("/message")
    public String message(ModelMap modelMap)
    {
        modelMap.addAttribute("messageValue", "Привет всем!");

        modelMap.addAttribute("today", new Date());
        return "message";
    }

    @RequestMapping(value = "/form1", method = RequestMethod.GET)
    public String form1(ModelMap modelMap)
    {
        modelMap.addAttribute("newComment", new Comment());
        return "form1";
    }

    @RequestMapping(value = "/form1", method = RequestMethod.POST)
    public String form1Handle(@ModelAttribute("newComment") Comment comment, ModelMap modelMap)
    {
        modelMap.addAttribute("comment", comment);
        return "form1Result";
    }

    @RequestMapping(value = "/allComments")
    public String form1Handle(ModelMap modelMap)
    {
        modelMap.addAttribute("comments", blogService.getAllComments());
        return "comments";
    }

}
