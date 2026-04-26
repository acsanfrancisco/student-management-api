package com.acsanfrancisco.student_management_api.exception;

public class EnrollmentNotFoundException extends RuntimeException{

    public EnrollmentNotFoundException(String message){
        super(message);
    }
}
