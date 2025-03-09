package com.example.recipeapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.recipeapp.model.Recipe
import com.example.recipeapp.viewmodel.RecipeViewModel

@Composable
fun RecipeDetailScreen(recipeId: Int, viewModel: RecipeViewModel = hiltViewModel()) {
    val recipe = getRecipeById(recipeId) // Fetch recipe from a list or ViewModel
    val favoriteRecipes = viewModel.favoriteRecipes.collectAsState()
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = recipe.name, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = recipe.description)
    }
    if (favoriteRecipes.value.contains(recipe)) {
        Button(onClick = { viewModel.removeFromFavorites(recipe) }) {
            Text(text = "Remove from Favorites")
        }
    } else {
        // Optionally show a message or button to add to favorites if not already a favorite
        Button(onClick = { viewModel.addToFavorites(recipe) }) {
            Text(text = "Add to Favorites")
        }
    }
}
fun getRecipeById(id: Int): Recipe {
    val recipes = listOf(
        Recipe(1, "Pasta", "Delicious pasta with tomato sauce"),
        Recipe(2, "Pizza", "Cheesy pizza with pepperoni")
    )
    return recipes.first { it.id == id }
}
