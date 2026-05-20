package com.example.travelpackginglist

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val tvOutput = findViewById<TextView>(R.id.tvOutput)

        if (MainActivity.itemNames.isEmpty()){
            tvOutput.text = "No items added yet"
        }else{
            val sb = StringBuilder()
            for (i in MainActivity.itemNames.indices){
                sb.append(" -${i + 1}.${MainActivity.itemNames[1]}")
                sb.append("-Qty: ${MainActivity.quantities[i]}")
                if (MainActivity.comments[i].isNotEmpty()){
                    sb.append("-${MainActivity.comments}")
                }
                sb.append("/n/n")
            }
            tvOutput.text = sb.toString()
        }
    }
}