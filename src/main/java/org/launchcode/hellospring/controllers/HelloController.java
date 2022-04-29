package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody //applies to all of the methods inside the controller class
@RequestMapping("hello") //every single methods inside should begin /hello
public class HelloController {

////    handles request at the root
////    @GetMapping
////    handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye") // lives at /hello/goodbye
//    @ResponseBody
    public String goodbye(){
        return "Goodbye, Spring!";
    }

//    if you want a controller method that handles
//    more than one method, say GET and POST you
//    can use @RequestMapping
    @RequestMapping(value = "hellogoodbye",method={RequestMethod.GET,RequestMethod.POST}) //lives at /hello/hellogoodbye
//    @ResponseBody
    public String helloGoodbye(){
        return "hello goodbye";
    }

////    handles request of the form /hello?name=John
//    @GetMapping("hello")
//    @ResponseBody
//    public String helloWithQueryParam(@RequestParam String name){
//        return "Welcome "+ name + "!";
//    }

//    updated to handle Get and Post request
    @RequestMapping(value = "hello",method = {RequestMethod.GET,RequestMethod.POST}) // lives at /hello/hello
//    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name){
        return "Welcome "+ name + "!";
    }

//    handles path parameters of the form /hello/name
    @GetMapping("hello/{name}") // lives at hello/hello
//    @ResponseBody
    public String helloWithPathParam(@PathVariable String name){
        return "Hi "+name+" welcome to John's website!";
    }

//  redirects a user
    @GetMapping("redirect")
    public String redirect(){
        return  "redirect:/goodbye";
    }

//    sending form data
    @GetMapping("form")
//    @ResponseBody
    public String helloForm(){
        return "<html>" +
                 "<body>" +
                  "<form action='hello' method='post'>"+ //submit request to /hello (if method omitted the default is set to get)
                   "<input type='text' name='name'>" +
                   "<input type='submit' value='Greet me!'>"+
                  "</form>" +
                 "</body>" +
                "</html>";
    }


}
