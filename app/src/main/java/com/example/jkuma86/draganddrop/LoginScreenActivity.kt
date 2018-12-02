package com.example.jkuma86.draganddrop

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login_screen.*

class LoginScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        etUsername.setOnFocusChangeListener { _, b ->

            username.isHintEnabled = !(!b && etUsername.text.toString().trim().isEmpty())
        }

        etPassword.setOnFocusChangeListener { _, b ->
            password.isHintEnabled = !(!b && etPassword.text.toString().trim().isEmpty())
        }
    }
}
