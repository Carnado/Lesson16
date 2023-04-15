package com.example.lesson16.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.example.lesson16.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    companion object{
        val IMAGE="image"
        val NAME="name"
        val FOLLOWER="followers"
    }
    private lateinit var binding: ActivityDetailBinding
    var name=""
    var image=""
    var count=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle=intent.extras
        bundle?.let {
            name= it.getString(NAME).toString()
            image= it.getString(IMAGE).toString()
            count= it.getString(FOLLOWER).toString()
        }
        loadData()
    }

    private fun loadData() {
        binding.nameDetail.setText(name)
        binding.followDetail.setText(count)
        binding.imageDetailUser.load(image)
    }
}