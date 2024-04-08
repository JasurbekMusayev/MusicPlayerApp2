package com.example.musicplayerapp2

import MyAdapter
import MyAdapter2
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.musicplayerapp2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var myadapter: MyAdapter
    lateinit var myAdapter2: MyAdapter2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myadapter = MyAdapter()
        myAdapter2 = MyAdapter2()
        binding.recycler.adapter = myadapter
        binding.recycler2.adapter = myAdapter2

        val list = listOf<MyKotlinModel>(
            MyKotlinModel(R.drawable.man2, "Out of My Mine", "Dance"),
            MyKotlinModel(R.drawable.electronic, "Freak In Me", "Electronic"),
            MyKotlinModel(R.drawable.lover, "Lover Boy", "Dance")

        )

        myadapter.setList(list)
        val list2 = listOf<MyKotlinModel2>(
            MyKotlinModel2(R.drawable.soit, "Out of My Mine", "Dance"),
            MyKotlinModel2(R.drawable.coldplay, "Freak In Me", "Electronic"),
            MyKotlinModel2(R.drawable.city, "Lover Boy", "Dance")

        )
        myAdapter2.setList(list2)

    }

}