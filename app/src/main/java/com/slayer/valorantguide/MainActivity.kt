package com.slayer.valorantguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.slayer.valorantguide.agents.AgentsScreen
import com.slayer.valorantguide.agents.AgentsViewModel
import com.slayer.valorantguide.buddies.BuddiesScreen
import com.slayer.valorantguide.home.HomeScreen
import com.slayer.valorantguide.ui.theme.ValorantGuideTheme
import com.slayer.valorantguide.ui.theme.md_theme_dark_primary
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
            }

            ValorantGuideTheme(useDarkTheme = true) {
                Scaffold(
                    containerColor = md_theme_dark_primary,
                    topBar = {

                        CenterAlignedTopAppBar(
                            colors = topAppBarColors(
                                containerColor = Color.Transparent,
                                titleContentColor = Color.White
                            ),
                            title = {
                                Text(vm.appBarTitle.value, fontWeight = FontWeight.Bold)
                            },
                            navigationIcon = {
                                if (canPop) {
                                    IconButton(onClick = { navController.navigateUp() }) {
                                        Icon(
                                            imageVector = Icons.Filled.ArrowBack,
                                            contentDescription = "Back"
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
            HomeScreen {
                navController.navigate(it)
            }
            vm.setTitle(null)
        }

        composable(route = "agents") {
            AgentsScreen(vm = hiltViewModel<AgentsViewModel>(), onItemClicked = {

            })
            vm.setTitle("AGENTS")
        }

        composable(route = "buddies") {
            BuddiesScreen()
            vm.setTitle("BUDDIES")
        }
    }
}