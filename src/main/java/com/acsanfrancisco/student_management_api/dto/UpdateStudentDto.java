package com.acsanfrancisco.student_management_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
}
