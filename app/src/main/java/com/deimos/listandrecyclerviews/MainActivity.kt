package com.deimos.listandrecyclerviews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.deimos.listandrecyclerviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fruits = listOf<String>("apple", "banana", "mango", "pear", "pineapple")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, fruits)
        binding.listView.adapter = adapter

        binding.listView.setOnItemClickListener { parent, view, position, id ->
            val fruit = adapter.getItem(position)
            Toast.makeText(this, fruit.toString(), Toast.LENGTH_SHORT).show()
        }

        binding.btnRV.setOnClickListener {
            val intent = Intent(applicationContext, RecyclerViewActivity::class.java)
            startActivity(intent)
        }
    }
}