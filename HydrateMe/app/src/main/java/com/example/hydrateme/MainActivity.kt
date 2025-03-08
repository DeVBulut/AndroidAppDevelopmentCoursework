package com.example.hydrateme

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var imageWaterGlass: ImageView
    private lateinit var textCupsDrank: TextView
    private lateinit var textTotalWater: TextView
    private lateinit var textMotivation: TextView
    private lateinit var buttonIncrease: Button
    private lateinit var buttonDecrease: Button

    private var cupsDrank = 0
    private val cupSizeMl = 240
    private val maxCups = 12

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageWaterGlass = findViewById(R.id.imageWaterGlass)
        textCupsDrank = findViewById(R.id.textCupsDrank)
        textTotalWater = findViewById(R.id.textTotalWater)
        textMotivation = findViewById(R.id.textMotivation)
        buttonIncrease = findViewById(R.id.buttonIncrease)
        buttonDecrease = findViewById(R.id.buttonDecrease)

        buttonIncrease.setOnClickListener { increaseWaterIntake() }
        buttonDecrease.setOnClickListener { decreaseWaterIntake() }
    }

    private fun increaseWaterIntake() {
        if (cupsDrank < maxCups) {
            cupsDrank++
            updateUI()
        }
    }

    private fun decreaseWaterIntake() {
        if (cupsDrank > 0) {
            cupsDrank--
            updateUI()
        }
    }

    private fun updateUI() {
        updateWaterImage()
        updateCupCounter()
        updateMlCounter()
        updateMotivationalQuote()
    }

    private fun updateWaterImage() {
        val imageResId = resources.getIdentifier("water_$cupsDrank", "drawable", packageName)
        imageWaterGlass.setImageResource(imageResId)
    }

    private fun updateCupCounter() {
        textCupsDrank.text = "$cupsDrank/12"
    }

    private fun updateMlCounter() {
        textTotalWater.text = "${cupsDrank * cupSizeMl}ml"
    }

    private fun updateMotivationalQuote() {
        val motivationalQuotes = arrayOf(
            "Start your hydration journey!",
            "Keep going, you're doing great!",
            "Halfway there, stay hydrated!",
            "Almost full, keep sipping!",
            "Perfect hydration, well done!"
        )

        textMotivation.text = when {
            cupsDrank == 0 -> motivationalQuotes[0]
            cupsDrank in 1..4 -> motivationalQuotes[1]
            cupsDrank in 5..8 -> motivationalQuotes[2]
            cupsDrank in 9..11 -> motivationalQuotes[3]
            cupsDrank == 12 -> motivationalQuotes[4]
            else -> "Stay Hydrated!"
        }
    }
}
