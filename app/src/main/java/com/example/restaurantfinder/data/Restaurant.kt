package com.example.restaurantfinder.data

data class Restaurant(
    val id: String,
    val name: String,
    val address: String,
    val lat: Double,
    val lng: Double,
    val genre: String,
    val budget: String,
    val access: String,
    val photoUrl: String,
    val urls: RestaurantUrls
)

data class RestaurantUrls(
    val pc: String
)
