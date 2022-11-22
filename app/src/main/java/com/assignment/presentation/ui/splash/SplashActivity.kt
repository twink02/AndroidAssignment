package com.assignment.presentation.ui.splash

import android.content.Intent
import android.os.Bundle
import com.assignment.R
import com.assignment.databinding.ActivitySplashBinding
import com.assignment.presentation.base.BaseActivity
import com.assignment.presentation.model.ViewModelCreator
import com.assignment.presentation.ui.activity.MainActivity
import java.util.*


class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timer().schedule(object : TimerTask() {
            override fun run() {
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.`in`, R.anim.out)
                finish()
            }
        }, 5000)
    }

    override fun subscribeToObservers() {
    }

    override fun getViewBinding(): ActivitySplashBinding = ActivitySplashBinding.inflate(layoutInflater)

}