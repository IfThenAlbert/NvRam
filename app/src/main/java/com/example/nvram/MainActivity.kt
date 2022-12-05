package com.example.nvram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.parse.Parse
import com.parse.ParseObject
import com.parse.SaveCallback

/*
    NAVIGATE RAM APP
    ALBERT ANG

*/


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun onTapScreen(v: View) {
        startActivity(Intent(applicationContext,NvRamLogInScreen::class.java))
        return
    }

    override fun onBackPressed() {
        // prevent user from going back
    }
}