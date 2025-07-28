package net.javaguides.ems.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Employee;
import net.javaguides.ems.exception.ResourceNotFoundException;
import net.javaguides.ems.mapper.EmployeeMapper;
import net.javaguides.ems.repository.EmployeeRepository;
import net.javaguides.ems.service.EmployeeService;

@Service
@AllArgsConstructor
public class EmployeeServiceImplemnetation implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        //first convert employeeDto into employeejpa entity
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        //save this employee entity into db for that call employeeRepository
        Employee savedEmployee = employeeRepository.save(employee);

        //Convert savedEmployee JPA entity into dto
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
            .orElseThrow(() -> 
                    new ResourceNotFoundException("Employee not found with id: " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees =  employeeRepository.findAll();
        return employees.stream().map((employee) -> 
            EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId)
            .orElseThrow(() -> 
                    new ResourceNotFoundException("Employee not found with id: " + employeeId));

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
        
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
            .orElseThrow(() -> 
                    new ResourceNotFoundException("Employee not found with id: " + employeeId));
        employeeRepository.deleteById(employeeId);
    }

}


