package com.group5.laboratorio6.ui.pages.city_detail

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.group5.laboratorio6.io.CityImageResponse
import com.group5.laboratorio6.io.RetrofitInstance
import kotlinx.coroutines.launch

class CityDetailViewModel : ViewModel() {
    private val apiService = RetrofitInstance.apiService
    private val _cityImage = MutableLiveData<CityImageResponse>()
    val cityImage: LiveData<CityImageResponse> = _cityImage

    fun fetchCityImage(citySlug: String) {
        viewModelScope.launch {
            try {
                val response = apiService.getCityImages(citySlug)
                _cityImage.value = response
            } catch (e: Exception) {
            }
        }
    }
}