package com.example.springbootsecurityjwt.member.repository;

import com.example.springbootsecurityjwt.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByMbrId(String id);
}
