package com.enti.dostres.dam.alextaravilla.modulodosfirebase.classes.firebase.models

import java.util.Date

data class DbUser(
   override var id: String? = null,
    var email: String? = null,
    var usurname: String? = null,
    var photoPath: String? = null,
    var lasLogin: Date? = Date(),
    val isAdmin: Boolean = false,
) :DbBaseData {
    override fun getTable() = "Users"
}