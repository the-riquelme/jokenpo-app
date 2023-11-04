package com.riquelme.jokenpo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.riquelme.jokenpo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

}