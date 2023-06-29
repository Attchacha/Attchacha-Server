package com.azaza.attchach_back.domain.member.controller;

import com.azaza.attchach_back.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import java.util.HashMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    
    @RequestMapping(value="/join", method = RequestMethod.POST)
    @ResponseBody
    public String join(HttpServletRequest request, ModelMap model) throws Exception {
    	HashMap params = this.getParamToHashMap(request);
    	String msg = "비정상가입";
    	try {
    		int msgFlag = memberService.checkUserInfo(params);
    		if(msgFlag==0) {
    			memberService.join(params);
    			msg = "정상가입";
    		}
    	}catch(Exception e) {
			e.printStackTrace();
		}
    	
    	return msg;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginMember = memberService.login(loginRequest.getId());
        return ResponseEntity.ok(loginMember);
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
