package com.example.recipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.recipeapp.Navigation.RecipeNavGraph
import com.example.recipeapp.model.NavigationItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecipeApp()
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController, currentRoute: String) {
    val interactionSource = remember { MutableInteractionSource() }

    val items = listOf(
        NavigationItem("home", Icons.Default.Home),
        NavigationItem("favorites", Icons.Default.Favorite)
    )
    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                selected = item.route == currentRoute,
                onClick = { navController.navigate(item.route) },
                icon = { Icon(item.icon, contentDescription = item.route) },
                label = { Text(
                    text = item.route.replaceFirstChar { it.uppercase() },
                    onTextLayout = {}
                ) }
            )
        }
    }
}

@Composable
fun RecipeApp() {
    val navController = rememberNavController()
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route ?: "home"

    Scaffold(
        bottomBar = { BottomNavigationBar(navController, currentRoute) }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            RecipeNavGraph(navController)
        }
    }
}