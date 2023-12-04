package com.enti.dostres.dam.alextaravilla.modulodosfirebase.classes.firebase

import android.app.Application
import java.math.MathContext

typealias FB = MyFireBase

class MyFireBase {
    companion object{

        lateinit var analytics: MyFireBaseAnalitycs
        val crashalyitcs = MyFireBaseCrashalyitcs()
        lateinit var auth: MyFireBaseAuth
        val db = MyFirebaseDataBase()


        fun init(appContext: Application){
            analytics = MyFireBaseAnalitycs(appContext)
            auth = MyFireBaseAuth(appContext)
        }
    }
}