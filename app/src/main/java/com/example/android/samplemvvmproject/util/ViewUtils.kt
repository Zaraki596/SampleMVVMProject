package com.example.android.samplemvvmproject.util

import android.content.Context
import android.widget.Toast

fun Context.toastS(message : String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
fun Context.toastL(message : String){
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}