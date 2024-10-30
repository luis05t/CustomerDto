package com.example.crm.service

import com.example.crm.dto.CustomerDto
import com.example.crm.entity.Customer
import com.example.crm.mapper.CustomerMapper
import com.example.crm.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class CustomerService {

    @Autowired
    lateinit var customerRepository: CustomerRepository

    fun getCustomers(): List<Customer> {
        return customerRepository.findAll()
    }

    fun save (customerDto: CustomerDto): Customer {
        val customer = CustomerMapper.toEntity(customerDto)
        return customerRepository.save(customer)
    }



}