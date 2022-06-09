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
    public List<BookDTO> getBookList(String bookSearch){
        if(bookSearch == ""){

            return (bookMapper.selectBookAll());
        }else{
            return (bookMapper.searchBook(bookSearch));
        }
    }

    @Override
    public void inUseChange(String id, int inUse){
        BookDTO book = bookMapper.findBookById(id);
        if(book == null){
            System.out.println("BookServiceImpl.findById() :: 책을 찾지 못했습니다");
        }else{
            if(inUse == 1){
                bookMapper.setInUseFalse(id);
            }else{
                bookMapper.setInUseTrue(id);
            }
        }
    }

/*
    private List<BookDTO> base64(List<BookDTO> selectBookAll){
        byte arr[] = blobToBytes()
    }
*/
}
