package com.example.demo.service;

import com.example.demo.dto.MemberDTO;
import com.example.demo.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public void insertMember(MemberDTO memberDTO){
        memberMapper.insertMember(memberDTO);
    }

    @Override
    public boolean loginCheck(MemberDTO memberDTO){
        System.out.println("=============서비스 호출됨==========");
        MemberDTO check = memberMapper.loginCheck(memberDTO);
        System.out.println("==========mapper 작업 완료=========");
        System.out.println("check값=========> "+check);

        if(check != null){
            System.out.println("===========정상처리=========");
            return true;
        }else{
            System.out.println("=========실패========");
            return false;
        }
    }
}
