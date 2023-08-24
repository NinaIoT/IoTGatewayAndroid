package com.example.iotgateway

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUI()
    }
    private fun initUI(){
        setContentView(R.layout.activity_main)
        val connectBtn = findViewById<Button>(R.id.connect_btn)
        connectBtn.setOnClickListener{
            connectMqttServer()
        }
    }
    private fun connectMqttServer(){

    }
}