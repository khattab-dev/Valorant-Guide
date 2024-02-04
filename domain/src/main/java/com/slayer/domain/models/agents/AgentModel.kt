package com.slayer.domain.models.agents

data class AgentModel(
    val uuid : String,
    val name : String,
    val image : String,
    val description: String,
    val developerName: String,
    val type : String,
    val typeDisplayIcon : String,
    val background : String,
    val backgroundGradient : List<Long>,
    val abilities : List<AgentAbilityModel>
)