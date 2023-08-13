package com.example.jetpackcomposelessons.widgets.dynamiccontent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

val namesList: ArrayList<String> = arrayListOf("pratik","andrea","diana","nikhil");

//@Composable
//fun MainScreen(){
//    val greetingListState = remember { mutableStateListOf<String>(namesList[0]) }
//    val textFieldState = remember { mutableStateOf("") }
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.SpaceEvenly,
//        horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//        GreetingList(
//            greetingListState,
//            { greetingListState.add(textFieldState.value) },
//            textFieldState.value,
//            { newName -> textFieldState.value = newName }
//        )
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun GreetingList(
//    namesList: List<String>,
//    onClick: () -> Unit,
//    newTextFieldValue: String,
//    UpdateTextFieldValue: (newName: String) -> Unit
//
//){
//
//    for (name in namesList){
//        Greeting(name = name)
//    }
//    TextField(value = newTextFieldValue, onValueChange = UpdateTextFieldValue)
//    Button(
//        modifier = Modifier.wrapContentSize(align = Alignment.Center),
//        onClick = onClick
//    ){
//        Text(text = "Add New Name")
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingListPreview(){
//    MainScreen();
//}
//@Composable
//fun Greeting(name: String){
//    Text(text = "Hello $name",
//    style= MaterialTheme.typography.headlineMedium)
//}