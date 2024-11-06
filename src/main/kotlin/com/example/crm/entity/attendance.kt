package com.example.crm.entity

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "attendances")
data class Attendance(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    val employee: Employee,

    val date: LocalDate, // Keep as LocalDate if you only need the date

    @Column(name = "entry_time") // Added to specify the column
    val entryTime: LocalDateTime? =null, // Changed to LocalDateTime to include date and time

    @Column(name = "exit_time", nullable = false) // Added to specify the column
    val exitTime: LocalDateTime, // Changed to LocalDateTime to include date and time

    @Column(nullable = false) // Make sure this is not null
    val status: String,

    @Column(name = "attendance_type", nullable = false) // Added the field attendanceType
    val attendanceType: String // Make sure this field is filled when creating an attendance
)
