package com.acsanfrancisco.student_management_api.mapper;

import com.acsanfrancisco.student_management_api.dto.CreateEnrollmentDto;
import com.acsanfrancisco.student_management_api.dto.EnrollmentResponseDto;
import com.acsanfrancisco.student_management_api.dto.UpdateEnrollmentDto;
import com.acsanfrancisco.student_management_api.entity.Enrollment;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentMapper {

    public static Enrollment toEntity(CreateEnrollmentDto dto){
        Enrollment enrollment = new Enrollment();
        enrollment.setEnrollmentCod(dto.getEnrollmentCod());
        enrollment.setCourseName(dto.getCourseName());
        enrollment.setStartDate(dto.getStartDate());
        enrollment.setInclusionDate((LocalDateTime.now()));
        return enrollment;
    }

    public static EnrollmentResponseDto toResponse(Enrollment enrollment){
        EnrollmentResponseDto dto = new EnrollmentResponseDto();
        dto.setId(enrollment.getId());
        dto.setEnrollmentCod(enrollment.getEnrollmentCod());
        dto.setCourseName(enrollment.getCourseName());
        dto.setInsertionDate(enrollment.getInclusionDate());
        dto.setUpdateDate(enrollment.getUpdateDate());
        dto.setStartDate(enrollment.getStartDate());
        return dto;
    }

    public static List<EnrollmentResponseDto> listToDto(List<Enrollment> enrollmentList){
        List<EnrollmentResponseDto> responseDtoList = new ArrayList<>();
        for(Enrollment enrollment : enrollmentList){
            responseDtoList.add(toResponse(enrollment));
        }
        return responseDtoList;
    }

    public static Enrollment toEntityFromUpdate(UpdateEnrollmentDto dto){
        Enrollment enrollment = new Enrollment();
        enrollment.setEnrollmentCod(dto.getEnrollmentCod());
        enrollment.setCourseName(dto.getCourseName());
        enrollment.setStartDate(dto.getStartDate());
        enrollment.setInclusionDate(LocalDateTime.now());
        return enrollment;
    }
}
