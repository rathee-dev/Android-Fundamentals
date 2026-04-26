package com.himanshu.unitconverterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.himanshu.unitconverterapp.ui.theme.UnitConverterAppTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UnitConverterApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun UnitConverterApp(modifier: Modifier = Modifier) {
    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Meter") }
    var outputUnit by remember { mutableStateOf("Meter") }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    val conversionFactor= remember { mutableStateOf(1.00) }
    val oconversionFactor= remember { mutableStateOf(1.00) }

    fun convertUnits(){
        val inputvalueDouble=inputValue.toDoubleOrNull() ?: 0.0
        val result=(inputvalueDouble * conversionFactor.value * 100/ oconversionFactor.value).roundToInt() / 100.0
        outputValue=result.toString()
    }
    Column(
        modifier=modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text ="Unit Converter",
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier= Modifier.height(16.dp))
        OutlinedTextField(
            value = inputValue,
            onValueChange = {
                inputValue = it
                convertUnits()
            },
            label = {Text(text ="Enter the value: ")}
        )
        Spacer(modifier= Modifier.height(16.dp))
        Row{
            Box {
                Button(
                    onClick = {iExpanded=true}
                ) {
                    Text(
                        text = inputUnit
                    )
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down"
                    )
                    DropdownMenu(
                        expanded =iExpanded,
                        onDismissRequest = {
                            iExpanded=false
                        }) {
                        DropdownMenuItem(
                            text ={Text(text ="Meter")},
                            onClick = {
                                iExpanded=false
                                inputUnit="Meter"
                                conversionFactor.value=1.00
                                convertUnits()
                            }
                        )
                        DropdownMenuItem(
                            text ={Text(text ="Centimeter")},
                            onClick = {
                                iExpanded=false
                                inputUnit="Centimeter"
                                conversionFactor.value=0.01
                                convertUnits()
                            }
                        )
                        DropdownMenuItem(
                            text ={Text(text ="Millimeter")},
                            onClick = {
                                iExpanded=false
                                inputUnit="Millimeter"
                                conversionFactor.value=0.001
                                convertUnits()
                            }
                        )
                        DropdownMenuItem(
                            text ={Text(text ="Feet")},
                            onClick = {
                                iExpanded=false
                                inputUnit="Feet"
                                conversionFactor.value=0.3048
                                convertUnits()
                            }
                        )
                        DropdownMenuItem(
                            text ={Text(text ="Inches")},
                            onClick = {
                                iExpanded=false
                                inputUnit="Inches"
                                conversionFactor.value=0.0254
                                convertUnits()
                            }
                        )
                    }
                }
            }
            Spacer(modifier= Modifier.width(16.dp))
            Box {
                Button(
                    onClick = {oExpanded = true}) {
                    Text(
                        text = outputUnit
                    )
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down"
                    )
                    DropdownMenu(
                        expanded = oExpanded,
                        onDismissRequest = {oExpanded = false}
                    ) {
                        DropdownMenuItem(
                            text ={Text(text ="Meter")},
                            onClick = {
                                oExpanded=false
                                outputUnit="Meter"
                                oconversionFactor.value=1.00
                                convertUnits()
                            }
                        )
                        DropdownMenuItem(
                            text ={Text(text ="Centimeter")},
                            onClick = {
                                oExpanded=false
                                outputUnit="Centimeter"
                                oconversionFactor.value=0.01
                                convertUnits()
                            }
                        )
                        DropdownMenuItem(
                            text ={Text(text ="Millimeter")},
                            onClick = {
                                oExpanded=false
                                outputUnit="Millimeter"
                                oconversionFactor.value=0.001
                                convertUnits()
                            }
                        )
                        DropdownMenuItem(
                            text ={Text(text ="Feet")},
                            onClick = {
                                oExpanded=false
                                outputUnit="Feet"
                                oconversionFactor.value=0.3048
                                convertUnits()
                            }
                        )
                        DropdownMenuItem(
                            text ={Text(text ="Inches")},
                            onClick = {
                                oExpanded=false
                                outputUnit="Inches"
                                oconversionFactor.value=0.0254
                                convertUnits()
                            }
                        )
                    }
                }
            }
        }
        Text(
            text ="Result: ${outputValue} ${outputUnit}",
            style = MaterialTheme.typography.headlineMedium
//            fontSize = 24.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterAppPreview() {
    UnitConverterAppTheme {
        UnitConverterApp()
    }
}