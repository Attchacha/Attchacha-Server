package com.azaza.attchach_back.domain.member.service;

import com.azaza.attchach_back.domain.member.controller.LoginResponse;
import com.azaza.attchach_back.domain.member.entity.Member;
import com.azaza.attchach_back.domain.member.repository.MemberRepository;
import com.azaza.attchach_back.global.exception.IdNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    
	public void join(HashMap params) throws Exception {
		memberRepository.join(
				params.get("userId").toString(),
				params.get("userName").toString(),
				params.get("remindTime").toString(),
				params.get("alarmCheck").toString(),
				params.get("alarmRadius").toString()
				);
	}
	
	public String checkUserInfo(HashMap params) throws Exception {
		List<Map<String, Object>> msg = memberRepository.checkUserInfo(params.get("userId").toString());
		return null;
	}

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
