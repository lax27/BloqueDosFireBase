package com.enti.dostres.dam.alextaravilla.modulodosfirebase

import android.app.Application
import com.enti.dostres.dam.alextaravilla.modulodosfirebase.classes.firebase.FB
import com.enti.dostres.dam.alextaravilla.modulodosfirebase.classes.firebase.MyFireBase

class MyApp:Application() {

    companion object {
        private lateinit var Instance: MyApp
        fun get() = Instance
    }

    override fun onCreate() {
        super.onCreate()
        Instance = this
        //enviar envento de que la app se a abierto
        FB.init(this)
        FB.analytics.LogOpenApp()

        FB.crashalyitcs.LogSimpleError("On Open app Error"){
            key("Name","no se abre jaja")
            key("es un error",true)
        }

    }
}