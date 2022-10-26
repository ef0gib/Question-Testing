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
@NamedEntityGraphs(
        value = {@NamedEntityGraph(
                name="all-fields",
                attributeNodes = {
                        @NamedAttributeNode(value = "id"),
                        @NamedAttributeNode(value = "name"),
                        @NamedAttributeNode(value = "questions", subgraph = "question-fields")
                },
                subgraphs = @NamedSubgraph(name = "question-fields",
                attributeNodes = {
                        @NamedAttributeNode(value = "id"),
                        @NamedAttributeNode(value = "name"),
                        @NamedAttributeNode(value = "level"),
                        @NamedAttributeNode(value = "numOfCorr")
                })
        )}
)
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
