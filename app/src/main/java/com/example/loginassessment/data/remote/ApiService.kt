package com.example.loginassessment.data.remote

import com.example.loginassessment.data.module.EmployeeResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("api/v1/employees")
    fun getEmployees(): Call<EmployeeResponse>
}