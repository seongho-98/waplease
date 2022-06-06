package com.example.demo.session;

import com.example.demo.dto.MemberDTO;
import org.springframework.stereotype.Component;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SessionManager {
    public static final String SESSION_COOKIE_NAME = "mySessionId";
    private Map<String, MemberDTO> sessionStore = new ConcurrentHashMap<>();

    public void createSession(MemberDTO value, HttpServletResponse res){

        String sessionId = UUID.randomUUID().toString();
        sessionStore.put(sessionId, value);

        Cookie mySessionCookie = new Cookie(SESSION_COOKIE_NAME, sessionId);
        res.addCookie(mySessionCookie);
    }

    public MemberDTO getSession(HttpServletRequest req){
        Cookie sessionCookie = findCookie(req, SESSION_COOKIE_NAME);
        if(sessionCookie == null){
            System.out.println("SessionManager:getSession() :: 쿠키값이 널입니다");
            return null;
        }
        return sessionStore.get(sessionCookie.getValue());
    }

    public void expire(HttpServletRequest req){
        Cookie sessionCookie = findCookie(req, SESSION_COOKIE_NAME);
        if(sessionCookie != null){
            sessionStore.remove(sessionCookie.getValue());
            System.out.println("SessionManager.expire() :: 해당 세션을 제거하였습니다.");
        }else{
        System.out.println("SessionManager:expire() :: 유효하지 않은 세션쿠키입니다");}
    }

    public Cookie findCookie(HttpServletRequest req, String cookieName){
        if(req.getCookies() == null){
            System.out.println("SessionManager:findCookie() :: request 쿠키가 없습니다.");
            return null;
        }

        return Arrays.stream(req.getCookies())
                .filter(cookie -> cookie.getName().equals(cookieName)).findAny().orElse(null);
    }
}
