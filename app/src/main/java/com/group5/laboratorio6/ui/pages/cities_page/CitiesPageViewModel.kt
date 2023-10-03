package com.group5.laboratorio6.ui.pages.cities_page

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.group5.laboratorio6.io.CityLink
import com.group5.laboratorio6.io.RetrofitInstance
import kotlinx.coroutines.launch

class CitiesViewModel : ViewModel() {
    private val apiService = RetrofitInstance.apiService

    var cities = mutableStateListOf<CityLink>()

    init {
        loadCities()
    }

    private fun loadCities() {
        viewModelScope.launch {
            try {
                val response = apiService.getCities()
                cities.addAll(response.links.cities)
            } catch (e: Exception) {
            }
        }
    }
}