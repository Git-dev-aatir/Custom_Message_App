package com.localdev.custommessageapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.localdev.custommessageapp.ui.theme.CustomMessageAppTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CustomMessageAppTheme {
                MainWindow()
            }
        }
    }
}

@Composable
fun MainWindow() {
    var displayText = remember { mutableStateOf("") }
    var userInput = remember { mutableStateOf("")}

    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Heading Text
            Text(
                text = "Create Your Custom Message",
                color = Color.DarkGray,
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Serif,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Spacer (modifier = Modifier.height(90.dp))

            // Input text field
            OutlinedTextField(
                value = userInput.value,
                onValueChange = {userInput.value = it },
                label = { Text ("Enter your custom message") },
                modifier = Modifier.fillMaxWidth(0.78f)
            )

            Spacer (modifier = Modifier.height(18.dp))

            // Button to display text
            Button (onClick = { displayText.value = userInput.value }) {
                Text("Display Message")
            }

            Spacer (modifier = Modifier.height(60.dp))

            // Displaying the message with delay between each letter
            DisplayIt(displayText.value)
        }
    }

}

@Composable
fun DisplayIt(displayText: String) {
    var tempString = remember { mutableStateOf("") }

    LaunchedEffect(displayText) {
        tempString.value = ""
        displayText.forEach { char ->
            tempString.value += char
            delay(150)
        }
    }

    Text (
        text = tempString.value,
        color = Color.Magenta,
        fontSize = 38.sp,
        fontFamily = FontFamily.Cursive,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        fontStyle = FontStyle.Normal
    )
}


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//package com.example.greetingcard
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.Font
//import androidx.compose.ui.text.font.FontFamily
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import kotlinx.coroutines.delay
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            MainWindow("Hello World!")
//        }
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun MainWindow(fullText: String) {
//    var displayText by remember { mutableStateOf("") }
//    var userInput by remember { mutableStateOf("") }
//
//    Box(
//        contentAlignment = Alignment.Center,
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.Yellow)
//            .padding(15.dp)
//    ) {
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            // Heading Text
//            Text(
//                text = "Create Your Custom Message",
//                color = Color.DarkGray,
//                fontSize = 28.sp,
//                fontWeight = FontWeight.Bold,
//                fontFamily = FontFamily.SansSerif,
//                textAlign = TextAlign.Center,
//                modifier = Modifier.padding(bottom = 16.dp)
//            )
//
//            Spacer (modifier = Modifier.height(110.dp))
//
//            // Input Text Field
//            OutlinedTextField(
//                value = userInput,
//                onValueChange = { userInput = it },
//                label = { Text("Enter your custom message") },
//                modifier = Modifier.fillMaxWidth(0.8f)
//            )
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            // Button to update display text
//            Button(onClick = { displayText = userInput }) {
//                Text("Display Message")
//            }
//
//            Spacer(modifier = Modifier.height(50.dp))
//
//            // Display the final message with a delay
//            DisplayIt(displayText)
//        }
//    }
//}
//
//@Composable
//fun DisplayIt(fullText: String) {
//    var displayText by remember { mutableStateOf("") }
//
//    LaunchedEffect(fullText) {
//        displayText = ""
//        fullText.forEach { char ->
//            displayText += char
//            delay(200) // Set the delay time in milliseconds
//        }
//    }
//
//    Text(
//        text = displayText,
//        color = Color.Magenta,
//        fontSize = 40.sp,
//        fontFamily = FontFamily.Cursive,
//        fontWeight = FontWeight.Bold,
//        textAlign = TextAlign.Center
//    )
//}
//
