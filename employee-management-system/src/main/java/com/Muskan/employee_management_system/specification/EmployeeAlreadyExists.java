package com.Muskan.employee_management_system.specification;

public class EmployeeAlreadyExists extends RuntimeException {
    public EmployeeAlreadyExists(String message) {
        super(message);
    }
}
