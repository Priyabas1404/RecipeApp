package com.example.recipeapp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.recipeapp.model.Recipe

@Composable
fun HomeScreen(navController: NavController) {
    val recipes = listOf(
        Recipe(1, "Pasta", "Delicious pasta with tomato sauce"),
        Recipe(2, "Pizza", "Cheesy pizza with pepperoni")
    )

    LazyColumn {
        items(recipes) { recipe ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { navController.navigate("recipeDetail/${recipe.id}") }
            ) {
                Text(text = recipe.name, modifier = Modifier.padding(16.dp))
            }
        }
    }
}