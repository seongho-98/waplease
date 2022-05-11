package com.example.demo.controller;

import com.example.demo.mappers.UserProfileMapper;
import com.example.demo.models.UserProfile;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class UserProfileController {

    private UserProfileMapper mapper;
/*

    private Map<String, UserProfile> userMap;
*/

    public UserProfileController(UserProfileMapper mapper){
        this.mapper = mapper;
    }

/*  mysql을 쓰면 삭제해야함
    @PostConstruct
    public void init(){
        userMap = new HashMap<String, UserProfile>();
        userMap.put("1", new UserProfile("1", "홍길동", "울산"));
        userMap.put("2", new UserProfile("2", "홍길동2", "부산"));
        userMap.put("3", new UserProfile("3", "홍길동3", "서울"));
    }
*/

    @GetMapping("/user/{id}")
    public UserProfile getUserProfile(@PathVariable("id")String id){

        //return userMap.get(id);           //메모리
        return mapper.getUserProfile(id);   //mysql
    }

    @GetMapping("/user/all")
    public List<UserProfile> getUserProfileList(){

        //return new ArrayList<UserProfile>(userMap.values());
        return mapper.getUserProfileList();
    }

    @PutMapping("/user/{id}")
    public void putUserProfile(@PathVariable("id") String id, @RequestParam("name")String name, @RequestParam("addr") String addr){
        /*UserProfile userProfile = new UserProfile(id, name, addr);
        userMap.put(id, userProfile);
        */
        mapper.insertUserProfile(id, name, addr);
    }

    @PostMapping("/user/{id}")
    public void postUserProfile(@PathVariable("id") String id, @RequestParam("name")String name, @RequestParam("addr") String addr){
/*        UserProfile userProfile = userMap.get(id);
        userProfile.setName(name);
        userProfile.setAddr(addr);
        */
        mapper.updateUserProfile(id, name, addr);
    }

    @DeleteMapping("/user/{id}")
    public void deleteProfile(@PathVariable("id") String id){
       /* userMap.remove(id);*/
        mapper.deleteProfile(id);
    }
}
