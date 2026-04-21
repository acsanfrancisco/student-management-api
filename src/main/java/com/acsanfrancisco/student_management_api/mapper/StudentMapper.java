package com.acsanfrancisco.student_management_api.mapper;

import com.acsanfrancisco.student_management_api.dto.CreateStudentDto;
import com.acsanfrancisco.student_management_api.dto.StudentResponseDto;
import com.acsanfrancisco.student_management_api.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentMapper {

    public static Student toEntity(CreateStudentDto createStudentDto){
        Student student = new Student();
        student.setName(createStudentDto.getName());
        student.setBirthDate(createStudentDto.getBirthDate());
        student.setTelephone(createStudentDto.getTelephone());
        return student;
    }

    public static StudentResponseDto toResponse(Student student){
        StudentResponseDto dto = new StudentResponseDto();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setBirthDate(student.getBirthDate());
        dto.setTelephone(student.getTelephone());
        dto.setUpdateDate(student.getUpdateDate());
        return dto;
    }

    public static List<StudentResponseDto> listToDto(List<Student> studentList){
        List<StudentResponseDto> responseDtoList = new ArrayList<>();
        for(Student student : studentList){
            responseDtoList.add(toResponse(student));
        }
        return responseDtoList;
    }
}
