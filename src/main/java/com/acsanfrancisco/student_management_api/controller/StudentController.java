package com.acsanfrancisco.student_management_api.controller;

import com.acsanfrancisco.student_management_api.dto.*;
import com.acsanfrancisco.student_management_api.entity.Student;
import com.acsanfrancisco.student_management_api.exception.ErrorMessage;
import com.acsanfrancisco.student_management_api.exception.StudentNotFoundException;
import com.acsanfrancisco.student_management_api.mapper.EnrollmentMapper;
import com.acsanfrancisco.student_management_api.mapper.StudentMapper;
import com.acsanfrancisco.student_management_api.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.boot.model.source.spi.IdentifierSourceAggregatedComposite;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
@Tag(name = "Students_Management", description = "API for managing students and their enrollments")
public class StudentController {

    private final StudentService service;

    @Operation(summary = "Create new Student", responses = {
            @ApiResponse(responseCode = "201", description = "Created Successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StudentResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
            @ApiResponse(responseCode = "500", description = "Unexpected Error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
    })
    @PostMapping
    public ResponseEntity<StudentResponseDto> createStudent(@Valid @RequestBody CreateStudentDto studentDto){
        Student student = service.createStudent(studentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(StudentMapper.toResponse(student));
    }

    @Operation(summary = "Return all students", responses = {
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = StudentResponseDto.class)))),
            @ApiResponse(responseCode = "500", description = "Unexpected Error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
    })
    @GetMapping
    public ResponseEntity<List<ToListAllStudentsDto>> findAllStudents(){
        List<ToListAllStudentsDto> studentsList = StudentMapper.listAllStudents(service.findAllStudents());
        return ResponseEntity.status(HttpStatus.OK).body(studentsList);
    }

    @Operation(summary = "Update student", responses = {
            @ApiResponse(responseCode = "OK", description = "OK",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StudentResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
            @ApiResponse(responseCode = "404", description = "Student not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
            @ApiResponse(responseCode = "500", description = "Unexpected Error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
    })
    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDto> updateStudent(@Valid @RequestBody UpdateStudentDto dto, @PathVariable Long id){
        return ResponseEntity.ok(StudentMapper.toResponse(service.updateStudent(dto, id)));
    }

    @Operation(summary = "Delete student", responses = {
            @ApiResponse(responseCode = "204", description = "No Content",
                    content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "404", description = "Student not Found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
            @ApiResponse(responseCode = "500", description = "Unexpected Error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(summary = "Find enrollments by the student id", responses = {
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = FindEnrollmentsByStudentId.class)))),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
            @ApiResponse(responseCode = "500", description = "Unexpected Error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<FindEnrollmentsByStudentId> findEnrollmentsByStudentId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(StudentMapper.listAllEnrollmentsByStudent(service.findById(id)));
    }
}
