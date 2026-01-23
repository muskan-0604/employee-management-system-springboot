package com.Muskan.employee_management_system.service;


import com.Muskan.employee_management_system.model.Employee;
import com.Muskan.employee_management_system.repository.repo;
//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
   private  repo rr ;

    public List<Employee> getEDetails(){
        return rr.findAll();
    }

    public Employee addEmployee(Employee employee) {
        return rr.save(employee);
    }

    public Employee updateDetails(Long id ,Employee employee) {

        Employee existingEmployee = rr.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found by id : " + id) ) ;

        if(employee.getDepartment() != null) {
            existingEmployee.setDepartment(employee.getDepartment());
        }
        if(employee.getName() != null){
        existingEmployee.setName(employee.getName());
        }
        if(employee.getEmail() != null) {
            existingEmployee.setEmail(employee.getEmail());
        }
        if(employee.getSalary() != null) {
            existingEmployee.setSalary(employee.getSalary());
        }
        return  rr.save(existingEmployee);

    }

    public void deleteEmployee(Long id) {
        Employee employee = rr.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));

        rr.delete(employee);
    }
}
