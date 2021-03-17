/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.content.Intent
import android.graphics.drawable.PaintDrawable
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.*
import com.example.androiddevchallenge.ui.widget.RoundButton
import com.example.androiddevchallenge.util.toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMaterialTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.primary)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_light_welcome_bg),
            contentDescription = "welcome_bg",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Column(
            Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(R.drawable.ic_light_welcome_illos),
                contentDescription = "welcome_illos",
                modifier = Modifier
                    .padding(top = 72.dp)
                    .align(Alignment.End)
            )
            //Bloom
            Image(
                painter = painterResource(R.drawable.ic_light_logo),
                contentDescription = "logo",
                modifier = Modifier
                    .padding(top = 48.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = "Beautiful home garden solutions",
                color = gray,
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.align(Alignment.CenterHorizontally)
                    .paddingFromBaseline(top = 32.dp)
            )
            //注册
            RoundButton(
                text = stringResource(id = R.string.btn_register),
                modifier = Modifier
                    .padding(top = 40.dp, start = 8.dp, end = 8.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                //todo register
            }
            val context = LocalContext.current
            //登录
            Text(
                text = "Log in",
                style = MaterialTheme.typography.button,
                color = pink900,
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
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MaterialTheme(colors = LightColorPalette) {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MaterialTheme(colors = DarkColorPalette) {
        MyApp()
    }
}
