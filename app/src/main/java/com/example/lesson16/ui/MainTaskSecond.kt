package com.example.lesson16.ui

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson16.R
import com.example.lesson16.core.WeatherAdapter
import com.example.lesson16.core.WeatherData
import com.example.lesson16.databinding.ActivityMainTaskSecondBinding

class MainTaskSecond : AppCompatActivity() {
    lateinit var binding: ActivityMainTaskSecondBinding
    private var weatherData=ArrayList<WeatherData>()
    private val adapter=WeatherAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainTaskSecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadData()
        adapter.setWeatherData(weatherData)
        binding.listView.adapter=adapter
    }

    private fun loadData() {
        for (i in 1 until 10){
            val a=(10..50).random();
            weatherData.add(WeatherData("Country ${i}","City ${i}",a))
        }
    }
}