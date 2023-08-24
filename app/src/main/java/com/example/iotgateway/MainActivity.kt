package com.example.iotgateway

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import info.mqtt.android.service.MqttAndroidClient
import org.eclipse.paho.client.mqttv3.MqttClient
import org.eclipse.paho.client.mqttv3.MqttMessage

class MainActivity : AppCompatActivity() {
    private val serverIp = "tcp://10.0.2.2:1883"
    lateinit var mqttclient: MqttAndroidClient

    val TOPIC_PUB = "/iot_study"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUI()
    }
    private fun initUI(){
        setContentView(R.layout.activity_main)
        val connectBtn = findViewById<Button>(R.id.connect_btn)

        val pubMsgBtn = findViewById<Button>(R.id.pub_msg_btn)

        connectBtn.setOnClickListener{
            connectMqttServer()
        }
        pubMsgBtn.setOnClickListener{
            publishMqttMsg()
        }
    }
    private fun connectMqttServer(){
        //Read EditText host_ip_editText
        val hostTextView = findViewById<EditText>(R.id.mqtt_host_ip)
        val hostString = "tcp://"+hostTextView.text.toString()+":1883"

        Log.d("IOT_STUDY","hostIpString : ${hostString}")
        //mqtt init

        mqttclient = MqttAndroidClient(applicationContext, hostString, MqttClient.generateClientId())
        //connect server

    }
    private fun publishMqttMsg(){
        // Read EditText pub_msg_editText
        val pubTextView = findViewById<EditText>(R.id.host_ip_editText)
        val pubMsgString = pubTextView.text.toString()
        Log.d("IOT_STUDY","pubMsgString : ${pubMsgString}")
        // Public mqtt message
        mqttclient.publish(TOPIC_PUB, MqttMessage(pubMsgString.toByteArray()))
    }
}