package com.akbar.bwamov.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.akbar.bwamov.R

class OnBoardingTwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding_two)

        val btn_lanjut = findViewById<Button>(R.id.btn_lanjut)
        btn_lanjut.setOnClickListener {
            val intent = Intent(this,OnBoardingThreeActivity::class.java)
            startActivity(intent)
        }

    }
}