package ru.sstu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Shvarts on 11.01.2017.
 */
@Controller
@RequestMapping(value = "/m")
public class MappingsController {

    @RequestMapping(value = "/print")
    public String printIndex2() {
        /*model.addAttribute("message", "Добрый день!");

        System.out.println("=================\nprint\n====================");*/
        return "index2";
    }

    @RequestMapping(value = "/method0")
    @ResponseBody
    public String method0() {
        return "method0";
    }

    @RequestMapping(value = {"/method1", "/*.html"})
    @ResponseBody
    public String method1() {
        return "method1";
    }

    @RequestMapping(value = "/method2", method = RequestMethod.POST)
    @ResponseBody
    public String method2() {
        return "method2";
    }

    @RequestMapping(value = "/method3", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String method3() {
        return "method3";
    }

    @RequestMapping(value = "/method4", params = {"pass=123456","id=7"})
    @ResponseBody
    public String method4() {
        return "method4";
    }

    @RequestMapping(value = "/method4_1", params = {"pass","id"})
    @ResponseBody
    public String method4_1() {
        return "method4_1";
    }

    @RequestMapping(value = "/method5", headers = {"name=abc", "id=1"})
    @ResponseBody
    public String method5() {
        return "method5";
    }

    @RequestMapping(value = "/method6", produces = {"application/json"})
    @ResponseBody
    public String method6() {
        return "method6";
    }

    @RequestMapping(value = "/method7/{category}/{id}")
    @ResponseBody
    public String method7(
            @PathVariable("category") String category,
            @PathVariable("id") int id) {
        return "method7 with id=" + id + " from category = " + category;
    }

    @RequestMapping(value = "/method8/{id:[\\d]{1,3}}/{name}")
    @ResponseBody
    public String method8(@PathVariable("id") long id,
                          @PathVariable("name") String name) {
        return "method8 with id= " + id + " and name=" + name;
    }

    @RequestMapping(value = "/method9")
    @ResponseBody
    public String method9(@RequestParam("id") int id) {
        System.out.println("METHOD 9 id=" + id);
        return "method9 with id= " + id;
    }

    @RequestMapping()
    @ResponseBody
    public String defaultMethod() {
        return "default method";
    }

    @RequestMapping("*")
    @ResponseBody
    public String fallbackMethod() {
        return "fallback method";
    }

}
