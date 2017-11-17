package com.example.ixzus.appacc

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.yltx.modulewd.SplashActivity

class MySplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_splash)
        startActivity(Intent(this, SplashActivity::class.java))
    }
}
