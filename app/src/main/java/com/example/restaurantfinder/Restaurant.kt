@file:OptIn(kotlinx.serialization.InternalSerializationApi::class)
package com.example.restaurantfinder
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


// これが「ファイル内」に複数のデータクラスをまとめた状態です
@Serializable
data class HotPepperResponse(
    val results: Results
)

@Serializable
data class Results(
    @SerialName("shop") val shops: List<Shop>
)

@Serializable
data class Shop(
    val id: String,
    val name: String,
    @SerialName("logo_image") val logoImage: String,
    val address: String,
    val lat: Double,
    val lng: Double,
    val access: String,
    val genre: Genre
)

@Serializable
data class Genre(
    val name: String
)