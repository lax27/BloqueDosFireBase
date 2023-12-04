package com.enti.dostres.dam.alextaravilla.modulodosfirebase.classes.firebase

import android.app.Application
import com.enti.dostres.dam.alextaravilla.modulodosfirebase.classes.firebase.models.DbUser
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth

class MyFireBaseAuth(val appContext: Application) {

    private val fireBaseAuth = FirebaseAuth.getInstance()
    private var currentUser: DbUser? = null

    fun getUser() = currentUser

    fun setCurrentUser(newUser: DbUser){
        currentUser = newUser
    }

    fun getAuthDbUser() : DbUser? {

        fireBaseAuth.currentUser?.let { user ->
            val dbUser = DbUser(id = user.uid, email = user.email, usurname = user.displayName, photoPath = user.photoUrl.toString())

            return dbUser
        }
        return null
    }

}