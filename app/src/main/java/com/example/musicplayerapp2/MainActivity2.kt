package com.example.musicplayerapp2

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomsheet.BottomSheetBehavior


class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_screen)

        // Qo'riqchi obyekti
        val bottomSheet = findViewById<LinearLayout>(R.id.bottom_sheet)

        // BottomSheetBehavior
        val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)

        // Qo'riqchi xaritasi
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED

        // Qo'riqchi xaritasi harakatini boshqarish
        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                // Qo'riqchi xaritasi holatini boshqarish
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                // Qo'riqchi xaritasi chiziqli harakati
            }
        })
    }
}