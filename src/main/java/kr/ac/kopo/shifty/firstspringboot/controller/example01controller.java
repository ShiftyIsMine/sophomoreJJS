package kr.ac.kopo.shifty.firstspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class example01controller {
    @RequestMapping(value="/exam01",method = RequestMethod.GET)
    public String requestMethod(){
        return "viewPage01";
    }
    @RequestMapping(value="/exam03",method = RequestMethod.GET)
    public @ResponseBody String getMessage(){
        return "rest rest!!! getMessage!!!!!!!!!!!!!!!!!!!!!!";
    }
}
