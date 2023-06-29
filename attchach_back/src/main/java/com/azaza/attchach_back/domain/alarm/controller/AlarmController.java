package com.azaza.attchach_back.domain.alarm.controller;

import com.azaza.attchach_back.domain.alarm.service.AlarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class AlarmController {

    private final AlarmService alarmService;

    @PostMapping("/alarm")
    public ResponseEntity<Integer> registerAlarm(@RequestBody AlarmRegisterRequest alarmRegisterRequest) {
        Integer savedId = alarmService.save(alarmRegisterRequest);
        return ResponseEntity.ok(savedId);
    }

//    @PutMapping("/alarm")
//    public ResponseEntity<AlarmModifyResponse> modifyAlarm(@RequestBody AlarmModifyRequest alarmModifyRequest) {
//        AlarmModifyResponse alarmModifyResponse = alarmService.put(alarmModifyRequest);
//        return ResponseEntity.ok(alarmModifyResponse);
//    }

    @DeleteMapping("/alarm")
    public ResponseEntity<AlarmModifyResponse> deleteAlarmYN(@RequestParam String a_id) {
        AlarmModifyResponse alarmModifyResponse = alarmService.deleteYn(a_id);
        return ResponseEntity.ok(alarmModifyResponse);
    }

}