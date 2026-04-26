package com.acsanfrancisco.student_management_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateEnrollmentDto {

    private Long id;
    private String enrollmentCod;
    private String courseName;
    private LocalDate startDate;
}
