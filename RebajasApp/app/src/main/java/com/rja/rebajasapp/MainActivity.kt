package com.rja.rebajasapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rja.rebajasapp.ui.theme.RebajasAppTheme
import com.rja.rebajasapp.viewModels.CalcularViewModel
import com.rja.rebajasapp.viewModels.CalcularViewModelv2
import com.rja.rebajasapp.viewModels.CalcularViewModelv3
import com.rja.rebajasapp.views.HomeView
import com.rja.rebajasapp.views.HomeViewv2
import com.rja.rebajasapp.views.HomeViewv3

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: CalcularViewModelv3 by viewModels()

        setContent {
            RebajasAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeViewv3(viewModel = viewModel)
                }
            }
        }
    }
}

