package com.examples.workingstructure

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.examples.workingstructure.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        //inflate metodu ile xml dosyası kotlin nesnesine dönüştürüldü
        //layoutInflater ise xml dosyasını inflate etmeye yarar
        binding = ActivityMainBinding.inflate(layoutInflater)

        //root ile en üst düzeyi temsil etmiş olduk
        setContentView(binding.root)

        binding.buttonDetail.setOnClickListener {
            //binding.textViewMainPage.text = "Hello"

            //alt taraf sayfalar içi geçiş niyeti için kullanılır
            //iki nokta kısmını unutma
            val intent = Intent(this@MainActivity, DetailActivity2::class.java)
            //burada @MainActivity gerek yok ama garanti olması için yazmalıyız

            //ilki key oluyor yani bu anhtar ile veri okunur diğer tarafta
            intent.putExtra("mesage","Hello, how are you?")

            startActivity(intent)
        }

        //setContentView(R.layout.activity_main)

    }
}