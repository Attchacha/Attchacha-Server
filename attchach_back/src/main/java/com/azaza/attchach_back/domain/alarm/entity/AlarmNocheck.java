package com.azaza.attchach_back.domain.alarm.entity;

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
@Table(name = "alarm_nocheck")
public class AlarmNocheck {

    @Id
    @Column(name = "a_id", nullable = false)
    private String a_id;
    @Column(name = "u_id", nullable = false)
    private String u_id;
}