package com.example.crm.dto

import java.time.LocalDate
import java.time.LocalTime

data class AttendanceDto(
    val employeeId: Long,
    val date: LocalDate, // Make sure it's LocalDate
    val entryTime: LocalTime,
    val exitTime: LocalTime,
    val status: String
)
