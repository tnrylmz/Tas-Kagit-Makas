package com.tnrylmz.taskagitmakas

import com.tnrylmz.taskagitmakas.model.GameChoice
import org.junit.Test
import org.junit.Assert.*

/**
 * Unit tests for game logic.
 */
class GameLogicTest {
    
    @Test
    fun rock_beats_scissors() {
        assertTrue(GameChoice.ROCK.beats(GameChoice.SCISSORS))
    }

    @Test
    fun paper_beats_rock() {
        assertTrue(GameChoice.PAPER.beats(GameChoice.ROCK))
    }

    @Test
    fun scissors_beats_paper() {
        assertTrue(GameChoice.SCISSORS.beats(GameChoice.PAPER))
    }

    @Test
    fun rock_does_not_beat_paper() {
        assertFalse(GameChoice.ROCK.beats(GameChoice.PAPER))
    }

    @Test
    fun paper_does_not_beat_scissors() {
        assertFalse(GameChoice.PAPER.beats(GameChoice.SCISSORS))
    }

    @Test
    fun scissors_does_not_beat_rock() {
        assertFalse(GameChoice.SCISSORS.beats(GameChoice.ROCK))
    }

    @Test
    fun same_choice_does_not_beat_itself() {
        assertFalse(GameChoice.ROCK.beats(GameChoice.ROCK))
        assertFalse(GameChoice.PAPER.beats(GameChoice.PAPER))
        assertFalse(GameChoice.SCISSORS.beats(GameChoice.SCISSORS))
    }

    @Test
    fun random_choice_is_valid() {
        val choices = mutableSetOf<GameChoice>()
        // Generate 100 random choices to verify all types can be generated
        repeat(100) {
            val randomChoice = GameChoice.random()
            choices.add(randomChoice)
            assertTrue(randomChoice in GameChoice.entries)
        }
        // With 100 iterations, we should have seen all choices (statistically very likely)
        assertTrue(choices.size >= 2) // At least 2 different types should appear
    }
}
