package com.example.demo.controller;


import com.example.demo.dto.MemberDTO;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Date;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/member/join")
    public String joinPage(){
        return "/join/join.html";
    }
    @GetMapping("/mainpage")
    public String mainPage(){
        return "/mainpage/mainpage.html";
    }
    @GetMapping("/loginpage")
    public  String loginPage(){
        return "/login/login";
    }


    @PostMapping("/member/join")
    public String registerMember(
            MemberDTO m1,
            Model model
    ){
        String id = m1.getMember_id();
        String name = m1.getMember_name();
        String pw = m1.getMember_pw();

        if(id.length() < 4 || name.length() < 1 || pw.length() < 3){
            model.addAttribute("msg", "아이디나 이름을 잘못 입력하셨습니다");
            model.addAttribute("url", "/join");
            return "/alert/MessageAlert";
        }

        memberService.insertMember(m1);

        model.addAttribute("msg", "회원가입이 성공하셨습니다 로그인 페이지로 이동합니다");
        model.addAttribute("url", "/loginpage");
        return "/alert/MessageAlert";
    }

    @PostMapping("/member/loginCheck")
    public String loginCheck(Model model, MemberDTO m1){
/*
        String id = m1.getMember_id();
        String name = m1.getMember_name();*/

        String pw = m1.getMember_pw();
        System.out.println("=============> 사용자 비밀번호 : " + pw);
        boolean isMember = memberService.loginCheck(m1);

        if(isMember == true){
            model.addAttribute("msg", "로그인 성공! 안녕하세요"+m1.getMember_name()+"님!! 메인 페이지로 이동합니다~");
            model.addAttribute("url", "/mainpage");
        }else{
            model.addAttribute("msg", "아이디나 비번이 잘못되었습니다. 로그인 페이지로 다시 이동합니다.");
            model.addAttribute("url", "/loginpage");
        }
        return "/alert/MessageAlert";

    }

}
