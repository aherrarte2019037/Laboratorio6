package com.group5.laboratorio6.ui.pages.cities_page

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun CitiesPage(viewModel: CitiesViewModel) {
    val cities = viewModel.cities

    LazyColumn {
        items(cities) { city ->
            Text(city.name)
        }
    }
}