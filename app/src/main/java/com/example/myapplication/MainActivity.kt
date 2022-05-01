package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import com.github.javafaker.Faker

class MainActivity : AppCompatActivity() {

    private val faker = Faker()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listContainer: LinearLayout = findViewById(R.id.listContainer)

        method(listContainer)
    }

    private fun method(listContainer: LinearLayout) {
        val itemView = layoutInflater.inflate(R.layout.list_item, listContainer, true)

        val userFullNameTextView = itemView.findViewById<TextView>(R.id.userFullNameTextView)
        val userAddressTextView = itemView.findViewById<TextView>(R.id.userAddressTextView)

        userFullNameTextView.text = faker.name().fullName()
        userAddressTextView.text = faker.address().fullAddress()
    }
}