package com.example.crm.service

import com.example.crm.dto.EmployeeDto
import com.example.crm.entity.Employee
import com.example.crm.mapper.EmployeeMapper
import com.example.crm.repository.EmployeeRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EmployeeService(private val employeeRepository: EmployeeRepository) {

    fun getEmployees(): List<EmployeeDto> {
        return employeeRepository.findAll().map(EmployeeMapper::toDto)
    }

    @Transactional
    fun save(employeeDto: EmployeeDto): EmployeeDto {
        val employee = EmployeeMapper.toEntity(employeeDto)
        val savedEmployee = employeeRepository.save(employee)
        return EmployeeMapper.toDto(savedEmployee)
    }

    fun findById(id: Long): Employee? {
        return employeeRepository.findById(id).orElse(null)
    }
}
