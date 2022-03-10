package com.zybooks.pizzaparty_v2

import kotlin.math.ceil

const val SLICES_PER_PIZZA = 8

/**
 * Pizza Calculator
 *
 * This class calculates total number of Pizzas required based on
 * number of people and their hunger level.
 *
 * @param [partySize] Number of people
 * @param [hungerLevel] hunger level of people
 */
class PizzaCalculator(partySize: Int, var hungerLevel: HungerLevel) {
    private var partySize = 0
        set(value) {
            field = if (value >= 0) value else 0
        }

    enum class HungerLevel(var numSlices: Int) {
        LIGHT(2), MEDIUM(3), RAVENOUS(4)
    }

    val totalPizzas: Int
        get() {
            return ceil(partySize * hungerLevel.numSlices / SLICES_PER_PIZZA.toDouble()).toInt()
        }

    init {
        this.partySize = partySize
    }
}