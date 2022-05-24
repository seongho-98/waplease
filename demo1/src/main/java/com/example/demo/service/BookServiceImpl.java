package com.example.demo.service;

import com.example.demo.dto.BookDTO;
import com.example.demo.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<BookDTO> getBookList(){

        System.out.println("===========>> book 서비스 호출됨");
        return bookMapper.selectBookAll();

    }
}
