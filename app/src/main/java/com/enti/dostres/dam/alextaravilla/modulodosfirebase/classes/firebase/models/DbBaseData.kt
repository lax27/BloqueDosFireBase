package com.enti.dostres.dam.alextaravilla.modulodosfirebase.classes.firebase.models

interface DbBaseData {

    var id: String?

    fun getTable(): String
}