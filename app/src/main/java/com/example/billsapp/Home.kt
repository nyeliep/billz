package com.example.billsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.billsapp.databinding.ActivityMainBinding

class Home : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val billsList: MutableList<Bill> = mutableListOf()
    private lateinit var adapter: BillAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.recyclerView.layoutManager = LinearLayoutManager(this)
//        adapter = BillAdapter(billsList)
//        binding.recyclerView.adapter = adapter

        billsList.add(Bill("Rent", 15000.0))
        billsList.add(Bill("Electricity bill", 750.0))
        billsList.add(Bill("Water bill", 1575.0))
    }
}

