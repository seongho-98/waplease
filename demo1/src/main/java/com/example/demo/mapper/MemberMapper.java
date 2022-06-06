package com.example.demo.mapper;

import com.example.demo.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    public void insertMember(MemberDTO memberDTO);
    public MemberDTO loginCheck(MemberDTO memberDTO);
    public MemberDTO findMember(String member_id);
}
