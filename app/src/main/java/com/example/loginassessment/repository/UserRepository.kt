package com.example.loginassessment.repository

import com.example.loginassessment.data.module.EmployeeResponse
import com.example.loginassessment.data.remote.ApiService
import retrofit2.Call
import javax.inject.Inject

class UserRepository @Inject constructor(private val apiService: ApiService) {

    fun getEmployees(): Call<EmployeeResponse> {
        return apiService.getEmployees()
    }
}