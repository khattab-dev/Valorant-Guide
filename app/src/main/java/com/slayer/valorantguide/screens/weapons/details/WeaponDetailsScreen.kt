package com.slayer.valorantguide.screens.weapons.details

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.slayer.valorantguide.ui.theme.md_theme_dark_secondaryContainer

@Composable
fun WeaponDetailsScreen(
    vm: WeaponDetailsViewModel = hiltViewModel<WeaponDetailsViewModel>(),
    appBarTitle: MutableState<String>
) {
    var tabIndex by remember { mutableIntStateOf(0) }

    LaunchedEffect(Unit) {
        appBarTitle.value = "Weapons Details"

        vm.getWeaponFromLocal()
    }

    vm.weaponResult.value?.let { weapon ->
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            item {
                AsyncImage(
                    model = weapon.image,
                    contentDescription = weapon.name,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    contentScale = ContentScale.Crop,
                )
            }

            item {
                TabRow(selectedTabIndex = tabIndex) {
                    Tab(
                        text = {
                            Text(
                                "Weapon",
                                color = if (tabIndex == 0) md_theme_dark_secondaryContainer else Color.White
                            )
                        },
                        selected = tabIndex == 0,
                        onClick = { tabIndex = 0 }
                    )
                    Tab(
                        text = {
                            Text(
                                "Ads",
                                color = if (tabIndex == 1) md_theme_dark_secondaryContainer else Color.White
                            )
                        },
                        selected = tabIndex == 1,
                        onClick = { tabIndex = 1 }
                    )
                }
            }

            item {
                Box {
                    when (tabIndex) {
                        0 -> ColumnWithEntries(weapon.weaponStats)
                        1 -> ColumnWithEntries(weapon.adsStats)
                        2 -> ColumnWithEntries(weapon.weaponStats)
                    }
                }
            }
        }
    }
}

@Composable
fun ColumnWithEntries(entries: Map<String, String>) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                shape = RoundedCornerShape(16.dp),
                color = md_theme_dark_secondaryContainer
            ).padding(16.dp)
    ) {
        entries.forEach {(key, value) ->
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = key,
                    color = md_theme_dark_secondaryContainer,
                    fontSize = 12.sp
                )
                Text(text = value, fontSize = 12.sp)
            }

            if (entries.keys.indexOf(key) < entries.size - 1) {
                Divider(
                    color = Color.White,
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 12.dp)
                )
            }
        }
    }
}