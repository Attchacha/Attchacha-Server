package com.azaza.attchach_back.domain.scheduler;

import com.azaza.attchach_back.domain.alarm.entity.AlarmList;
import com.azaza.attchach_back.domain.alarm.repository.AlarmRepository;
import com.azaza.attchach_back.domain.member.controller.LoginResponse;
import com.azaza.attchach_back.domain.member.entity.Member;
import com.azaza.attchach_back.domain.member.repository.MemberRepository;
import com.azaza.attchach_back.global.exception.IdNotFoundException;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final AlarmRepository alarmRepository;
    
	public void updateAlramList() throws Exception {
		List<AlarmList> alramList = alarmRepository.findAll();
		List<AlarmList> newAlarmList = new ArrayList();
		
		Calendar now = Calendar.getInstance();
		for(int i=0; i<alramList.size(); i++) {
			LocalDate serverDate = LocalDate.of(now.get(Calendar.YEAR), now.get(Calendar.MONTH)+1, now.get(Calendar.DAY_OF_MONTH));
			LocalDate alramDate = LocalDate.of(Integer.parseInt(alramList.get(i).getEnd_dt().toString().substring(0, 4)),
					Integer.parseInt(alramList.get(i).getEnd_dt().toString().substring(5, 7)),
					Integer.parseInt(alramList.get(i).getEnd_dt().toString().substring(8, 10)));
			System.out.println(serverDate.toString()+" vs " +alramDate.toString());
			if(serverDate.isBefore(alramDate)==false) {//서버시간보다 알람시간이 더클때
				newAlarmList.add(alramList.get(i));
			}
		}
		System.out.println("마감일이 지난 알림 수 : " + newAlarmList.size());
		//repo update req
		for(int i=0; i< newAlarmList.size(); i++) {
			AlarmList alarm = newAlarmList.get(i);
			alarm.setEndYPass();
			alarmRepository.save(alarm);
		}
	}
}
