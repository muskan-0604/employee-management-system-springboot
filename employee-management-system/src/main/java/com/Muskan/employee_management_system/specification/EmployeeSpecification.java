package com.Muskan.employee_management_system.specification;

import com.Muskan.employee_management_system.model.Employee;
import com.Muskan.employee_management_system.status.EmployeeStatus;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpecification {

    public static Specification<Employee> hasStatus(EmployeeStatus status){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("status"),status));
    }


    public static Specification<Employee> hasDepartment(String department){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("department"),department));
    }

    public static Specification<Employee> salaryGreaterThan(Double salary){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThan(root.get("salary"),salary);
    }

    public static Specification<Employee> salaryLessThan(Double salary){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThan(root.get("salary"),salary);
    }

    public static Specification<Employee> salaryBetween(Double min , Double max){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.between(root.get("salary"),min , max);
    }

    public static Specification<Employee> nameContains (String name){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("name")) ,
                        "%" +  name.toLowerCase() + "%")) ;
    }
}
