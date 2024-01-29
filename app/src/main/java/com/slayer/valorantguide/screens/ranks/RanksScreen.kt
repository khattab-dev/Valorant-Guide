package com.slayer.valorantguide.screens.ranks

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.slayer.domain.models.ranks.RankModel
import com.slayer.valorantguide.ui.theme.md_theme_dark_secondaryContainer

@Composable
fun RanksScreen(
    vm: RanksViewModel = hiltViewModel<RanksViewModel>()
) {
    vm.getPlayerCards()

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(32.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        vm.ranksValue.value?.let { ranks ->
            items(ranks.keys.toList(), key = { it }, contentType = { RankModel::class }) { rank ->
                RanksCard(rank, ranks[rank].orEmpty())
            }
        }
    }
}

@Composable
private fun RanksCard(tier: String, ranks: List<RankModel>) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = tier)
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            for (i in 0..ranks.lastIndex)
                AsyncImage(
                    model = ranks[i].divisionIcon,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .border(border = BorderStroke(2.dp, md_theme_dark_secondaryContainer))
                        .padding(16.dp)
                )

        }
    }
}