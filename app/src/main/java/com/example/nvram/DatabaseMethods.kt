package com.example.nvram

import com.parse.FindCallback
import com.parse.ParseObject
import com.parse.ParseQuery

class DatabaseMethods {

    //  creates a username for the user
    public fun generateUsername(fn:String,ln:String): String {
        var nUser:String = ln.toString() + ""+fn.get(0)+ ""+fn.get(1)
        return  nUser
    }

}