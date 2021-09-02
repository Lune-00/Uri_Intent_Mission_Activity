package com.example.uri_intent_mission_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_input_phone_num.*

class Input_PhoneNum_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_phone_num)


        okBtn.setOnClickListener {

            val newPhoneNum = phoneNumEdt.text.toString()

            val returnIntent = Intent()
            returnIntent.putExtra("newPhoneNum", newPhoneNum)
            setResult(RESULT_OK, returnIntent)
            finish()

        }

    }
}