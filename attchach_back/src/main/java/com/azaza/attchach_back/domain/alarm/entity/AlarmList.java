package com.azaza.attchach_back.domain.alarm.entity;

import com.azaza.attchach_back.domain.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@Table(name = "alarm_list")
public class AlarmList {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "a_id", nullable = false)
    private Integer a_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "u_id")
    private Member member;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "time_taken")
    private String time_taken;

    @Column(name = "end_dt")
    private Date end_dt;

    @Column(name = "lon")
    private Double lon;

    @Column(name = "lat")
    private Double lat;

    @Column(name = "addr")
    private String addr;

    @Column(name = "del_yn")
    @ColumnDefault("n")
    private String del_yn;

    @Column(name = "visit_cnt")
    @ColumnDefault("0")
    private Integer visit_cnt;

    @Column(name = "end_yn")
    @ColumnDefault("n")
    private Integer end_yn;
}