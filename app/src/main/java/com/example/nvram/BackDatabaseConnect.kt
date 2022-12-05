package com.example.nvram

import android.app.Application
import com.parse.Parse

/*
        BackDatabaseConnect
        Albert Ang
 */


class BackDatabaseConnect:Application() {

    override fun onCreate() {
        super.onCreate()

        Parse.initialize(Parse.Configuration.Builder(applicationContext)
            .applicationId(getString(R.string.database_id))
            .clientKey(getString(R.string.database_client))
            .server(getString(R.string.database_server)).build())
    }

}