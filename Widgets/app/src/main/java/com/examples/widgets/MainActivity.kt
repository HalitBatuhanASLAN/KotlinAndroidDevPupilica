package com.examples.widgets

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.examples.widgets.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var control = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toggleButton.addOnButtonCheckedListener{group,checkedId,isChecked ->
            control = isChecked
            if(isChecked)
            {
                val chosenBotton = findViewById<Button>(checkedId)
                val buttonYazi = chosenBotton.text.toString()
                Log.e("Widgets",buttonYazi)
            }
        }

        val countries = ArrayList<String>()
        countries.add("Türkiye")
        countries.add("Italy")
        countries.add("Germany")

        //adaptor
        val arrayAdopter = ArrayAdapter(this,android.R.layout.simple_list_item_1,countries)
        binding.autoCompleteTextView.setAdapter(arrayAdopter)

        binding.buttonShow.setOnClickListener {
            if(control)
            {
                val chosenBotton = findViewById<Button>(binding.toggleButton.checkedButtonId)
                val buttonYazi = chosenBotton.text.toString()
                Log.e("Result(Show)",buttonYazi)
            }
            Log.e("Selected country",binding.autoCompleteTextView.text.toString())
        }
    }
}