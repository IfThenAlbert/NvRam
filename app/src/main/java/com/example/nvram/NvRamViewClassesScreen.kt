package com.example.nvram

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import com.parse.FindCallback
import com.parse.ParseObject
import com.parse.ParseQuery
import com.parse.ParseUser
/*
    NvRamViewClassesScreen
    ALBERT ANG
 */
class NvRamViewClassesScreen : AppCompatActivity() {
    @BindView(R.id.lstv_all_my_classes)
    lateinit var lstv_all_my_classes:ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nv_ram_view_classes_screen)
        ButterKnife.bind(this)

        val cUser: ParseUser = ParseUser.getCurrentUser()

        if(cUser == null) {
            startActivity(Intent(applicationContext,NvRamLogInScreen::class.java))
            return
        }

        var q = ParseQuery.getQuery<ParseObject>("UserClasses")
        q.whereEqualTo("ramid",cUser.getString("ramid").toString())
        var d1:ArrayList<String> = ArrayList<String>()

        q.findInBackground(FindCallback { objects, e ->
            if(e == null) {
                objects.forEach{
                    d1.add(it.getString("classname").toString() + " is in " + it.getString("classbuilding").toString() + "\nCLASS ID: " +it.getString("classid").toString() )
                }

                 var w:ArrayAdapter<String> = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1,d1)
                lstv_all_my_classes.adapter = w
            }

        })



    }
}