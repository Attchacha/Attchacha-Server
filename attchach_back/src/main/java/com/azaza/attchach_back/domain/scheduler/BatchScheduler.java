package com.azaza.attchach_back.domain.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.azaza.attchach_back.domain.member.service.MemberService;

@Component
public class BatchScheduler {
	
	private final ScheduleService scheduleService;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
    //10초마다 실행
    @Scheduled(cron = "0 * * * * *")
    public void updateSchedule() {
    	
    	try {
    		scheduleService.updateAlramList();//시간 지난 알람 변경 fullSelect
    		//scheduleService.selectRemindAlran();//리마인드알람Select
    	}catch(Exception e) {
			e.printStackTrace();
		}
        
    }
}
