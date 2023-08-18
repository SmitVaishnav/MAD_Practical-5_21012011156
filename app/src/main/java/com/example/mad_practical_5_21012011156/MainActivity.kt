package com.example.mad_practical_5_21012011156

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonBrowse:Button=findViewById(R.id.button_browse)
        val editUrl:EditText=findViewById(R.id.editTextURL)
        buttonBrowse.setOnClickListener{
            Browse(editUrl.text.toString())
        }

        
    }
    fun Browse(url:String){
        Intent(Intent.ACTION_VIEW, Uri.parse(url )).also{startActivity(it)}
    }
    fun Call(number:String){
        Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:$number")).also { startActivity(it) }
    }
    fun OpenCallLog(){
        Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).also { startActivity(it) }
    }
    fun OpenGalllery(){
        Intent(Intent.ACTION_VIEW).setType("image/*").also { startActivity(it) }
    }

    fun OpenCamera(){
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { startActivity(it) }

    }

    fun OpenAlarm(){
        Intent(AlarmClock.ACTION_SHOW_ALARMS).also { startActivity(it) }

    }



}