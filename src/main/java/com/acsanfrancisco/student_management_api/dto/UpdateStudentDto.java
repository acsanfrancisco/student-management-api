package com.acsanfrancisco.student_management_api.dto;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateStudentDto {

    private String name;
    @Pattern(regexp = "^\\d{11}$", message = "Telephone must have 11 digits")
    private String telephone;
    @Past(message = "Birth date must be in the past")
    private LocalDate birthDate;
    private List<UpdateEnrollmentDto> enrollments = new ArrayList<>();
}
