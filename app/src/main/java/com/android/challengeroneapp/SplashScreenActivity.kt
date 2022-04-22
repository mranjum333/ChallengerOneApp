package com.android.challengeroneapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.challengeroneapp.view.BaseActivity
import java.util.*
import kotlin.concurrent.schedule

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timer().schedule(2000) {
            launchHomeScreen()
        }
    }

    private fun launchHomeScreen() {
        startActivity(Intent(this, BaseActivity::class.java))
        finish()
    }
}