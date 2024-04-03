package com.khethelo.thehistoryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var ageInput: EditText
    private lateinit var resultTextView: TextView
    private lateinit var generateButton: Button
    private lateinit var clearButton: Button

    private val famousPeople = mapOf(
        90 to "Winston Churchill",
        91 to "Pablo Picasso",
        92 to "Rosa Parks",
        93 to "Harriet Tubman",
        94 to "George H.W. Bush",
        95 to "Stan Lee",
        96 to "Queen Elizabeth II",
        97 to "Chuck Yeager",
        98 to "Lillian Disney",
        99 to "Betty White",
        100 to "Dave Bartholomew"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ageInput = findViewById(R.id.ageInput)
        resultTextView = findViewById(R.id.resultTextView)
        generateButton = findViewById(R.id.generateButton)
        clearButton = findViewById(R.id.clearButton)

        generateButton.setOnClickListener {
            val ageText = ageInput.text.toString()
            if (ageText.isNotEmpty()){
                val age = ageText.toIntOrNull()
                if (age != null && age in 90..100) {

                    val person =
                        famousPeople.entries.firstOrNull() { age in it.key..(it.key + 1) }?.value
                            ?: "Unknown"
                    resultTextView.text =
                        "You are $age years old! The same age as one of history's very well-known figures, $person!"
                } else {
                    resultTextView.text = "Invalid age! Please enter age between 90-100!"

                } 
            }
        }
        clearButton.setOnClickListener {
            ageInput.text.clear()
            resultTextView.text = "Please enter age between 90-100"
        }
    }
}