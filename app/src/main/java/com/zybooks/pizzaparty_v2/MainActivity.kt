package com.zybooks.pizzaparty_v2

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.ceil

/**
 * MainActivity
 *
 * This class defines the activity that starts once the app is launched.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var numAttendEditText: EditText
    private lateinit var numPizzasTextView: TextView
    private lateinit var howHungryRadioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numAttendEditText = findViewById(R.id.num_attend_edit_text)
        numPizzasTextView = findViewById(R.id.num_pizzas_text_view)
        howHungryRadioGroup = findViewById(R.id.hungry_radio_group)
    }

    /**
     * This method calculates the number of pizzas and displays the value
     * in the view
     */
    fun calculateClick(view: View) {
        // Get the text that was typed into the EditText
        val numAttendStr = numAttendEditText.text.toString()
        // Convert the text into an integer
        val numAttend = numAttendStr.toIntOrNull() ?: 0
        // Get hunger level selection
        val hungerLevel = when (howHungryRadioGroup.getCheckedRadioButtonId()) {
            R.id.light_radio_button -> PizzaCalculator.HungerLevel.LIGHT
            R.id.medium_radio_button -> PizzaCalculator.HungerLevel.MEDIUM
            else -> PizzaCalculator.HungerLevel.RAVENOUS
        }
        // Get the number of pizzas needed
        val calc = PizzaCalculator(numAttend, hungerLevel)
        val totalPizzas = calc.totalPizzas
        // Place totalPizzas into the string resource and display
        val totalText = getString(R.string.total_pizzas, totalPizzas)
        numPizzasTextView.setText(totalText)
    }
}