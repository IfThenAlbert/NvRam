package com.example.nvram

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class CustomAdapterClass(private val context: Activity, private val classid: Array<String>, private val classnames: Array<String>, private val buildings: Array<String>,
                         private val professors: Array<String>): ArrayAdapter<String>(context,R.layout.custlistclasses,classid) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return super.getView(position, convertView, parent)

        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.custlistclasses, null, true)

        val txtClassName = rowView.findViewById(R.id.lst_txt_class_name) as TextView
        val txtClassId = rowView.findViewById(R.id.lst_txt_class_id) as TextView

        txtClassName.setText(classnames[position] + " with prof. " + professors[position])
        txtClassId.setText("CLASS ID: " + classid[position])

        return  rowView
    }
}