package com.himanshu.navigationtest2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController){
    val modifier= Modifier
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var nameValue by remember { mutableStateOf("") }
        var ageValue by remember { mutableStateOf("") }
        Text("Home Screen ", fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier.height(24.dp))
        TextField(
            value=nameValue ,
            onValueChange = {nameValue=it},
            modifier.padding(10.dp),
            placeholder = {
                Text("Enter your Name?")
            }
        )
        TextField(
            value=ageValue ,
            onValueChange = {ageValue=it},
            modifier.padding(10.dp),
            placeholder = {
                Text("Enter your Age?")
            }
        )
        Spacer(modifier.height(24.dp))
        Button(onClick = {
           navController.navigate("details_screen?name=$nameValue&age=$ageValue")
            }
        ) {
            Text("Pass Data",fontSize =24.sp)
        }
    }
}