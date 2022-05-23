package com.example.demo.service;

import com.example.demo.dto.MemberDTO;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {
    public void insertMember(MemberDTO memberDTO);
    public boolean loginCheck(MemberDTO memberDTO);
}
