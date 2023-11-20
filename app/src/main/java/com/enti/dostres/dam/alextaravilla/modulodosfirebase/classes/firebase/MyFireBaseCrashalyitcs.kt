package com.enti.dostres.dam.alextaravilla.modulodosfirebase.classes.firebase

import com.google.firebase.crashlytics.KeyValueBuilder
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.crashlytics.setCustomKeys
import com.google.firebase.ktx.Firebase



class MyFireBaseCrashalyitcs {
    private val crashalyitcs = Firebase.crashlytics

    fun LogSimpleError(text:String, addExtraDataFun: (KeyValueBuilder.() -> Unit)? = null){
        LogError(Exception(text),addExtraDataFun)
    }

    fun LogError(exception: Exception, addExtraDataFun: (KeyValueBuilder.() -> Unit)? = null){
        addExtraDataFun?.let { addExtraDataFun ->
            val builder = KeyValueBuilder(crashalyitcs)
            builder.addExtraDataFun()
        }
        crashalyitcs.recordException(exception)
    }
}