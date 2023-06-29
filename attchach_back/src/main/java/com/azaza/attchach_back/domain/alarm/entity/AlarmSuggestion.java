package com.azaza.attchach_back.domain.alarm.entity;

import com.azaza.attchach_back.domain.member.entity.Member;
import com.azaza.attchach_back.domain.alarm.entity.AlarmList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "alarm_suggestion")
public class AlarmSuggestion {

    @Id
    @Column(name = "visit_id", nullable = false)
    private String visit_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "u_id")
    private Member member;

    @Column(name = "sug_addr", nullable = false)
    private String sug_addr;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "a_id")
    private AlarmList alarmList;
}