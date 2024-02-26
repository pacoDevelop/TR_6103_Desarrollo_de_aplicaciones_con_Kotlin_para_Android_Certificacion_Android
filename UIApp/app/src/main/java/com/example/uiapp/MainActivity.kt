package com.example.uiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uiapp.components.BotonIcono
import com.example.uiapp.components.BotonNormal
import com.example.uiapp.components.BotonNormal2
import com.example.uiapp.components.Space

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Content()
        }
    }
}
@Preview(showBackground = true)
@Composable
fun Content() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
            .padding(horizontal = 5.dp)
    ) {
        //Texto(texto = "Hola que tal")
        //Spacer(modifier = Modifier.padding(10.dp))
        //Texto(texto = "Como estas")
        BotonNormal()
        Space()
        BotonNormal2()
        Space()
        BotonIcono()

    }
}

