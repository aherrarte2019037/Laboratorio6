package com.group5.laboratorio6.io
import com.google.gson.annotations.SerializedName
import retrofit2.http.GET

interface ApiService {
    @GET("api/urban_areas/")
    suspend fun getCities(): CityResponse
}

data class CityResponse(
    @SerializedName("_links") val links: Links
)

data class Links(
    @SerializedName("ua:item") val cities: List<CityLink>
)

data class CityLink(
    val href: String,
    val name: String
)
