package com.example.email

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etEmail : EditText = findViewById(R.id.etEmail)
        val etSubject : EditText = findViewById(R.id.etSubject)
        val etText : EditText = findViewById(R.id.etText)
        val btSend : Button = findViewById(R.id.btSend)

        btSend.setOnClickListener{
            var email = etEmail.text.toString()
            var subject = etSubject.text.toString()
            var text = etText.text.toString()

            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL,arrayOf(email))
            intent.putExtra(Intent.EXTRA_SUBJECT,subject)
            intent.putExtra(Intent.EXTRA_TEXT,text)

            intent.type="message/rfc822"
            startActivity(Intent.createChooser(intent,"Kindly choose a client..!"))

        }
    }
}