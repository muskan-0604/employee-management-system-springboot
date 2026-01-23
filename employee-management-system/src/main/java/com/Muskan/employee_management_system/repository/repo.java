package com.Muskan.employee_management_system.repository;

import com.Muskan.employee_management_system.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repo extends JpaRepository<Employee , Long> {
}
