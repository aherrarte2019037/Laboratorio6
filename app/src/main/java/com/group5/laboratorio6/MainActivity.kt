package com.group5.laboratorio6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.group5.laboratorio6.ui.pages.cities_page.CitiesPage
import com.group5.laboratorio6.ui.pages.cities_page.CitiesViewModel
import com.group5.laboratorio6.ui.pages.city_detail.CityDetailPage
import com.group5.laboratorio6.ui.pages.city_detail.CityDetailViewModel
import com.group5.laboratorio6.ui.theme.Laboratorio6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val citiesViewModel = ViewModelProvider(this)[CitiesViewModel::class.java]
        val cityDetailViewModel = ViewModelProvider(this)[CityDetailViewModel::class.java]

        setContent {
            val navController = rememberNavController()

            Laboratorio6Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = navController, startDestination = "cityList") {
                        composable("cityList") {
                            CitiesPage(citiesViewModel, navController)
                        }
                        composable("cityDetails/{cityName}") { backStackEntry ->
                            val cityName = backStackEntry.arguments?.getString("cityName")
                            CityDetailPage(cityName = cityName ?: "Unknown", cityDetailViewModel)
                        }
                    }
                }
            }
        }
    }
}

