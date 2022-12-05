package com.example.nvram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import butterknife.BindView
import butterknife.ButterKnife
import com.parse.ParseUser

/*
        NvRamHomeScreen
        Albert Ang
 */

class NvRamHomeScreen : AppCompatActivity() {
    @BindView(R.id.txt_greetings)
    lateinit var txt_greetings:TextView

    @BindView(R.id.crd_view_campus)
    lateinit var crd_view_campus:CardView
    @BindView(R.id.crd_edit_classes)
    lateinit var crd_edit_classes:CardView
    @BindView(R.id.crd_view_schedule)
    lateinit var crd_view_schedule:CardView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nv_ram_home_screen)
        ButterKnife.bind(this)

        val cUser:ParseUser = ParseUser.getCurrentUser()

        if(cUser == null) {
            startActivity(Intent(applicationContext,NvRamLogInScreen::class.java))
            return
        }else{
            txt_greetings.setText("Hello " + cUser.getString("firstname"))
        }

        crd_view_campus.setOnClickListener{
            startActivity(Intent(applicationContext,NvRamMapScreen::class.java))
        }

        crd_edit_classes.setOnClickListener{
            startActivity(Intent(applicationContext,NvRamsEditClassesScreen::class.java))
        }

        crd_view_schedule.setOnClickListener{
            startActivity(Intent(applicationContext,NvRamViewClassesScreen::class.java))
        }

        txt_greetings.setOnClickListener {
            ParseUser.logOut()
            startActivity(Intent(applicationContext,NvRamLogInScreen::class.java))
        }
    }


    override fun onBackPressed() {
        // prevent user from going back
    }
}