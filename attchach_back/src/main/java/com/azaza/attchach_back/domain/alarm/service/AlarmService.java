package com.azaza.attchach_back.domain.alarm.service;

import com.azaza.attchach_back.domain.alarm.controller.AlarmModifyRequest;
import com.azaza.attchach_back.domain.alarm.controller.AlarmModifyResponse;
import com.azaza.attchach_back.domain.alarm.controller.AlarmRegisterRequest;
import com.azaza.attchach_back.domain.alarm.entity.AlarmList;
import com.azaza.attchach_back.domain.alarm.repository.AlarmRepository;
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
public class AlarmService {

    private final AlarmRepository alarmRepository;
    private final MemberRepository memberRepository;

    public Integer save(AlarmRegisterRequest alarmRegisterRequest) {
        Member member = memberRepository.findById(alarmRegisterRequest.getU_id())
                .orElseThrow(() -> new IdNotFoundException("회원 정보가 없습니다."));
        AlarmList alarmList = AlarmList.builder()
                .member(member)
                .name(alarmRegisterRequest.getName())
                .end_dt(alarmRegisterRequest.getEnd_dt())
                .time_taken(alarmRegisterRequest.getTime_taken())
                .addr(alarmRegisterRequest.getAddr())
                .lat(alarmRegisterRequest.getLat())
                .lon(alarmRegisterRequest.getLon())
                .build();

        AlarmList savedAlarm = alarmRepository.save(alarmList);
        return savedAlarm.getA_id();
    }

    public AlarmModifyResponse put(AlarmModifyRequest alarmModifyRequest) {
        Member member = memberRepository.findById(alarmModifyRequest.getU_id())
                .orElseThrow(() -> new IdNotFoundException("회원 정보가 없습니다."));
        AlarmList alarmList = AlarmList.builder()
                .a_id(alarmModifyRequest.getA_id())
                .member(member)
                .name(alarmModifyRequest.getName())
                .end_dt(alarmModifyRequest.getEnd_dt())
                .time_taken(alarmModifyRequest.getTime_taken())
                .addr(alarmModifyRequest.getAddr())
                .lat(alarmModifyRequest.getLat())
                .lon(alarmModifyRequest.getLon())
                .del_yn(alarmModifyRequest.getDel_yn())
                .end_yn(alarmModifyRequest.getEnd_yn())
                .visit_cnt(alarmModifyRequest.getVisit_cnt())
                .build();
        AlarmList modifiedAlarm = alarmRepository.save(alarmList);
        return toAlarmResponse(modifiedAlarm);
    }

    public AlarmModifyResponse deleteYn(String a_id) {
        AlarmList alarm = alarmRepository.findById(Integer.parseInt(a_id))
                .orElseThrow(() -> new IdNotFoundException("알림 정보가 없습니다."));
        AlarmList alarmList = AlarmList.builder()
                .a_id(alarm.getA_id())
                .member(alarm.getMember())
                .name(alarm.getName())
                .end_dt(alarm.getEnd_dt())
                .time_taken(alarm.getTime_taken())
                .addr(alarm.getAddr())
                .lat(alarm.getLat())
                .lon(alarm.getLon())
                .del_yn("y")
                .end_yn(alarm.getEnd_yn())
                .visit_cnt(alarm.getVisit_cnt())
                .build();
        AlarmList savedAlarm = alarmRepository.save(alarmList);
        return toAlarmResponse(savedAlarm);
    }

    private AlarmModifyResponse toAlarmResponse(AlarmList alarm) {
        AlarmModifyResponse alarmModifyResponse = AlarmModifyResponse.builder()
                .a_id(alarm.getA_id())
                .u_id(alarm.getMember().getUId())
                .name(alarm.getName())
                .end_dt(alarm.getEnd_dt())
                .time_taken(alarm.getTime_taken())
                .addr(alarm.getAddr())
                .lat(alarm.getLat())
                .lon(alarm.getLon())
                .del_yn(alarm.getDel_yn())
                .end_yn(alarm.getEnd_yn())
                .visit_cnt(alarm.getVisit_cnt())
                .build();
        return alarmModifyResponse;
    }
    
    public List<Map<String, String>> getAlramList(HashMap params) throws Exception {
    	List<Map<String, String>> alarmList = alarmRepository.getAlramList(params.get("userId").toString());
		return alarmList;
	}
}
