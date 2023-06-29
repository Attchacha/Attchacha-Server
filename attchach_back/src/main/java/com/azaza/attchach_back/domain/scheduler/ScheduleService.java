package com.azaza.attchach_back.domain.scheduler;

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

    private final ScheduleRepository scheduleRepository;
    
	public void updateAlramList() throws Exception {
		ArrayList<HashMap<String, String>> alramList = scheduleRepository.selectAlramList();
		ArrayList<HashMap<String, String>> newAlarmList = new ArrayList<HashMap<String, String>>();
		
		Calendar now = Calendar.getInstance();
		for(int i=0; i<alramList.size(); i++) {
			LocalDate serverDate = LocalDate.of(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));
			LocalDate alramDate = LocalDate.of(Integer.parseInt(alramList.get(i).get("end_dt").substring(0, 3)), Integer.parseInt(alramList.get(i).get("end_dt").substring(5, 6)), Integer.parseInt(alramList.get(i).get("end_dt").substring(8, 9)));
			//alramList.get(i).get("end_dt");
			
			if(serverDate.isBefore(alramDate)==false) {//서버시간보다 알람시간이 더클때
				newAlarmList.add(i, alramList.get(i));
			}
		}
		//repo update req
	}
}
