package com.example.loginassessment.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.loginassessment.R
import com.example.loginassessment.fragment.UserListFragment
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, UserListFragment())
                .commit()
        }
    }
}