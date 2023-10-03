package com.group5.laboratorio6.io
import com.google.gson.annotations.SerializedName
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("api/urban_areas/")
    suspend fun getCities(): CityResponse

    @GET("api/urban_areas/slug:{citySlug}/images")
    suspend fun getCityImages(@Path("citySlug") citySlug: String): CityImageResponse
}

data class CityImageResponse(
    val photos: List<Photo>
)

data class Photo(
    val attribution: Attribution,
    val image: Image
)

data class Attribution(
    val license: String,
    val photographer: String,
    val site: String,
    val source: String
)

data class Image(
    val mobile: String,
    val web: String
)

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
