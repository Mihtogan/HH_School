package org.example.domain.dices

class DiceD6 : Dice {
    override fun roll(): Int =
        (1..6).random()
}