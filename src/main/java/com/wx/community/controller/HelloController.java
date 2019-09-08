package com.wx.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: WX
 * @Date 2019/9/8 14:55
 * @Description:
 */

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam(name ="name")String name, Model model){
        model.addAttribute("name",name);
        return "index";

    }
    @GetMapping("/")
    public String hello1(){

        return "index";

    }
}
