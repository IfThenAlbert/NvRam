package com.example.nvram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import com.parse.LogInCallback
import com.parse.ParseUser
/*
    NvRamLogInScreen
    ALBERT ANG
 */
class NvRamLogInScreen : AppCompatActivity() {
    @BindView(R.id.inp_username)
    lateinit var inp_username:EditText
    @BindView(R.id.inp_password)
    lateinit var inp_password:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nv_ram_log_in_screen)
        ButterKnife.bind(this)
    }

    fun onLoginTap(v: View) {
        if(inp_username.text.isEmpty() || inp_password.text.isEmpty()) {
            Toast.makeText(applicationContext,"PLEASE FILL OUT ALL THE FIELDS!",Toast.LENGTH_SHORT).show()
        }else{
            ParseUser.logInInBackground(inp_username.text.toString(),inp_password.text.toString(),
                LogInCallback { user, e ->
                    if(e==null) {
                        Toast.makeText(applicationContext,"LOGGED IN",Toast.LENGTH_SHORT).show()
                        startActivity(Intent(applicationContext,NvRamHomeScreen::class.java))
                        finish()
                    }
                })
        }
    }

    fun onRegisterTap(v:View) {
        startActivity(Intent(applicationContext,NvRamsRegisterScreen::class.java))
    }


    override fun onBackPressed() {
        // prevent user from going back
    }
}