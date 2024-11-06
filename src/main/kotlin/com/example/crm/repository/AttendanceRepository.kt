package com.example.crm.repository

import com.example.crm.entity.Attendance
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AttendanceRepository : JpaRepository<Attendance, Long>
