package ru.anvarzhonov.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Table(name = "auditorium")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Auditorium {
    @Id
    @Column(name = "id_aud", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number_aud")
    private String numberAud;

    @OneToMany(mappedBy = "auditorium", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Schedule> schedules;
}