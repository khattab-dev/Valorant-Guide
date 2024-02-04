package com.slayer.valorantguide.screens.agents.agent_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slayer.common.printToLog
import com.slayer.domain.models.agents.AgentModel
import com.slayer.domain.repositories.AgentsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgentDetailsViewModel @Inject constructor(
    private val agentsRepository: AgentsRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _agentResult = mutableStateOf<AgentModel?>(null)
    val agentResult: State<AgentModel?> = _agentResult

    fun getAgent() = viewModelScope.launch(Dispatchers.IO) {
        val agentId = savedStateHandle["agent_id"] ?: "e370fa57-4757-3604-3648-499e1f642d3f"
        agentsRepository.getAgentFromLocal(agentId).collect {
            _agentResult.value = it

            agentResult.printToLog()
        }
    }
}