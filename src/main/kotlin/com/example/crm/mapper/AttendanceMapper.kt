package com.example.crm.mapper

import com.example.crm.dto.AttendanceDto
import com.example.crm.entity.Attendance
import com.example.crm.entity.Employee
import java.time.LocalDateTime

object AttendanceMapper {

    fun toEntity(attendanceDto: AttendanceDto, employee: Employee, attendanceType: String): Attendance {
        return Attendance(
            employee = employee,
            date = attendanceDto.date, // Keeps as LocalDate
            entryTime = LocalDateTime.of(attendanceDto.date, attendanceDto.entryTime), // Combines date and time
            exitTime = LocalDateTime.of(attendanceDto.date, attendanceDto.exitTime), // Combines date and time
            status = attendanceDto.status,
            attendanceType = attendanceType // Make sure to pass this parameter
        )
    }

    fun toDto(attendance: Attendance): AttendanceDto {
        return AttendanceDto(
            employeeId = attendance.employee.employeeId,
            date = attendance.date, // Keeps as LocalDate
            entryTime = attendance.entryTime!!.toLocalTime(), // Extracts only the time
            exitTime = attendance.exitTime.toLocalTime(), // Extracts only the time
            status = attendance.status
        )
    }
}
