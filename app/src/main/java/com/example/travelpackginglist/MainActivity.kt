package com.example.travelpackginglist

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    companion object {
        val itemNames = ArrayList<String>()
        val categories = ArrayList<String>()
        val quantities = ArrayList<Int>()
        val comments = ArrayList<String>()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etItem = findViewById<EditText>(R.id.etItem)
        val etCategory = findViewById<EditText>(R.id.etCategory)
        val etQuantity = findViewById<EditText>(R.id.etQuantity)
        val etComments = findViewById<EditText>(R.id.etComments)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnView = findViewById<Button>(R.id.btnView)
        val btnExit = findViewById<Button>(R.id.btnExit)

        btnAdd.setOnClickListener {
            val name = etItem.text.toString().trim()
            val cat = etCategory.text.toString().trim()
            val comm = etComments.text.toString().trim()
            val qtyStr = etQuantity.text.toString().trim()

            if (name.isEmpty() || cat.isEmpty() || qtyStr.isEmpty()){
                Toast.makeText(this, "Please fill Item, Category and Quantity", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val qty = qtyStr.toIntOrNull()
            if (qty == null || qty <= 0){
                Toast.makeText(this, "Quantity must be greater than 0", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            itemNames.add(name)
            categories.add(cat)
            quantities.add(qty)
            comments.add(comm)

            Toast.makeText(this, "Item Added", Toast.LENGTH_SHORT).show()

            etItem.text.clear()
            etCategory.text.clear()
            etQuantity.text.clear()
            etComments.text.clear()
        }
        btnView.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
        btnExit.setOnClickListener {
            finishAffinity()
        }

    }
}