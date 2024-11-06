package com.example.crm.mapper

import com.example.crm.dto.EmployeeDto
import com.example.crm.entity.Employee
import java.math.BigDecimal
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object EmployeeMapper {
    private val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd") // Adjust the format as needed

    fun toEntity(employeeDto: EmployeeDto): Employee {
        return Employee(
            firstName = employeeDto.firstName,
            lastName = employeeDto.lastName,
            position = employeeDto.position,
            department = employeeDto.department,
            salary = employeeDto.salary ?: BigDecimal.ZERO, // Assign a default value in case it's null
            hiringDate = LocalDate.parse(employeeDto.hiringDate, dateFormatter) // Parse the date from String
        )
    }

    fun toDto(employee: Employee): EmployeeDto {
        return EmployeeDto(
            firstName = employee.firstName,
            lastName = employee.lastName,
            position = employee.position,
            department = employee.department,
            salary = employee.salary,
            hiringDate = employee.hiringDate.format(dateFormatter) // Convert the date to String
        )
    }
}
