package com.himanshu.navigationtest

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SecondScreen(
    name: String,
    age: Int,
    navigationToFirstScreen: () -> Unit,
    navigationToThirdScreen: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Second Screen", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))

        Text("Name: $name", fontSize = 20.sp)
        Text("Age: $age", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                navigationToFirstScreen()
            }) {
                Text("First Screen")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = {
                navigationToThirdScreen()
            }) {
                Text("Third Screen")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun SecondPreview() {
    SecondScreen("Himanshu", 25, {}, {})
}