package com.enti.dostres.dam.alextaravilla.modulodosfirebase.classes.firebase

import android.provider.Settings.NameValueTable
import com.enti.dostres.dam.alextaravilla.modulodosfirebase.classes.firebase.models.DbBaseData
import com.enti.dostres.dam.alextaravilla.modulodosfirebase.classes.firebase.models.DbUser
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.lang.Exception
import java.util.Date

class MyFirebaseDataBase {
    val db = Firebase.firestore

    fun<T:DbBaseData> save(data: T,onSuccess: (T) -> Unit,onFailure: (Exception) -> Unit){

        val table = db.collection(data.getTable())

        val id = data.id ?: table.document().id

        data.id = id

        table
            .document(id)
            .set(data)
            .addOnSuccessListener {
                onSuccess(data)
            }
            .addOnFailureListener{ exception ->

                FB.crashalyitcs.LogError(exception){
                    key("Object",data.toString())
                    key("erro type","insert or update error")
                }

                onFailure(exception)
            }
    }

    inline fun <reified T:DbBaseData> find(id: String, tableName: String,
                                           crossinline onSuccess: (T) -> Unit, crossinline onFailure: (Exception) -> Unit){
        val table = db.collection(tableName)
        table
            .document(id)
            .get()
            .addOnSuccessListener {documentSnapshot ->
                val data: T? = documentSnapshot.toObject(T::class.java)

                data?.let { data->

                    onSuccess(data)

                }?:kotlin.run {
                    val exception = Exception("Error On Parse FireStore Document")
                    FB.crashalyitcs.LogError(exception){
                        key("id",id)
                        key("table",tableName)
                        key("Error type","pasre error")
                        key("Error type",documentSnapshot.toString())
                    }
                    onFailure(exception)
                }
            }
            .addOnFailureListener {exception ->
                FB.crashalyitcs.LogError(exception){
                    key("id",id)
                    key("table",tableName)
                    key("Error type","Object not Found")
                }

                onFailure(exception)
            }
    }

}