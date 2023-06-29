package com.azaza.attchach_back.domain.alarm.controller;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class AlarmModifyResponse {
    private Integer a_id;

    private String u_id;

    private String name;

    private String time_taken;

    private Date end_dt;

    private Double lon;

    private Double lat;

    private String addr;

    private String del_yn;

    private Integer visit_cnt;

    private Integer end_yn;
}
