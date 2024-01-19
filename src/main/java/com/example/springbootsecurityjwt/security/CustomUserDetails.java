package com.example.springbootsecurityjwt.security;

import com.example.springbootsecurityjwt.member.entity.Member;
import com.example.springbootsecurityjwt.role.MemberRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class CustomUserDetails implements UserDetails {
    private long mbrSeq;
    private String mbrId;
    private String mbrPwd;
    private Set<MemberRole> memberRoleSet;


    public CustomUserDetails(Member member) {
        this.mbrSeq = member.getMbrSeq();
        this.mbrId = member.getMbrId();
        this.mbrPwd = member.getMbrPwd();
        this.memberRoleSet = member.getRoleSet();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        List<MemberRole> list = new ArrayList<>(memberRoleSet);
        list.forEach(v -> collection.add(new SimpleGrantedAuthority("ROLE_" + v)));
        return collection;
    }

    @Override
    public String getPassword() {
        return mbrPwd;
    }

    @Override
    public String getUsername() {
        return mbrId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
