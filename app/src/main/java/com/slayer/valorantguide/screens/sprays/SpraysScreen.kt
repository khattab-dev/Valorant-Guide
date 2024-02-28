package com.slayer.valorantguide.screens.sprays

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.slayer.domain.models.sprays.SprayModel
import com.slayer.valorantguide.ui.theme.md_theme_dark_secondaryContainer

@Composable
fun SpraysScreen(
    vm: SpraysViewModel = hiltViewModel<SpraysViewModel>(),
    appBarTitle: MutableState<String>
) {
    SideEffect {
        appBarTitle.value = "Sprays"

        vm.getSpraysFromLocal()
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(16.dp),
        contentPadding = PaddingValues(
            top = 16.dp,
            bottom = 16.dp,
        ),
    ) {
        vm.spraysValue.value?.let { sprays ->
            items(sprays, key = { it.uuid }, contentType = { SprayModel::class }) { spray ->
                PlayerCard(spray)
            }
        }
    }
}

@Composable
private fun PlayerCard(spray: SprayModel) {
    AsyncImage(
        model = spray.image,
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .border(
                border = BorderStroke(2.dp, md_theme_dark_secondaryContainer),
                shape = RectangleShape
            ).size(160.dp),
    )
}