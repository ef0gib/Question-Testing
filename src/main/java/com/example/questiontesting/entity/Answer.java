package com.example.questiontesting.entity;

import com.example.questiontesting.dto.AnswerDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Answers")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor

@NamedEntityGraphs(
        value = {@NamedEntityGraph(
                name="answer-fields",
                attributeNodes = {
                        @NamedAttributeNode(value = "id"),
                        @NamedAttributeNode(value = "name"),
                        @NamedAttributeNode(value = "question", subgraph = "answer-question-fields")
                },
                subgraphs = {@NamedSubgraph(name = "answer-question-fields",
                        attributeNodes = {
                                @NamedAttributeNode(value = "id"),
                                @NamedAttributeNode(value = "name"),
                                @NamedAttributeNode(value = "profile"),
                                @NamedAttributeNode(value = "level")
                        })

                }
        )}
)

public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ans_id")
    private Long id;
    @Column(name = "ans_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "ans_que_id", updatable = false, insertable = false)
    @ToString.Exclude
    private Question question;

/*
    public Answer(AnswerDto answerDto) { // пример способа конвертации Entity <-> Dto
        this.id = answerDto.getId();
        this.name = answerDto.getName();
//        this.question = answerDto.getQuestion(); ???
    }
*/
}
