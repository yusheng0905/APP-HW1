package com.example.hw1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {

            val editText1 = findViewById<EditText>(R.id.editTextTextPersonName)
            val editText2 = findViewById<EditText>(R.id.editTextTextPersonName2)
            val bundle = Bundle()
            bundle.putString("Key1", editText1.text.toString())
            bundle.putString("Key2", editText2.text.toString())

            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtras(bundle)
            startActivityForResult(intent, 1)

        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        data?.extras?.let{

            if(requestCode == 1 && resultCode == Activity.RESULT_OK){
                findViewById<TextView>(R.id.textView2).text =
                    "名字: ${it.getString("Key1")}\n" +
                            "性別: ${it.getString("Key2")}\n" +
                            "尺寸: ${it.getString("Key3")}\n" +
                            "顏色: ${it.getString("Key4")}\n"
            }
        }
    }
}