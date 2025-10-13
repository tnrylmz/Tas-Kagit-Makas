package com.tnrylmz.taskagitmakas.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tnrylmz.taskagitmakas.model.GameChoice
import com.tnrylmz.taskagitmakas.model.GameResult
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class GameState(
    val playerChoice: GameChoice? = null,
    val computerChoice: GameChoice? = null,
    val result: GameResult? = null,
    val playerScore: Int = 0,
    val computerScore: Int = 0,
    val isPlaying: Boolean = false
)

class GameViewModel : ViewModel() {
    private val _gameState = MutableStateFlow(GameState())
    val gameState: StateFlow<GameState> = _gameState.asStateFlow()

    fun playGame(playerChoice: GameChoice) {
        viewModelScope.launch {
            // Set playing state
            _gameState.value = _gameState.value.copy(
                playerChoice = playerChoice,
                computerChoice = null,
                result = null,
                isPlaying = true
            )

            // Delay for animation
            delay(300)

            // Generate computer choice
            val computerChoice = GameChoice.random()
            _gameState.value = _gameState.value.copy(
                computerChoice = computerChoice
            )

            delay(300)

            // Determine result
            val result = when {
                playerChoice == computerChoice -> GameResult.DRAW
                playerChoice.beats(computerChoice) -> GameResult.WIN
                else -> GameResult.LOSE
            }

            // Update scores
            val currentState = _gameState.value
            val newPlayerScore = if (result == GameResult.WIN) currentState.playerScore + 1 else currentState.playerScore
            val newComputerScore = if (result == GameResult.LOSE) currentState.computerScore + 1 else currentState.computerScore

            _gameState.value = currentState.copy(
                result = result,
                playerScore = newPlayerScore,
                computerScore = newComputerScore,
                isPlaying = false
            )
        }
    }

    fun resetGame() {
        _gameState.value = GameState()
    }
}
