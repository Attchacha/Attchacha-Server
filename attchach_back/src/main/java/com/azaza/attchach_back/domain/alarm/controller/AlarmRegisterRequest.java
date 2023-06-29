package com.azaza.attchach_back.domain.alarm.controller;

import lombok.Getter;

import java.util.Date;

@Getter
public class AlarmRegisterRequest {

    private String u_id;

    private String name;

    private String time_taken;

    private Date end_dt;

    private Double lon;

    private Double lat;

    private String addr;

}
