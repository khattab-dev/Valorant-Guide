package com.slayer.valorantguide.agents

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slayer.domain.AgentsRepository
import com.slayer.domain.models.AgentModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgentsViewModel @Inject constructor(
    private val agentsRepository: AgentsRepository
) : ViewModel() {
    private val _agentsResult = mutableStateOf<List<AgentModel>?>(null)
    val agentsResult: State<List<AgentModel>?> = _agentsResult

    fun getAgents() = viewModelScope.launch {
        val agents = agentsRepository.getAgents()
        _agentsResult.value = agents
    }
}