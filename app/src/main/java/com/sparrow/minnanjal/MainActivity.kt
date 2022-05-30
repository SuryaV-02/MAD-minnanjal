package com.sparrow.minnanjal

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_emailSender =findViewById<Button>(R.id.btn_sendEmail)
        btn_emailSender.setOnClickListener{
            sendMail()
        }
    }

    private fun sendMail() {
        val etEmail =  findViewById<EditText>(R.id.et_mail)
        val etSubject =  findViewById<EditText>(R.id.et_subjectMessage)
        val etContent =  findViewById<EditText>(R.id.et_content)
        val userAddress = etEmail!!.text.toString()
        val userSubject = etSubject!!.text.toString()
        val userMessage = etContent!!.text.toString()

        val mailIntent: Intent = Intent(Intent.ACTION_SEND)
        mailIntent.data = Uri.parse("mailto")
        mailIntent.type = "text/plain"

        val emailAddress  = arrayOf<String>(userAddress)
        print(emailAddress)
        mailIntent.putExtra(Intent.EXTRA_EMAIL,emailAddress)
        mailIntent.putExtra(Intent.EXTRA_SUBJECT,userSubject)
        mailIntent.putExtra(Intent.EXTRA_TEXT,userMessage)
        startActivity(Intent.createChooser(mailIntent,"Send Email"))
    }
}