package com.example.loginassessment.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.loginassessment.R
import com.example.loginassessment.adapter.EmployeeAdapter
import com.example.loginassessment.data.module.EmployeeResponse
import com.example.loginassessment.data.module.User
import com.example.loginassessment.data.remote.NetworkModule
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@AndroidEntryPoint
class UserListFragment : Fragment() {



    private lateinit var recyclerView: RecyclerView
    private lateinit var employeeAdapter: EmployeeAdapter
    private val userList: MutableList<User> = mutableListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        employeeAdapter = EmployeeAdapter(userList)
        recyclerView.adapter = employeeAdapter

        loadUsers()
        return view
    }

    private fun loadUsers() {
        Log.d("UserListFragment", "loadUsers: Fetching users from API")
        val apiService = NetworkModule.provideApiService()

        apiService.getEmployees().enqueue(object : Callback<EmployeeResponse> {
            override fun onResponse(call: Call<EmployeeResponse>, response: Response<EmployeeResponse>) {
                if (response.isSuccessful) {
                    val users = response.body()?.data ?: emptyList()
                   //userList.clear()
                    userList.addAll(users)
                    employeeAdapter.notifyDataSetChanged()
                    Log.d("UserListFragment", "onResponse: Successfully fetched users")
                } else {
                    Log.e("UserListFragment", "onResponse: Failed to fetch users, response code: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<EmployeeResponse>, t: Throwable) {
                Log.e("UserListFragment", "onFailure: Failed to fetch users", t)
            }
        })
    }
}
