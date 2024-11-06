package com.example.crm.controller

import com.example.crm.JSendResponse.JSendResponse
import com.example.crm.dto.EmployeeDto
import com.example.crm.service.EmployeeService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/employees")
class EmployeeController(private val employeeService: EmployeeService) {

    @GetMapping
    fun getEmployees(): ResponseEntity<JSendResponse<List<EmployeeDto>>> {
        val employees = employeeService.getEmployees()
        return ResponseEntity.ok(JSendResponse.success(employees))
    }

    @PostMapping
    fun saveEmployee(@Validated @RequestBody employeeDto: EmployeeDto): ResponseEntity<JSendResponse<EmployeeDto>> {
        val savedEmployee = employeeService.save(employeeDto)
        return ResponseEntity.status(HttpStatus.CREATED).body(JSendResponse.success(savedEmployee))
    }
}
