package com.acsanfrancisco.student_management_api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FindEnrollmentsByStudentId {

    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<EnrollmentResponseDto> enrollments = new ArrayList<>();
}

