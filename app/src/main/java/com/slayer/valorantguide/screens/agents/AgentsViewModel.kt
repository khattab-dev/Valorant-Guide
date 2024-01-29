package com.slayer.valorantguide.screens.agents

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slayer.domain.repositories.AgentsRepository
import com.slayer.domain.models.agents.AgentModel
import com.slayer.domain.models.NetworkResult
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
        when (val result = agentsRepository.getAgents()) {
            is NetworkResult.Error -> {}
            is NetworkResult.Exception -> {}
            is NetworkResult.Success -> {_agentsResult.value = result.data}
        }
    }
}