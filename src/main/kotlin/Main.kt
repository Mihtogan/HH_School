package org.example

import org.example.domain.arenas.SimpleArena
import org.example.domain.units.Monster
import org.example.domain.units.Player
import kotlin.random.Random

fun main() {
    try {
        val player = Player(25, 10, 15, 2, 9)
        val monster = Monster(14, 11, 33, 3, 6)

        val arena = SimpleArena()

        while (player.isAlive && monster.isAlive) {
            if (player.health < player.maxHealth * 0.7
                && Random.nextInt(1, 3) == 1
            )
                player.healing()
            else
                arena.attack(player, monster)

            if (monster.isAlive)
                arena.attack(monster, player)

            println("player XP: ${player.health}, monster XP: ${monster.health}")
        }

    } catch (e: Exception) {
        println(e)
    }
}