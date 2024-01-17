package com.example.springbootsecurityjwt;

import com.example.springbootsecurityjwt.member.entity.Member;
import com.example.springbootsecurityjwt.member.repository.MemberRepository;
import com.example.springbootsecurityjwt.role.MemberRole;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 기본 h2 DB 사용 안함
public class MemberTest {

    @Autowired
    private MemberRepository memberRepository;


    @Test
    @DisplayName("멤버 세이브 테스트")
    @Rollback(value = false)
    public void memberSaveTest() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Member mem = Member.builder().mbrId("test").mbrPwd(encoder.encode("22")).build();
        mem.addMemberRole(MemberRole.ADMIN);
        memberRepository.save(mem);
        Optional<Member> byId = memberRepository.findById(1L);
        System.out.println("byId = " + byId);
    }
}
