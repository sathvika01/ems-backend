package net.javaguides.ems.mapper;


import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Employee;

/*
 * This class will contain methods to convert between Employee (Entity) and EmployeeDto.
 * Employee(Entity) is the real db table and EmployeeDto is the one which is
 *  used to tansfer the data and which is exposed to client
 */
//This method takes an Employee entity (usually loaded from the database) and creates
//n EmployeeDto, which is safe to send to a client via an API.


public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
            employee.getId(),
            employee.getFirstName(),
            employee.getLastName(),
            employee.getEmail()
        );

    }

//This does the reverse — takes the data received from the client and converts it to an Employee entity
//hat can be saved in the database.
    public static Employee mapToEmployee(EmployeeDto employeeDto){
         return new Employee(
            employeeDto.getId(),
            employeeDto.getFirstName(),
            employeeDto.getLastName(),
            employeeDto.getEmail()
        );

    }
       
    }


