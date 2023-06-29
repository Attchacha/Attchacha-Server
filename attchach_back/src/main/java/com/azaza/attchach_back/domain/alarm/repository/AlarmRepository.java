package com.azaza.attchach_back.domain.alarm.repository;


import com.azaza.attchach_back.domain.alarm.entity.AlarmList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlarmRepository extends JpaRepository<AlarmList, Integer> {

    @Override
    List<AlarmList> findAll();
}
