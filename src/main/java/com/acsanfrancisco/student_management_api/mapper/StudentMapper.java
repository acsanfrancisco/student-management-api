package com.acsanfrancisco.student_management_api.mapper;

import com.acsanfrancisco.student_management_api.dto.*;
import com.acsanfrancisco.student_management_api.entity.Enrollment;
import com.acsanfrancisco.student_management_api.entity.Student;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StudentMapper {

    public static Student toEntity(CreateStudentDto createStudentDto){
        Student student = new Student();
        student.setName(createStudentDto.getName());
        student.setBirthDate(createStudentDto.getBirthDate());
        student.setTelephone(createStudentDto.getTelephone());
        student.setInsertionDate(LocalDateTime.now());
        return student;
    }

    public static StudentResponseDto toResponse(Student student){
        StudentResponseDto dto = new StudentResponseDto();
        List<EnrollmentResponseDto> enrollmentResponseDto = new ArrayList<>();
        for(Enrollment enrollment : student.getEnrollments()){
            enrollmentResponseDto.add(EnrollmentMapper.toResponse(enrollment));
        }
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setBirthDate(student.getBirthDate());
        dto.setTelephone(student.getTelephone());
        dto.setUpdateDate(student.getUpdateDate());
        dto.setEnrollments(enrollmentResponseDto);
        return dto;
    }

    public static List<StudentResponseDto> listToDto(List<Student> studentList){
        List<StudentResponseDto> responseDtoList = new ArrayList<>();
        for(Student student : studentList){
            responseDtoList.add(toResponse(student));
        }
        return responseDtoList;
    }

    public static List<ToListAllStudentsDto> listAllStudents(List<Student> students){
        List<ToListAllStudentsDto> toListAllStudentsDto = new ArrayList<>();
        for(Student student : students){
            ToListAllStudentsDto dto = new ToListAllStudentsDto();
            dto.setId(student.getId());
            dto.setName(student.getName());
            dto.setTelephone(student.getTelephone());
            dto.setBirthDate(student.getBirthDate());
            dto.setUpdateDate(student.getUpdateDate());
            toListAllStudentsDto.add(dto);
        }
        return toListAllStudentsDto;
    }

    public static FindEnrollmentsByStudentId listAllEnrollmentsByStudent(Student student){
        List<Enrollment> enrollments = student.getEnrollments();
        FindEnrollmentsByStudentId enrollmentsByStudentId = new FindEnrollmentsByStudentId();
        enrollmentsByStudentId.setName(student.getName());
        List<EnrollmentResponseDto> enrollmentResponseDto = new ArrayList<>();
        for(Enrollment enrollment : enrollments){
            enrollmentResponseDto.add(EnrollmentMapper.toResponse(enrollment));
        }
        enrollmentsByStudentId.setEnrollments(enrollmentResponseDto);
        return enrollmentsByStudentId;
    }
}
