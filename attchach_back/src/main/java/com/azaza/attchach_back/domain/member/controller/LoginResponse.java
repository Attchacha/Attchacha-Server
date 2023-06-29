package com.azaza.attchach_back.domain.member.controller;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginResponse {

    private String u_id;

    private String u_nm;

}
