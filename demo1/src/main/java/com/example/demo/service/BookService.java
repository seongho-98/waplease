package com.example.demo.service;

import com.example.demo.dto.BookDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    public List<BookDTO> getBookList(String bookSearch);
}
