package com.acsanfrancisco.student_management_api.service;

import com.acsanfrancisco.student_management_api.dto.CreateEnrollmentDto;
import com.acsanfrancisco.student_management_api.dto.CreateStudentDto;
import com.acsanfrancisco.student_management_api.dto.UpdateEnrollmentDto;
import com.acsanfrancisco.student_management_api.dto.UpdateStudentDto;
import com.acsanfrancisco.student_management_api.entity.Enrollment;
import com.acsanfrancisco.student_management_api.entity.Student;
import com.acsanfrancisco.student_management_api.exception.StudentNotFoundException;
import com.acsanfrancisco.student_management_api.mapper.EnrollmentMapper;
import com.acsanfrancisco.student_management_api.mapper.StudentMapper;
import com.acsanfrancisco.student_management_api.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    @Transactional
    public Student createStudent(CreateStudentDto studentDto){
        List<Enrollment> enrollments = new ArrayList<>();
        List<CreateEnrollmentDto> enrollmentDto = studentDto.getEnrollments();
        for(CreateEnrollmentDto createEnrollmentDto : enrollmentDto){
            enrollments.add(EnrollmentMapper.toEntity(createEnrollmentDto));
        }
        Student student = StudentMapper.toEntity(studentDto);
        for(Enrollment enrollment : enrollments){
            student.addEnrollments(enrollment);
        }
        return repository.save(student);
    }

    @Transactional(readOnly = true)
    public List<Student> findAllStudents(){
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Student findById(Long id){
        Optional<Student> student = repository.findById(id);
        return student.orElseThrow(() -> new StudentNotFoundException("Student not found. ID = " + id));
    }

    @Transactional
    public void deleteById(Long id){
        Student student = findById(id);
        repository.delete(student);
    }

    @Transactional
    public Student updateStudent(UpdateStudentDto dto, Long id){
        Student student = findById(id);
        student.setName(dto.getName());
        student.setTelephone(dto.getTelephone());
        student.setBirthDate(dto.getBirthDate());
        student.setUpdateDate(LocalDateTime.now());
        List<Enrollment> enrollments = student.getEnrollments();
        List<UpdateEnrollmentDto> enrollmentsDto = dto.getEnrollments();
        Map<Long, Enrollment> map = new HashMap<>();

        for(Enrollment enrollment : enrollments){
            map.put(enrollment.getId(), enrollment);
        }

        if(enrollmentsDto != null){
            for(UpdateEnrollmentDto updateEnrollmentDto : enrollmentsDto){
                Enrollment enrollment = map.get(updateEnrollmentDto.getId());
                if(enrollment != null){
                    enrollment.setCourseName(updateEnrollmentDto.getCourseName());
                    enrollment.setEnrollmentCod(updateEnrollmentDto.getEnrollmentCod());
                    enrollment.setStartDate(updateEnrollmentDto.getStartDate());
                    enrollment.setUpdateDate(LocalDateTime.now());
                }
                else{
                   Enrollment newEnrollment =  EnrollmentMapper.toEntityFromUpdate(updateEnrollmentDto);
                   student.addEnrollments(newEnrollment);
                }
            }
        }
        return repository.save(student);
    }
}
