package net.javaguides.ems.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.service.EmployeeService;

@AllArgsConstructor
@RestController //It makes this class as Spring MVC rest Controller and is capable of handling HTTP requests

@RequestMapping("/api/employees")//to define base URL for all REST APIS within his controller
public class EmployeeController {

    private final EmployeeService employeeService;
    //build add Employee REST API
    //Return type of method ResponseEntity
    //ResponseEntity is a generic class, so pass EmployeeDto as a type this helps to return data along with HTTP status code
    //createEmployee is method name
    //employeeDto as parameter
    //@RequestBody will extract JSON from HTTP request and will convert to employeeDto java object
    @PostMapping //this maps incoming POST requests to this method {creates new user}
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
    }

    //build get Employee by id REST API
    //This method will be used to fetch employee details by id
    @GetMapping("/{id}") //this maps incoming GET requests to this method {fetches user by id}
    //@PathVariable will extract employeeId from URL and will pass it to method as parameter
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
        

    }
    //build get all Employees REST API
    @GetMapping //this maps incoming GET requests to this method {fetches all users}
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return  ResponseEntity.ok(employees);
    }

    //build update Employee REST API
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(
            @PathVariable("id") Long employeeId,
            @RequestBody EmployeeDto updatedEmployee) {
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);
        return  ResponseEntity.ok(employeeDto);
    }

    //build delete Employee REST API
    @DeleteMapping("{id}") //this maps incoming DELETE requests to this method {deletes user by id}
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return  ResponseEntity.ok("Employee deleted successfully");
    }
}


