package com.example.loginpage.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen(){
    object SignUpScreen:Screen()
    object termsandconditions:Screen()

}
object PostOfficeAppRouter{
    var currentScreen: MutableState<Screen> = mutableStateOf(Screen.SignUpScreen)
    fun navigateTo(destination:Screen){
        currentScreen.value=destination
    }
}