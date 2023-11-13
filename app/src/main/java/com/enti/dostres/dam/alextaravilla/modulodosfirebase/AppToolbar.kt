package com.enti.dostres.dam.alextaravilla.modulodosfirebase

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.enti.dostres.dam.alextaravilla.modulodosfirebase.R
import com.google.android.material.appbar.MaterialToolbar

class AppToolbar : Fragment(){

    companion object{
        private lateinit var Instance: AppToolbar

        fun Get() = Instance
    }

    lateinit var toolbar: MaterialToolbar

    override fun onCreate(savedInstancesState: Bundle?){
        super.onCreate(savedInstancesState)
        Instance = this
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.component_toolbar,container,false)
        toolbar = view.findViewById(R.id.appToolBar)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}