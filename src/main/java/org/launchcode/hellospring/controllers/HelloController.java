package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

//    handles request at the root
//    @GetMapping
//    handles request at path /hello
    @GetMapping("hello")
    @ResponseBody
    public String hello(){
        return "Hello, Spring!";
    }

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye, Spring!";
    }

//    if you want a controller method that handles
//    more than one method, say GET and POST you
//    can use @RequestMapping
    @RequestMapping(value = "hellogoodbye",method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String helloGoodbye(){
        return "hello goodbye";
    }
}
