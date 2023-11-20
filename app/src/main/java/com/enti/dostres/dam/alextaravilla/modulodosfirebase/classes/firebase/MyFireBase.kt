package com.enti.dostres.dam.alextaravilla.modulodosfirebase.classes.firebase

import android.app.Application
import java.math.MathContext

typealias FB = MyFireBase

class MyFireBase {
    companion object{

        lateinit var analytics: MyFireBaseAnalitycs

        fun init(appContext: Application){
            analytics = MyFireBaseAnalitycs(appContext)
        }
    }
}