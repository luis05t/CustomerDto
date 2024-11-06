package com.example.crm.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

class CustomerDto {

    @NotNull(message = "Email is required")
    @NotBlank(message = "Name is required")
    var fullName: String? = null
    @NotNull(message = "Email is required")
    @NotBlank(message = "Email is required")
    var email: String? = null

}
