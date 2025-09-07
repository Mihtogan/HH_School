package org.example.domain.units

import kotlin.random.Random

abstract class Creature(
    val attack: Int,
    val defense: Int,
    val maxHealth: Int,
    val minDamage: Int,
    val maxDamage: Int
) {
    init {
        require(attack in CreatureRules.ATTACK_RANGE) {
            "Attack must be ${CreatureRules.ATTACK_RANGE}"
        }
        require(defense in CreatureRules.DEFENSE_RANGE) {
            "Defense must be ${CreatureRules.DEFENSE_RANGE}"
        }
        require(maxHealth > 0) {
            "Max health must be positive"
        }
        require(minDamage in 1..maxDamage) {
            "Damage range must be valid"
        }
    }

    var health = maxHealth
        protected set

    val isAlive: Boolean
        get() = health > 0

    fun rollDamage(): Int =
        Random.nextInt(minDamage, maxDamage + 1)

    fun takeDamage(damage: Int) {
        health = (health - damage).coerceAtLeast(0)
    }
}