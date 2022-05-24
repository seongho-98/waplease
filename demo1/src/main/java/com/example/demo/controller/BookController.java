package com.example.demo.controller;

import com.example.demo.dto.BookDTO;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/book/showBookList")
    public String bookList(Model model){

        System.out.println("================>> 컨트롤러 호출");
        List<BookDTO> bookList = bookService.getBookList();

        System.out.println(bookList.get(0).toString());
        System.out.println(bookList.get(6).toString());

        model.addAttribute("bookList", bookList);

        return "/book/bookList";
    }
     /*model.addAttribute("msg", "bookList 모델 테스트입니다.");
        model.addAttribute("url", "/");

        return "/alert/MessageAlert";*/
}
