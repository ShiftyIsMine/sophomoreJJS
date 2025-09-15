package kr.ac.kopo.konumon.springboot_jdbctest.controller;


import kr.ac.kopo.konumon.springboot_jdbctest.domain.Member;
import kr.ac.kopo.konumon.springboot_jdbctest.repository.MemberRepository02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam03")
public class Example03controller {
    @Autowired
    MemberRepository02 memberRepository;

    @GetMapping
    public String viewHomePage(Model model) {
        Iterable<Member> memberList = memberRepository.selectMethod();
        model.addAttribute("memberList", memberList);
        return "viewPage02";
    }

    @GetMapping("/new")
    public String newMethod(Model model) {
        model.addAttribute("member", new Member());
        return "viewPage02_new";
    }

    @GetMapping("/insert")
    public String insertMethod(@ModelAttribute("member")Member member) {
        memberRepository.insertMethod(member.getName(), member.getAge(), member.getEmail());
        return "redirect:/exam03";
    }
}
