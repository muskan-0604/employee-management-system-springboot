package com.Muskan.employee_management_system.Controller;
import com.Muskan.employee_management_system.model.Employee;
import com.Muskan.employee_management_system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/details")
    public ResponseEntity<Page<Employee>> getEDetails
            (@RequestParam (defaultValue = "0")int page ,
             @RequestParam (defaultValue = "10") int size,
             @RequestParam(defaultValue = "id") String sortBy,
             @RequestParam(defaultValue = "asc") String direction,
             @RequestParam(required = false) String department,
             @RequestParam(required = false) Double minSalary,
             @RequestParam(required = false) Double maxSalary,
             @RequestParam (required = false) String name
    ){
     Page<Employee> employees  = employeeService.getEDetails(
             page,
             size,
             sortBy ,
             direction,department,
             minSalary ,
             maxSalary,
             name
     );
       return  ResponseEntity.ok(employees);

    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee ) {
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
