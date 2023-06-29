package com.azaza.attchach_back.domain.member.repository;

import com.azaza.attchach_back.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {

    @Override
    Optional<Member> findById(String id);
    
    @Query(value = "INSERT INTO member_info (u_id, u_nm, remind_time, alarm_yn, alarm_radius) VALUES (:userId, :userName, :remindTime, :alarmCheck, :alarmRadius)", nativeQuery = true)
    public void join(
    		@Param("userId") String userId, 
    		@Param("userName") String userName, 
    		@Param("remindTime") String remindTime, 
    		@Param("alarmCheck") String alarmCheck, 
    		@Param("alarmRadius") String alarmRadius);
    
    @Query(value = "SELECT u_id FROM member_info WHERE u_id = :userId", nativeQuery = true)
    public HashMap checkUserInfo(@Param("userId") String userId);
}
