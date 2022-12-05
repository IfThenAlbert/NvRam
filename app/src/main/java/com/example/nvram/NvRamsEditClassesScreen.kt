package com.example.nvram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import com.parse.ParseObject
import com.parse.ParseUser
import com.parse.SaveCallback
/*
    NvRamsEditClassesScreen
    ALBERT ANG
 */
class NvRamsEditClassesScreen : AppCompatActivity() {
    @BindView(R.id.inp_add_class_building)
    lateinit var inp_add_class_building:EditText
    @BindView(R.id.inp_add_class_name)
    lateinit var inp_add_class_name:EditText
    @BindView(R.id.inp_add_class_id)
    lateinit var inp_add_class_id:EditText
    @BindView(R.id.inp_add_class_professor)
    lateinit var inp_add_class_professor:EditText

    @BindView(R.id.btn_add_class)
    lateinit var btn_add_class:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nv_rams_edit_classes_screen)
        ButterKnife.bind(this)
        val cUser: ParseUser = ParseUser.getCurrentUser()

        if(cUser == null) {
            startActivity(Intent(applicationContext,NvRamLogInScreen::class.java))
            return
        }

        btn_add_class.setOnClickListener{
            var aUserClasses:ParseObject = ParseObject("UserClasses")
            aUserClasses.put("ramid",cUser.getString("ramid").toString())
            aUserClasses.put("classid",inp_add_class_id.text.toString())
            aUserClasses.put("classname",inp_add_class_name.text.toString())
            aUserClasses.put("classbuilding",inp_add_class_building.text.toString())
            aUserClasses.put("professor",inp_add_class_professor.text.toString())

            aUserClasses.saveInBackground(SaveCallback {
                if(it == null) {
                    Toast.makeText(applicationContext,"ADDED TO YOUR LIST",Toast.LENGTH_SHORT).show()
                }
            })

        }

    }

}