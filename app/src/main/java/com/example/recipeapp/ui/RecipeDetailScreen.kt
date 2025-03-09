package com.example.recipeapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recipeapp.model.Recipe

@Composable
fun RecipeDetailScreen(recipeId: Int) {
    val recipe = getRecipeById(recipeId) // Fetch recipe from a list or ViewModel

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = recipe.name, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = recipe.description)
    }
}
fun getRecipeById(id: Int): Recipe {
    val recipes = listOf(
        Recipe(1, "Pasta", "Delicious pasta with tomato sauce"),
        Recipe(2, "Pizza", "Cheesy pizza with pepperoni")
    )
    return recipes.first { it.id == id }
}
