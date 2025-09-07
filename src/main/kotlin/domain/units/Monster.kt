package org.example.domain.units

class Monster(
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
}