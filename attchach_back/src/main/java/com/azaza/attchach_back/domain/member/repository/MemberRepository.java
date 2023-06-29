package com.azaza.attchach_back.domain.member.repository;

import com.azaza.attchach_back.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {

    @Override
    Optional<Member> findById(String id);
}
