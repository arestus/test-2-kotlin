package com.example.training_task_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private var clickCount = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val clickCountDisplayView = findViewById<TextView>(R.id.clickCountView)
        val clickMeButton = findViewById<TextView>(R.id.clickButton)
        val userNameTextInputView = findViewById<TextInputLayout>(R.id.nameText)
        val allUsers = mutableMapOf("default" to 0)

        clickMeButton.setOnClickListener{

            val userName = userNameTextInputView.editText?.text?.toString()
            val maskedUserName =
                if (userName.isNullOrEmpty()) "Somebody"
                else userName

                    //var neededValue = allUsers.getValue(maskedUserName)
                if (allUsers.containsKey(maskedUserName)) {
                    clickCount = allUsers.getValue(maskedUserName) + 1
                    allUsers.put(maskedUserName, clickCount++)
                }
                else {
                    clickCount = 0
                    allUsers.put(maskedUserName, clickCount++)
                }





            clickCountDisplayView.text = "$maskedUserName clicked $clickCount times"
        }
    }
}