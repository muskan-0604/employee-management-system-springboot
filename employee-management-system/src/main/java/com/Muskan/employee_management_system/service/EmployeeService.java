package com.Muskan.employee_management_system.service;


import com.Muskan.employee_management_system.model.Employee;
import com.Muskan.employee_management_system.repository.EmployeeRepository;
import com.Muskan.employee_management_system.specification.EmployeeAlreadyExists;
import com.Muskan.employee_management_system.specification.EmployeeNotFoundException;
import com.Muskan.employee_management_system.specification.EmployeeSpecification;
import com.Muskan.employee_management_system.status.EmployeeStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {

    @Autowired
   private EmployeeRepository rr ;

    public Page<Employee> getEDetails(int pageNumber ,
                                      int pageSize ,
                                      String sortBy ,
                                      String direction,
                                      String department ,
                                      Double minSalary,
                                      Double maxSalary,
                                      String name
                                      ){

        if(sortBy == null || sortBy.isBlank()){
            sortBy ="id";
        }
        if(direction == null || direction.isBlank()){
            direction = "asc";
        }

        sortBy = sortBy.trim().toLowerCase();
        direction= direction.trim().toLowerCase();

        String[] allowedFields = {"id" , "email" , "department" , "salary" , "status"};
        Sort sort = direction.equalsIgnoreCase("desc") ?
                Sort.by(sortBy).descending() :
                Sort.by(sortBy).ascending();

        boolean validSortField = false;

        for(int i =0; i<allowedFields.length ;i++){
            if(sortBy.equalsIgnoreCase(allowedFields[i])){
             validSortField = true;
             break;
            }
        }
        if(!validSortField){
           sortBy = "id";
        }

        Pageable pageable = PageRequest.of(pageNumber,pageSize, sort );
        Specification<Employee> spec = EmployeeSpecification.hasStatus(EmployeeStatus.ACTIVE);
        if(department != null && !department.isBlank()){
            spec = spec.and(EmployeeSpecification.hasDepartment(department));
        }
        if (minSalary != null && maxSalary != null) {
            spec =spec.and(EmployeeSpecification.salaryBetween(minSalary , maxSalary));
        } else if (minSalary != null) {
            spec = spec.and(EmployeeSpecification.salaryGreaterThan(minSalary));
        } else if (maxSalary != null) {
            spec = spec.and(EmployeeSpecification.salaryLessThan(maxSalary));
        }
        if(name != null && !name.isBlank()){
            spec = spec.and(EmployeeSpecification.nameContains(name));
        }
        return rr.findAll(spec, pageable);
    }



    public Employee addEmployee(Employee employee) {
        if (rr.existsByEmail(employee.getEmail())) {
            throw new EmployeeAlreadyExists("Email already exists, Use different one ");
        } else {
            employee.setStatus(EmployeeStatus.ACTIVE);
            return rr.save(employee);
        }
    }
    public Employee updateDetails(Long id ,Employee employee) {

        Employee existingEmployee = rr.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found by id : " + id) ) ;

        if(employee.getDepartment() != null) {
            existingEmployee.setDepartment(employee.getDepartment());
        }
        if(employee.getName() != null){
        existingEmployee.setName(employee.getName());
        }
        if(employee.getEmail() != null) {
            if (!employee.getEmail().equals(existingEmployee.getEmail())) {
                    if (rr.existsByEmail(employee.getEmail())) {
                        throw new EmployeeAlreadyExists("Email already exists, Use different one ");
                    }
                }
            existingEmployee.setEmail(employee.getEmail());
            }
        if(employee.getSalary() != null) {
            existingEmployee.setSalary(employee.getSalary());
        }
        if(employee.getStatus()!= null){
            existingEmployee.setStatus(employee.getStatus());
        }

        return  rr.save(existingEmployee);

    }

    public void deleteEmployee(Long id) {
        Employee employee = rr.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
        employee.setStatus(EmployeeStatus.INACTIVE);
         rr.save(employee);
    }
}
