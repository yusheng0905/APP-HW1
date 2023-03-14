package com.example.hw1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val button = findViewById<Button>(R.id.button2)
        button.setOnClickListener {
            intent?.extras?.let {

                val value1 = it.getString("Key1")
                val value2 = it.getString("Key2")
                val editText3 = findViewById<EditText>(R.id.editTextTextPersonName3)
                val editText4 = findViewById<EditText>(R.id.editTextTextPersonName4)

                val bundle = Bundle()
                bundle.putString("Key1", value1)
                bundle.putString("Key2", value2)
                bundle.putString("Key3", editText3.text.toString())
                bundle.putString("Key4", editText4.text.toString())
                val intent = Intent().putExtras(bundle)
                setResult(Activity.RESULT_OK, intent.putExtras(bundle))
                finish()
            }
        }
    }
}