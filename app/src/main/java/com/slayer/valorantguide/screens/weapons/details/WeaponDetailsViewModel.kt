package com.slayer.valorantguide.screens.weapons.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slayer.domain.models.weapons.WeaponModel
import com.slayer.domain.repositories.WeaponsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeaponDetailsViewModel @Inject constructor(
    private val weaponsRepository: WeaponsRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _weaponResult = mutableStateOf<WeaponModel?>(null)
    val weaponResult: State<WeaponModel?> = _weaponResult

    fun getWeaponFromLocal() = viewModelScope.launch(Dispatchers.IO) {
        val weaponId = savedStateHandle["weapon_id"] ?: "63e6c2b6-4a8e-869c-3d4c-e38355226584"

        weaponsRepository.getWeaponFromLocal(weaponId).collect {
            _weaponResult.value = it
        }
    }
}