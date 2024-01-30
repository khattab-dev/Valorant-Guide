package com.slayer.valorantguide.screens.agents

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slayer.domain.models.NetworkResult
import com.slayer.domain.models.agents.AgentModel
import com.slayer.domain.repositories.AgentsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgentsViewModel @Inject constructor(
    private val agentsRepository: AgentsRepository
) : ViewModel() {
    private val _agentsResult = mutableStateOf<List<AgentModel>?>(null)
    val agentsResult: State<List<AgentModel>?> = _agentsResult

    private fun getAgentsFromApi() = viewModelScope.launch(Dispatchers.IO) {
        when (agentsRepository.getAgentsFromApi()) {
            is NetworkResult.Error -> {}
            is NetworkResult.Exception -> {}
            is NetworkResult.Success -> {}
        }
    }

    fun getAgentsFromLocal() = viewModelScope.launch(Dispatchers.IO) {
        agentsRepository.getAgentsFromLocal().collect {
            if (it.isNotEmpty()) { _agentsResult.value = it }
            else { getAgentsFromApi() }
        }
    }
}