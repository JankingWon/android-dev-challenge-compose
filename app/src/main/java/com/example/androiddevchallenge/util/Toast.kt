package com.example.androiddevchallenge.util

import android.widget.Toast
import kotlin.coroutines.coroutineContext

fun toast(msg : String){
    Toast.makeText(GlobalContext, msg, Toast.LENGTH_SHORT).show()
}