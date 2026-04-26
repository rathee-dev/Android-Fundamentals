package com.example.captaingame2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.captaingame2.ui.theme.CaptainGame2Theme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaptainGame2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CaptainGame(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CaptainGame(modifier: Modifier = Modifier) {
    val treasureFound = remember { mutableIntStateOf(0) }
    val direction = remember { mutableStateOf("North") }
    val stormOrTreasure= remember {mutableStateOf("")}

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "TreasureFound: ${treasureFound.intValue}")
        Text(text = "Direction: ${direction.value}")
        Text(text="${stormOrTreasure.value}")

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Button(onClick = {
                direction.value = "East"
                if (Random.nextBoolean()) {
                    treasureFound.intValue += 1
                }
            }) {
                Text("Sail East")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                direction.value = "West"
                if (Random.nextBoolean()) {
                    treasureFound.intValue += 1
                    stormOrTreasure.value = "Found a Treasure!!!"
                } else
                    stormOrTreasure.value = "Storm ahead!"

            }) {
                Text("Sail West")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row {
            Button(onClick = {
                direction.value = "North"
                if (Random.nextBoolean()) {
                    treasureFound.intValue += 1
                    stormOrTreasure.value = "Found a Treasure!"
                } else
                    stormOrTreasure.value = "Storm ahead!"

            }) {
                Text("Sail North")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                direction.value = "South"
                if (Random.nextBoolean()) {
                    treasureFound.intValue += 1
                    stormOrTreasure.value = "Found a Treasure!"
                } else
                    stormOrTreasure.value = "Storm ahead!"

            }) {
                Text("Sail South")
            }
        }
    }
}
