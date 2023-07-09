package com.example.pyz.app

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.multidex.MultiDex

class Myapplication : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}