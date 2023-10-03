package com.group5.laboratorio6.io
import retrofit2.http.GET

interface ApiService {
    @GET("api/urban_areas/")
    suspend fun getCities(): CityResponse
}

data class CityResponse(
    val _links: Links,
)

data class Links(
    val cities: List<CityLink>
)

data class CityLink(
    val href: String,
    val name: String
)
