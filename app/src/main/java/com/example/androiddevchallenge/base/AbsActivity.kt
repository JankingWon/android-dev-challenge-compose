package com.example.androiddevchallenge.base

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import com.example.androiddevchallenge.ui.theme.MyMaterialTheme
import com.example.androiddevchallenge.util.ComposeContent

/**
 * @author n16455 on 2021/3/18.
 **/
open class AbsActivity(val composeContent: ComposeContent) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.run {
            //这个是之前的透明状态栏做法，有一层遮罩，效果不是很好，弃用了
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            //设置内容全屏， 设置状态栏字体颜色还是跟随系统
            decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            //表示使用statusBarColor来当状态栏背景色
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            //设置状态栏背景透明
            statusBarColor = Color.TRANSPARENT
//            decorView.windowInsetsController.setSystemBarsAppearance(WindowInsetsController.APPEARANCE_OPAQUE_STATUS_BARS, )
        }
        setContent {
            if (isSystemInDarkTheme()) {
                window?.decorView?.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
            } else {
                window?.decorView?.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
            }
            MyMaterialTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.background)
                ) {
                    composeContent()
                }
            }
        }
    }
}