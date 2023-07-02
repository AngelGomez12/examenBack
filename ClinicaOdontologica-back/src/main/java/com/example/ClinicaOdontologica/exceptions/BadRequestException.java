package com.example.ClinicaOdontologica.exceptions;

public class BadRequestException extends Exception {
    public BadRequestException(String message){
        super(message);
    }
}
