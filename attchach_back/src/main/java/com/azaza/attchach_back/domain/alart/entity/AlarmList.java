package com.azaza.attchach_back.domain.member.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "alert_info")
public class AlarmList {

    @Id
    @Column(name = "a_id", nullable = false)
    private String a_id;
    @Column(name = "u_id", nullable = false)
    private String u_id;
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
    private String del_yn;

    @Column(name = "visit_cnt")
    @ColumnDefault("0")
    private Integer visit_cnt;

    @Column(name = "end_yn")
    @ColumnDefault("0")
    private Integer end_yn;
}