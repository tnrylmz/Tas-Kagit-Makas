package com.tnrylmz.taskagitmakas.ui.screens

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tnrylmz.taskagitmakas.R
import com.tnrylmz.taskagitmakas.model.GameChoice
import com.tnrylmz.taskagitmakas.model.GameResult
import com.tnrylmz.taskagitmakas.viewmodel.GameViewModel

@Composable
fun GameScreen(
    viewModel: GameViewModel = viewModel()
) {
    val gameState by viewModel.gameState.collectAsState()
    val context = LocalContext.current

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Title and Score
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.game_title),
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.height(24.dp))

                ScoreBoard(
                    playerScore = gameState.playerScore,
                    computerScore = gameState.computerScore
                )
            }

            // Game Area
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Computer Choice
                AnimatedVisibility(
                    visible = gameState.computerChoice != null,
                    enter = scaleIn(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    ) + fadeIn(),
                    exit = scaleOut() + fadeOut()
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(R.string.computer),
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        gameState.computerChoice?.let { choice ->
                            ChoiceCard(choice = choice, isSelected = false)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                // Result
                AnimatedVisibility(
                    visible = gameState.result != null,
                    enter = scaleIn(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    ) + fadeIn(),
                    exit = scaleOut() + fadeOut()
                ) {
                    gameState.result?.let { result ->
                        ResultCard(result = result)
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                // Player Choice
                AnimatedVisibility(
                    visible = gameState.playerChoice != null,
                    enter = scaleIn(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    ) + fadeIn(),
                    exit = scaleOut() + fadeOut()
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        gameState.playerChoice?.let { choice ->
                            ChoiceCard(choice = choice, isSelected = true)
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = stringResource(R.string.you),
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            // Choice Buttons
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.choose_your_move),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ChoiceButton(
                        choice = GameChoice.ROCK,
                        enabled = !gameState.isPlaying,
                        onClick = {
                            vibrateDevice(context)
                            viewModel.playGame(GameChoice.ROCK)
                        },
                        modifier = Modifier.weight(1f)
                    )
                    ChoiceButton(
                        choice = GameChoice.PAPER,
                        enabled = !gameState.isPlaying,
                        onClick = {
                            vibrateDevice(context)
                            viewModel.playGame(GameChoice.PAPER)
                        },
                        modifier = Modifier.weight(1f)
                    )
                    ChoiceButton(
                        choice = GameChoice.SCISSORS,
                        enabled = !gameState.isPlaying,
                        onClick = {
                            vibrateDevice(context)
                            viewModel.playGame(GameChoice.SCISSORS)
                        },
                        modifier = Modifier.weight(1f)
                    )
                }

                if (gameState.result != null) {
                    Spacer(modifier = Modifier.height(16.dp))
                    OutlinedButton(
                        onClick = { viewModel.resetGame() },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(stringResource(R.string.reset_game))
                    }
                }
            }
        }
    }
}

@Composable
fun ScoreBoard(
    playerScore: Int,
    computerScore: Int
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.you),
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
                Text(
                    text = playerScore.toString(),
                    style = MaterialTheme.typography.displayMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Text(
                text = ":",
                style = MaterialTheme.typography.displayMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier.padding(top = 8.dp)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.computer),
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
                Text(
                    text = computerScore.toString(),
                    style = MaterialTheme.typography.displayMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
fun ChoiceCard(
    choice: GameChoice,
    isSelected: Boolean
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected)
                MaterialTheme.colorScheme.primaryContainer
            else
                MaterialTheme.colorScheme.tertiaryContainer
        )
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = getIconForChoice(choice)),
                contentDescription = getNameForChoice(choice),
                modifier = Modifier.size(64.dp),
                tint = if (isSelected)
                    MaterialTheme.colorScheme.onPrimaryContainer
                else
                    MaterialTheme.colorScheme.onTertiaryContainer
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = getNameForChoice(choice),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = if (isSelected)
                    MaterialTheme.colorScheme.onPrimaryContainer
                else
                    MaterialTheme.colorScheme.onTertiaryContainer
            )
        }
    }
}

@Composable
fun ResultCard(result: GameResult) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = when (result) {
                GameResult.WIN -> MaterialTheme.colorScheme.primaryContainer
                GameResult.LOSE -> MaterialTheme.colorScheme.errorContainer
                GameResult.DRAW -> MaterialTheme.colorScheme.secondaryContainer
            }
        )
    ) {
        Text(
            text = when (result) {
                GameResult.WIN -> stringResource(R.string.result_win)
                GameResult.LOSE -> stringResource(R.string.result_lose)
                GameResult.DRAW -> stringResource(R.string.result_draw)
            },
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = when (result) {
                GameResult.WIN -> MaterialTheme.colorScheme.onPrimaryContainer
                GameResult.LOSE -> MaterialTheme.colorScheme.onErrorContainer
                GameResult.DRAW -> MaterialTheme.colorScheme.onSecondaryContainer
            },
            modifier = Modifier.padding(24.dp)
        )
    }
}

@Composable
fun ChoiceButton(
    choice: GameChoice,
    enabled: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    FilledTonalButton(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier.height(120.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = getIconForChoice(choice)),
                contentDescription = getNameForChoice(choice),
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = getNameForChoice(choice),
                style = MaterialTheme.typography.labelLarge,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
private fun getIconForChoice(choice: GameChoice): Int {
    return when (choice) {
        GameChoice.ROCK -> R.drawable.ic_rock
        GameChoice.PAPER -> R.drawable.ic_paper
        GameChoice.SCISSORS -> R.drawable.ic_scissors
    }
}

@Composable
private fun getNameForChoice(choice: GameChoice): String {
    return when (choice) {
        GameChoice.ROCK -> stringResource(R.string.rock)
        GameChoice.PAPER -> stringResource(R.string.paper)
        GameChoice.SCISSORS -> stringResource(R.string.scissors)
    }
}

private fun vibrateDevice(context: Context) {
    val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        val vibratorManager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
        vibratorManager.defaultVibrator
    } else {
        @Suppress("DEPRECATION")
        context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    }

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE))
    } else {
        @Suppress("DEPRECATION")
        vibrator.vibrate(50)
    }
}
