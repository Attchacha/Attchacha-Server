package com.azaza.attchach_back.domain.alart.entity;

import com.azaza.attchach_back.domain.member.entity.AlarmList;
import com.azaza.attchach_back.domain.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "alert_info")
public class AlarmNocheck {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "a_id", nullable = false)
    private AlarmList a_id;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "u_id", nullable = false)
    private Member u_id;
}