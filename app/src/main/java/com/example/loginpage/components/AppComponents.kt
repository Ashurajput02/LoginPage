package com.example.loginpage.components

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginpage.R
import com.example.loginpage.navigation.Screen
import com.example.loginpage.ui.theme.componentShapes


@Composable
fun NormalTextComponents(value:String,textsize:Int) {
    Text(
        text =value,
        modifier= Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = textsize.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal

        )
        ,color= colorResource(id = R.color.colorText)
        , textAlign = TextAlign.Center
    )

}

@Composable
fun HeadingTextComponents(value:String) {
    Text(
        text =value,
        modifier= Modifier
            .fillMaxWidth(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal

        )
        ,color= colorResource(id = R.color.colorText)
        , textAlign = TextAlign.Center
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(labelValue: String) {
    val textValue = remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.small)
            ,
        label = { Text(text = labelValue) },
        value = textValue.value,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.colorPrimary),
            focusedLabelColor = colorResource(id = R.color.colorPrimary),
            cursorColor = colorResource(id = R.color.colorPrimary)
        ),
        keyboardOptions = KeyboardOptions.Default,
        onValueChange = { textValue.value=it}

    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField(labelValue: String) {
    val password = remember {
        mutableStateOf("")
    }

    val passwordvisbile= remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.small)
        ,
        label = { Text(text = labelValue) },
        value = password.value, // khaali value likhdene se yeh kiski value retrive karega bhai ?
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.colorPrimary),
            focusedLabelColor = colorResource(id = R.color.colorPrimary),
            cursorColor = colorResource(id = R.color.colorPrimary)
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        onValueChange = { password.value=it}
        ,
        trailingIcon = {
            val iconImage= if(passwordvisbile.value){
                Icons.Filled.Visibility

            }
            else{
                Icons.Filled.VisibilityOff
            }
            var description=if(passwordvisbile.value){
                stringResource(id = R.string.passwordshow)

            }
            else{
                stringResource(id = R.string.passwordhide)

            }
            IconButton(onClick = { passwordvisbile.value=!passwordvisbile.value}) {
                Icon(imageVector=iconImage,contentDescription=description)


            }
        },
visualTransformation = if(passwordvisbile.value) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@Composable
fun CheckBoxComponent(value: String, textsize: Int, onTextSelected: (String) -> Unit) {
    Row(
        modifier= Modifier
            .fillMaxWidth()
            .heightIn(56.dp),
        verticalAlignment= Alignment.CenterVertically
    ){
        val checkedstate=remember{
            mutableStateOf(true)
        }

        Checkbox(checked=checkedstate.value,
            onCheckedChange={
                checkedstate.value!=checkedstate.value
            })
        Annotedpart(value=value,onTextSelected)
         }
}
@Composable
fun Annotedpart(value:String,onTextSelected:(String) -> Unit){
    val initialText = "By continuing you accept our"
    val privacy = "Privacy policy"
    val andText = " and "
    val use = "Terms of use"
    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = colorResource(id = R.color.colorPrimary))) {
            append(" ")
            pushStringAnnotation(tag = privacy, annotation = privacy)
            append(privacy)

        }
        append(andText)
        withStyle(style = SpanStyle(color = colorResource(id = R.color.colorPrimary))) {
            pushStringAnnotation(tag = use, annotation = use)
            append(use)
        }
    }
    ClickableText(text =annotatedString , onClick ={offset ->
        annotatedString.getStringAnnotations(offset,offset)
            .firstOrNull()?.also{ span->

                Log.d("Cilckable Text Component","{$span")
                if(span.item == use || (span.item==privacy) ){
                    onTextSelected(span.item)
                }
            }
    } )

}

@Composable
fun ButtonEvents(value:String){

    Button( {},
        modifier= Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ){
         Box(  modifier= Modifier
             .fillMaxWidth()
             .heightIn(48.dp)
             .background(
                 brush = Brush.horizontalGradient(
                     listOf(
                         colorResource(id = R.color.colorSecondary),
                         colorResource(id = R.color.colorPrimary)
                     )

                 ),
                 shape = RoundedCornerShape(50.dp)
             )
             ,
             contentAlignment = Alignment.Center
             ){
             Text(text=value,
                 fontSize = 18.sp,
                 fontWeight = FontWeight.Bold)
         }
    }
}
@Composable
fun Dividerera(value:String){
    Row(modifier=Modifier
        .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){

        Divider(modifier= Modifier
            .fillMaxWidth()
            .weight(1f),
            color= colorResource(id = R.color.colorGray),
            thickness=1.dp)

        Text(modifier=Modifier
            .padding(18.dp)
            ,text = value, fontSize = 14.sp,color= colorResource(id = R.color.colorText))

        Divider(modifier= Modifier
            .fillMaxWidth()
            .weight(1f),
            color= colorResource(id = R.color.colorGray),
            thickness=1.dp)


    }
}