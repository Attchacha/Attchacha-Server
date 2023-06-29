package com.azaza.attchach_back.domain.alarm.controller;

import com.azaza.attchach_back.domain.alarm.service.AlarmService;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
    
    @RequestMapping(value="/getAlramList", method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String, String>> getAlramList(HttpServletRequest request) throws Exception {
    	HashMap params = this.getParamToHashMap(request);
    	
    	List<Map<String, String>> alarmList = new ArrayList<Map<String, String>>();

    	try {
    		alarmList = alarmService.getAlramList(params);
    	}catch(Exception e) {
			e.printStackTrace();
		}
    	return alarmList;
    }
    
    public HashMap getParamToHashMap(HttpServletRequest request) {
		HashMap<String, String> returnMap = new HashMap();
		Map<String, String[]> params = request.getParameterMap();
		
	    for (String key : params.keySet()) {
			String[] value = params.get(key);
			returnMap.put(key, value[0]);
        }
	    return returnMap;
	}

}
