package com.acsanfrancisco.student_management_api.repository;

import com.acsanfrancisco.student_management_api.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
