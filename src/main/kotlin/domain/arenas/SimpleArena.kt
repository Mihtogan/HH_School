package org.example.domain.arenas

import org.example.domain.dices.DiceD6
import org.example.domain.units.Creature

class SimpleArena : Arena() {
    private val diceD6 = DiceD6()

    override fun attack(attacker: Creature, defender: Creature) {
        if (!attacker.isAlive) {
            println("The attacker is dead")
            return
        }
        if (!defender.isAlive) {
            println("The defender is already dead")
            return
        }

        val modifier = (attacker.attack - defender.defense + 1)
            .coerceAtLeast(1)

        var success = false
        (1..modifier).forEach { _ ->
            if (successfulDiceRoll()) {
                success = true
                return@forEach
            }
        }

        if (success) {
            val damage = attacker.rollDamage()
            defender.takeDamage(damage)
            println("${attacker::class.simpleName} hits ${defender::class.simpleName} for $damage damage!")
        } else {
            println("${attacker::class.simpleName} misses ${defender::class.simpleName}")
        }
    }

    override fun successfulDiceRoll(): Boolean {
        return diceD6.roll() >= 5
    }
}