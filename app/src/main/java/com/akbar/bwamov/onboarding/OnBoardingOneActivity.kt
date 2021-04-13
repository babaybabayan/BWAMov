package com.akbar.bwamov.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.akbar.bwamov.R
import com.akbar.bwamov.SignInActivity

class OnBoardingOneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding_one)

        val btn_daftar = findViewById<Button>(R.id.btn_daftar)
        val btn_lewat = findViewById<Button>(R.id.btn_lewat)

        btn_daftar.setOnClickListener{
            val intent = Intent(this, OnBoardingTwoActivity::class.java)
            startActivity(intent)
        }

        btn_lewat.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

    }
}