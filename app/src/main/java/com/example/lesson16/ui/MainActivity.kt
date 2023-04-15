package com.example.lesson16.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson16.core.FollowerAdapter
import com.example.lesson16.core.FollowerData
import com.example.lesson16.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var data=ArrayList<FollowerData>()
    private val adapter= FollowerAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadData()
        adapter.setFollowerData(data)
        binding.followerList.adapter=adapter
        adapter.setOnAdapterItemClick {
            val intent= Intent(this, DetailActivity::class.java)
            val bundle= Bundle()
            bundle.putString(DetailActivity.IMAGE,it.followerImage)
            bundle.putString(DetailActivity.FOLLOWER,it.followerCount)
            bundle.putString(DetailActivity.NAME,it.followerName)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }

    private fun loadData() {
        var a=1;
        for (i in 1 until 100){
            var image:String=""
            val randomFollower=(100..10000).random()
            a++
            if (a%7==0){
                a=1
            }
            var name:String=""
            val image1="https://upload.wikimedia.org/wikipedia/commons/thumb/f/fc/MarkZuckerberg-crop.jpg/220px-MarkZuckerberg-crop.jpg"
            val image2="https://m.media-amazon.com/images/M/MV5BODYxNzE4OTk5Nl5BMl5BanBnXkFtZTcwODYyMDYzMw@@._V1_FMjpg_UX1000_.jpg"
            val image3="https://b.fssta.com/uploads/application/soccer/headshots/885.vresize.350.350.medium.14.png"
            val image4="https://wp.technologyreview.com/wp-content/uploads/2021/02/20210128_Keatley-Bill_Gates_0107_R.jpeg"
            val image5="https://upload.wikimedia.org/wikipedia/commons/5/54/Shavkat_Mirziyoyev_official_portrait.jpg"
            val image6="https://cdn.themag.uz/2018/03/spec-proj_grooms_shakhram_img-1.jpg"
            when(a){
                1->{image=image1
                name="@MarkZuckerberg"}
                2->{image=image2
                name="@JesicaAlba"}
                3->{image=image3
                name="@cr7"}
                4->{image=image4
                name="@Bill"}
                5->{image=image5
                name="@sh_mirziyoyev"}
                6->{image=image6
                name="@giyasovTeam"}
            }
            data.add(
                FollowerData(image,
                name,
                "${randomFollower} followers")
            )
        }
    }
}