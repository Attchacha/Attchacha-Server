package com.azaza.attchach_back.domain.alart.entity;

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
@Table(name = "alarm_suggestion")
public class AlarmSuggestion {

    @Id
    @Column(name = "visit_id", nullable = false)
    private String visit_id;
    @Column(name = "u_id", nullable = false)
    private String u_id;
    @Column(name = "sug_addr", nullable = false)
    private String sug_addr;
    @Column(name = "a_id", nullable = false)
    private String a_id;
}