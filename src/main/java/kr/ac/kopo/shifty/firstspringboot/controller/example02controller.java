package kr.ac.kopo.shifty.firstspringboot.controller;

import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class example02controller {
    @RequestMapping(value="/exam02" ,method=RequestMethod.GET)
    public String requestMethod(){
        return "restcontroller 연습 주웅";
    }
}
