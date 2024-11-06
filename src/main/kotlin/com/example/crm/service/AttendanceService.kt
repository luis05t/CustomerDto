package com.example.crm.service

import com.example.crm.dto.AttendanceDto
import com.example.crm.entity.Employee
import com.example.crm.mapper.AttendanceMapper
import com.example.crm.repository.AttendanceRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AttendanceService(private val attendanceRepository: AttendanceRepository) {
    fun getAttendances(): List<AttendanceDto> {
        return attendanceRepository.findAll().map(AttendanceMapper::toDto)
    }

    @Transactional
    fun save(attendanceDto: AttendanceDto, employee: Employee, attendanceType: String): AttendanceDto {
        val attendance = AttendanceMapper.toEntity(attendanceDto, employee, attendanceType) // Now includes attendanceType
        return AttendanceMapper.toDto(attendanceRepository.save(attendance))
    }
}
