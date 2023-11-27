package com.enti.dostres.dam.alextaravilla.modulodosfirebase.classes.firebase

import android.app.Application
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth

class MyFireBaseAuth(val appContext: Application) {

    private val fireBaseAuth = FirebaseAuth.getInstance()

    fun getUser(): FirebaseUser? {

        return fireBaseAuth.currentUser
    }

}