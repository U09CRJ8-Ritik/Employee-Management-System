package com.employee.exceptions;

public class DateOfBirthInNegativeException extends RuntimeException {

    public DateOfBirthInNegativeException(String msg) {
        super(msg);
    }
}
