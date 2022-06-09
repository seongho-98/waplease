package com.example.demo.mapper;

import com.example.demo.dto.BookDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    public List<BookDTO> selectBookAll();

    public List<BookDTO> searchBook(String bookSearch);

    public BookDTO findBookById(String id);

    public void setInUseFalse(String id);

    public void setInUseTrue(String id);
}
