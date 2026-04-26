package com.acsanfrancisco.student_management_api.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateStudentDto {

    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Telephone is required")
    @Pattern(regexp = "^\\d{11}$", message = "Telephone number must have 11 digits")
    private String telephone;
    @NotNull(message = "Birth date is required")
    @Past(message = "Birth date must be in the past")
    private LocalDate birthDate;
    private List<CreateEnrollmentDto> enrollments;
}
