package ru.anvarzhonov.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Table(name = "groop")
@Entity
@NoArgsConstructor
@AllArgsConstructor
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