package com.example.nvram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import com.google.android.material.snackbar.Snackbar
import com.parse.ParseUser
import com.parse.SignUpCallback
/*
    NvRamsRegisterScreen
    ALBERT ANG
 */
class NvRamsRegisterScreen : AppCompatActivity() {

    @BindView(R.id.btn_register)
    lateinit var btn_register:Button

    @BindView(R.id.inp_new_firstname)
    lateinit var inp_new_firstname:EditText
    @BindView(R.id.inp_new_lastname)
    lateinit var inp_new_lastname:EditText
    @BindView(R.id.inp_new_ramid)
    lateinit var inp_new_ramid:EditText
    @BindView(R.id.inp_new_password)
    lateinit var inp_new_password:EditText
    @BindView(R.id.inp_new_email)
    lateinit var inp_new_email:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nv_rams_register_screen)
        ButterKnife.bind(this)


        btn_register.setOnClickListener{
            if(inp_new_firstname.text.toString().isEmpty() || inp_new_lastname.text.toString().isEmpty() || inp_new_ramid.text.toString().isEmpty() ||
                    inp_new_password.text.toString().isEmpty()|| inp_new_email.text.toString().isEmpty()) {
                Snackbar.make(it,"Please fill out all the fields",Snackbar.LENGTH_SHORT).show()
            }else{
                var db:DatabaseMethods = DatabaseMethods()
                var nUser:ParseUser = ParseUser()
                nUser.setUsername(db.generateUsername(inp_new_firstname.text.toString(),inp_new_lastname.text.toString()))
                nUser.setPassword(inp_new_password.text.toString())
                nUser.setEmail(inp_new_email.text.toString())
                nUser.put("firstname",inp_new_firstname.text.toString())
                nUser.put("lastname",inp_new_lastname.text.toString())
                nUser.put("ramid",inp_new_ramid.text.toString())


                nUser.signUpInBackground(SignUpCallback {
                    if(it ==null) {
                        Toast.makeText(applicationContext,"WELCOME !",Toast.LENGTH_SHORT).show()
                        startActivity(Intent(applicationContext,NvRamHomeScreen::class.java))
                    }else{
                        Toast.makeText(applicationContext,"CODE: " + it.code,Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }

    }
}