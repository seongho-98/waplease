package com.example.demo.controller;

import com.example.demo.dto.BookDTO;
import com.example.demo.dto.MemberDTO;
import com.example.demo.service.BookService;
import com.example.demo.service.MemberService;
import com.example.demo.session.SessionManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private MemberService memberService;

    private final SessionManager sessionManager;


    @GetMapping("/search")
    public String bookList(Model model, @RequestParam(value="bookSearch") String bookSearch, HttpServletRequest request){

        MemberDTO member = sessionManager.getSession(request);

        if(member == null){
            System.out.println("member가 null입니다");
            return "/login/login";
        }

        model.addAttribute("userName", memberService.findById(member.getMember_id()).getMember_name());

        List<BookDTO> bookList = bookService.getBookList(bookSearch);

        model.addAttribute("bookList", bookList);

        return "/book/bookList2";
    }


}
