package com.example.questiontesting.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Profiles")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prof_id")
    private Long id;
    @Column(name = "prof_name")
    private String name;

    @OneToMany(mappedBy = "profile")
    private List<Question> questions;
}
