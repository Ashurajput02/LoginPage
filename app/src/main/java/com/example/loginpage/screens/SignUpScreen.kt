package com.example.loginpage.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginpage.R
import com.example.loginpage.components.ButtonEvents
import com.example.loginpage.components.CheckBoxComponent
import com.example.loginpage.components.Dividerera
import com.example.loginpage.components.HeadingTextComponents
import com.example.loginpage.components.MyTextField
import com.example.loginpage.components.NormalTextComponents
import com.example.loginpage.components.PasswordField
import com.example.loginpage.navigation.PostOfficeAppRouter
import com.example.loginpage.navigation.Screen

@Composable
fun SignUpScreen() {
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp)
    ) {
        Column(
            modifier=Modifier.fillMaxSize()

        ) {
            NormalTextComponents(value = stringResource(id = R.string.hello),24)
            HeadingTextComponents(value = stringResource(id = R.string.create_account))
            Spacer(modifier=Modifier
                .height(20.dp))
            MyTextField(labelValue= stringResource(id = R.string.firstname))
            Spacer(modifier=Modifier
                .height(10.dp))
            MyTextField(labelValue= stringResource(id = R.string.lasttname))
            Spacer(modifier=Modifier
                .height(10.dp))
            MyTextField(labelValue= stringResource(id = R.string.email))

            Spacer(modifier=Modifier
                .height(10.dp))
            PasswordField(labelValue= stringResource(id = R.string.password))

            Spacer(modifier = Modifier
                .height(10.dp))
            CheckBoxComponent(value=stringResource(id = R.string.policy), 18, onTextSelected = {
                PostOfficeAppRouter.navigateTo(Screen.termsandconditions)
            })
            Spacer(modifier = Modifier
                .height(80.dp))
            ButtonEvents(value= stringResource(id = R.string.register))

            Spacer(modifier=Modifier
                .height(10.dp))
            Dividerera(value= stringResource(id = R.string.other))
        }
    }
}


@Preview
@Composable
fun DefaultPreviewOfSignUpScreen(){
    SignUpScreen()
    
}