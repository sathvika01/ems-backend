package net.javaguides.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.ems.entity.Employee;

/*
 Purpose: This is your DAO (Data Access Object) or repository interface.
You use this to interact with the employees table in your database.

JpaRepository<Employee, Long> gives you CRUD operations for free:

save(employee)

findById(id)

findAll()

deleteById(id)

etc.

You don’t need to write any SQL or method implementations — Spring Data JPA generates them automatically.
 */

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
