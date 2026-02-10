package com.Muskan.employee_management_system.repository;

import com.Muskan.employee_management_system.model.Employee;
import com.Muskan.employee_management_system.status.EmployeeStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>, JpaSpecificationExecutor<Employee> {

    Page<Employee> findByStatus(EmployeeStatus status , Pageable pageable);

    Boolean existsByEmail(String email);
   Optional<Employee> findByEmail(String email);
}
