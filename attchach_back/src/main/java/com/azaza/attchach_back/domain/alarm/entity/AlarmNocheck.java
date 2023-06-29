package com.azaza.attchach_back.domain.alarm.entity;

import com.azaza.attchach_back.domain.member.entity.Member;
import com.azaza.attchach_back.domain.alarm.entity.AlarmList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "alarm_nocheck")
public class AlarmNocheck implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "a_id")
    private AlarmList alarmList;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "u_id")
    private Member u_id;
}