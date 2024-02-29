package com.rja.rebajasapp.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.rja.rebajasapp.components.Alert
import com.rja.rebajasapp.components.MainButton
import com.rja.rebajasapp.components.MainTextField
import com.rja.rebajasapp.components.SpaceH
import com.rja.rebajasapp.components.TwoCards
import com.rja.rebajasapp.viewModels.CalcularViewModelv3

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeViewv3(viewModel: CalcularViewModelv3) {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {  Text(text = "App Rebajas", color = Color.White) },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary)
        )
    }) {
        ContentHomeViewv3(paddingValues = it , viewModel = viewModel)
    }
}

@Composable
fun ContentHomeViewv3(paddingValues: PaddingValues, viewModel: CalcularViewModelv3) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val state = viewModel.state

        TwoCards(
            title1 = "Total",
            number1 = state.totalDescuento,
            title2 = "Descuento" ,
            number2 =  state.precioDescuento )

        MainTextField(value = state.precio, onValueChange = { viewModel.onValue(it, "precio")} , label = "Precio")
        SpaceH()
        MainTextField(value = state.descuento, onValueChange = { viewModel.onValue(it, "descuento")} , label = "Descuento %")
        SpaceH(10.dp)
        MainButton(text = "Generar descuento") {
            viewModel.calcular()
        }
        SpaceH()
        MainButton(text = "Limpiar", color = Color.Red) {
            viewModel.limpiar()
        }

        if (state.showAlert) {
            Alert(
                title = "Aviso",
                message = "Informar del precio y/o del descuento",
                confirmText = "Aceptar" ,
                onConfirmClick = { viewModel.cancelAlert() }) {

            }
        }

    }
}