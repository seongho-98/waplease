package com.example.demo.service;

import com.example.demo.dto.MemberDTO;
import com.example.demo.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void insertMember(MemberDTO memberDTO){

        String encodedPw = passwordEncoder.encode(memberDTO.getMember_pw());
        memberDTO.setMember_pw(encodedPw);
        memberMapper.insertMember(memberDTO);
    }

    @Override
    public boolean loginCheck(MemberDTO memberDTO){

        MemberDTO storedMember = memberMapper.findMember(memberDTO.getMember_id());

        if(storedMember == null){
            System.out.println("MemberServiceImpl.loginCheck() : 회원 발견 못했습니다.");
            return false;
        }

        boolean check = passwordEncoder.matches(memberDTO.getMember_pw(), storedMember.getMember_pw());

        if(check == true){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public MemberDTO findById(String member_id){
        MemberDTO member = memberMapper.findMember(member_id);

        return member;
    }
}
