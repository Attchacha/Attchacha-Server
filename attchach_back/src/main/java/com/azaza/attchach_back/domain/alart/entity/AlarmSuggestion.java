package com.azaza.attchach_back.domain.alart.entity;

import com.azaza.attchach_back.domain.member.entity.AlarmList;
import com.azaza.attchach_back.domain.member.entity.Member;
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
    @Column(name = "u_id", nullable = false)
    private Member u_id;
    @Column(name = "sug_addr", nullable = false)
    private String sug_addr;
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "a_id", nullable = false)
    private AlarmList a_id;
}