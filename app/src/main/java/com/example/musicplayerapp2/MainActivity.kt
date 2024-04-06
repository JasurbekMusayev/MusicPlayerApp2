package com.example.musicplayerapp2

import MyAdapter
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.musicplayerapp2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var myadapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myadapter = MyAdapter()
        binding.recycler.adapter = myadapter

        val list = listOf(
            MyKotlinModel(R.drawable.man2, "Out of My Mine", "Dance"),
            MyKotlinModel(R.drawable.electronic, "Freak In Me", "Electronic"),
            MyKotlinModel(R.drawable.lover, "Lover Boy", "Dance")
        )

        myadapter.setList(list)

//        binding.blur.setRenderEffect(
//            RenderEffect.createBlurEffect(
//                80.0f, 80.0f, Shader.TileMode.MIRROR
//            )
//        )

//        Blurry.with(this).radius(8).sampling(2).onto(binding.blur)
    }

}