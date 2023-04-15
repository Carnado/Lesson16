package com.example.lesson16.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson16.databinding.ActMainBinding

class MainAct : AppCompatActivity() {
    lateinit var binding: ActMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.taskFirst.setOnClickListener {
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        binding.taskSecond.setOnClickListener {
            val intent=Intent(this,MainTaskSecond::class.java)
            startActivity(intent)
        }
    }
}