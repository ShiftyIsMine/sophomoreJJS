package kr.ac.kopo.shifty.firstspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class exam06controllererererererererre {
    @GetMapping("/exam06")
    public String requestMethod(Model model) {
        model.addAttribute("data1","Model 예제에");
        model.addAttribute("data2","웹 요청할 때 http://localhost:8080/exam06임당");
        return "viewPage06_1";
    }
    @GetMapping("/exam07")
    public String requestMethod2(ModelMap modelmap) {
        modelmap.addAttribute("message1","모델맵 클래스는 model의 자식이다");
        modelmap.addAttribute("message2","모뎁맵 클래스는 model 기능과 동일 and 확장 기능 사용");

        List<String> list =new ArrayList<>();
        list.add("망고망고망고망고");
        list.add("수박수박수박수박");
        list.add("사과사과사과사과");

        modelmap.addAttribute("list1",list);
        return "viewPage0Modelhuh";
    }
    @GetMapping("/exam08")
    public ModelAndView requestMethod3() {
        ModelAndView maavictory = new ModelAndView("viewPageMAVast");
//        maavictory.setViewName("viewPageMAVast");
        maavictory.addObject("msg1","다시다,MAV 클래스 예제제제");
        maavictory.addObject("msg2","미원,MAV 클래스는 View의 이름 생성자 또는 메소드를 통해 설정할 수 있따.");
        maavictory.addObject("msg3","연두, MAV 클래스는 값이나 객체 참조값을 전달할 때");
        maavictory.addObject("msg4","MAV 클래스는 요청 메소드의 매개변수를 통해 사용하는 것이 아니라 객체 생성을 해서 사용 and 리턴 값으로 참조 변수");

        List<String> list2 =new ArrayList<>();
        list2.add("맛있는 거 없나");
        list2.add("공차?");
        list2.add("스벅?");
        list2.add("아니면 다른 곳?");
        maavictory.addObject("list2",list2);

        return maavictory;
    }
}
