package com.azaza.attchach_back.domain.member.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "member_info")
public class Member {

    @Id
    @Column(name = "u_id", nullable = false)
    private String uId;

    @Column(name = "u_nm")
    private String uNM;

    @Column(name = "remind_time", nullable = false)
    private String remindTime;

    @Column(name = "alarm_yn")
    private String alarmYn;

    @Column(name = "alarm_radius", nullable = false)
    private String alarmRadius;

}
