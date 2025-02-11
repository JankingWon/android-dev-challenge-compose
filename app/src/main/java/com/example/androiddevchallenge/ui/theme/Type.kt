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
package com.example.androiddevchallenge.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val typography = Typography(
    h1 = TextStyle(
        fontSize = 18.sp,
        letterSpacing = 0.sp,
        fontWeight = FontWeight.Bold
    ),
    h2 = TextStyle(
        fontSize = 15.sp,
        letterSpacing = 0.15.sp,
        fontWeight = FontWeight.Bold
    ),
    subtitle1 = TextStyle(
        fontSize = 16.sp,
        letterSpacing = 0.sp,
        fontWeight = FontWeight.Light
    ),
    body1 = TextStyle(
        fontSize = 14.sp,
        letterSpacing = 0.sp,
        fontWeight = FontWeight.Light
    ),
    body2 = TextStyle(
        fontSize = 12.sp,
        letterSpacing = 0.sp,
        fontWeight = FontWeight.Light
    ),
    button = TextStyle(
        fontSize = 12.sp,
        letterSpacing = 1.sp,
        fontWeight = FontWeight.SemiBold
    ),
    caption = TextStyle(
        fontSize = 12.sp,
        letterSpacing = 0.sp,
        fontWeight = FontWeight.SemiBold
    )
)
