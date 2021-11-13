package ru.anvarzhonov.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@Table(name = "lessons")
@AllArgsConstructor
@NoArgsConstructor
    @Builder
public class Lesson {
    @Id
    @Column(name = "id_lesson", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "begin_lesson")
    private String beginLesson;

    @Column(name = "end_lesson")
    private String endLesson;

    @OneToMany(mappedBy = "lesson", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Schedule> schedules;

}
