package com.blog.controller;

import com.blog.properties.Proper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloController {

    @Resource
    private Proper Proper;

    @RequestMapping("/")
    public String toDemo(ModelMap map) {
        map.addAttribute("blog", "hello blog");
        return "demo";
    }

    @RequestMapping("/info")
    @ResponseBody
    public String getMsg(HttpServletResponse response) {
        return Proper.getBlogName() + Proper.getBlogTitle() + Proper.getBlogMessage()
                + Proper.getBlogRandomNum() + Proper.getBlogRandomStr();
    }
}
