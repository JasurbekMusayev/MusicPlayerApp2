package com.example.musicplayerapp2

import MyAdapter
import MyAdapter2
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.musicplayerapp2.databinding.ActivityMainBinding
import com.example.musicplayerapp2.service.PlayerServiceNew2

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentMainn) as NavHostFragment

        navController = navHostFragment.findNavController()

        val serviceIntent = Intent(this, PlayerServiceNew2::class.java)

        serviceIntent.action = PlayerServiceNew2.STARTFOREGROUND_ACTION
        startService(serviceIntent)
    }

}