package com.slayer.valorantguide.screens.agents.agent_details

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage

@Composable
fun AgentDetailsScreen(
    vm: AgentDetailsViewModel = hiltViewModel<AgentDetailsViewModel>(),
    appBarTitle: MutableState<String>
) {
    SideEffect {        appBarTitle.value = "Agent Details"

        vm.getAgent()
    }

    vm.agentResult.value?.let { agent ->
        val attributes = listOf(
            mapOf("Name" to agent.name),
            mapOf("Role" to agent.type),
            mapOf("Developer" to agent.developerName),
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            item {
                Box(
                    modifier = Modifier
                        .background(
                            brush = Brush.linearGradient(
                                colors = agent.backgroundGradient.map { Color(it) },
                            ),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .padding(vertical = 32.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(horizontal = 32.dp),
                        verticalArrangement = Arrangement.spacedBy(24.dp)
                    ) {
                        Box(
                            modifier = Modifier.size(300.dp)
                        ) {
                            AsyncImage(
                                model = agent.background,
                                contentDescription = agent.name,
                                modifier = Modifier.fillMaxSize(),
                            )
                            AsyncImage(
                                model = agent.image,
                                contentDescription = agent.name,
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop,
                            )
                        }

                        Divider(
                            color = Color.White,
                            thickness = 1.dp,
                        )

                        Text(
                            text = agent.description,
                            fontSize = 9.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth(),
                            lineHeight = TextUnit(16f, TextUnitType.Sp)
                        )
                    }
                }
            }

            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            shape = RoundedCornerShape(16.dp),
                            color = Color(agent.backgroundGradient[1])
                        )
                        .padding(16.dp)
                ) {
                    for (i in 0..attributes.lastIndex) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                            ) {
                                Text(
                                    fontSize = 12.sp,
                                    color = Color(agent.backgroundGradient[1]),
                                    text = attributes[i].keys.first()
                                )
                                Text(
                                    fontSize = 12.sp,
                                    text = attributes[i].values.first()
                                )
                            }

                            if (i < attributes.lastIndex) {
                                Divider(
                                    color = Color.White,
                                    thickness = 1.dp,
                                    modifier = Modifier.padding(vertical = 12.dp)
                                )
                            }
                        }
                    }
                }
            }

            item {
                Text(
                    text = "Abilities",
                    fontSize = 12.sp,
                    color = Color(agent.backgroundGradient[1]),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.padding(vertical = 4.dp))

                for (i in 0..agent.abilities.lastIndex) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(
                                width = 1.dp,
                                shape = RoundedCornerShape(16.dp),
                                color = Color(agent.backgroundGradient[1])
                            )
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            AsyncImage(
                                model =  agent.abilities[i].icon,
                                contentDescription = null,
                                modifier = Modifier.size(64.dp)
                            )

                            Spacer(modifier = Modifier.padding(8.dp))

                            Column {
                                Row {
                                    Text(
                                        text = "Name: ",
                                        fontSize = 10.sp,
                                        color = Color(agent.backgroundGradient[1]),
                                    )
                                    Text(
                                        text = agent.abilities[i].name,
                                        fontSize = 10.sp,
                                    )
                                }
                            }
                        }

                        Row {
                            val annotatedString = buildAnnotatedString {
                                withStyle(style = SpanStyle(Color(agent.backgroundGradient[1]))) {
                                    append("Description: ")
                                }
                                append("Equip an Incendiary grenade launcher. Fire to launch a grenade that detonates as it comes to a rest on the floor, creating a lingering fire zone that damages players within the zone.")
                            }
                            Text(text = annotatedString, fontSize = 10.sp)
                        }
                    }

                    Spacer(modifier = Modifier.padding(vertical = 12.dp))
                }
            }
        }
    }
}