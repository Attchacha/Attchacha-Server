package com.azaza.attchach_back.domain.alarm.repository;


import com.azaza.attchach_back.domain.alarm.entity.AlarmList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface AlarmRepository extends JpaRepository<AlarmList, Integer> {
	
	@Query(value = "SELECT * FROM alarm_list WHERE u_id = :userId", nativeQuery = true)
    public List<Map<String, String>> getAlramList(@Param("userId") String userId);
	
	
}
