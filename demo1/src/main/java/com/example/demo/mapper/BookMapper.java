package com.example.demo.mapper;

import com.example.demo.dto.BookDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    public List<BookDTO> selectBookAll();

}
