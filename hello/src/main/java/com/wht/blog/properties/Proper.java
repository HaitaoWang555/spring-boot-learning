package com.wht.blog.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Proper {
    @Value("${blog.name}")
    private String blogName;

    @Value("${blog.title}")
    private String blogTitle;

    @Value("${blog.message}")
    private String blogMessage;

    @Value("${blog.randomNum}")
    private String blogRandomNum;

    @Value("${blog.randomStr}")
    private String blogRandomStr;

}
