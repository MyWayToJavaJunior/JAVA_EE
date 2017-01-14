package ru.sstu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Shvarts on 11.01.2017.
 */
@Controller
@RequestMapping("/")
public class MainController {

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
}
