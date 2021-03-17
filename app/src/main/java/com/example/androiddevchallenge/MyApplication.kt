package com.example.androiddevchallenge

import android.app.Application
import android.content.Context
import com.example.androiddevchallenge.util.GlobalContext

/**
 * @author n16455 on 2021/3/17.
 **/
class MyApplication : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        GlobalContext = base!!
    }
}