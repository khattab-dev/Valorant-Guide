package com.slayer.valorantguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.slayer.valorantguide.agents.AgentsScreen
import com.slayer.valorantguide.agents.AgentsViewModel
import com.slayer.valorantguide.buddies.BuddiesScreen
import com.slayer.valorantguide.home.HomeScreen
import com.slayer.valorantguide.ui.theme.ValorantGuideTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ValorantGuideTheme {
                ScreensAroundApp()
            }
        }
    }
}

@Composable
private fun ScreensAroundApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable(route = "home") {
            HomeScreen {
                navController.navigate(it)
            }
        }

        composable(route = "agents") {
            AgentsScreen(vm = hiltViewModel<AgentsViewModel>(), onItemClicked = {
                
            })
        }

        composable(route = "buddies") {
            BuddiesScreen()
        }

        // This is just example on how to pass an argument to the screen
//        composable(route = "details/{id}") {
//            HomeScreen()
//        }
    }
}