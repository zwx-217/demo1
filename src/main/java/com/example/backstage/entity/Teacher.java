package com.example.backstage.entity;

import ch.qos.logback.classic.turbo.TurboFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @MapsId
    @OneToOne
    private User user;

    private Integer upper_limit ; //学生上限
    private Float mark_limit;//分数下限

    @Column(columnDefinition = "timestamp default current_timestamp", insertable = false, updatable = false)
    private LocalDate insertTime;
    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "teacher",fetch = FetchType.LAZY)
    private List<Student> studentList;
    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "teacher",fetch = FetchType.LAZY)
    private List<Course> courseList;
    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "teacher",fetch = FetchType.LAZY)
    private List<Direction> directionList;
}