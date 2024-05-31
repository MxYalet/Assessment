package com.example.loginassessment.viewModel

import com.example.loginassessment.data.module.EmployeeResponse
import com.example.loginassessment.repository.UserRepository


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    val userListLiveData = MutableLiveData<EmployeeResponse>()
    val errorMessage = MutableLiveData<String>()

    fun fetchUsers() {
        viewModelScope.launch {
            userRepository.getEmployees().enqueue(object : Callback<EmployeeResponse> {
                override fun onResponse(call: Call<EmployeeResponse>, response: Response<EmployeeResponse>) {
                    if (response.isSuccessful) {
                    } else {
                        errorMessage.postValue("Error: ${response.code()} ${response.message()}")
                    }
                }

                override fun onFailure(call: Call<EmployeeResponse>, t: Throwable) {
                    errorMessage.postValue(t.message)
                }
            })
        }
    }
}