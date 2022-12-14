package com.example.questiontesting.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Questions")
@Getter
@Setter
@ToString
@EqualsAndHashCode

@NamedEntityGraphs(
        value = {@NamedEntityGraph(
                name="question-fields",
                attributeNodes = {
                        @NamedAttributeNode(value = "id"),
                        @NamedAttributeNode(value = "name"),
                        @NamedAttributeNode(value = "numOfCorr"),
//                        @NamedAttributeNode(value = "answers", subgraph = "question-answers-fields"),
                        @NamedAttributeNode(value = "profile", subgraph = "question-profile-fields"),
                        @NamedAttributeNode(value = "level", subgraph = "question-level-fields")
                },
                subgraphs = {
//                        @NamedSubgraph(
//                                name = "question-answers-fields",
//                                attributeNodes = {
//                                        @NamedAttributeNode(value = "id"),
//                                        @NamedAttributeNode(value = "name"),
//                                        @NamedAttributeNode(value = "question")
//                                }),
                        @NamedSubgraph(name = "question-profile-fields",
                                attributeNodes = {
                                        @NamedAttributeNode(value = "id"),
                                        @NamedAttributeNode(value = "name"),
//                                        @NamedAttributeNode(value = "questions")
                                }),
                        @NamedSubgraph(name = "question-level-fields",
                                attributeNodes = {
                                        @NamedAttributeNode(value = "id"),
                                        @NamedAttributeNode(value = "name"),
//                                        @NamedAttributeNode(value = "questions")
                                })

                }
        )}
)

public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "que_id")
    private Long id;
    @Column(name = "que_name")
    private String name;
    private Long numOfCorr;

/*
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @ToString.Exclude
    private List<Answer> answers;
*/

    @ManyToOne
    @JoinColumn(name = "que_prof_id")
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "que_lvl_id")
    private Level level;
}
