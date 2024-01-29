package com.slayer.valorantguide.screens.weapons

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slayer.domain.repositories.WeaponsRepository
import com.slayer.domain.models.NetworkResult
import com.slayer.domain.models.weapons.WeaponModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeaponsViewModel @Inject constructor(
    private val weaponsRepository: WeaponsRepository
) : ViewModel() {
    private val _weaponsResult = mutableStateOf<List<WeaponModel>?>(null)
    val weaponsResult: State<List<WeaponModel>?> = _weaponsResult

    fun getWeapons() = viewModelScope.launch {
        when (val result = weaponsRepository.getWeapons()) {
            is NetworkResult.Error -> {}
            is NetworkResult.Exception -> {}
            is NetworkResult.Success -> {_weaponsResult.value = result.data}
        }
    }
}