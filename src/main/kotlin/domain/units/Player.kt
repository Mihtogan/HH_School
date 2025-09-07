package org.example.domain.units

class Player(
    attack: Int,
    defense: Int,
    maxHealth: Int,
    minDamage: Int,
    maxDamage: Int
) : Creature(
    attack,
    defense,
    maxHealth,
    minDamage,
    maxDamage
) {
    private var healsLeft = 4

    fun healing() {
        if (healsLeft == 0) return

        health = (health + maxHealth * 0.3).toInt()
            .coerceAtMost(maxHealth)
        healsLeft--
    }
}