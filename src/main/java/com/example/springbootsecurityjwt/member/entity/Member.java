package com.example.springbootsecurityjwt.member.entity;

import com.example.springbootsecurityjwt.role.MemberRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long mbrSeq;
    private String mbrId;
    private String mbrPwd;

    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private Set<MemberRole> roleSet = new HashSet<>(List.of(MemberRole.USER));

    public void addMemberRole(MemberRole role) {
        if (roleSet == null) {
            roleSet = new HashSet<>();
        }
        roleSet.add(role);
    }

}
