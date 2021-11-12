package ru.anvarzhonov.models;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Table(name = "groop")
@Entity

@Data
public class Group {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_group")
    private String nameGroup;

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Schedule> schedules;
}