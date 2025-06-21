package net.javaguides.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/*
 * This class is used to transfer data between layers (usually between the backend and frontend or between services and controllers).

Why use a DTO?

To avoid exposing your entity directly to the client.

To control exactly what data is sent and received.

To add additional validation or transformation if needed.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;


}
