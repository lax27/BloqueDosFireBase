package com.enti.dostres.dam.alextaravilla.modulodosfirebase.classes.firebase

import android.app.Application
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

class MyFireBaseAnalitycs(private val appContex: Application) {

    private val analitycs = FirebaseAnalytics.getInstance(appContex)

    fun LogOpenApp(){
        val bundle = Bundle()
        analitycs.logEvent(FirebaseAnalytics.Event.APP_OPEN,bundle)
    }
}