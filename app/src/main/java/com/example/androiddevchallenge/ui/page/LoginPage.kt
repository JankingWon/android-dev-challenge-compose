package com.example.androiddevchallenge.ui.page

import android.content.Context
import android.content.Intent
import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults.outlinedTextFieldColors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.HomeActivity
import com.example.androiddevchallenge.LoginActivity
import com.example.androiddevchallenge.ui.theme.MyMaterialTheme
import com.example.androiddevchallenge.ui.theme.gray
import com.example.androiddevchallenge.ui.theme.white
import com.example.androiddevchallenge.ui.widget.RoundButton
import com.example.androiddevchallenge.util.ComposeContent

val LoginPage: ComposeContent = {
    fun login(context : Context){
        context.startActivity(
            Intent(
                context,
                HomeActivity::class.java
            )
        )
    }

    Column(Modifier.fillMaxSize()) {
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        val context = LocalContext.current
        // initialize focus reference to be able to request focus programmatically
        val focusRequester = FocusRequester()
        Text(
            text = "Log in with email",
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .paddingFromBaseline(top = 184.dp)
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            textStyle = MaterialTheme.typography.body1,
            singleLine = true,
            label = {
                Text(
                    text = "Email address",
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onPrimary,
                )
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(top = 8.dp, start = 16.dp, end = 16.dp)
                .height(56.dp),
            colors = outlinedTextFieldColors(
                textColor = MaterialTheme.colors.onPrimary,
                cursorColor = MaterialTheme.colors.onPrimary,
                focusedBorderColor = MaterialTheme.colors.onPrimary,
                unfocusedBorderColor = MaterialTheme.colors.onPrimary,
            ),
            keyboardOptions = KeyboardOptions(
              imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusRequester.requestFocus()
                }
            )
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            textStyle = MaterialTheme.typography.body1,
            singleLine = true,
            label = {
                Text(
                    text = "Password(8+ characters)",
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onPrimary,
                )
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(top = 8.dp, start = 16.dp, end = 16.dp)
                .height(56.dp)
                .focusRequester(focusRequester),
            colors = outlinedTextFieldColors(
                textColor = MaterialTheme.colors.onPrimary,
                cursorColor = MaterialTheme.colors.onPrimary,
                focusedBorderColor = MaterialTheme.colors.onPrimary,
                unfocusedBorderColor = MaterialTheme.colors.onPrimary,
            ),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Send
            ),
            keyboardActions = KeyboardActions(
                onSend = {
                    login(context)
                }
            )
        )
        Text(
            text = AnnotatedString.Builder().apply {
                append("By clicking below, you agree to our ")
                pushStyle(SpanStyle(
                    textDecoration = TextDecoration.Underline
                ))
                append("Terms of Use")
                pop()
                append("and consent to our ")
                pushStyle(SpanStyle(
                    textDecoration = TextDecoration.Underline
                ))
                append("Privacy Policy.")
                pop()
            }.toAnnotatedString(),
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .paddingFromBaseline(top = 24.dp)
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth()
        )
        RoundButton(
            text = "Log in",
            onClick = {
                login(context)
            },
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
@Preview
fun previewLoginPage() {
    MyMaterialTheme(LoginPage)
}