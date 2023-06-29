package com.azaza.attchach_back.domain.member.service;

import com.azaza.attchach_back.domain.member.controller.LoginResponse;
import com.azaza.attchach_back.domain.member.entity.Member;
import com.azaza.attchach_back.domain.member.repository.MemberRepository;
import com.azaza.attchach_back.global.exception.IdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public LoginResponse login(String uId) {
        Member findMember = memberRepository.findById(uId)
                .orElseThrow(() -> new IdNotFoundException("회원정보가 없습니다."));
        System.out.println("findMember = " + findMember.getUId()+":"+findMember.getUNM());
        return LoginResponse.builder()
                .u_id(findMember.getUId())
                .u_nm(findMember.getUNM())
                .build();
    }
}
