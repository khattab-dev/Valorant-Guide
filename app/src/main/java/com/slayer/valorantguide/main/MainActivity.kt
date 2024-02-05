package com.slayer.valorantguide.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.slayer.common.printToLog
import com.slayer.valorantguide.R
import com.slayer.valorantguide.screens.agents.agent_details.AgentDetailsScreen
import com.slayer.valorantguide.screens.agents.agents_list.AgentsScreen
import com.slayer.valorantguide.screens.buddies.BuddiesScreen
import com.slayer.valorantguide.screens.home.HomeScreen
import com.slayer.valorantguide.screens.maps.MapsScreen
import com.slayer.valorantguide.screens.player_cards.PlayerCardScreen
import com.slayer.valorantguide.screens.ranks.RanksScreen
import com.slayer.valorantguide.screens.sprays.SpraysScreen
import com.slayer.valorantguide.screens.weapons.WeaponsScreen
import com.slayer.valorantguide.screens.weapons.details.WeaponDetailsScreen
import com.slayer.valorantguide.ui.theme.ValorantGuideTheme
import com.slayer.valorantguide.ui.theme.md_theme_dark_primary
import com.slayer.valorantguide.ui.theme.md_theme_light_secondary
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            window.statusBarColor = md_theme_dark_primary.toArgb()

            val vm: MainViewModel = viewModel()
            val navController = rememberNavController()
            var canPop by remember { mutableStateOf(false) }

            navController.addOnDestinationChangedListener { controller, destination, bundle ->
                canPop = controller.previousBackStackEntry != null

                when (destination.route) {
                    "home" -> {
                        vm.setTitle(null)
                    }

                    "cards" -> vm.setTitle("PLAYER CARDS")
                    "agentDetails/{agent_id}" -> vm.setTitle("Agent Details")
                    "weaponDetails/{weapon_id}" -> vm.setTitle("Weapon Details")
                    else -> vm.setTitle(destination.route?.uppercase())
                }
                destination.route.printToLog()
            }

            ValorantGuideTheme(useDarkTheme = true) {
                Scaffold(
                    containerColor = md_theme_dark_primary,
                    topBar = {
                        CenterAlignedTopAppBar(
                            colors = topAppBarColors(
                                containerColor = Color.Transparent,
                            ),
                            title = {
                                Text(vm.appBarTitle.value, fontWeight = FontWeight.Bold)
                            },
                            navigationIcon = {
                                if (canPop) {
                                    IconButton(onClick = { navController.navigateUp() }) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.baseline_arrow_back_ios_new_24),
                                            contentDescription = "Back",
                                            tint = md_theme_light_secondary
                                        )
                                    }
                                } else {
                                    null
                                }
                            }
                        )
                    }
                ) {
                    ScreensAroundApp(it, vm, navController)
                }
            }
        }
    }
}

@Composable
private fun ScreensAroundApp(
    paddingValues: PaddingValues,
    vm: MainViewModel,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = Modifier.padding(paddingValues)
    ) {
        composable(route = "home") {
            HomeScreen(navHostController = navController)
        }

        composable(route = "agents") {
            AgentsScreen(navHostController = navController)
        }

        composable(route = "agentDetails/{agent_id}", arguments = listOf(
            navArgument("agent_id") { type = NavType.StringType }
        )) {
            AgentDetailsScreen()
        }

        composable(route = "buddies") {
            BuddiesScreen()
        }

        composable(route = "weapons") {
            WeaponsScreen(navHostController = navController)
        }

        composable(route = "weaponDetails/{weapon_id}", arguments = listOf(
            navArgument("weapon_id") { type = NavType.StringType }
        )) {
            WeaponDetailsScreen()
        }

        composable(route = "sprays") {
            SpraysScreen()
        }

        composable(route = "ranks") {
            RanksScreen()
        }

        composable(route = "maps") {
            MapsScreen()
        }

        composable(route = "cards") {
            PlayerCardScreen()
        }

        composable(route = "buddies") {
            BuddiesScreen()
        }
    }
}