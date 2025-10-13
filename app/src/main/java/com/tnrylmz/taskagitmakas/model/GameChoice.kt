package com.tnrylmz.taskagitmakas.model

enum class GameChoice {
    ROCK,
    PAPER,
    SCISSORS;

    fun beats(other: GameChoice): Boolean {
        return when (this) {
            ROCK -> other == SCISSORS
            PAPER -> other == ROCK
            SCISSORS -> other == PAPER
        }
    }

    companion object {
        fun random(): GameChoice {
            return entries.random()
        }
    }
}
