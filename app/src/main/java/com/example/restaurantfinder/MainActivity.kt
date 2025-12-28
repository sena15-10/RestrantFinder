package com.example.restaurantfinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.restaurantfinder.ui.screens.MainScreen
import com.example.restaurantfinder.ui.theme.RestaurantFinderTheme

object NetworkConfig {
    const val API_KEY = "dd08613a4b3c75ae"
    const val BASE_URL = "https://webservice.recruit.co.jp/hotpepper/"
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RestaurantFinderTheme {
                MainScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    RestaurantFinderTheme {
        MainScreen()
    }
}
