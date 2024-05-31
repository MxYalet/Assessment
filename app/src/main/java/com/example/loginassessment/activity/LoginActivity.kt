// LoginActivity.kt
package com.example.loginassessment.activity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.loginassessment.R
import com.example.loginassessment.data.remote.ApiService
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var apiService: ApiService

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var cbRememberMe: CheckBox
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_pass)
        cbRememberMe = findViewById(R.id.cbRememberMe)
        val btnLogin = findViewById<Button>(R.id.btn_login)

        sharedPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE)
        loadPreferences()

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            loginUser(email, password)
        }
    }

    private fun loadPreferences() {
        val rememberMe = sharedPreferences.getBoolean("rememberMe", false)
        if (rememberMe) {
            etEmail.setText(sharedPreferences.getString("email", ""))
            etPassword.setText(sharedPreferences.getString("password", ""))
            cbRememberMe.isChecked = true
        }
    }

    private fun loginUser(email: String, password: String) {
        // Simple authentication logic (replace with actual API call)
        if (email == "user@example.com" && password == "password") {
            if (cbRememberMe.isChecked) {
                savePreferences(email, password)
            } else {
                clearPreferences()
            }

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
          //  Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
            // Redirect to the user list fragment
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun savePreferences(email: String, password: String) {
        val editor = sharedPreferences.edit()
        editor.putBoolean("rememberMe", true)
        editor.putString("email", email)
        editor.putString("password", password)
        editor.apply()
    }

    private fun clearPreferences() {
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }
}
