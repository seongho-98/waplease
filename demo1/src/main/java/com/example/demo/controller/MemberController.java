package com.example.demo.controller;


import com.example.demo.dto.MemberDTO;
import com.example.demo.service.MemberService;
import com.example.demo.session.SessionManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    private final SessionManager sessionManager;

    @GetMapping("/member/join")
    public String joinPage(){
        return "/join/join";
    }

    @GetMapping("/loginpage")
    public  String loginPage(){
        return "/login/login";
    }

    @GetMapping("/mainpage")
    public String mainPage(HttpServletRequest request, Model model){

        MemberDTO member = sessionManager.getSession(request);

        if(member == null){
            System.out.println("member가 null입니다");
            return "/login/login";
        }

        model.addAttribute("userName", memberService.findById(member.getMember_id()).getMember_name());
        System.out.println("==>인증 성공 메인페이지");

        return "/mainpage/mainpage";
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
            model.addAttribute("msg", "아이디나 이름의 길이가 맞지 않습니다.");
            model.addAttribute("url", "/join");
            return "/alert/MessageAlert";
        }

        memberService.insertMember(m1);

        model.addAttribute("msg", "회원가입이 성공하셨습니다 로그인 페이지로 이동합니다");
        model.addAttribute("url", "/loginpage");
        return "/alert/MessageAlert";
    }
/*
*   response.setCookie()해줬는데, /mainpage로 reqeust보냈을때 자꾸 cookie가 없어졌었는데, f12에서 쿠키 path를 보니
*   /member로 잡혀있었었음.. 아마 PostMapping : /member/loginCheck에서 /member가 앞으로 잡혀서 그런듯?
* */

    @PostMapping("/logout")
    public String logout(HttpServletRequest request){

        sessionManager.expire(request);
        System.out.println("세션 파괴됨");

        return "redirect:/loginpage";
    }

    @PostMapping("/login")
    public String loginCheck(Model model, MemberDTO m1, HttpServletResponse response){

        boolean isMember = memberService.loginCheck(m1);

        if(isMember){
            sessionManager.createSession(m1, response);
            return "redirect:/mainpage";
        }else{
            model.addAttribute("msg", "아이디나 비번이 잘못되었습니다. 로그인 페이지로 다시 이동합니다.");
            model.addAttribute("url", "/loginpage");
            return "/alert/MessageAlert";
        }
    }



}
