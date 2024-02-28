package com.slayer.valorantguide.screens.player_cards

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
import com.slayer.domain.models.cards.CardModel
import com.slayer.valorantguide.ui.theme.md_theme_dark_secondaryContainer

@Composable
fun PlayerCardScreen(
    vm: PlayerCardsViewModel = hiltViewModel<PlayerCardsViewModel>(),
    appBarTitle: MutableState<String>
) {
    SideEffect {
        appBarTitle.value = "Cards"

        vm.getPlayerCardsFromLocal()
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
        vm.playerCards.value?.let { cards ->
            items(cards, key = { it.uuid }, contentType = { CardModel::class }) { card ->
                PlayerCard(card)
            }
        }
    }
}

@Composable
private fun PlayerCard(card: CardModel) {
    AsyncImage(
        model = card.image,
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .size(width = 160.dp, height = 320.dp)
            .border(
                border = BorderStroke(2.dp, md_theme_dark_secondaryContainer),
                shape = RectangleShape
            ),
    )
}