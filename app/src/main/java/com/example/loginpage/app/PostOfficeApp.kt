package com.example.loginpage.app

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.loginpage.screens.SignUpScreen


@Composable
 fun PostOfficeApp(){
     Surface (
     modifier= Modifier
          .fillMaxSize(),
         color= Color.White
     ){
SignUpScreen()
     }
 }