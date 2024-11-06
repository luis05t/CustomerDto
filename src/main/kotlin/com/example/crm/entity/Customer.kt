package com.example.crm.entity

import jakarta.persistence.*

@Entity
@Table (name = "customer")
class Customer {
    @GeneratedValue (strategy =  GenerationType.IDENTITY)
    @Id
    @Column (updatable = false)
    var id: Long? = null
    var fullName: String? = null
    var email: String? = null
    var phone: String? = null
    var address: String? = null
}