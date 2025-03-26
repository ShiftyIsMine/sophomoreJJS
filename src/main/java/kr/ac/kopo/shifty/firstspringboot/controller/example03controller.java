package kr.ac.kopo.shifty.firstspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/test")
public class example03controller {

    @GetMapping(value = "/exam04")
    public String requestMethod(){
        return "requesttest";
    }
}
