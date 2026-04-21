package com.acsanfrancisco.student_management_api.service;

import com.acsanfrancisco.student_management_api.dto.UpdateStudentDto;
import com.acsanfrancisco.student_management_api.entity.Student;
import com.acsanfrancisco.student_management_api.exception.StudentNotFoundException;
import com.acsanfrancisco.student_management_api.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    @Transactional
    public Student createStudent(Student student){
        student.setInsertionDate(LocalDateTime.now());
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
        return repository.save(student);
    }
}
