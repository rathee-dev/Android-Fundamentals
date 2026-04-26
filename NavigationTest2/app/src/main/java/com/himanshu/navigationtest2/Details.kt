package com.himanshu.navigationtest2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailsScreen(myName: String?,myAge: Int?){
    val modifier= Modifier
    Column(modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Details Screen", fontSize = 30.sp, fontWeight= FontWeight.Bold)
        Spacer(modifier.height(10.dp))
        Text("Name is: $myName", fontSize = 24.sp)
        Text("Age is: $myAge",fontSize= 24.sp)

    }
}

