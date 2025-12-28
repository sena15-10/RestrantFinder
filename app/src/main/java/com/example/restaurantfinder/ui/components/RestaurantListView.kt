package com.example.restaurantfinder.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.restaurantfinder.data.Restaurant
import com.example.restaurantfinder.data.RestaurantUrls

@Composable
fun RestaurantListView(
    restaurants: List<Restaurant>,
    modifier: Modifier = Modifier
) {
    if (restaurants.isEmpty()) {
        Box(
            modifier = modifier,
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "検索結果がありません",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    } else {
        LazyColumn(
            modifier = modifier,
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(restaurants) { restaurant ->
                RestaurantCard(restaurant = restaurant)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantCard(
    restaurant: Restaurant,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = { /* TODO: 詳細画面へ遷移 */ },
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            AsyncImage(
                model = restaurant.photoUrl,
                contentDescription = restaurant.name,
                modifier = Modifier
                    .size(80.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = restaurant.name,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = restaurant.genre,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "予算: ${restaurant.budget}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = restaurant.access,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RestaurantCardPreview() {
    MaterialTheme {
        RestaurantCard(
            restaurant = Restaurant(
                id = "1",
                name = "サンプル居酒屋",
                address = "東京都渋谷区渋谷1-2-3",
                lat = 35.6595,
                lng = 139.7004,
                genre = "居酒屋",
                budget = "3000円",
                access = "渋谷駅徒歩5分",
                photoUrl = "https://via.placeholder.com/150",
                urls = RestaurantUrls(pc = "https://example.com")
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RestaurantListViewPreview() {
    MaterialTheme {
        RestaurantListView(
            restaurants = listOf(
                Restaurant(
                    id = "1",
                    name = "サンプル居酒屋",
                    address = "東京都渋谷区渋谷1-2-3",
                    lat = 35.6595,
                    lng = 139.7004,
                    genre = "居酒屋",
                    budget = "3000円",
                    access = "渋谷駅徒歩5分",
                    photoUrl = "https://via.placeholder.com/150",
                    urls = RestaurantUrls(pc = "https://example.com")
                ),
                Restaurant(
                    id = "2",
                    name = "イタリアンレストラン",
                    address = "東京都新宿区新宿2-3-4",
                    lat = 35.6900,
                    lng = 139.7000,
                    genre = "イタリアン",
                    budget = "5000円",
                    access = "新宿駅徒歩3分",
                    photoUrl = "https://via.placeholder.com/150",
                    urls = RestaurantUrls(pc = "https://example.com")
                )
            )
        )
    }
}
