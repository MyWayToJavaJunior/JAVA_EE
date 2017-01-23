package ru.sstu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
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












    //FIXME
    /*
        SECURITY
     */
    @RequestMapping(value = { "/welcome" }, method = RequestMethod.GET)
    public String defaultPage(ModelMap modelMap) {

        modelMap.addAttribute("title", "Spring Security Login Form - Database Authentication");
        modelMap.addAttribute("message", "This is default page!");
        return "hello";

    }

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public String adminPage(ModelMap modelMap) {
        modelMap.addAttribute("title", "Spring Security Login Form - Database Authentication");
        modelMap.addAttribute("message", "This page is for ROLE_ADMIN only!");
        return "admin";

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout, ModelMap modelMap) {


        if (error != null) {
            modelMap.addAttribute("error", "Invalid username and password!");
        }

        if (logout != null) {
            modelMap.addAttribute("msg", "You've been logged out successfully.");
        }

        return "login";

    }

    //for 403 access denied page
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accesssDenied(ModelMap modelMap) {


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            modelMap.addAttribute("username", userDetail.getUsername());
        }


        return "403";

    }

}
