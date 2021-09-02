package com.example.uri_intent_mission_activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQUEST_FOR_PHONENUM = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changePhoneNumBtn.setOnClickListener {

            val myIntent = Intent(this, Input_PhoneNum_Activity::class.java)
            myIntent.putExtra("number", phoneNumTxt.text.toString())
            startActivityForResult(myIntent, REQUEST_FOR_PHONENUM)


        }

        dialBtn.setOnClickListener {

            val phoneNum = phoneNumTxt.text.toString()

            val myUri = Uri.parse("tel:${phoneNum}")

            val dialIntent = Intent(Intent.ACTION_DIAL, myUri)
            startActivity(dialIntent)

        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_FOR_PHONENUM){

            if (resultCode == RESULT_OK){

                val resultIntent = data?.getStringExtra("newPhoneNum")
                phoneNumTxt.text = resultIntent

            }
        }
    }

}