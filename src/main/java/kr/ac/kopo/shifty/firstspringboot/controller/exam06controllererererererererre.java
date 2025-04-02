package kr.ac.kopo.shifty.firstspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class exam06controllererererererererre {
    @GetMapping("/exam06")
    public String requestMethod(Model model) {
        model.addAttribute("data1","Model 예제에");
        model.addAttribute("data2","웹 요청할 때 http://localhost:8080/exam06임당");
        return "viewPage06_1";
    }
}
