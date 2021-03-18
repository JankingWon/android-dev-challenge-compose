package com.example.androiddevchallenge.ui.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.google.android.material.color.MaterialColors

@Composable
fun RoundButton(text : String, modifier: Modifier = Modifier, onClick : ()->Unit){
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .clip(MaterialTheme.shapes.medium)
            .background(MaterialTheme.colors.secondary)
            .clickable {
                onClick()
            }
    ){
        Text(
            text = text,
            style = MaterialTheme.typography.button,
            color = colorResource(id = R.color.text_reverse),
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Preview
@Composable
fun PreviewRoundButton(){
    RoundButton(text = "Create account", onClick = { })
}