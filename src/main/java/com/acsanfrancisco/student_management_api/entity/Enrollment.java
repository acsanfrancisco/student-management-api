package com.acsanfrancisco.student_management_api.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "enrollments")
public class Enrollment implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id")
    private Long id;
    @Column(name = "enrollment_code")
    private String enrollmentCod;
    @Column(name = "course_name", nullable = false)
    private String courseName;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "inclusion_date")
    private LocalDateTime inclusionDate;
    @Column(name = "update_date")
    private LocalDateTime updateDate;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
