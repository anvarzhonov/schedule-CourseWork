package ru.anvarzhonov.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "schedule")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Schedule {
    @Id
    @Column(name = "id_schedule", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


//    @Column(name = "id_lesson")
//    private Long lessonId;
//    @Column(name = "id_type")
//    private Long typeId;
//    @Column(name = "id_group")
//    private Long groupId;
//    @Column(name = "id_aud")
//    private Long audId;
    @Column(name = "id_weekday")
    private Long weekdayId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_lesson",
            nullable = false)
    private Lesson lesson;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_type", nullable = true)
    @ToString.Exclude
    private TypeLesson typeLesson;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_group", nullable = false)
    @ToString.Exclude
    private Group group;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_aud", nullable = true)
    @ToString.Exclude
    private Auditorium auditorium;





}



