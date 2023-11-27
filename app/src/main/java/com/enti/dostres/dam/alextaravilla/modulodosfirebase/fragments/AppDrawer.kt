package com.enti.dostres.dam.alextaravilla.modulodosfirebase.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.enti.dostres.dam.alextaravilla.modulodosfirebase.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class AppDrawer: Fragment() {

    companion object{
        lateinit var Instance: AppDrawer

        fun get() = Instance
    }



    lateinit var fragmentView: View

    lateinit var drawer: DrawerLayout
    lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Instance = this
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentView = inflater.inflate(R.layout.component_navigationdrawer,container,false)

        drawer = fragmentView.findViewById(R.id.AppDrawer)
        navigationView = fragmentView.findViewById(R.id.navigationDrawer)


        return fragmentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigationView.setNavigationItemSelectedListener { menuItem ->

            when(menuItem.itemId)
            {
                R.id.login_drawer_button -> {
                    var loginScreen = LoginScreen()
                    val transaction = childFragmentManager.beginTransaction()
                    transaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_right,R.anim.enter_from_right,R.anim.exit_to_right)
                    transaction.replace(R.id.reusableDiaLogsContainer,loginScreen)
                        .addToBackStack(null)
                        .commit()
                    drawer.closeDrawers()
                }

            }
            true
        }
    }

    fun open(){
        drawer.open()
    }

}