package net.javaguides.ems.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.service.EmployeeService;

@RestController //It makes this class as Spring MVC rest Controller and is capable of handling HTTP requests
@AllArgsConstructor
@RequestMapping("/api/employees")//to define base URL for all REST APIS within his controller
public class EmployeeController {

    private EmployeeService employeeService;
    //build add Employee REST API
    //Return type of method ResponseEntity
    //ResponseEntity is a generic class, so pass EmployeeDto as a type
    //createEmployee is method name
    //employeeDto as parameter
    //@RequestBody will extract JSON from HTTP request and will convert to employeeDto java object
    @PostMapping //this maps incoming POST requests to this method
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
        

    }
        

    }


