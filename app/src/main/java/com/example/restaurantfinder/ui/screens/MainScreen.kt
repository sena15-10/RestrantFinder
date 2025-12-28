package com.example.restaurantfinder.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Map
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.restaurantfinder.data.Restaurant

enum class DisplayMode {
    LIST, MAP
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    var searchQuery by remember { mutableStateOf("") }
    var displayMode by remember { mutableStateOf(DisplayMode.LIST) }
    var restaurants by remember { mutableStateOf<List<Restaurant>>(emptyList()) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("レストラン検索") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        modifier = modifier
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            SearchBar(
                query = searchQuery,
                onQueryChange = { searchQuery = it },
                onSearch = {
                    // TODO: 実際の検索処理を実装
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            TabRow(
                selectedTabIndex = displayMode.ordinal,
                modifier = Modifier.fillMaxWidth()
            ) {
                Tab(
                    selected = displayMode == DisplayMode.LIST,
                    onClick = { displayMode = DisplayMode.LIST },
                    text = { Text("リスト") },
                    icon = { Icon(Icons.AutoMirrored.Filled.List, contentDescription = "リスト表示") }
                )
                Tab(
                    selected = displayMode == DisplayMode.MAP,
                    onClick = { displayMode = DisplayMode.MAP },
                    text = { Text("マップ") },
                    icon = { Icon(Icons.Default.Map, contentDescription = "マップ表示") }
                )
            }

            when (displayMode) {
                DisplayMode.LIST -> {
                    RestaurantListView(
                        restaurants = restaurants,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                DisplayMode.MAP -> {
                    MapView(
                        restaurants = restaurants,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun MapView(
    restaurants: List<Restaurant>,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = androidx.compose.ui.Alignment.Center
    ) {
        Text("マップ表示 (実装予定)")
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MaterialTheme {
        MainScreen()
    }
}
