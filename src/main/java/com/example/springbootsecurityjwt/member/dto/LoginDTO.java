package com.example.springbootsecurityjwt.member.dto;

import lombok.Data;

@Data
public class LoginDTO {
    private String mbrId;
    private String mbrPwd;
}
