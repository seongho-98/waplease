package com.example.demo;

import com.example.demo.dto.MemberDTO;
import com.example.demo.mapper.MemberMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MapperTest {
    @Autowired
    private MemberMapper memberMapper;
    //Test는 간편하게 접근이 잘 되는지 확인할 수 있는 도구임.
    //별도의 컨트롤러나 서비스 없이도 mysql과 잘 통신이 되는걸 확인가능.
    @Test
    public void testInsert(){
        MemberDTO m1 = new MemberDTO();

        m1.setMember_id("id_test");
        m1.setMember_name("test");
        m1.setMember_addr("addr_test");
        System.out.println(m1.getMember_addr());
        memberMapper.insertMember(m1);
    }
}
