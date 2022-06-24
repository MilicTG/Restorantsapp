package com.delminiusdevs.restorantsapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun RestaurantsScreen() {

    val viewModel: RestaurantsViewModel = viewModel()

    LazyColumn(
        contentPadding = PaddingValues(
            vertical = 8.dp,
            horizontal = 8.dp
        )
    ) {
        items(items = viewModel.getRestaurants()) { restaurant ->
            RestaurantItem(item = restaurant)
        }
    }
}

@Composable
fun RestaurantItem(item: Restaurant) {

    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(all = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(all = 8.dp)
        ) {
            RestaurantIcon(
                Icons.Filled.Place,
                Modifier.weight(0.15f),
            )
            RestaurantDetail(
                item.title,
                item.description,
                Modifier.weight(0.85f)
            )
        }
    }
}

@Composable
fun RestaurantIcon(
    icon: ImageVector,
    modifier: Modifier
) {
    Image(
        imageVector = icon, contentDescription = "Restaurant Icon",
        modifier = modifier.padding(8.dp)
    )
}

@Composable
private fun RestaurantDetail(
    item: String,
    description: String,
    modifier: Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = item,
            style = MaterialTheme.typography.h6
        )
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(
                text = description,
                style = MaterialTheme.typography.body2
            )
        }
    }
}