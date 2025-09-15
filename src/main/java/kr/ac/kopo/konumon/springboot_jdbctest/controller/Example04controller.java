package kr.ac.kopo.konumon.springboot_jdbctest.controller;

import kr.ac.kopo.konumon.springboot_jdbctest.domain.Member;
import kr.ac.kopo.konumon.springboot_jdbctest.repository.MemberRepository04;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam04")
public class Example04controller {
    @Autowired
    MemberRepository04 repository;

    @GetMapping
    public String viewHompage(Model model) {
        Iterable<Member> memberList = repository.selectMethod();
        model.addAttribute("memberList", memberList);
        return "viewPage04";
    }

    @GetMapping("/new")
    public String newMethod(Model model) {
        model.addAttribute("member",new Member());
        return "viewPage04_new";
    }

    @PostMapping("/insert")
    public String insertMethod(@ModelAttribute("member") Member member) {
//        repository.insertMethod(member.getName(), member.getAge(), member.getEmail());
        repository.insertMethod(member);
        return "redirect:/exam04";
    }
}
