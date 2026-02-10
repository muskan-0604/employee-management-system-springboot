package com.Muskan.employee_management_system.model;

import com.Muskan.employee_management_system.status.EmployeeStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private   String name;

    @Column(unique = true)
    private String email;
    private String department;
    private  Double salary;

    @Enumerated(EnumType.STRING)
  private EmployeeStatus status;
}
