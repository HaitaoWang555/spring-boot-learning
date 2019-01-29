package com.wht.blog.controller;

import com.wht.blog.Scheduled.Task;
import com.wht.blog.properties.Proper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.Future;

@Controller
public class HelloController {

    @Resource
    private Proper Proper;
    @Resource
    private Task Task;

    @RequestMapping("/")
    public String toDemo(ModelMap map) {
        map.addAttribute("blog", "hello blog");
        return "demo";
    }

    @RequestMapping("/logError")
    @ResponseBody
    public String logError() {
//      System.out.println(1/0);
        return "hello spring boot logError!";
    }

    @RequestMapping("/info")
    @ResponseBody
    public String getMsg(HttpServletResponse response) {
        return Proper.getBlogName() + Proper.getBlogTitle() + Proper.getBlogMessage()
                + Proper.getBlogRandomNum() + Proper.getBlogRandomStr();
    }

    @RequestMapping("/test")
    @ResponseBody
    public String getTest() {
        try{
            long start = System.currentTimeMillis();
            Future<String>task1 = Task.doTaskOne();
            Future<String>task2 = Task.doTaskTwo();
            Future<String>task3 = Task.doTaskThree();
            while(true) {
                if(task1.isDone() && task2.isDone() && task3.isDone()) {
                    //三个任务都调用完成，退出循环等待
                    long end = System.currentTimeMillis();
                    return "任务全部完成，总耗时：" + (end - start) + "毫秒";
                }
                Thread.sleep(1000);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return "任务失败";
        }
    }
}
