package net.javaguides.ems.service.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Employee;
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

}


