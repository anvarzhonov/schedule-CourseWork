package ru.anvarzhonov.models;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "type_lesson")
@Data
public class TypeLesson {
    @Id
    @Column(name = "id_type", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_type")
    private String nameType;

    @OneToMany(mappedBy = "typeLesson", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Schedule> schedules;

}
