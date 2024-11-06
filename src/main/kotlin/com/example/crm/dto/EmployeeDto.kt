package com.example.crm.dto

import java.math.BigDecimal

data class EmployeeDto(
    val firstName: String,
    val lastName: String,
    val position: String,
    val department: String,
    val salary: BigDecimal?, // It can be null
    val hiringDate: String // It should be a String representing the date
)
