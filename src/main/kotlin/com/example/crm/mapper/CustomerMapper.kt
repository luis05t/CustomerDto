package com.example.crm.mapper

import com.example.crm.dto.CustomerDto
import com.example.crm.entity.Customer

object CustomerMapper {

    fun toEntity(customerDto: CustomerDto): Customer {
        val customer = Customer()
        customer.fullName = customerDto.fullName
        customer.email = customerDto.email
        return customer
    }
}