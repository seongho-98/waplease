package com.example.demo.memberSecurity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class PasswordEncoderTest {


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void passwordEncoder(){
        String pw = "123qwe";

        String encodedPw = passwordEncoder.encode(pw);

        assertAll(
                () -> assertNotEquals(pw, encodedPw),
                () -> assertTrue(passwordEncoder.matches(pw, encodedPw))
        );
    }

}
