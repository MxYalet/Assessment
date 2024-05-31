package com.example.loginassessment.data.module

import com.example.loginassessment.data.EmployeeResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("/api/v1/employees")
     fun getEmployees(): Call<EmployeeResponse>
}