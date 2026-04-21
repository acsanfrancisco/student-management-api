package com.acsanfrancisco.student_management_api.controller;

import com.acsanfrancisco.student_management_api.dto.CreateStudentDto;
import com.acsanfrancisco.student_management_api.dto.StudentResponseDto;
import com.acsanfrancisco.student_management_api.dto.UpdateStudentDto;
import com.acsanfrancisco.student_management_api.entity.Student;
import com.acsanfrancisco.student_management_api.exception.ErrorMessage;
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
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
    })
    @PostMapping
    public ResponseEntity<StudentResponseDto> createStudent(@Valid @RequestBody CreateStudentDto dto){
        Student student = service.createStudent(StudentMapper.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(StudentMapper.toResponse(student));
    }

    @Operation(summary = "Return all students", responses = {
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = StudentResponseDto.class))))
    })
    @GetMapping
    public ResponseEntity<List<StudentResponseDto>> findAllStudents(){
        List<StudentResponseDto> studentsList = StudentMapper.listToDto(service.findAllStudents());
        return ResponseEntity.status(HttpStatus.OK).body(studentsList);
    }

    @Operation(summary = "Update student", responses = {
            @ApiResponse(responseCode = "OK", description = "OK",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StudentResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
    })
    @PatchMapping("/{id}")
    public ResponseEntity<StudentResponseDto> updateStudent(@Valid @RequestBody UpdateStudentDto dto, @PathVariable Long id){
        return ResponseEntity.ok(StudentMapper.toResponse(service.updateStudent(dto, id)));
    }

    @Operation(summary = "Delete student", responses = {
            @ApiResponse(responseCode = "204", description = "No Content",
                    content = @Content(schema = @Schema(implementation = Void.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
