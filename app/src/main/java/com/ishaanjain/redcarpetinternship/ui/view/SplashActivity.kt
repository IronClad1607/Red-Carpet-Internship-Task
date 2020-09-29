package com.ishaanjain.redcarpetinternship.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.ishaanjain.redcarpetinternship.R

class SplashActivity : AppCompatActivity() {

    private val splashDelay: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            val splashIntent = Intent(this, HomeActivity::class.java)
            startActivity(splashIntent)
        }, splashDelay)
    }
}