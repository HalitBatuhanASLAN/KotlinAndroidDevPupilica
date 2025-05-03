package com.examples.workingstructure

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.examples.workingstructure.databinding.ActivityDetail2Binding

class DetailActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityDetail2Binding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityDetail2Binding.inflate(layoutInflater)

        //alt taraf tasarımı bağlama kısmı
        setContentView(binding.root)

        val takingMessage = intent.getStringExtra("mesage")
        binding.textViewResult.text = takingMessage

    }
}