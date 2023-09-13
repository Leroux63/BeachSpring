package com.hb.dl.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller()
public class HomeController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    @ResponseBody
    public String sayHello(){
        return "<h1>Hello World !</h1>";
    }
}
