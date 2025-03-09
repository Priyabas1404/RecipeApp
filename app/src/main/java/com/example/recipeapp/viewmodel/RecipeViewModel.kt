package com.example.recipeapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.recipeapp.model.Recipe
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor() : ViewModel() {

    // MutableStateFlow to hold favorite recipes
    private val _favoriteRecipes = MutableStateFlow<List<Recipe>>(emptyList())
    val favoriteRecipes: StateFlow<List<Recipe>> = _favoriteRecipes

    // Method to add a recipe to favorites
    fun addToFavorites(recipe: Recipe) {
        _favoriteRecipes.value += recipe
    }

    // Method to remove a recipe from favorites
    fun removeFromFavorites(recipe: Recipe) {
        _favoriteRecipes.value -= recipe
    }
}
