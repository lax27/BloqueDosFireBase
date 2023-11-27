package com.enti.dostres.dam.alextaravilla.modulodosfirebase.fragments

import android.app.Activity.RESULT_OK
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.enti.dostres.dam.alextaravilla.modulodosfirebase.R
import com.enti.dostres.dam.alextaravilla.modulodosfirebase.classes.firebase.FB
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.common.SignInButton
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class LoginScreen: Fragment() {


    lateinit var fragmentView: View

    val usernameContainer by lazy { fragmentView.findViewById<MaterialCardView>(R.id.usernameInputContainer) }
    val usernameField by lazy { fragmentView.findViewById<TextInputLayout>(R.id.usernameInput) }

    val passwordContainer by lazy { fragmentView.findViewById<MaterialCardView>(R.id.passwordInputContainer) }
    val passwordField by lazy { fragmentView.findViewById<TextInputLayout>(R.id.passwordInput) }

    val verifyPasswordContainer by lazy { fragmentView.findViewById<MaterialCardView>(R.id.verifyPasswordInputContainer) }
    val verifyPasswordField by lazy { fragmentView.findViewById<TextInputLayout>(R.id.verifyPasswordInput) }

    val emailLoginButton by lazy { fragmentView.findViewById<MaterialButton>(R.id.loginButton) }
    val registerButton by lazy { fragmentView.findViewById<MaterialButton>(R.id.loginButton) }
    val googleAuthButton by lazy { fragmentView.findViewById<SignInButton>(R.id.login_google_button) }

    val singInLauncher = registerForActivityResult(
        FirebaseAuthUIActivityResultContract()
    ){ res ->
        this.onSingInResult(res)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentView = inflater.inflate(R.layout.login_screen,container,false)

        return fragmentView
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        emailLoginButton.setOnClickListener{ emailLogin()}
        registerButton.setOnClickListener { startRegister() }
        googleAuthButton.setOnClickListener{googleAuth()}

    }

    private fun emailLogin() {

    }

    private fun startRegister(){
        verifyPasswordContainer.visibility = View.VISIBLE

        emailLoginButton.text = getString(R.string.back_to_login_button)
        registerButton.text = getString(R.string.finish_register_button)
        
        emailLoginButton.setOnClickListener { 
            
            verifyPasswordContainer.visibility = View.GONE
            
            emailLoginButton.text = getString(R.string.login_button)
            emailLoginButton.setOnClickListener { emailLogin() }

            registerButton.text = getString(R.string.register_button)
            registerButton.setOnClickListener { startRegister() }
        }

        registerButton.setOnClickListener { endRegister() }
    }

    private fun endRegister(){

    }

    private fun googleAuth(){
        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build(),
        )

        val singInIntent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .build()

        singInLauncher.launch(singInIntent)
    }

    private fun onSingInResult(result: FirebaseAuthUIAuthenticationResult){
        if(result.resultCode == RESULT_OK){

            parentFragmentManager.popBackStack()

            FB.auth.getUser()?.let { user ->

                Snackbar.make(AppDrawer.get().fragmentView,getString(R.string.user_login_message, user.displayName),
                    Snackbar.LENGTH_LONG).show()
            } ?:{

                FB.crashalyitcs.LogSimpleError("Login Error no User"){
                    key("code", result.resultCode)
                    key("data",result.toString())
                }

                Snackbar.make(AppDrawer.get().fragmentView,
                    getString(R.string.login_error),
                    Snackbar.LENGTH_LONG).show()


            }

        } else{

            FB.crashalyitcs.LogSimpleError("Login Error no User"){
                key("code", result.resultCode)
                key("data",result.toString())
            }

            Snackbar.make(AppDrawer.get().fragmentView,
            getString(R.string.login_error),
            Snackbar.LENGTH_LONG).show()

        }



    }
}