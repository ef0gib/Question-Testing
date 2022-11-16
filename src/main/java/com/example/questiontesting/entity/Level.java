package com.example.questiontesting.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Levels")
@Getter
@Setter
@ToString
@EqualsAndHashCode

@NamedEntityGraphs(
        value = {@NamedEntityGraph(
                name="level-fields",
                attributeNodes = {
                        @NamedAttributeNode(value = "id"),
                        @NamedAttributeNode(value = "name"),
                        @NamedAttributeNode(value = "questions", subgraph = "level-questions-fields")
                },
                subgraphs = {@NamedSubgraph(name = "level-questions-fields",
                        attributeNodes = {
                                @NamedAttributeNode(value = "id"),
                                @NamedAttributeNode(value = "name"),
                                @NamedAttributeNode(value = "level"),
                                @NamedAttributeNode(value = "numOfCorr")
                        })
                }
        )}
)


public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lvl_id")
    private Long id;
    @Column(name = "lvl_name")
    private String name;

    @OneToMany(mappedBy = "level")
    private List<Question> questions;
}
