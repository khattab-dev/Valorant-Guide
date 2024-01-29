package com.slayer.valorantguide.screens.agents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.slayer.domain.models.agents.AgentModel
import com.slayer.valorantguide.ui.theme.md_theme_dark_secondaryContainer

@Composable
fun AgentsScreen(
    vm: AgentsViewModel = hiltViewModel<AgentsViewModel>(),
) {
    vm.getAgents()

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
        vm.agentsResult.value?.let { agents ->
            items(agents, key = { it.uuid }, contentType = { AgentModel::class }) { agent ->
                AgentCard(agent)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AgentCard(agent: AgentModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        border = BorderStroke(1.dp, md_theme_dark_secondaryContainer),
        onClick = {  }
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = md_theme_dark_secondaryContainer.copy(alpha = .5f),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(4.dp),
                contentAlignment = Alignment.Center,
            ) {
                Text(text = agent.name)
            }

            AsyncImage(
                model = agent.image,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}