@file:Suppress("DEPRECATION")

package com.rezaharis.githubuser

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler

class SplashScreen : Activity() {
    private val displayLength = 1500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        showSplash()
    }

    private fun showSplash(){
        Handler().postDelayed({
            val intent = Intent(this@SplashScreen, MainActivity::class.java)
            this@SplashScreen.startActivity(intent)
            finish()
        }, displayLength.toLong())
    }

}