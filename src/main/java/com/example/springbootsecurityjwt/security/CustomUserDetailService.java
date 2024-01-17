package com.example.springbootsecurityjwt.security;

import com.example.springbootsecurityjwt.member.entity.Member;
import com.example.springbootsecurityjwt.member.repository.MemberRepository;
import jakarta.servlet.ServletException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> byMbrId = memberRepository.findByMbrId(username);
        if (byMbrId.isPresent()) {
            Member member = byMbrId.get();
            return new CustomUserDetails(member);
        } else {
            throw new UsernameNotFoundException("User Not Found: " + username);
        }
    }

}
