package com.example.recipeapp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.recipeapp.viewmodel.RecipeViewModel

@Composable
fun FavoritesScreen(viewModel: RecipeViewModel = hiltViewModel()) {
    val favoriteRecipes = viewModel.favoriteRecipes.collectAsState()

    LazyColumn {
        items(favoriteRecipes.value) { recipe ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { /* You can navigate to recipe detail screen if needed */ }
            ) {
                Text(text = recipe.name, modifier = Modifier.padding(16.dp))
            }
        }
    }
}
