package com.example.crm.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate

@Entity
@Table(name = "employees")
data class Employee(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val employeeId: Long = 0,

    @Column(nullable = false)
    val firstName: String,

    @Column(nullable = false)
    val lastName: String,

    @Column(nullable = false)
    val position: String,

    @Column(nullable = false)
    val department: String,

    @Column(nullable = false)
    val salary: BigDecimal,

    @Column(name = "hiring_date", nullable = false)
    val hiringDate: LocalDate
)
