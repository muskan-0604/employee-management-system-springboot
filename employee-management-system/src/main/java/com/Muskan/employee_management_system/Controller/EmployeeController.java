package com.Muskan.employee_management_system.Controller;
import com.Muskan.employee_management_system.model.Employee;
import com.Muskan.employee_management_system.service.EmployeeService;
//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/details")
    public ResponseEntity<List<Employee>> getEDetails(){
        List<Employee> employees = employeeService.getEDetails();
        return new  ResponseEntity<>( employees,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee AddEmp = employeeService.addEmployee(employee);
        return new ResponseEntity<>(AddEmp, HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,
                                                   @RequestBody Employee employee){

        Employee Upemployee = employeeService.updateDetails(id, employee);
                return new ResponseEntity<>(Upemployee, HttpStatus.OK);
        }


    @DeleteMapping("remove/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id ){
       employeeService.deleteEmployee(id);

        return new ResponseEntity<>("Deleted" , HttpStatus.OK);
}

}
