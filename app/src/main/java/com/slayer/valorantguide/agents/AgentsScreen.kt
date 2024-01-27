package com.slayer.valorantguide.agents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.slayer.domain.models.AgentModel

@Composable
fun AgentsScreen(onItemClicked: () -> Unit, vm : AgentsViewModel) {

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
            items(agents) { agent ->
                AgentCard(agent, onItemClicked)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AgentCard(agent: AgentModel, onItemClicked: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        border = BorderStroke(1.dp, Color.Red),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF141E29)
        ),
        onClick = { onItemClicked() }
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Text(
                text = agent.name,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            AsyncImage(
                model = agent.image,
                contentDescription = null,
                modifier = Modifier.size(72.dp)
            )
        }
    }
}