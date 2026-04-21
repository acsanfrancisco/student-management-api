package com.acsanfrancisco.student_management_api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class StudentResponseDto {

    private Long id;
    private String name;
    private String telephone;
    private LocalDate birthDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime updateDate;
}
