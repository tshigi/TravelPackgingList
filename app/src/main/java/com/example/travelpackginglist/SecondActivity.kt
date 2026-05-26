package com.example.travelpackginglist

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val tvOutput = findViewById<TextView>(R.id.tvOutput)

        val itemNames = intent.getStringArrayListExtra("Item_Names")?: ArrayList()
        val categories = intent.getStringArrayListExtra("Categories")?: ArrayList()
        val comments = intent.getStringArrayListExtra("Comments")?: ArrayList()
        val quantities = intent.getIntegerArrayListExtra("Quantities")?: ArrayList()

        if (itemNames.isEmpty()){
            tvOutput.text = "No items added yet"
        }else{
            val sb = StringBuilder()
            for (i in itemNames.indices){
                sb.append(" -${i + 1}.${itemNames[i]}\n")
                sb.append("-Qty: ${quantities[i]}")
                if (comments[i].isNotEmpty()){
                    sb.append("-${comments}")
                }
                sb.append("/n/n")
            }
            tvOutput.text = sb.toString()
        }
    }
}