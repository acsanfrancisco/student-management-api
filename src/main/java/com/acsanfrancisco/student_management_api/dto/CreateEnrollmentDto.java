package com.acsanfrancisco.student_management_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateEnrollmentDto {

    @NotBlank(message = "Course name is required")
    private String courseName;
    @NotBlank(message = "Enrollment code is required")
    private String enrollmentCod;
    @NotNull(message = "Start Date is required")
    private LocalDate startDate;
}
