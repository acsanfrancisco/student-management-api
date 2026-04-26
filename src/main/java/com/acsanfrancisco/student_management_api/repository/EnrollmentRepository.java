package com.acsanfrancisco.student_management_api.repository;

import com.acsanfrancisco.student_management_api.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
