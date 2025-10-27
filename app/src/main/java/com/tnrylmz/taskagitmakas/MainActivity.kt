package com.tnrylmz.taskagitmakas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tnrylmz.taskagitmakas.ui.screens.GameScreen
import com.tnrylmz.taskagitmakas.ui.theme.TasKagitMakasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TasKagitMakasTheme {
                GameScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GamePreview() {
    TasKagitMakasTheme {
        GameScreen()
    }
}