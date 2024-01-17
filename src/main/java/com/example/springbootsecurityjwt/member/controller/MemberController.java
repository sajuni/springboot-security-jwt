package com.example.springbootsecurityjwt.member.controller;

import com.example.springbootsecurityjwt.jwt.TokenInfo;
import com.example.springbootsecurityjwt.member.dto.LoginDTO;
import com.example.springbootsecurityjwt.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/login")
    public TokenInfo login(LoginDTO loginDTO) {
        log.info("loginDTO: {}", loginDTO);
        return memberService.login(loginDTO.getMbrId(), loginDTO.getMbrPwd());
    }

}
