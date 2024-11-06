package com.example.crm.controller

import com.example.crm.dto.AttendanceDto
import com.example.crm.service.AttendanceService
import com.example.crm.service.EmployeeService
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/attendances")  // Cambiamos la ruta
@CrossOrigin(origins = ["*"])
class AttendanceController(
    private val attendanceService: AttendanceService,
    private val employeeService: EmployeeService
) {
    private val logger = LoggerFactory.getLogger(AttendanceController::class.java)

    @GetMapping
    fun getAttendances(): ResponseEntity<List<AttendanceDto>> {
        logger.info("Getting all attendances")
        val attendances = attendanceService.getAttendances()
        return ResponseEntity.ok(attendances)
    }

    @GetMapping("/test")  // Endpoint de prueba
    fun test(): ResponseEntity<String> {
        logger.info("Test endpoint called")
        return ResponseEntity.ok("Controller is working!")
    }

    @PostMapping
    fun saveAttendance(
        @RequestBody attendanceDto: AttendanceDto,
        @RequestParam attendanceType: String
    ): ResponseEntity<AttendanceDto> {
        logger.info("Saving attendance for employee: ${attendanceDto.employeeId}")
        val employee = employeeService.findById(attendanceDto.employeeId)
            ?: throw RuntimeException("Employee not found")

        val savedAttendance = attendanceService.save(attendanceDto, employee, attendanceType)
        return ResponseEntity.ok(savedAttendance)
    }
}