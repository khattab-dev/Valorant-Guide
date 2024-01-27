package com.slayer.valorantguide.home

import androidx.lifecycle.ViewModel
import com.slayer.domain.models.CategoryModel
import com.slayer.valorantguide.R

class HomeViewModel : ViewModel() {
    val categories = listOf(
        CategoryModel(path = "agents", title = "AGENTS", drawableId = R.drawable.agents),
        CategoryModel(path = "buddies", title = "BUDDIES", drawableId = R.drawable.buddies),
    )
}