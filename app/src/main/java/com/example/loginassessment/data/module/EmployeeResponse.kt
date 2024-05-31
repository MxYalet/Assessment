package com.example.loginassessment.data.module

data class EmployeeResponse(
    val status: String,
    val data: List<User>
)