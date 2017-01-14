package ru.sstu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by user on 09.01.2017.
 */
@Controller
@RequestMapping("/")
public class DefaultController {

    @RequestMapping("/")
    public String index()
    {
        return "index";
    }
}
