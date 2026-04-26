package com.example.captaingame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.captaingame.ui.theme.CaptainGameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
//        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            CaptainGameTheme {
                Scaffold( modifier= Modifier.fillMaxSize(),
                    contentColor = Color.Blue
//                    , containerColor = Color.Yellow
                )
                { innerPadding->

//                    Test("Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    Surface(
                        modifier = Modifier.fillMaxSize().padding(innerPadding),
                        color = Color.Yellow) {
                    Test("Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                    }
                }
            }
        }
    }
}

@Composable
fun Test(name: String,modifier: Modifier = Modifier){
        Text(
            text="My name is $name",
            modifier = modifier
        )
    }

@Preview(showBackground = true)
@Composable
fun TestPreview(){
    Test("Himanshu")
}