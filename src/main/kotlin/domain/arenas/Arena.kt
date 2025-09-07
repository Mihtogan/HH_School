package org.example.domain.arenas

import org.example.domain.units.Creature

abstract class Arena {
    abstract fun attack(attacker: Creature,defender: Creature)
    abstract fun successfulDiceRoll(): Boolean
}