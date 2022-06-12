package com.example.notes

import android.content.Context
import android.content.Intent

open class Base {

    open fun onCLickIntent(context: Context, context2:Class<*>){
        val intent = Intent(context,context2)
        context.startActivity(intent) }
}