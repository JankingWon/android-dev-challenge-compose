package com.example.androiddevchallenge.ui.page

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.LoginActivity
import com.example.androiddevchallenge.ui.theme.DarkColorPalette
import com.example.androiddevchallenge.ui.theme.LightColorPalette
import com.example.androiddevchallenge.ui.widget.RoundButton
import com.example.androiddevchallenge.util.ComposeContent
import com.example.androiddevchallenge.R


val WelcomePage: ComposeContent = {
    Image(
        painter = painterResource(R.drawable.ic_welcome_bg),
        contentDescription = "welcome_bg",
        modifier = Modifier.fillMaxWidth(),
        contentScale = ContentScale.FillWidth
    )
    Column(
        Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.ic_welcome_illos),
            contentDescription = "welcome_illos",
            modifier = Modifier
                .padding(top = 72.dp)
                .align(Alignment.End)
        )
        //Bloom
        Image(
            painter = painterResource(R.drawable.ic_logo),
            contentDescription = "logo",
            modifier = Modifier
                .padding(top = 48.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = "Beautiful home garden solutions",
            style = MaterialTheme.typography.subtitle1,
            color = colorResource(id = R.color.text),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .paddingFromBaseline(top = 32.dp)
        )
        //注册
        RoundButton(
            text = "Create account",
            modifier = Modifier
                .padding(top = 40.dp, start = 16.dp, end = 16.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            //todo register
        }
        val context = LocalContext.current
        //登录
        Text(
            text = "Log in",
            style = MaterialTheme.typography.button,
            color = colorResource(id = R.color.text_click),
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp)
                .align(Alignment.CenterHorizontally)
                .clickable {
                    context.startActivity(
                        Intent(
                            context,
                            LoginActivity::class.java
                        )
                    )
                }
        )
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MaterialTheme(colors = LightColorPalette) {
        WelcomePage()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MaterialTheme(colors = DarkColorPalette) {
        WelcomePage()
    }
}
