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

    @PostMapping("/alarm/{a_id}")
    public ResponseEntity<Integer> completeAlarm(@PathVariable Integer a_id) {
        alarmService.completeAlarm(a_id);
        return ResponseEntity.ok(a_id);
    }

    @GetMapping("/alarm/{a_id}")
    public ResponseEntity<AlarmModifyResponse> getAlarm(@PathVariable Integer a_id) {
        AlarmModifyResponse alarm = alarmService.findById(a_id);
        return ResponseEntity.ok(alarm);
    }

    @PutMapping("/alarm")
    public ResponseEntity<AlarmModifyResponse> modifyAlarm(@RequestBody AlarmModifyRequest alarmModifyRequest) {
        AlarmModifyResponse alarmModifyResponse = alarmService.put(alarmModifyRequest);
        return ResponseEntity.ok(alarmModifyResponse);
    }

    @DeleteMapping("/alarm")
    public ResponseEntity<AlarmModifyResponse> deleteAlarmYN(@RequestParam String a_id) {
        AlarmModifyResponse alarmModifyResponse = alarmService.deleteYn(a_id);
        return ResponseEntity.ok(alarmModifyResponse);
    }

}
