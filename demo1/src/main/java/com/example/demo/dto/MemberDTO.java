package com.example.demo.dto;

public class MemberDTO {
    private String member_id;
    private String member_name;
    private String member_addr;

    public MemberDTO(String member_id, String member_name, String member_addr) {
        this.member_id = member_id;
        this.member_name = member_name;
        this.member_addr = member_addr;
    }
    public MemberDTO(){

    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getMember_addr() {
        return member_addr;
    }

    public void setMember_addr(String member_addr) {
        this.member_addr = member_addr;
    }
}
