package com.example.androiddevchallenge

import com.example.androiddevchallenge.base.AbsActivity
import com.example.androiddevchallenge.ui.page.HomePage
import com.example.androiddevchallenge.ui.page.LoginPage
import com.example.androiddevchallenge.ui.page.WelcomePage


class WelcomeActivity : AbsActivity(WelcomePage)

class LoginActivity : AbsActivity(LoginPage)

class HomeActivity : AbsActivity(HomePage)