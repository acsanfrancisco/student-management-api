package com.acsanfrancisco.student_management_api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "students")
public class Student implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id")
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "telephone", nullable = false)
    private String telephone;
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;
    @Column(name = "insertion_date", nullable = false)
    private LocalDateTime insertionDate;
    @Column(name = "update_date")
    private LocalDateTime updateDate;
}
